import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Rating } from 'react-simple-star-rating';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import axios from 'axios';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import RegButton from '../../Components/Btn.jsx';
import Input from '../../Components/Input.jsx';

const MainWrap = styled.div`
  position: absolute;
  background-color: ${palette('PsCocoa', 0)};
  width: 100%;
  padding: auto;
  height: calc(100% - 4rem);
`;

const Wrap = styled.div`
  margin: 8rem auto 0rem auto;
  width: fit-content;
  height: fit-content;
  background-color: ${palette('PsCocoa', 1)};
  padding: 3rem;
  text-align: left;
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
  /* border: 1px solid black; */
  margin-bottom: 1rem;
  font-size: 1.2rem;
`;
const WrapReviewTitle = styled.div`
  margin-right: 0.4rem;
`;

const WrapDetailReview = styled.div`
  width: fit-content;
  height: 12rem;
  margin-top: 1rem;
  padding: 1rem;
  background-color: ${palette('PsLightBrown', 0)};
  border-radius: 0.2rem;
`;

const WrapStar = styled.div`
  width: 40rem;
  display: flex;
`;

const WrapStarRating = styled.div`
  margin-right: 1rem;
  margin-bottom: 1rem;
  display: flex;
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
  font-family: 'Noto Sans KR', sans-serif;
  resize: none;
  &:focus {
    outline: none;
  }
`;

const WrapRegButton = styled.div`
  float: right;
`;

function ReviewReg() {
  const navigate = useNavigate();
  const [oneLineReview, setOneLineReview] = useState();
  const [detailReview, setDetailReview] = useState();
  const [difficultRating, setDifficultRating] = useState(0);
  const [scoreRating, setScoreRating] = useState(0);

  const onChangeOneLineReview = (e) => {
    setOneLineReview(e.target.value);
  };

  const onChangeDetailReview = (e) => {
    setDetailReview(e.target.value);
  };

  const onClickDifficultRating = (rate) => {
    setDifficultRating(rate);
  };

  const onClickScoreRating = (rate) => {
    setScoreRating(rate);
  };

  const PostReview = () => {
    const oneLine = { oneLineReview };
    const detail = { detailReview };
    const review = {
      book: {
        isbn: '798789789978',
        title: '미움 받을 용기',
        author: '독도독도',
        publisher: 'test_b64e856b1458',
        imageUrl: 'aaa.bb.com',
        price: 62,
        publishAt: '2023-02-10',
      },
      title: oneLine.oneLineReview,
      content: detail.detailReview,
      score: scoreRating,
      difficulty: difficultRating,
    };
    console.log(review);
    axios
      .post(`${process.env.REACT_APP_BASE_URL}book-reviews`, review)
      .then((res) => {
        console.log(res);
        alert('리뷰가 등록되었습니다.');
        navigate(`/ReviewList`);
      })
      .catch((error) => {
        console.log(error);
        alert('리뷰 등록에 실패했습니다');
        // navigate(`/ReviewList`);
      });
  };

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
                <Input
                  width='39.7rem'
                  height='2.3rem'
                  placeholder='50자 내의 한줄평을 작성해 주세요'
                  maxLength='65'
                  onChange={onChangeOneLineReview}
                />
                <WrapDetailReview>
                  <WrapStar>
                    <WrapStarRating>
                      <WrapReviewTitle>난이도</WrapReviewTitle>
                      <Rating
                        onClick={onClickDifficultRating}
                        ratingValue={difficultRating}
                        size={20}
                      />
                    </WrapStarRating>
                    <WrapStarRating>
                      <WrapReviewTitle>평점</WrapReviewTitle>
                      <Rating
                        onClick={onClickScoreRating}
                        ratingValue={scoreRating}
                        size={20}
                      />
                    </WrapStarRating>
                  </WrapStar>
                  <DetailReview
                    placeholder='250자 내의 상세평을 작성해 주세요'
                    onChange={onChangeDetailReview}
                  />
                  <WrapRegButton>
                    <RegButton
                      color={palette('PsYellow')}
                      background={palette('PsBtn')}
                      width='6rem'
                      height='2.5rem'
                      name='등록하기'
                      borderRadius='0.3rem'
                      onClick={PostReview}
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
