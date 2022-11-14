/* eslint-disable no-unused-vars */
import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import MLProfileCon from '../../Components/MMList/MLProfileCon';
import profileimg from '../../Image/cbu_circle.png';

//가로 정렬
const MainWrap = styled.div`
  display: flex;
  background-color: ${palette('PsWhite')};
`;

const SecondWrap = styled.div`
  display: inline-block;
  overflow-x: hidden;
`;

const LineUp = styled.div`
  width: 100vw;
  height: 75.5vh;
  overflow: auto;
`;

//마이페이지, 검색의 가로 정렬을 위해 사용
const SearchWrap = styled.div`
  display: flex;
  white-space: wrap;
`;

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
  margin-left: 1.7rem;
  font-weight: bolder;
  margin-right: 43.2rem;
`;

const SearchBox = styled.input`
  width: 10rem;
  height: 2rem;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 2rem;
  font-family: 'Noto Sans KR', sans-serif;
  padding: 0rem 1rem;
  border: 0.5rem;
  font-size: 12pt;
  margin-top: 2.8rem;
  font-weight: bolder;
  margin-left: 1rem;
  margin-right: 1rem;
`;

const MemList = styled.div`
  width: 75rem;
  height: 3.5rem;
  border-radius: 3rem;
  margin-top: 0.8rem;
  padding-left: 1.5rem;
  display: flex;
  background-color: ${palette('PsLightBrown')};
  margin-left: 1.5rem;
`;
const MemListInput = styled.div`
  font-size: 1.2rem;
  font-weight: bold;
  display: flex;
  align-items: center;
`;
const MemNav = styled.div`
  width: 75rem;
  height: 5rem;
  border-radius: 3rem;
  margin-top: 0.8rem;
  padding-left: 1.5rem;
  display: flex;
  background-color: ${palette('PsLightBrown')};
  margin-left: 1.5rem;
  align-items: center;
`;

const Scroll = styled.div`
  overflow: auto;
`;
const Wrap1 = styled.div`
  overflow-y: auto;
`;
const SelcBox = styled.div`
  width: 5rem;
  height: 2rem;
  background-color: ${palette('PsGreen')};
  border-radius: 2rem;
  font-family: 'Noto Sans KR', sans-serif;
  border: 0.5rem;
  font-size: 12pt;
  margin-top: 3rem;
  font-weight: bolder;
  margin-right: 0.4rem;
`;

const SortOption = styled.div`
  margin-top: 0.7rem;
  margin-bottom: 0.7rem;
  margin-left: 71rem;
`;
const Photo = styled.div`
  width: 3rem;
  height: 3rem;
  border-radius: 100%;
  background-color: rgba(217, 217, 217, 1);
  background-image: url(${profileimg});
  background-position: center;
  background-size: 3.5rem;
  background-repeat: no-repeat;
`;

function MM_MemListCon() {
  return (
    <div>
      <ThemeProvider theme={theme}>
        <MainWrap>
          <MLProfileCon />

          <SecondWrap>
            <SearchWrap>
              <InfoButton>마이페이지</InfoButton>
              <SelcBox>&nbsp;▼</SelcBox>
              <SearchBox />
            </SearchWrap>
            <MemNav>
              <MemListInput style={{ fontSize: '1.8rem' }}>
                프사 &nbsp; 이름&emsp; 학과&emsp;&emsp;&emsp; 학년&emsp;
                기수&emsp; 스터디/스택
              </MemListInput>
            </MemNav>
            <SortOption>이름순 ↑↓</SortOption>

            <LineUp>
              <Scroll>
                <MemList>
                  <MemListInput>
                    <Photo />
                    &emsp;&nbsp;&nbsp; 씨부엉이&emsp;
                    컴퓨터공학과&emsp;&nbsp;&nbsp; 2학년&emsp;&emsp;
                    14기&emsp;&emsp;&nbsp;&nbsp; 자바, 코틀린 등
                  </MemListInput>
                </MemList>
                <MemList>
                  <MemListInput>
                    <Photo />
                    &emsp;&nbsp;&nbsp; 씨부엉이&emsp;
                    컴퓨터공학과&emsp;&nbsp;&nbsp; 2학년&emsp;&emsp;
                    14기&emsp;&emsp;&nbsp;&nbsp; 자바, 코틀린 등
                  </MemListInput>
                </MemList>
                <MemList>
                  <MemListInput>
                    <Photo />
                    &emsp;&nbsp;&nbsp; 씨부엉이&emsp;
                    컴퓨터공학과&emsp;&nbsp;&nbsp; 2학년&emsp;&emsp;
                    14기&emsp;&emsp;&nbsp;&nbsp; 자바, 코틀린 등
                  </MemListInput>
                </MemList>
                <MemList>
                  <MemListInput>
                    <Photo />
                    &emsp;&nbsp;&nbsp; 씨부엉이&emsp;
                    컴퓨터공학과&emsp;&nbsp;&nbsp; 2학년&emsp;&emsp;
                    14기&emsp;&emsp;&nbsp;&nbsp; 자바, 코틀린 등
                  </MemListInput>
                </MemList>
                <MemList>
                  <MemListInput>
                    <Photo />
                    &emsp;&nbsp;&nbsp; 씨부엉이&emsp;
                    컴퓨터공학과&emsp;&nbsp;&nbsp; 2학년&emsp;&emsp;
                    14기&emsp;&emsp;&nbsp;&nbsp; 자바, 코틀린 등
                  </MemListInput>
                </MemList>
                <MemList>
                  <MemListInput>
                    <Photo />
                    &emsp;&nbsp;&nbsp; 씨부엉이&emsp;
                    컴퓨터공학과&emsp;&nbsp;&nbsp; 2학년&emsp;&emsp;
                    14기&emsp;&emsp;&nbsp;&nbsp; 자바, 코틀린 등
                  </MemListInput>
                </MemList>
                <MemList>
                  <MemListInput>
                    <Photo />
                    &emsp;&nbsp;&nbsp; 씨부엉이&emsp;
                    컴퓨터공학과&emsp;&nbsp;&nbsp; 2학년&emsp;&emsp;
                    14기&emsp;&emsp;&nbsp;&nbsp; 자바, 코틀린 등
                  </MemListInput>
                </MemList>
                <MemList>
                  <MemListInput>
                    <Photo />
                    &emsp;&nbsp;&nbsp; 씨부엉이&emsp;
                    컴퓨터공학과&emsp;&nbsp;&nbsp; 2학년&emsp;&emsp;
                    14기&emsp;&emsp;&nbsp;&nbsp; 자바, 코틀린 등
                  </MemListInput>
                </MemList>
                <MemList>
                  <MemListInput>
                    <Photo />
                    &emsp;&nbsp;&nbsp; 씨부엉이&emsp;
                    컴퓨터공학과&emsp;&nbsp;&nbsp; 2학년&emsp;&emsp;
                    14기&emsp;&emsp;&nbsp;&nbsp; 자바, 코틀린 등
                  </MemListInput>
                </MemList>
                <MemList>
                  <MemListInput>
                    <Photo />
                    &emsp;&nbsp;&nbsp; 씨부엉이&emsp;
                    컴퓨터공학과&emsp;&nbsp;&nbsp; 2학년&emsp;&emsp;
                    14기&emsp;&emsp;&nbsp;&nbsp; 자바, 코틀린 등
                  </MemListInput>
                </MemList>
                <MemList>
                  <MemListInput>
                    <Photo />
                    &emsp;&nbsp;&nbsp; 씨부엉이&emsp;
                    컴퓨터공학과&emsp;&nbsp;&nbsp; 2학년&emsp;&emsp;
                    14기&emsp;&emsp;&nbsp;&nbsp; 자바, 코틀린 등
                  </MemListInput>
                </MemList>
                <MemList>
                  <MemListInput>
                    <Photo />
                    &emsp;&nbsp;&nbsp; 씨부엉이&emsp;
                    컴퓨터공학과&emsp;&nbsp;&nbsp; 2학년&emsp;&emsp;
                    14기&emsp;&emsp;&nbsp;&nbsp; 자바, 코틀린 등
                  </MemListInput>
                </MemList>
              </Scroll>
            </LineUp>
          </SecondWrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}
export default MM_MemListCon;
