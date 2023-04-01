import React from 'react';
import { useLocation } from 'react-router-dom';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import AskButton from '../../Components/Btn.jsx';

const MainWrap = styled.div`
  position: absolute;
  background-color: ${palette('PsCocoa', 0)};
  width: 100%;
  height: calc(100% - 4rem);
`;

const Wrap = styled.div`
  margin: 8rem auto 0rem auto;
  width: fit-content;
  height: fit-content;
  padding: 3rem;
  box-sizing: content-box;
  background-color: ${palette('PsLightBrown')};
`;

const WrapInfo = styled.div`
  /* float: center; */
  margin-left: 6.5rem;
  width: 18rem;
`;

const BookImage = styled.div`
  width: 20rem;
  height: 28rem;
  background-color: #ffffff;
`; // 책 이미지

const BookName = styled.h1`
  font-size: 20pt;
`; // 책 이름

const BookInfos = styled.h1`
  font-size: 15pt;
  margin-bottom: 2rem;
`; // 책정보 저자 | 출판사

const Publisher = styled.h1`
  font-size: 15pt;
`; // 책 게시자

const ReturnDate = styled.h1`
  font-size: 15pt;
`; // 반납일

const Location = styled.h1`
  font-size: 15pt;
`; // 위치

const WrapContent = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;

const WrapButton = styled.div`
  margin-top: 9rem;
`;

function Borrow() {
  const { state } = useLocation();
  console.log(state);
  return (
    <div>
      <ThemeProvider theme={theme}>
        <Header />
        <MainWrap>
          <Wrap>
            <WrapContent>
              <BookImage>{state.imageUrl}</BookImage>
              <WrapInfo>
                <BookName>{state.title}</BookName>
                <BookInfos>
                  {state.author} | {state.Publisher}
                </BookInfos>
                <Publisher>게시자 : {state.lender}</Publisher>
                <ReturnDate>반납일 : {state.endDate}</ReturnDate>
                <Location>위치 : {state.location}</Location>
                <Location>카카오톡 : {state.kakaoUrl}</Location>
                <WrapButton>
                  <AskButton
                    color={palette('PsYellow')}
                    background={palette('PsBtn')}
                    width='9rem'
                    height='3rem'
                    name='문의 하기'
                    borderRadius='0.7rem'
                  />
                </WrapButton>
              </WrapInfo>
            </WrapContent>
          </Wrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}

export default Borrow;
