import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import SearchBar from '../../Components/Input';
import SearchIcon from '../../Image/SearchIcon.png';
import SearchButton from '../../Components/Btn';
import Input from '../../Components/Input.jsx';

const Wrap = styled.div`
  margin: 8rem auto 0rem auto;
  // width: fit-content;
  // height: fit-content;
  background-color: #DAC9C2;
  padding: 3rem;
  box-sizing: content-box;
`;

const WrapContent = styled.div`
  display: flex;

  /* margin: auto 0; */
`;

const BookImage = styled.div`
  width: 15rem;
  height: 19rem;
  background-color: #ffffff;

`;

const Title = styled.h1`
  color: ${palette('Black')};
  text-align: left;

`;

const CalendarImage = styled.div`
    width : 15rem;
    height: 19rem;
    background-color: #aaaa;

`;


// const Title = styled.h1`
//   color: ${palette('PsYellow')};
// `;

// const WrapPopupBackground = styled.div`
//   position: absolute;
//   width: 100vw;
//   height: 100vh;
//   /* background-color: rgba(0, 0, 0, 0.5); */
//   background-color: rgba(255, 255, 255, 0.2);
// `;

// Wrap~~ --> ~~~Wrap으로 이름 바꾸기

// x 버튼 구현
// input 안으로 돋보기 버튼 넣기

// const RegisterWrap

// const WrapPopup = styled.div`
//   position: absolute;
//   width: 60rem;
//   height: 35rem;
//   background-color: ${palette('PsCocoa', 1)};
//   top: 50%;
//   left: 50%;
//   transform: translate(-50%, -50%);
//   border-radius: 1rem;
// `;

// const Title = styled.div`
//   width: 15rem;
//   white-space: normal;
//   text-align: center;
//   /* border: 1px solid green; */
//   /* word-break: break-all; */
// `;

// const Writer = styled.div`
//   width: 12rem;
//   white-space: normal;
//   /* word-break: break-all; */
//   /* border: 1px solid green; */
//   margin-left: 1rem;
//   text-align: center;
// `;

// const Publisher = styled.div`
//   width: 10rem;
//   white-space: normal;
//   word-break: break-all;
//   /* border: 1px solid green; */
//   margin-left: 1rem;
//   text-align: center;
// `;
// const ReleaseDate = styled.div`
//   width: 8rem;
//   white-space: normal;
//   word-break: break-all;
//   /* border: 1px solid green; */
//   margin-left: 1rem;
//   text-align: center;
// `;

function BR_BookReg() {
  return (
    <div>
    <ThemeProvider theme={theme}>
      <Header />
      <Wrap>
        <Title>도서등록</Title>
        <CalendarImage></CalendarImage>
        <WrapContent>
          <BookImage />

        </WrapContent>
      </Wrap>
      
      {/* <WrapPopupBackground>
        <WrapPopup>
          <ISBNSearch>ISBN 검색</ISBNSearch>
          <WrapSearchbar>
            {/* <SearchForm></SearchForm> */}
            {/* <SearchBar
              width={'40rem'}
              height={'3.2rem'}
              placeholder='ISBN을 적어주세요.'
            ></SearchBar>
            <WrapSearchIcon />
          // </WrapSearchbar> */}

          {/* <WrapList>
            <List>
              <Title>프로그래밍 대회에서 배우는 알고리즘 문제 해결 전략1</Title>
              <Writer>천인국, 공용해, 하상호</Writer>
              <Publisher>생능출판사</Publisher>
              <ReleaseDate>2022.02.22</ReleaseDate>
            </List>

            <List>
              <Title>유닉스 이론과 실습</Title>
              <Writer>윤소정, 이종원</Writer>
              <Publisher>한빛아카데미</Publisher>
              <ReleaseDate>2022.02.22</ReleaseDate>
            </List>

          </WrapList>
        </WrapPopup>
      </WrapPopupBackground> */}

      <Wrap></Wrap>
    </ThemeProvider>
  </div>
    
  );
}

export default BR_BookReg;
