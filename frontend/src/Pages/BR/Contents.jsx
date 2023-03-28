import React, { useState, useEffect, useRef } from 'react';
import { useNavigate, useParams, useLink } from 'react-router-dom';
import axios from 'axios';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import { Rating } from 'react-simple-star-rating';
import theme from '../../Components/Color';
import BorrowButton from '../../Components/Btn.jsx';

const WrapContent = styled.div`
  /* border: 1px solid black; */
  height: fit-content;
  width: fit-content;
  min-width: 24.5rem;
  box-sizing: border-box;
  margin-bottom: 1rem;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 0.9rem;
`;
const WrapInfo = styled.div`
  text-align: left;
  /* margin-left: 1rem; */
  min-width: 9rem;
`;
const BookImage = styled.div`
  width: 11rem;
  height: 15rem;
  min-width: 11rem;
  min-height: 15rem;
  margin-right: 1rem;
  background-color: white;
  background-image: url(${(props) => props.backgroundImage});
  background-repeat: no-repeat;
  background-size: contain;
  background-position: center;
`; // 책 이미지

const BookName = styled.div`
  width: 100%;
  min-width: 13rem;
  font-size: 1rem;
  font-weight: bold;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  overflow: hidden;
  text-overflow: ellipsis;
`; // 책 이름

const BookInfos = styled.div`
  margin-top: 0.5rem;
  margin-bottom: 1rem;
`; // 책정보 저자 | 출판사

const WrapStarScore = styled.div`
  /* border: 1px solid black; */
  display: flex;
`;

const StarScore = styled.div`
  /* border: 1px solid black; */
  width: 3rem;
  margin-bottom: 0.5rem;
`;

const Deadline = styled.div`
  margin: 0.5rem 0rem;
`; // 마감일

const BorrowDate = styled.div`
  margin-bottom: 1rem;
`; // 대여일

function Contents({
  id,
  imageUrl,
  title,
  author,
  publisher,
  difficulty,
  rating,
  endDate,
  createAt,
  lender,
}) {
  const navigate = useNavigate();
  const ToNavigateBorrow = () => {
    navigate(`/Borrow`, {
      state: {
        id,
        imageUrl,
        author,
        publisher,
        lender,
      },
    });
  };
  return (
    <div>
      <WrapContent key={id}>
        <BookImage backgroundImage={imageUrl} />

        <WrapInfo>
          <BookName>{title}</BookName>
          <BookInfos>
            {author} <br /> {publisher}
          </BookInfos>
          <WrapStarScore>
            <StarScore>난이도</StarScore>
            <Rating readonly size={17} initialValue={difficulty} />
          </WrapStarScore>
          <WrapStarScore>
            <StarScore>평점</StarScore>
            <Rating readonly size={17} initialValue={rating} />
          </WrapStarScore>
          <Deadline>마감일 : {endDate}</Deadline>
          <BorrowDate>게시일 : {createAt}</BorrowDate>
          <BorrowButton
            color={palette('PsYellow')}
            background={palette('PsBtn')}
            width='5.5rem'
            height='2.2rem'
            name='대여하기'
            borderRadius='0.5rem'
            fontSize='0.9rem'
            onClick={ToNavigateBorrow}
          />
        </WrapInfo>
      </WrapContent>
    </div>
  );
}

export default Contents;
