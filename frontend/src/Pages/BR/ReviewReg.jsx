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
  width: 15rem;
  height: 19rem;
  background-color: #ffffff;
`;

const WrapReview = styled.div`
  margin-left: 3rem;
`;
const OneLineReview = styled.div`
  /* width: fit-content;
  height: fit-content;
  background-color: white;
  border-radius: 0.2rem; */
`;

const WrapDetailReview = styled.div`
  width: fit-content;
  height: 13.3rem;
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

const DetailReview = styled.div`
  margin-bottom: 1rem;
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
                <OneLineReview>
                  <Input width='40rem' height='2.3rem' placeholder='한줄평' />
                </OneLineReview>
                <WrapDetailReview>
                  <WrapStarScore>
                    <StarScore>난이도</StarScore>
                    <StarScore>평점</StarScore>
                  </WrapStarScore>
                  <DetailReview>
                    <Input width='38rem' height='7rem' placeholder='상세평' />
                  </DetailReview>
                  <WrapRegButton>
                    <RegButton
                      color={palette('PsYellow')}
                      background={palette('PsBtn')}
                      width='5.5rem'
                      height='2.5rem'
                      name='등 록'
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
