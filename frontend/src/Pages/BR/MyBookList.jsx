import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import axios from 'axios';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import Button from '../../Components/Btn';

const MainWrap = styled.div`
  position: absolute;
  background-color: ${palette('PsCocoa', 0)};
  width: 100%;
  height: 100%;
`;

const WrapContent = styled.div`
  width: 100%;
  height: fit-content;
  margin-bottom: 2rem;
  background-color: ${palette('PsCocoa', 0)};
  border: 0.01px solid ${palette('PsCocoa', 0)};
`;
const WrapList = styled.div`
  width: 50rem;
  height: fit-content;
  margin: 5rem auto;
  background-color: ${palette('PsCocoa', 1)};
  padding: 1.5rem;
  border-radius: 1rem;
`;

const ListTitle = styled.div`
  font-size: 1.5rem;
  font-weight: bold;
  color: ${palette('PsYellow')};
  margin-bottom: 1rem;
`;

const Guide = styled.div`
  width: 46rem;
  height: fit-content;
  background-color: white;
  border-radius: 2rem;
  box-sizing: content-box;
  display: flex;
  justify-content: space-between;
  margin: 1.5rem auto 0.5rem auto;
  padding: 0.5rem 2rem;
`;

const BookList = styled.div`
  width: 46rem;
  height: fit-content;
  align-items: center;
  background-color: ${palette('PsLightBrown', 1)};
  border-radius: 2rem;
  box-sizing: content-box;
  display: flex;
  justify-content: space-between;
  margin: 1.5rem auto 0.5rem auto;
  padding: 0.5rem 2rem;
`;

const BookTitle = styled.div`
  width: 11rem;
  text-align: center;
  word-break: break-all;
  -webkit-line-clamp: 2;
  text-overflow: ellipsis;
  //border: 1px solid grey;
`;

const PostUser = styled.div`
  width: 9rem;
  text-align: center;
  word-break: break-all;
  //border: 1px solid grey;
`;

const State = styled.div`
  width: 5rem;
  text-align: center;
`;

const WrapStateButton = styled.div`
  width: 6rem;
  text-align: center;
  /* pointer-events: none; */
`;

const PostDate = styled.div`
  width: 7rem;
  text-align: center;
`;

const BorrowUser = styled.div`
  width: 9rem;
  text-align: center;
  //border: 1px solid grey;
`;

const ReturnDate = styled.div`
  width: 7rem;
  text-align: center;
`;

function MyBookList() {
  const navigate = useNavigate();
  const [myLend, getMyLend] = useState([]);

  const navigateToReview = () => {
    navigate('/ReviewRegister');
  };

  useEffect(
    axios
      .get(`${process.env.REACT_APP_BASE_URL}book-borrows/my-lend`)
      .then((res) => {
        console.log(res);
        getMyLend(res);
      })
      .catch((err) => {
        console.log(err);
      }),
    []
  );
  console.log(myLend);
  return (
    <ThemeProvider theme={theme}>
      <MainWrap>
        <Header />
        <WrapContent>
          <WrapList>
            <ListTitle>빌린 도서 리스트</ListTitle>

            <Guide>
              <BookTitle>도서 제목</BookTitle>
              <PostUser>빌려주는 사람</PostUser>
              <State>반납 상태</State>
              <WrapStateButton>남은 날짜</WrapStateButton>
            </Guide>

            <BookList>
              <BookTitle>컴퓨터활용능력 1급 실기</BookTitle>
              <PostUser>2019156014 김혜진</PostUser>
              <State>반납 완료</State>
              <WrapStateButton>
                <Button
                  width='6rem'
                  height='1.5rem'
                  name='리뷰쓰기'
                  background={palette('PsYellow')}
                  onClick={navigateToReview}
                  borderRadius='10rem'
                />
              </WrapStateButton>
            </BookList>

            <BookList>
              <BookTitle>
                코틀린을 활용한 안드로이드 프로그래밍 우재남, 유혜림
              </BookTitle>
              <PostUser>2019150012 김혜진</PostUser>
              <State>대여중</State>
              <WrapStateButton>
                <Button
                  width='6rem'
                  height='1.5rem'
                  name='D-100'
                  borderRadius='10rem'
                />
              </WrapStateButton>
            </BookList>
          </WrapList>

          <WrapList>
            <ListTitle>빌려준 도서 리스트</ListTitle>

            <Guide>
              <BookTitle>도서 제목</BookTitle>
              <PostDate>올린 날짜</PostDate>
              <BorrowUser>빌린 사람</BorrowUser>
              <State>대여 상태</State>
              <ReturnDate>반납 날짜</ReturnDate>
            </Guide>

            <BookList>
              <BookTitle>밑바닥부터 시작하는 딥러닝</BookTitle>
              <PostDate>2022/12/01</PostDate>
              <BorrowUser>2019146013 김혜진</BorrowUser>
              <State>반납 완료</State>
              <ReturnDate>2022/01/01</ReturnDate>
            </BookList>

            <BookList>
              <BookTitle>명품 JAVA Programming</BookTitle>
              <PostDate>2023/01/01</PostDate>
              <BorrowUser>2019157010 김혜진</BorrowUser>
              <State>대여중</State>
              <ReturnDate>2023/02/28</ReturnDate>
            </BookList>
          </WrapList>
        </WrapContent>
      </MainWrap>
    </ThemeProvider>
  );
}

export default MyBookList;
