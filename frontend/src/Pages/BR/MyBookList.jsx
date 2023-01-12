import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import Button from '../../Components/Btn';

const MainWrap = styled.div`
  display: inline-block;
  width: 100%;
  height: fit-content;
  background-color: ${palette('PsCocoa', 0)};
  position: fixed;
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
  color: ${palette('PsYellow')};
  margin-bottom: 1rem;
`;

const BookList = styled.div`
  width: 49rem;
  height: fit-content;
  padding: 0.5rem;
  margin: 1.5rem auto 0.5rem auto;
  background-color: white;
  display: flex;
  border-radius: 2rem;
`;

const BookTitle = styled.div`
  margin-right: 2rem;
`;

const PostUser = styled.div`
  margin: 0rem 2rem;
`;

const State = styled.div`
  margin: 0rem 2rem;
`;
const WrapState = styled.div`
  border: 1px solid grey;
  float: right;
`;

const PostDate = styled.div`
  margin: 0rem 2rem;
`;
const BorrowUser = styled.div`
  margin: 0rem 2rem;
`;
const ReturnDate = styled.div`
  margin: 0rem 2rem;
`;
function MyBookList() {
  return (
    <ThemeProvider theme={theme}>
      <MainWrap>
        <Header />
        <WrapList>
          <ListTitle>빌린 도서 리스트</ListTitle>
          <BookList>
            <BookTitle>알고리즘</BookTitle>
            <PostUser>빌려주는 사람</PostUser>
            <State>반납 완료</State>
            <WrapState>
              <Button width='5rem' height='1.5rem' name='리뷰쓰기' />
            </WrapState>
          </BookList>
          <BookList>
            <BookTitle>인공지능</BookTitle>
            <PostUser>빌려주는 사람</PostUser>
            <State>대여중</State>
            <WrapState>
              <Button width='5rem' height='1.5rem' name='D-5' />
            </WrapState>
          </BookList>
          <BookList>
            <BookTitle>인공지능</BookTitle>
            <PostUser>빌려주는 사람</PostUser>
            <State>대여중</State>
            <WrapState>
              <Button width='5rem' height='1.5rem' name='D-5' />
            </WrapState>
          </BookList>
        </WrapList>
        <WrapList>
          <ListTitle>빌려준 도서 리스트</ListTitle>
          <BookList>
            <BookTitle>알고리즘</BookTitle>
            <PostDate>올린 날짜</PostDate>
            <BorrowUser>빌린 사람</BorrowUser>
            <State>대여중</State>
            <ReturnDate>반납 날짜</ReturnDate>
          </BookList>
          <BookList>
            <BookTitle>웹프로그래밍</BookTitle>
            <PostDate>2022/12/01</PostDate>
            <BorrowUser>빌린 사람</BorrowUser>
            <State>반납 완료</State>
            <ReturnDate>2022/01/01</ReturnDate>
          </BookList>
          <BookList>
            <BookTitle>데이터 베이스</BookTitle>
            <PostDate>2023/01/01</PostDate>
            <BorrowUser>빌린 사람</BorrowUser>
            <State>대여중</State>
            <ReturnDate>2023/02/28</ReturnDate>
          </BookList>
        </WrapList>
      </MainWrap>
    </ThemeProvider>
  );
}

export default MyBookList;
