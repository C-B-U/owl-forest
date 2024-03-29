/* eslint-disable no-unused-vars */
import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import MLProfileCon from '../../Components/MMList/MLProfileCon';
import MLList from '../../Components/MMList/MLList';

// 가로 정렬
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
  margin-top: 2.5rem;
`;

// 마이페이지, 검색의 가로 정렬을 위해 사용
const SearchWrap = styled.div`
  display: flex;
  white-space: wrap;
  margin-left: 16rem;
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

const SortOption = styled.div`
  margin-top: 0.8rem;
  margin-bottom: 0rem;
  margin-left: 67rem;
  position: absolute;
`;

const SelectBox = styled.select`
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  width: 5rem;
  height: 2rem;
  background-color: ${palette('PsGreen')};
  border-radius: 3rem;
  font-family: 'Noto Sans KR', sans-serif;
  &:focus {
    outline: none;
  }
  border: none;
  padding-left: 1.7rem;
  margin-top: 3rem;
  margin-left: 43.2rem;
`;

const PhotoInfo = styled.div``;

const NameInfo = styled.div`
  margin-left: 1.5rem;
`;

const MajorInfo = styled.div`
  margin-left: 6rem;
  text-align: left;
`;

const GradeInfo = styled.div`
  margin-left: 9rem;
`;
const InterstinInfo = styled.div`
  margin-left: 3rem;
`;

function MemListCon() {
  return (
    <div>
      <ThemeProvider theme={theme}>
        <MainWrap>
          <MLProfileCon />

          <SecondWrap>
            <SearchWrap>
              <SelectBox name='generation'>
                <option value='none'> 이름 </option>
                <option value='1기'>학과</option>
              </SelectBox>
              <SearchBox />
            </SearchWrap>
            <MemNav>
              <MemListInput style={{ fontSize: '1.8rem' }}>
                <PhotoInfo>프사</PhotoInfo>
                <NameInfo>이름</NameInfo>
                <MajorInfo>학과</MajorInfo>
                <GradeInfo>학년</GradeInfo>
                <InterstinInfo>관심분야</InterstinInfo>
              </MemListInput>
            </MemNav>
            <SortOption>
              <b>이름순&nbsp;</b> 학과순&nbsp; 학년순
            </SortOption>
            <LineUp>
              <Scroll>
                <MLList />
              </Scroll>
            </LineUp>
          </SecondWrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}
export default MemListCon;
