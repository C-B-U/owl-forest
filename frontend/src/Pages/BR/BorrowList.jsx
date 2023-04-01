/* eslint-disable camelcase */
import React, { useState, useEffect, useRef } from 'react';
import { useNavigate, useParams, useLink } from 'react-router-dom';
import axios from 'axios';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import Search from '../../Components/Search';
import Contents from './Contents';
import BorrowButton from '../../Components/Btn.jsx';

const MainWrap = styled.div`
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
  /* border: 1px solid black; */
  float: right;
`;
const WrapSearchbar = styled.div`
  margin-left: 300px;
  margin-bottom: 10px;
`;

const Wrap = styled.div`
  /* border: 1px solid black; */
  position: fixed;
  bottom: 0;
  box-sizing: border-box;
  display: grid;
  width: 100vw;
  height: calc(100vh - 11rem);
  padding: 1rem;
  grid-template-columns: repeat(3, 1fr);
  gap: 1.3rem;
  min-height: 75vh;

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

function BorrowList() {
  // 책을
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
    const data = {
      page: 0,
    };
    axios
      .get(`${process.env.REACT_APP_BASE_URL}book-borrows`, { params: data })
      .then((res) => {
        console.log(res.data);
        setBorrows(res.data);
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
              {borrows.map((borrow) => (
                <Contents
                  id={borrow.id}
                  imageUrl={borrow.book.imageUrl}
                  title={borrow.book.title}
                  author={borrow.book.author}
                  publisher={borrow.book.publisher}
                  difficulty={2.3}
                  rating={5}
                  endDate={borrow.endDate}
                  createAt='2023-03-28'
                  lender={borrow.lender.name}
                  borrower={borrow.borrower}
                  kakaoUrl={borrow.kakaoUrl}
                  location={borrow.location}
                />
              ))}
            </Wrap>
          </ListWrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}

export default BorrowList;
