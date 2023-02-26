/* eslint-disable camelcase */
import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import { Rating } from 'react-simple-star-rating';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import Search from '../../Components/Search';
import BorrowButton from '../../Components/Btn.jsx';

const MainWrap = styled.div`
  /* display: inline-block; */
  width: 100%;
  height: 100%;
  background-color: ${palette('PsCocoa', 0)};
  position: fixed;
`;

const ListWrap = styled.div`
  /* position: absolute; */

  width: 100%;
`;
const WrapTop = styled.div`
  float: right;
  /* border: 1px solid black; */
  /* margin-bottom: 1rem; */
`;
const WrapSearchbar = styled.div`
  margin-left: 300px;
  margin-bottom: 10px;
`;

const Wrap = styled.div`
  position: fixed;
  bottom: 0;
  box-sizing: border-box;
  display: grid;
  width: 100%;
  /* margin-top: 100px; */
  padding: 1rem;
  /* border: 1px solid black; */
  grid-template-columns: repeat(4, 1fr);
  gap: 1rem;
  min-height: 75vh;
  /* min-height: 60vh; */
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
const BorrowButtons = styled.div`
  display: grid;
  grid-template-rows: 1fr;
  grid-template-columns: repeat(4, 1fr);
  grid-gap: 2rem;
  margin-right: 2rem;
`;
const WrapContent = styled.div`
  height: fit-content;
  width: fit-content;
  /* border: 1px solid black; */
  box-sizing: border-box;
  margin-bottom: 1rem;
  /* padding: 1rem; */
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 0.9rem;
`;
const WrapInfo = styled.div`
  /* float: left; */
  text-align: left;
  margin-left: 1rem;
  width: 9rem;
`;
const BookImage = styled.div`
  width: 11rem;
  height: 15rem;
  background-color: white;
`; // 책 이미지

const BookName = styled.div`
  width: 100%;
  font-size: 1rem;
`; // 책 이름

const BookInfos = styled.div`
  margin-top: 0.5rem;
`; // 책정보 저자 | 출판사

const WrapStarScore = styled.div`
  width: 100%;
  padding: 0.5rem 0rem;
  display: flex;
  flex-direction: column;
`;

const StarScore = styled.div`
  width: 3rem;
  margin-top: 0.5rem;
`;

const Deadline = styled.div`
  margin: 0.5rem 0rem;
`; // 마감일

const BorrowDate = styled.div`
  margin-bottom: 1rem;
`; // 대여일

function BorrowList() {
  // get으로 받은 리뷰 저장
  const [borrows, setBorrows] = useState([]);

  const navigate = useNavigate();
  const ToNavigateBookReg = () => {
    navigate(`/BookRegister`);
  };
  const ToNavigateReviewList = () => {
    navigate(`/ReviewList`);
  };
  const ToNavigateMyBookList = () => {
    navigate(`/MyBookList`);
  };
  useEffect(() => {
    axios
      .get(`${process.env.REACT_APP_BASE_URL}/book-borrows`)
      .then((res) => {
        console.log(res);
        setBorrows(res);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);
  return (
    <div>
      <ThemeProvider theme={theme}>
        <MainWrap>
          <Header />
          <ListWrap>
            {/* // 검색창, 버튼 4개 감쌈 */}
            <WrapTop>
              {/* // 검색창 */}
              <WrapSearchbar>
                <Search />
              </WrapSearchbar>
              {/* // 위에 버튼 4개 */}
              <BorrowButtons>
                <BorrowButton
                  color={palette('PsYellow')}
                  background={palette('PsBtn')}
                  width='6.5rem'
                  height='2.5rem'
                  name='채팅 이동'
                  borderRadius='0.5rem'
                />
                <BorrowButton
                  color={palette('PsYellow')}
                  background={palette('PsBtn')}
                  width='6.5rem'
                  height='2.5rem'
                  name='전체 북리뷰'
                  borderRadius='0.5rem'
                  onClick={ToNavigateReviewList}
                />
                <BorrowButton
                  color={palette('PsYellow')}
                  background={palette('PsBtn')}
                  width='6.5rem'
                  height='2.5rem'
                  name='내 북리스트'
                  borderRadius='0.5rem'
                  onClick={ToNavigateMyBookList}
                />
                <BorrowButton
                  color={palette('PsYellow')}
                  background={palette('PsBtn')}
                  width='6.5rem'
                  height='2.5rem'
                  name='도서 등록'
                  borderRadius='0.5rem'
                  onClick={ToNavigateBookReg}
                />
              </BorrowButtons>
            </WrapTop>
            <Wrap>
              {/* // data에 아무것도 없어서 오류 뜸 */}
              {borrows.map((borrow) => (
                <WrapContent>
                  <BookImage />
                  <WrapInfo>
                    <BookName>{borrow.book.title}</BookName>
                    <BookInfos>
                      {borrow.book.author} <br /> {borrow.title}
                    </BookInfos>
                    <WrapStarScore>
                      <StarScore>난이도</StarScore>
                      <Rating readonly size={17} initialValue={2.3} />
                    </WrapStarScore>
                    <WrapStarScore>
                      <StarScore>평점</StarScore>
                      <Rating readonly size={17} initialValue={0} />
                    </WrapStarScore>
                    <Deadline>마감일 : 2022-02-22</Deadline>
                    <BorrowDate>대여일:</BorrowDate>
                    <BorrowButton
                      color={palette('PsYellow')}
                      background={palette('PsBtn')}
                      width='5.5rem'
                      height='2.2rem'
                      name='대여하기'
                      borderRadius='0.5rem'
                      fontSize='0.9rem'
                    />
                  </WrapInfo>
                </WrapContent>
              ))}
            </Wrap>
          </ListWrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}

export default BorrowList;
