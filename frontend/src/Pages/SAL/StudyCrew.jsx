import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import StudyProfile from '../../Components/ActivityLog/StudyProfile';

const MainWrap = styled.div`
  display: flex;
  height: calc(100vh - 64px);
  background-color: ${palette('PsCocoa', 0)};
`;

const HeaderTitle = styled.header`
  height: 4rem;
  padding-left: 1rem;
  font-size: 20pt;
  font-weight: bold;
  color: #fafad2;
  align-items: center;
  justify-content: left;
  display: flex;
`;

const RightMainWrap = styled.div`
  margin: 5rem 0px;
  width: 100%;
  margin-right: 5rem;
`;

const StudyList = styled.div`
  width: 71rem;
  height: 8rem;
  border-radius: 1rem;
  margin-top: 0.8rem;
  padding: 1.5rem;
  display: inline-block;
  background-color: ${palette('PsLightBrown')};
`;

const Scroll = styled.div`
  width: 100%;
  height: 43.5rem;
  margin-right: -7px;
  overflow-y: auto;
  &::-webkit-scrollbar {
    background: white;
    width: 7px;
  }

  &::-webkit-scrollbar-thumb {
    background: ${palette('PsCocoa', 0)};
  }
  & > div:nth-child(1) {
    margin-top: 0px;
  }
`;

function StudyCrew() {
  return (
    <ThemeProvider theme={theme}>
      <Header />
      <MainWrap>
        <StudyProfile />
        <RightMainWrap>
          <HeaderTitle>활동 일지</HeaderTitle>
          <Scroll>
            <StudyList />
            <StudyList />
            <StudyList />
            <StudyList />
            <StudyList />
            <StudyList />
          </Scroll>
        </RightMainWrap>
      </MainWrap>
    </ThemeProvider>
  );
}

export default StudyCrew;
