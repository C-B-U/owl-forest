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

const WrapInfo = styled.div`
  float: left;
  margin-left: 3rem;
  width: 30rem;
`;

const BookImage = styled.div`
  width: 20rem;
  height: 28rem;
  background-color: #ffffff;
  background-image: url(${(props) => props.backgroundImage});
  background-repeat: no-repeat;
  background-size: contain;
  background-position: center;
`; // 책 이미지

const BookTitle = styled.h1`
  width: fit-content;
  height: fit-content;
  font-size: 1.5rem;
`; // 책 이름

const BookInfos = styled.h1`
  float: left;
  width: fit-content;
  height: fit-content;
  font-size: 1rem;
  margin-bottom: 2rem;
`; // 책 제목 | 저자 | 출판사

const AddInfos = styled.div`
  width: fit-content;
  height: fit-content;
  font-size: 0.8rem;
  margin-bottom: 1.5rem;
`; // 게시자, 반납일

const WrapButton = styled.div`
  margin-top: 9rem;
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
                <BookInfos>{state.author}</BookInfos>
                <BookInfos>{state.Publisher}</BookInfos>
                <AddInfos>게시자 : {state.lender}</AddInfos>
                <AddInfos>반납일 : {state.endDate}</AddInfos>
                <AddInfos>위치 : {state.location}</AddInfos>
                {state.kakaoUrl}
                <WrapButton>
                  <AskButton
                    color={palette('PsYellow')}
                    background={palette('PsBtn')}
                    width='9rem'
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
