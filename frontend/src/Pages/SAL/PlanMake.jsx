import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import Btn from '../../Components/Btn';
import Profile from '../../Components/ActivityLog/Profile';

const MainWrap = styled.div`
  display: flex;
  height: calc(100vh - 64px);
  background-color: ${palette('PsCocoa', 0)};
`;

const HeaderWrap = styled.header`
  height: 4rem;
  padding-left: 1rem;
  color: #fafad2;
  align-items: center;
  justify-content: left;
  display: flex;
`;

const HeaderTitle = styled.header`
  font-size: 20pt;
  font-weight: bold;
  color: #fafad2;
  align-items: center;
  justify-content: left;
`;

const BtnWrap = styled.header`
  font-size: 20pt;
  font-weight: bold;
  color: #fafad2;
  align-items: center;
  display: flex;
  margin-left: auto;
`;

const BtnItems = styled.div`
  font-size: 15pt;
  margin: 1rem;
  &:hover {
    cursor: pointer;
    text-decoration: underline;
    text-underline-position: under;
    text-decoration-thickness: 0.2rem;
    text-decoration-color: ${palette('PsPurple', 0)};
  }
`;

const RightMainWrap = styled.div`
  margin: 5rem 0px;
  width: 100%;
  margin-right: 5rem;
`;

const PlanNote = styled.div`
  width: 71rem;
  height: 15rem;
  border-radius: 1rem;
  margin-top: 0.8rem;
  padding: 1.5rem;
  display: flex;
  flex-direction: column;
  background-color: ${palette('PsLightBrown')};
`;

const StudyName = styled.div`
  font-size: 15pt;
  font-weight: bold;
  align-items: center;
  justify-content: left;
  display: flex;
  margin-bottom: 0.5rem;
`;

const NoteInput = styled.div`
  font-size: 10pt;
  font-weight: bold;
  display: flex;
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

const PlanBox = styled.div`
  width: 71rem;
  height: 40rem;
  border-radius: 1rem;
  margin-top: 0.8rem;
  padding: 1.5rem;
  display: flex;
  flex-direction: column;
  background-color: ${palette('PsLightBrown')};
`;

const PlanTitle = styled.div`
  width: 100%;
  height: 3rem;
  margin-left: 1rem;
  font-size: 15pt;
  font-weight: bold;
  display: flex;
  align-items: center;
`;

const PlanInput = styled.div`
  width: 100%;
  height: 5rem;
  border-radius: 1rem;
  display: flex;
  align-items: center;
  font-size: 12pt;
  padding-left: 1rem;
  background-color: ${palette('PsWhite')};
`;

const PlanTable = styled.div`
  width: 100%;
  height: 20rem;
  border-radius: 1rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  font-size: 12pt;
  padding-left: 1rem;
  background-color: ${palette('PsWhite')};
`;

function PlanMake() {
  return (
    <ThemeProvider theme={theme}>
      <Header />
      <MainWrap>
        <Profile />
        <RightMainWrap>
          <HeaderWrap>
            <HeaderTitle>스터디 계획서</HeaderTitle>
            <BtnWrap>
              <BtnItems>
                <Btn
                  background={palette('PsBtn')}
                  color={palette('PsYellow')}
                  width='7rem'
                  height='3rem'
                  name='파일 첨부'
                />
              </BtnItems>
              <BtnItems>
                <Btn
                  background={palette('PsBtn')}
                  color={palette('PsYellow')}
                  width='7rem'
                  height='3rem'
                  name='저장'
                />
              </BtnItems>
            </BtnWrap>
          </HeaderWrap>
          <Scroll>
            <PlanNote>
              <StudyName>작성시 참고사항</StudyName>
              <NoteInput>~~~</NoteInput>
            </PlanNote>
            <PlanBox>
              <PlanTitle>제목</PlanTitle>
              <PlanInput>ex - c언어 스터디</PlanInput>
              <PlanTitle>규칙</PlanTitle>
              <PlanInput>ex - ~</PlanInput>
              <PlanTitle>주차별 계획</PlanTitle>
              <PlanTable />
            </PlanBox>
          </Scroll>
        </RightMainWrap>
      </MainWrap>
    </ThemeProvider>
  );
}

export default PlanMake;
