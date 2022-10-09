import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import StudyBtn from '../../Components/Btn';
import Header from '../../Components/ActivityLog/Header';
import Profile from '../../Components/ActivityLog/Profile';
import EmptyHeart from '../../Image/EmptyHeart.png';
import FullHeart from '../../Image/FullHeart.png';

const theme = {
  palette: {
    primary: ['rgba(108, 99, 255, 0.1)'],
    secondary: ['rgba(172, 172, 172, 1)'],
  },
};

const MainWrap = styled.div`
  display: flex;
  background-color: ${palette('primary')};
`;

const ListWrap = styled.div`
  display: inline-block;
`;

const Nav = styled.nav`
  margin-left: auto;
  margin-right: 0.5rem;
  display: flex;
  color: rgba(172, 172, 172, 1);
`;

const NavItems = styled.div`
  font-size: 15pt;
  margin: 2rem;
  &:hover {
    cursor: pointer;
    color: rgba(108, 99, 255, 1);
    text-decoration: underline;
    text-underline-position: under;
  }
`;

const ListHeader = styled.header`
  width: 74rem;
  height: 4rem;
  margin-top: 3rem;
  padding-left: 1rem;
  font-size: 20pt;
  font-weight: bold;
  align-items: center;
  justify-content: left;
  display: flex;
`;

const StudyList = styled.div`
  width: 71rem;
  height: 8rem;
  border-radius: 1rem;
  margin-top: 0.8rem;
  padding: 1.5rem;
  display: inline-block;
  background-color: rgba(255, 255, 255, 1);
`;

const StudyName = styled.div`
  font-size: 15pt;
  font-weight: bold;
  align-items: center;
  justify-content: center;
  display: flex;
`;

const StudyInput = styled.div`
  font-size: 10pt;
  font-weight: bold;
  display: flex;
`;

const LastStudy = styled.div`
  font-size: 10pt;
  font-weight: bold;
  margin-left: auto;
  margin-top: auto;
  align-items: center;
  justify-content: center;
  display: flex;
`;

const StudyCnt = styled.div`
  font-size: 15pt;
  font-weight: bold;
  margin-left: auto;
  margin-top: auto;
  margin-left: 0.5rem;
`;

const Heart = styled.button`
  width: 3rem;
  height: 3rem;
  margin-left: auto;
  margin-right: 1rem;
  border-style: none;
  background-color: rgba(255, 255, 255, 1);
  background-image: url(${EmptyHeart});
  background-size: 2rem;
  background-repeat: no-repeat;
  background-position: center;
  &:active {
    background-image: url(${FullHeart});
  }
`;

const BtnWrap = styled.div`
  margin-top: 1.5rem;
`;

function ActivityLog() {
  return (
    <div>
      <Header />
      <ThemeProvider theme={theme}>
        <MainWrap>
          <Profile />
          <ListWrap>
            <ListHeader>
              스터디 목록
              <Nav>
                <NavItems>최신순</NavItems>
                <NavItems>활동일지순</NavItems>
                <NavItems>인기순</NavItems>
              </Nav>
            </ListHeader>
            <StudyList>
              <StudyName>
                스터디 이름
                <Heart />
              </StudyName>
              <StudyInput>
                스터디 개요~~~~
                <br />
                <br />
                <br />
                팀장 : 씨부엉
                <br />
                팀원 : 부엉일, 부엉이, 부엉삼, 부엉사
                <LastStudy>
                  최근 일지 : 2022년 10월 08일<StudyCnt>활동일지 2개</StudyCnt>
                </LastStudy>
              </StudyInput>
            </StudyList>
            <StudyList />
            <StudyList />
            <BtnWrap>
              <StudyBtn
                background={'rgb(108,99,255)'}
                color={'white'}
                width={'74rem'}
                height={'3.5rem'}
                name={'스터디 생성'}
              ></StudyBtn>
            </BtnWrap>
          </ListWrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}

export default ActivityLog;
