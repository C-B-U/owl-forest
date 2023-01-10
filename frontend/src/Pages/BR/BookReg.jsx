import React, { useState } from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import SearchIcon from '../../Image/SearchIcon.png';
import Button from '../../Components/Btn';
import Input from '../../Components/Input';

// ------------- 책등록 페이지 -------------

const MainWrap = styled.div`
  position: absolute;
  background-color: ${palette('PsCocoa', 0)};
  width: 100%;
  height: calc(100% - 4rem);
`;

const Wrap = styled.div`
  margin: 4rem auto 0rem auto;
  width: fit-content;
  height: fit-content;
  background-color: ${palette('PsCocoa', 1)};
  padding: 3rem;
  box-sizing: content-box;
`;

const Title = styled.h1`
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

const WrapRegister = styled.div`
  margin-left: 3rem;
`;
const WrapBookTitle = styled.div`
  /* width: fit-content;
  height: fit-content;
  background-color: white;
  border-radius: 0.2rem; */
`;

const WrapBookDetail = styled.div`
  /* width: fit-content;
  height: fit-content;
  background-color: white;
  border-radius: 0.2rem; */
  margin-top: 1rem;
`;

const WrapBookReturn = styled.div`
  width: fit-content;
  height: 13.3rem;
  padding: 1rem;
  background-color: ${palette('PsLightBrown', 0)};
  /* background-color: white; */
  border-radius: 0.2rem;
  margin-top: 2rem;
  /* float: right; */
`;

const WrapReturnAlert = styled.div`
  display: flex;
`;

const ReturnAlert = styled.div`
  margin-right: 1rem;
  margin-bottom: 1rem;
`;

const DetailDate = styled.div`
  margin-bottom: 1rem;
`;

const WrapRegButton = styled.div`
  float: right;
`;

// ---------------- 팝업창 작업----------------

const WrapPopupBackground = styled.div`
  position: absolute;
  width: 100vw;
  height: 100%;
  /* background-color: rgba(0, 0, 0, 0.5); */
  background-color: rgba(255, 255, 255, 0.2);
`;

const WrapPopup = styled.div`
  position: absolute;
  width: 60rem;
  height: 35rem;
  background-color: ${palette('PsCocoa', 1)};
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  border-radius: 1rem;
`;

const ISBNSearch = styled.div`
  font-size: 3rem;
  margin-top: 4rem;
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
`;

const SearchForm = styled.form`
  background-image: url(${SearchIcon});
  background-position: right;
  width: 40rem;
  height: 3.2rem;
  background-size: 3rem;
  background-repeat: no-repeat;
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
  /* border: 1px solid black; */
  height: fit-content;
  width: fit-content;
  margin: 2rem auto;
`;

const ListPopup = styled.div`
  width: 40rem;
  height: fit-content;
  background-color: white;
  margin-bottom: 1rem;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  box-sizing: content-box;
  padding: 0.7rem;
  justify-items: center;
  border-radius: 0.2rem;
`;

const TitlePopup = styled.div`
  width: 15rem;
  white-space: normal;
  text-align: center;
  /* border: 1px solid green; */
  /* word-break: break-all; */
`;
const WriterPopup = styled.div`
  width: 12rem;
  white-space: normal;
  /* word-break: break-all; */
  /* border: 1px solid green; */
  margin-left: 1rem;
  text-align: center;
`;
const PublisherPopup = styled.div`
  width: 10rem;
  white-space: normal;
  word-break: break-all;
  /* border: 1px solid green; */
  margin-left: 1rem;
  text-align: center;
`;
const ReleaseDate = styled.div`
  width: 8rem;
  white-space: normal;
  word-break: break-all;
  /* border: 1px solid green; */
  margin-left: 1rem;
  text-align: center;
`;

function BookReg() {
  // 팝업창 x 버튼 기능 구현
  const [isShown, setIsShown] = useState(false);

  const handleClick = (e) => {
    setIsShown((current) => !current);
  };

  return (
    <div>
      <ThemeProvider theme={theme}>
        <Header />
        <MainWrap>
          {/* 
              ---------------- 팝업창 작업----------------
          */}

          <WrapPopupBackground style={{ display: isShown ? 'block' : 'none' }}>
            <WrapPopup>
              <Button onclick={handleClick} name='x' />
              <ISBNSearch>ISBN 검색</ISBNSearch>
              <WrapSearchbar>
                {/* <SearchForm></SearchForm> */}
                <Input
                  width='40rem'
                  height='3.2rem'
                  placeholder='ISBN을 적어주세요.'
                />
                <WrapSearchIcon />
              </WrapSearchbar>

              <WrapList>
                <ListPopup>
                  <TitlePopup>
                    프로그래밍 대회에서 배우는 알고리즘 문제 해결 전략1
                  </TitlePopup>
                  <WriterPopup>천인국, 공용해, 하상호</WriterPopup>
                  <PublisherPopup>생능출판사</PublisherPopup>
                  <ReleaseDate>2022.02.22</ReleaseDate>
                </ListPopup>

                <ListPopup>
                  <TitlePopup>유닉스 이론과 실습</TitlePopup>
                  <WriterPopup>윤소정, 이종원</WriterPopup>
                  <PublisherPopup>한빛아카데미</PublisherPopup>
                  <ReleaseDate>2022.02.22</ReleaseDate>
                </ListPopup>
              </WrapList>
            </WrapPopup>
          </WrapPopupBackground>

          {/*
              ------------- 책등록 페이지 작업 -------------
           */}

          <Wrap>
            <Title>도서 등록</Title>
            {/* <button onclick={handleClick}>팝업 여는 테스트 버튼</button> */}
            <WrapContent>
              <WrapBookImage />
              <WrapRegister>
                <WrapBookTitle>
                  <Input width='40rem' height='2.3rem' placeholder='책 제목' />
                </WrapBookTitle>
                <WrapBookDetail>
                  <Input
                    width='40rem'
                    height='2.3rem'
                    placeholder='( 작가 | 출판사 | 출판일 )'
                  />
                </WrapBookDetail>
                <WrapBookReturn>
                  <WrapReturnAlert>
                    <ReturnAlert>반납 마감일</ReturnAlert>
                    <ReturnAlert>반납날짜 : 연도 | 월 | 일 </ReturnAlert>
                  </WrapReturnAlert>
                  <DetailDate>
                    <Input
                      width='38rem'
                      height='7rem'
                      placeholder='달력..이미지 어떡하죠'
                    />
                  </DetailDate>
                  <WrapRegButton>
                    <Button
                      color={palette('PsYellow')}
                      background={palette('PsBtn')}
                      width='5.5rem'
                      height='2.5rem'
                      name='게시하기'
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
