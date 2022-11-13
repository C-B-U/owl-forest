import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import SearchBar from '../../Components/Input';
import SearchIcon from '../../Image/SearchIcon.png';
import SerachButton from '../../Components/Btn';

const Wrap = styled.div`
  width: 100vw;
  height: 100vh;
  background-color: ${palette('PsCocoa')};
`;

const WrapPopupBackground = styled.div`
  position: absolute;
  width: 100vw;
  height: 100vh;
  /* background-color: rgba(0, 0, 0, 0.5); */
  background-color: rgba(255, 255, 255, 0.2);
`;

// Wrap 뒤로

const WrapPopup = styled.div`
  position: absolute;
  width: 60rem;
  height: 35rem;
  background-color: ${palette('PsCocoa', 1)};
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  border-radius: 1rem;
`;

const ISBNSearch = styled.div`
  font-size: 3rem;
  margin-top: 4rem;
  align-items: center;
  justify-content: center;
  text-align: center;
`;

const WrapSearchbar = styled.div`
  /* border: 1px solid black; */
  margin-top: 2rem;
  display: flex;
  align-items: center;
  justify-content: center;
`;

const SearchForm = styled.form`
  background-image: url(${SearchIcon});
  background-position: right;
  width: 40rem;
  height: 3.2rem;
  background-size: 3rem;
  background-repeat: no-repeat;
`;

const WrapSearchIcon = styled.div`
  height: 3rem;
  width: 3rem;
  background-size: 3rem;
  background-position: center;
  background-repeat: no-repeat;
  background-image: url(${SearchIcon});
`;

const WrapList = styled.div`
  /* border: 1px solid black; */
  height: fit-content;
  width: fit-content;
  margin: 2rem auto;
`;

const List = styled.div`
  width: 40rem;
  height: fit-content;
  background-color: white;
  margin-bottom: 1rem;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  box-sizing: content-box;
  padding: 0.7rem;
  justify-items: center;
  border-radius: 0.2rem;
`;

const Title = styled.div`
  width: 15rem;
  white-space: normal;
  text-align: center;
  /* border: 1px solid green; */
  /* word-break: break-all; */
`;
const Writer = styled.div`
  width: 12rem;
  white-space: normal;
  /* word-break: break-all; */
  /* border: 1px solid green; */
  margin-left: 1rem;
  text-align: center;
`;
const Publisher = styled.div`
  width: 10rem;
  white-space: normal;
  word-break: break-all;
  /* border: 1px solid green; */
  margin-left: 1rem;
  text-align: center;
`;
const ReleaseDate = styled.div`
  width: 8rem;
  white-space: normal;
  word-break: break-all;
  /* border: 1px solid green; */
  margin-left: 1rem;
  text-align: center;
`;

function BR_BookReg() {
  return (
    <ThemeProvider theme={theme}>
      <WrapPopupBackground>
        <WrapPopup>
          <ISBNSearch>ISBN 검색</ISBNSearch>
          <WrapSearchbar>
            {/* <SearchForm></SearchForm> */}
            <SearchBar
              width={'40rem'}
              height={'3.2rem'}
              placeholder='ISBN을 적어주세요.'
            ></SearchBar>
            <WrapSearchIcon />
          </WrapSearchbar>

          <WrapList>
            <List>
              <Title>프로그래밍 대회에서 배우는 알고리즘 문제 해결 전략1</Title>
              <Writer>천인국, 공용해, 하상호</Writer>
              <Publisher>생능출판사</Publisher>
              <ReleaseDate>2022.02.22</ReleaseDate>
            </List>

            <List>
              <Title>유닉스 이론과 실습</Title>
              <Writer>윤소정, 이종원</Writer>
              <Publisher>한빛아카데미</Publisher>
              <ReleaseDate>2022.02.22</ReleaseDate>
            </List>
          </WrapList>
        </WrapPopup>
      </WrapPopupBackground>

      <Wrap></Wrap>
    </ThemeProvider>
  );
}

export default BR_BookReg;
