/* eslint-disable no-console */
import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
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
  background-image: url(${(props) => props.backgroundImage});
  background-repeat: no-repeat;
  background-size: contain;
  background-position: center;
`;

const WrapBookSearch = styled.div`
  margin-top: 20rem;
  margin-left: -15rem;
`;

const WrapRegister = styled.div`
  margin-left: 3rem;
`;
const WrapBookTitle = styled.div`
  width: 38rem;
  margin-bottom: 1rem;
  font-weight: bold;
  font-size: 1.5rem;
`;

const WrapBookDetail = styled.div`
  margin-top: 0.5rem;
`;

const WrapBookReturn = styled.div`
  width: fit-content;
  height: fit-content;
  padding: 2rem;
  background-color: ${palette('PsLightBrown', 0)};
  border-radius: 0.2rem;
`;

const WrapWriteForm = styled.div`
  width: fit-content;
  height: fit-content;
  margin-top: 2rem;
`;

const WrapReturnAlert = styled.div`
  display: flex;
  margin-top: 2rem;
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
  /* border: 1px solid grey; */
  width: 6rem;
  margin-right: 0rem;

  display: flex;
  /* justify-content: center; */
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
  /* border: 1px solid red; */
  width: 40rem;
  height: fit-content;
  background-color: white;
  margin-bottom: 1rem;
  margin-top: 1rem;
  padding: 0.7rem;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  justify-items: center;
  align-items: center;
  box-sizing: content-box;
  border-radius: 0.2rem;
`;

const TitlePopup = styled.div`
  width: 15rem;
  white-space: normal;
  text-align: center;

  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
`;

const WriterPopup = styled.div`
  width: 12rem;
  margin-left: 1rem;
  text-align: center;

  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
`;

const PublisherPopup = styled.div`
  width: 10rem;
  margin-left: 1rem;
  text-align: center;

  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
`;

const ReleaseDate = styled.div`
  width: 8rem;
  white-space: normal;
  word-break: break-all;
  margin-left: 1rem;
  text-align: center;
`;

const ImagePopup = styled.div``;
const PricePopup = styled.div``;

function BookReg() {
  const navigate = useNavigate();

  // 팝업창 x 버튼 기능 구현
  const [isShown, setIsShown] = useState(false);

  // 달력 보이기
  const [startDate, setStartDate] = useState(new Date());

  // 달력 값 받기
  const [endDate, setEndDate] = useState();

  // 도서 검색 input 값 받기
  const [bookTitle, setBookTitle] = useState();

  // book-external api 값 저장
  const [getBook, setGetBook] = useState([]);

  // 장소 input 값 받기
  const [location, setLocation] = useState();

  // 선택한 책 정보 받기
  const [bookInfo, setBookInfo] = useState([]);

  // 팝업 열기
  const openPopup = () => {
    setIsShown(true);
  };

  // 팝업 닫기
  const closePopup = () => {
    setIsShown(false);
  };

  const onChangeTitle = (e) => {
    setBookTitle(e.target.value);
  };

  const onChangeLocation = (e) => {
    setLocation(e.target.value);
  };

  // 팝업에서 책 제목 찾는 함수
  const SearchBook = () => {
    const data = {
      keyword: bookTitle,
      page: 1,
      pageSize: 20,
    };
    if (!bookTitle) {
      alert('키워드를 입력해 주세요.');
    } else {
      axios
        .get(`${process.env.REACT_APP_BASE_URL}/externalbooks`, {
          params: data,
        })
        .then((res) => {
          console.log(res);
          setGetBook(res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    }
  };

  // 팝업 리스트에서 하나 클릭했을 때
  const onClickBook = (e) => {
    setBookInfo([
      e.currentTarget.children[0].id, // isbn
      e.currentTarget.children[0].innerText, // 제목
      e.currentTarget.children[1].innerText, // 지은이
      e.currentTarget.children[2].innerText, // 출판사
      e.currentTarget.children[4].getAttribute('value'), // 이미지
      e.currentTarget.children[3].innerText, // 출판일
      e.currentTarget.children[5].getAttribute('value'), // 가격
    ]);
    console.log(bookInfo);
    setIsShown(false);
  };

  // 게시하기 클릭했을 때
  const onClickPost = () => {
    if (!location) {
      alert('장소를 입력해 주세요.');
    } else {
      const book = {
        book: {
          isbn: bookInfo[0],
          title: bookInfo[1],
          author: bookInfo[2],
          publisher: bookInfo[3],
          imageUrl: bookInfo[4],
          price: Number(bookInfo[6]),
          publishAt: bookInfo[5],
        },
        location,
        endDate,
      };
      console.log(book);
      axios
        .post(`${process.env.REACT_APP_BASE_URL}/book-borrows`, book)
        .then((res) => {
          console.log(res);
          alert('도서 등록에 성공했습니다!');
          navigate('/BorrowList');
        })
        .catch((err) => {
          console.log(err);
          alert('도서 등록에 실패했습니다!');
        });
    }
  };
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
                  onChange={onChangeTitle}
                />
                <WrapSearchIcon onClick={SearchBook} />
              </WrapSearchbar>

              <WrapList>
                {getBook.map((book) => (
                  <ListPopup key={book.isbn} onClick={onClickBook}>
                    <TitlePopup id={book.isbn}>{book.title}</TitlePopup>
                    <WriterPopup>{book.author.replace('^', ', ')}</WriterPopup>
                    <PublisherPopup>{book.publisher}</PublisherPopup>
                    <ReleaseDate>{book.publishAt}</ReleaseDate>
                    <ImagePopup value={book.imageUrl} />
                    <PricePopup value={book.price} />
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
              <WrapBookImage backgroundImage={bookInfo[4]} />
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
                  <WrapBookTitle>제목 : {bookInfo[1]}</WrapBookTitle>
                  <WrapBookDetail>지은이 : {bookInfo[2]}</WrapBookDetail>
                  <WrapBookDetail>출판사 : {bookInfo[3]}</WrapBookDetail>
                  <WrapWriteForm>
                    <WrapReturnAlert>
                      <Location>반납 마감일</Location>
                      <div>
                        <PickDate
                          locale={ko}
                          dateFormat='yyyy일 MM월 dd일'
                          selected={startDate}
                          onChange={(date) => {
                            const newdate = date.toISOString().slice(0, 10);
                            setEndDate(newdate);
                            setStartDate(date);
                          }}
                        />
                      </div>
                    </WrapReturnAlert>
                    <WrapReturnAlert>
                      <Location>만날 장소</Location>
                      <Input
                        width='23rem'
                        height='2.5rem'
                        placeholder='만날 장소를 적어주세요'
                        onChange={onChangeLocation}
                      />
                    </WrapReturnAlert>
                  </WrapWriteForm>

                  <WrapRegButton>
                    <Button
                      color='black'
                      background={palette('PsYellow')}
                      width='5.5rem'
                      height='2.5rem'
                      name='게시하기'
                      borderRadius='1rem'
                      onClick={onClickPost}
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
