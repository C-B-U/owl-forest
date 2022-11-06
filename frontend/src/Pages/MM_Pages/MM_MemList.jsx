import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import MLProfile from '../../Components/MMList/MLProfile';

//--------------------------------------
//리스트 왼쪽 margin은 1.5로 주기!
//---------------------------------------

//가로 정렬
const MainWrap = styled.div`
  display: flex;
`;

//리스트에서 사용
const ListWrap = styled.div`
  padding-left: auto;
  display: flex;
`;

const Rightlineup = styled.div`
  float: right;
  padding-left: 60rem;
`;

//마이페이지, 검색의 가로 정렬을 위해 사용
const SearchWrap = styled.div`
  // display: flex;
`;

const Test = styled.div``;

const Memlist = styled.li`
  width: 20rem;
  height: 3rem;
  border-radius: 1.5rem;
  list-style: none;
  list-style-position: inside;
  background-color: rgba(179, 146, 131, 1);
  align-items: center;
  justify-content: center;
  display: flex;
  margin-top: 1.2rem;
  margin-left: 1.2 rem;
`;

const InfoButton = styled.button`
  width: 15rem;
  height: 2.8rem;
  background-color: ${palette('PsGreen')};
  border-radius: 3rem;
  font-family: 'Noto Sans KR', sans-serif;
  border: none;
  font-size: 12pt;
  margin-top: 2rem;
  margin-left: 1.5rem;
  font-weight: bolder;
`;

const SearchBox = styled.div`
  width: 15rem;
  height: 2.8rem;
  background-color: ${palette('PsGreen')};
  border-radius: 3rem;
  font-family: 'Noto Sans KR', sans-serif;
  border: none;
  font-size: 12pt;
  margin-top: 2rem;
  margin-left: 1.5rem;
  font-weight: bolder;
`;

function MM_MemList() {
  return (
    <div>
      <ThemeProvider theme={theme}>
        <MainWrap>
          <MLProfile />

          <SearchWrap>
            <InfoButton>마이 페이지</InfoButton>

            <Rightlineup>
              <SearchBox></SearchBox>
            </Rightlineup>
          </SearchWrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}

export default MM_MemList;
