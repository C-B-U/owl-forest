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
  // display: flex;
`;

const LineUp = styled.div`
  flexwrap: wrap;
  position: sticky;
  margin-left: auto;
`;

//마이페이지, 검색의 가로 정렬을 위해 사용
const SearchWrap = styled.div`
  display: flex;
  // margin-left: auto;
  // padding-right: 1rem;
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
  margin-right: 48.5rem;
`;

const SearchBox = styled.div`
  width: 15rem;
  height: 2.8rem;
  background-color: ${palette('PsGreen')};
  border-radius: 3rem;
  font-family: 'Noto Sans KR', sans-serif;
  border: 0.5rem;
  font-size: 12pt;
  margin-top: 2rem;
  font-weight: bolder;
  margin-left: auto;
  margin-right: 1rem;
`;
const MemList = styled.div`
  width: 75rem;
  height: 1rem;
  border-radius: 3rem;
  margin-top: 0.8rem;
  padding: 1.5rem;
  display: flex;
  background-color: ${palette('PsLightBrown')};
  margin-left: 1.5rem;
`;
const MemListInput = styled.div`
  font-size: 10pt;
  font-weight: bold;
  display: flex;
  justify-content: center;
`;
const Wrap = styled.div`
  position: fixed;
`;
function MM_MemList() {
  return (
    <div>
      <ThemeProvider theme={theme}>
        <MainWrap>
          <Wrap>
            <MLProfile />
          </Wrap>

          <LineUp>
            <SearchWrap>
              <InfoButton>마이페이지</InfoButton>
              <SearchBox></SearchBox>
            </SearchWrap>

            <MemList>
              <MemListInput>안녕하세요</MemListInput>
            </MemList>
            <MemList>
              <MemListInput>안녕하세요</MemListInput>
            </MemList>
            <MemList>
              <MemListInput>안녕하세요</MemListInput>
            </MemList>
            <MemList>
              <MemListInput>안녕하세요</MemListInput>
            </MemList>
            <MemList>
              <MemListInput>안녕하세요</MemListInput>
            </MemList>
            <MemList>
              <MemListInput>안녕하세요</MemListInput>
            </MemList>
            <MemList>
              <MemListInput>안녕하세요</MemListInput>
            </MemList>
            <MemList>
              <MemListInput>안녕하세요</MemListInput>
            </MemList>
            <MemList>
              <MemListInput>안녕하세요</MemListInput>
            </MemList>
            <MemList>
              <MemListInput>안녕하세요</MemListInput>
            </MemList>
            <MemList>
              <MemListInput>안녕하세요</MemListInput>
            </MemList>
            <MemList>
              <MemListInput>안녕하세요</MemListInput>
            </MemList>
            <MemList>
              <MemListInput>안녕하세요</MemListInput>
            </MemList>
            <MemList>
              <MemListInput>안녕하세요</MemListInput>
            </MemList>
            <MemList>
              <MemListInput>안녕하세요</MemListInput>
            </MemList>
          </LineUp>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}

export default MM_MemList;
