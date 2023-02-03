import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import RegButton from '../../Components/Btn.jsx';
import Input from '../../Components/Input.jsx';

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
  background-color: ${palette('PsCocoa', 1)};
  padding: 3rem;
  box-sizing: content-box;
`;

const Title = styled.h1`
  color: ${palette('PsYellow')};
`;

const WrapContent = styled.div`
  display: flex;

  /* margin: auto 0; */
`;

const BookImage = styled.div`
  width: 18rem;
  height: 24rem;
  /* margin-top: 1rem; */
  background-color: #ffffff;
`;

const WrapReview = styled.div`
  margin-left: 3rem;
`;

const BookTitle = styled.h1`
  margin-top: 0rem;
  /* border: 1px solid black; */
  font-weight: bold;
`;
const BookDetail = styled.div`
  margin-bottom: 1rem;
  font-size: 1.2rem;
  /* border: 1px solid black; */
`;
const OneLineReview = styled.div`
  /* width: fit-content;
  height: fit-content;
  background-color: white;
  border-radius: 0.2rem; */
`;

const WrapDetailReview = styled.div`
  width: fit-content;
  height: 12rem;
  padding: 1rem;
  background-color: ${palette('PsLightBrown', 0)};
  /* background-color: white; */
  border-radius: 0.2rem;
  margin-top: 1rem;
  /* float: right; */
`;

const WrapStarScore = styled.div`
  display: flex;
`;

const StarScore = styled.div`
  margin-right: 1rem;
  margin-bottom: 1rem;
`;

const DetailReview = styled.textarea`
  box-sizing: border-box;
  width: 40rem;
  height: 6rem;
  display: block;
  margin-bottom: 1rem;
  padding: 1rem;
  border: 0.15rem solid rgba(128, 109, 70);
  border-radius: 0.3rem;
  font-size: 1.1rem;
  font-family: 'Noto Sans KR', sans-serif;
  resize: none;
  &:focus {
    outline: none;
  }
`;

const WrapRegButton = styled.div`
  float: right;
  /* margin-right: auto; */
`;

function ReviewReg() {
  return (
    <div>
      <ThemeProvider theme={theme}>
        <Header />
        <MainWrap>
          <Wrap>
            <Title>북리뷰 등록</Title>
            <WrapContent>
              <BookImage />
              <WrapReview>
                <BookTitle>도서 제목</BookTitle>
                <BookDetail>작가 | 출판사 | 출판일</BookDetail>
                <OneLineReview>
                  <Input width='39.7rem' height='2.3rem' placeholder='한줄평' />
                </OneLineReview>
                <WrapDetailReview>
                  <WrapStarScore>
                    <StarScore>난이도</StarScore>
                    <StarScore>평점</StarScore>
                  </WrapStarScore>
                  <DetailReview />
                  <WrapRegButton>
                    <RegButton
                      color={palette('PsYellow')}
                      background={palette('PsBtn')}
                      width='6rem'
                      height='2.5rem'
                      name='등록하기'
                      borderRadius='0.3rem'
                    />
                  </WrapRegButton>
                </WrapDetailReview>
              </WrapReview>
            </WrapContent>
          </Wrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}

export default ReviewReg;
