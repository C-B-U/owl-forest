/* eslint-disable camelcase */
import React, { useState, useEffect } from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import { Rating } from 'react-simple-star-rating';
import axios from 'axios';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import Search from '../../Components/Search';
import EmptyHeart from '../../Image/EmptyHeart.png';
import FullHeart from '../../Image/FullHeart.png';

const WrapMain = styled.div`
  width: 100vw;
  height: 100vh;
  background-color: ${palette('PsCocoa', 0)};
`;

const PageTitle = styled.h1`
  /* border: 1px solid black; */
  width: fit-content;
  margin-left: 2rem;
  margin-top: 2.5rem;
  /* margin-bottom: 2rem; */
  color: ${palette('PsYellow')};
  text-align: left;
`;

const WrapSerach = styled.div`
  /* border: 1px solid black; */
  width: fit-content;
  height: fit-content;
  float: right;
  margin-top: 2rem;
  margin-right: 2rem;
`;

const WrapList = styled.div`
  position: fixed;
  width: 100%;
  height: calc(100% - 11rem);
  padding: 0rem 2rem 2rem 2rem;
  bottom: 0;
  box-sizing: border-box;

  display: grid;
  gap: 3rem 1.3rem;
  grid-template-columns: repeat(3, minmax(18.5rem, 80rem));
  overflow: auto;
  &::-webkit-scrollbar {
    width: 8px;
    height: 8px;
    border-radius: 10px;
  }
  &::-webkit-scrollbar-track {
    background: #eeeeee;
    border-radius: 5px;
  }
  &::-webkit-scrollbar-thumb {
    background: ${palette('PsGreen')};
    border-radius: 10px;
  }
`;

const WrapContent = styled.div`
  /* border: 1px solid black; */
  display: flex;
  width: 100%;
  height: fit-content;
`;

const WrapLeft = styled.div`
  width: 8rem;
`;

const WrapImage = styled.div`
  width: 8rem;
  height: 11rem;
  background-color: white;
`;

const BookTitle = styled.div`
  /* border: 1px solid black; */
  width: 8rem;
  height: fit-content;
  margin-top: 0.3rem;
  font-size: 0.9rem;

  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
`;

const WrapRight = styled.div`
  /* border: 1px solid black; */
  margin-left: 0.6rem;
  width: 100%;
  text-align: left;
`;

const WrapTop = styled.div`
  /* border: 1px solid red; */
  margin-bottom: 1rem;
  display: flex;
  justify-content: space-between;
`;

const Review = styled.div`
  /* border: 1px solid black; */
  width: calc(100% - 2rem);
  height: fit-content;
  font-size: 1rem;

  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
`;

const WrapRating = styled.div`
  width: fit-content;
  height: fit-content;
  display: flex;
`;
const StarRating = styled.div`
  /* border: 1px solid black; */
  width: 3.5rem;
  margin-bottom: 0.5rem;
`;

const Writer = styled.div`
  /* border: 1px solid black; */
  margin-top: 1.5rem;
  font-size: 0.9rem;

  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 1;
  -webkit-box-orient: vertical;
`;

const PostDate = styled.div`
  /* border: 1px solid black; */
  width: 8rem;
  margin-top: 0.4rem;
  font-size: 0.9rem;
`;

const LikeButton = styled.button`
  width: 1.5rem;
  height: 1.5rem;
  margin: -0.1rem 0rem auto auto;
  background-image: url(${(props) => props.backgroundImage}) no-repeat center;
  background-size: 1.5rem;
  border: none;
`;

function ReviewList() {
  // const [like, setLike] = useState(false);
  const [background, setBackground] = useState({ EmptyHeart });
  const [reviews, setReviews] = useState();

  const onClickLike = (e) => {
    console.log(e.target.value);
    setBackground(
      background === { EmptyHeart } ? { FullHeart } : { EmptyHeart }
    );
    // console.log(e.target.value);
    // if (e.target.value === 'empty') {
    //   console.log('빨간 하트');
    //   e.target.value = 'full';
    // } else {
    //   console.log('빈 하트');
    //   e.target.value = 'empty';
    // }
  };

  useEffect(() => {
    axios
      .get(`${process.env.REACT_APP_BASE_URL}/book-reviews`)
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  return (
    <div>
      <ThemeProvider theme={theme}>
        <WrapMain>
          <Header />
          <WrapSerach>
            <Search />
          </WrapSerach>
          <PageTitle>북리뷰 리스트</PageTitle>
          <WrapList>
            <WrapContent>
              <WrapLeft>
                <WrapImage />
                <BookTitle>
                  유닉스 이론과 실습 어쩌구 저쩌구 테스트테슽스
                </BookTitle>
              </WrapLeft>
              <WrapRight>
                <WrapTop>
                  <Review>
                    우헤헤몇글자까지가능하려나요오오오테스트테스트ㅁㄴㅇㄹㅁㄴㅇㄹ
                  </Review>
                  <LikeButton
                    onClick={onClickLike}
                    value='empty'
                    backgroundImage={background}
                  />
                </WrapTop>
                <WrapRating>
                  <StarRating>난이도</StarRating>
                  <Rating readonly size={17} initialValue={2.3} />
                </WrapRating>
                <WrapRating>
                  <StarRating>평점</StarRating>
                  <Rating readonly size={17} initialValue={0} />
                </WrapRating>

                <Writer>작성자 | 인포메이션djdjdjddjdjdj</Writer>
                <PostDate>작성일 | 2022.02.10</PostDate>
              </WrapRight>
            </WrapContent>
          </WrapList>
        </WrapMain>
      </ThemeProvider>
    </div>
  );
}

export default ReviewList;
