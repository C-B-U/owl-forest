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
  margin: 5rem auto 0rem auto;
  width: fit-content;
  height: fit-content;
  padding: 3rem;
  box-sizing: content-box;
  background-color: ${palette('PsLightBrown')};
`;

const WrapContent = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;

const BookImage = styled.div`
  width: 20rem;
  height: 28rem;
  background-color: white;
  background-image: url(${(props) => props.backgroundImage});
  background-repeat: no-repeat;
  background-size: contain;
  background-position: center;
`; // 책 이미지

const WrapInfo = styled.div`
  /* border: 2px solid black; */
  float: left;
  margin-left: 3rem;
  width: 30rem;
  height: 30rem;
`;

const BookTitle = styled.h1`
  /* border: 2px solid red; */
  width: fit-content;
  height: fit-content;
  font-size: 1.5rem;
  text-align: left;
  /* margin-top: -0.5rem; */
  margin-bottom: 0.5rem;
`; // 책 이름

const BookInfo = styled.h1`
  /* border: 2px solid blue; */
  width: fit-content;
  height: fit-content;
  font-size: 1.1rem;
  margin-bottom: 2rem;
`; // 책 저자 | 출판사

const BookLender = styled.div`
  /* border: 2px solid green; */
  width: fit-content;
  height: fit-content;
  font-size: 1rem;
  margin-bottom: 0.5rem;
`; // 게시자

const BookEndDate = styled.div`
  /* border: 2px solid purple; */
  width: fit-content;
  height: fit-content;
  font-size: 1rem;
  margin-bottom: 0.5rem;
`; // 반납일

const Location = styled.div`
  /* border: 2px solid black; */
  width: fit-content;
  height: fit-content;
  font-size: 1rem;
`; // 장소

const WrapButton = styled.div`
  /* margin-top: 9rem; */
  bottom: 0;
`;

function Borrow() {
  const { state } = useLocation();
  console.log(state);

  const url = state.kakaoUrl;
  return (
    <div>
      <ThemeProvider theme={theme}>
        <Header />
        <MainWrap>
          <Wrap>
            <WrapContent>
              <BookImage backgroundImage={state.imageUrl} />
              <WrapInfo>
                <BookTitle>{state.title}</BookTitle>
                <BookInfo>
                  {state.publisher} | {state.author}
                </BookInfo>
                <BookLender>게시자 : {state.lender}</BookLender>
                <BookEndDate>반납일 : {state.endDate}</BookEndDate>
                <BookEndDate>게시일 : {state.createAt}</BookEndDate>
                <Location>위치 : {state.location}</Location>
                <WrapButton>
                  <AskButton
                    color={palette('PsYellow')}
                    background={palette('PsBtn')}
                    width='11rem'
                    height='3rem'
                    name='문의 하기'
                    fontWeight='bold'
                    borderRadius='0.7rem'
                    onClick={() => {
                      window.open(url);
                    }}
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
