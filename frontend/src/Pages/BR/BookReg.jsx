/* eslint-disable no-console */
import React, { useState, useEffect } from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { ko } from 'date-fns/esm/locale';
import { palette } from 'styled-tools';
import axios from 'axios';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import SearchIcon from '../../Image/SearchIcon.png';
import Button from '../../Components/Btn';
import Input from '../../Components/Input';

// ------------- 책등록 페이지 -------------

const MainWrap = styled.div`
  position: absolute;
  width: 100%;
  height: 100%;
  background-color: ${palette('PsCocoa', 0)};
`;

const Wrap = styled.div`
  width: fit-content;
  height: fit-content;
  margin: 5rem auto 0rem auto;
  padding: 3rem;
  background-color: ${palette('PsCocoa', 1)};
  text-align: left;
  box-sizing: content-box;
`;

const Title = styled.h1`
  /* border: 1px solid red; */
  color: ${palette('PsYellow')};
`;

const WrapContent = styled.div`
  display: flex;
`;

const WrapBookImage = styled.div`
  width: 15rem;
  height: 19rem;
  background-color: #ffffff;
`;

const WrapBookSearch = styled.div`
  margin-top: 20rem;
  margin-left: -15rem;
`;

const WrapRegister = styled.div`
  margin-left: 3rem;
`;
const WrapBookTitle = styled.div`
  font-weight: bold;
  font-size: 1.5rem;
`;

const WrapBookDetail = styled.div`
  font-size: 1.3rem;
  margin-top: 1rem;
  margin-bottom: 4rem;
`;

const WrapBookReturn = styled.div`
  width: fit-content;
  height: fit-content;
  padding: 2rem;
  background-color: ${palette('PsLightBrown', 0)};
  border-radius: 0.2rem;
`;

const WrapReturnAlert = styled.div`
  display: flex;
  margin-top: 1rem;
  vertical-align: middle;
`;

const PickDate = styled(DatePicker)`
  width: 12rem;
  height: 2.5rem;
  box-sizing: border-box;
  text-align: center;
  margin-top: -0.5rem;
  padding: 0.8rem 2rem;
  border-radius: 0.4rem;
  border: 0.15rem solid rgba(128, 109, 70);
  font-size: 0.9rem;
  z-index: -1;
`;
const Location = styled.div`
  width: 6rem;
  margin-right: 1rem;
  /* border: 1px solid grey; */
  display: flex;
  justify-content: center;
  align-items: center;
`;
const WrapRegButton = styled.div`
  margin-top: 3rem;
  margin-right: -2rem;
  float: right;
`;

// ---------------- 팝업창 작업----------------

const WrapPopupBackground = styled.div`
  position: absolute;
  width: 100vw;
  height: 100vh;
  margin-top: -4rem;
  background-color: rgba(255, 255, 255, 0.4);
`;

const WrapPopup = styled.div`
  position: absolute;
  width: 60rem;
  height: 35rem;
  top: 45%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: ${palette('PsCocoa', 1)};
  border-radius: 1rem;
  z-index: 1;
`;

const WrapCloseButton = styled.div`
  /* border: 1px solid black; */
  width: fit-content;
  height: fit-content;
  margin-top: 1.5rem;
  margin-left: 2.5rem;
  text-align: left;
`;

const TitleSearch = styled.div`
  font-size: 3rem;
  margin-top: 1rem;
  align-items: center;
  justify-content: center;
  text-align: center;
`;

const WrapSearchbar = styled.div`
  /* border: 1px solid black; */
  margin-top: 2rem;
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 99;
`;

const WrapSearchIcon = styled.div`
  height: 3rem;
  width: 3rem;
  background-size: 3rem;
  background-position: center;
  background-repeat: no-repeat;
  background-image: url(${SearchIcon});
`;

const WrapList = styled.div`
  height: 15rem;
  width: fit-content;
  margin: 2rem auto;
  overflow: scroll;
  overflow-x: hidden;
  &::-webkit-scrollbar {
    width: 8px;
    height: 8px;
    border-radius: 10px;
  }
  &::-webkit-scrollbar-track {
    background: transparent;
    /* background: #eeeeee; */
    border-radius: 5px;
  }
  &::-webkit-scrollbar-thumb {
    background: ${palette('PsGreen')};
    border-radius: 10px;
  }
`;

const ListPopup = styled.div`
  width: 40rem;
  height: fit-content;
  background-color: white;
  margin-bottom: 1rem;
  margin-top: 1rem;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  box-sizing: content-box;
  padding: 0.7rem;
  justify-items: center;
  border-radius: 0.2rem;
  /* border: 1px solid red; */
`;

const TitlePopup = styled.div`
  width: 15rem;
  white-space: normal;
  text-align: center;
`;
const WriterPopup = styled.div`
  width: 12rem;
  white-space: normal;
  margin-left: 1rem;
  text-align: center;
`;
const PublisherPopup = styled.div`
  width: 10rem;
  white-space: normal;
  word-break: break-all;
  margin-left: 1rem;
  text-align: center;
`;
const ReleaseDate = styled.div`
  width: 8rem;
  white-space: normal;
  word-break: break-all;
  margin-left: 1rem;
  text-align: center;
`;

function BookReg() {
  // 팝업창 x 버튼 기능 구현
  const [isShown, setIsShown] = useState(false);

  // 달력 보이기
  const [startDate, setStartDate] = useState(new Date());

  // 도서 검색 input 값 받기
  const [bookTitle, setBookTitle] = useState();

  // api 값 저장
  const [getBook, setGetBook] = useState([]);

  // 팝업 열기
  const openPopup = () => {
    console.log('open');
    setIsShown(true);
  };

  // 팝업 닫기
  const closePopup = () => {
    console.log('close');
    setIsShown(false);
  };

  const SearchBook = () => {
    console.log('클릭', bookTitle);
    const data = {
      keyword: bookTitle,
      page: 1,
      pageSize: 20,
    };
    console.log(data);
    if (!bookTitle) {
      alert('키워드를 입력해 주세요.');
    } else {
      axios
        .get(`${process.env.REACT_APP_BASE_URL}/externalbooks`, {
          params: data,
        })
        .then((response) => {
          console.log(response.data);
          setGetBook(response.data);
          // console.log('getBook : ', getBook);
        })
        .catch((error) => {
          console.log(error);
        });
    }
  };

  const onChange = (e) => {
    setBookTitle(e.target.value);
  };

  // const onClickList = (e) = {

  // };

  return (
    <div>
      <ThemeProvider theme={theme}>
        <MainWrap>
          <Header />
          {/* 
              ---------------- 팝업창 작업----------------
          */}

          <WrapPopupBackground style={{ display: isShown ? 'block' : 'none' }}>
            <WrapPopup>
              <WrapCloseButton>
                <Button
                  background='transparent'
                  name='x'
                  borderStyle='none'
                  fontSize='3rem'
                  onClick={closePopup}
                />
              </WrapCloseButton>
              <TitleSearch>도서 검색</TitleSearch>
              <WrapSearchbar>
                <Input
                  width='36rem'
                  height='3.2rem'
                  placeholder='키워드를 적어주세요.'
                  fontSize='1.2rem'
                  onChange={onChange}
                />
                <WrapSearchIcon onClick={SearchBook} />
              </WrapSearchbar>

              <WrapList
              // onClick={onClickList}
              >
                {getBook.map((book) => (
                  <ListPopup>
                    <TitlePopup>{book.title}</TitlePopup>
                    <WriterPopup>{book.author}</WriterPopup>
                    <PublisherPopup>{book.publisher}</PublisherPopup>
                    <ReleaseDate>{book.publishAt}</ReleaseDate>
                  </ListPopup>
                ))}
              </WrapList>
            </WrapPopup>
          </WrapPopupBackground>

          {/*
              ------------- 책등록 페이지 작업 -------------
           */}
          <Wrap>
            <Title>도서 등록</Title>
            <WrapContent>
              <WrapBookImage />
              <WrapBookSearch>
                <Button
                  onClick={openPopup}
                  color='black'
                  background={palette('PsGreen')}
                  width='15rem'
                  height='2.5rem'
                  name='도서 검색'
                  borderRadius='1rem'
                />
              </WrapBookSearch>

              <WrapRegister>
                <WrapBookReturn>
                  <WrapBookTitle>도서 제목</WrapBookTitle>
                  <WrapBookDetail>작가 | 출판사 | 출판일</WrapBookDetail>
                  <WrapReturnAlert>
                    <Location>반납 마감일</Location>
                    <div>
                      <PickDate
                        locale={ko}
                        dateFormat='yyyy일 MM월 dd일'
                        selected={startDate}
                        onChange={(date) => setStartDate(date)}
                      />
                    </div>
                  </WrapReturnAlert>
                  <WrapReturnAlert>
                    <Location>위치</Location>
                    <Input
                      width='23rem'
                      height='2.5rem'
                      placeholder='만날 위치를 적어주세요'
                    />
                  </WrapReturnAlert>
                  <WrapReturnAlert>
                    <Location>오픈 채팅 주소</Location>
                    <Input
                      width='23rem'
                      height='2.5rem'
                      placeholder='카카오 오픈 채팅 주소'
                    />
                  </WrapReturnAlert>
                  <WrapRegButton>
                    <Button
                      color='black'
                      background={palette('PsYellow')}
                      width='5.5rem'
                      height='2.5rem'
                      name='게시하기'
                      borderRadius='1rem'
                    />
                  </WrapRegButton>
                </WrapBookReturn>
              </WrapRegister>
            </WrapContent>
          </Wrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}
export default BookReg;
