import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import StudyBtn from '../../Components/Btn';
import Header from '../../Components/ActivityLog/Header';
import Profile from '../../Components/ActivityLog/Profile';
import EmptyHeart from '../../Image/EmptyHeart.png';
import FullHeart from '../../Image/FullHeart.png';

const MainWrap = styled.div`
  display: flex;
  background-color: ${palette('PsCocoa', 0)};
`;

const ListWrap = styled.div`
  display: inline-block;
`;

const Nav = styled.nav`
  margin-left: auto;
  margin-right: 0.5rem;
  display: flex;
  color: ${palette('PsYellow', 0)};
`;

const NavItems = styled.div`
  font-size: 15pt;
  margin: 2rem;
  &:hover {
    cursor: pointer;
    text-decoration: underline;
    text-underline-position: under;
    text-decoration-thickness: 0.2rem;
    text-decoration-color: ${palette('PsPurple', 0)};
  }
`;

const ListHeader = styled.header`
  width: 74rem;
  height: 4rem;
  margin-top: 3rem;
  padding-left: 1rem;
  font-size: 20pt;
  font-weight: bold;
  color: #fafad2;
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
  background-color: ${palette('PsLightBrown')};
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
  background-color: ${palette('PsLightBrown')};
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
      <ThemeProvider theme={theme}>
        <Header />
        <MainWrap>
          <Profile />
          <ListWrap>
            <ListHeader>
              ????????? ??????
              <Nav>
                <NavItems>?????????</NavItems>
                <NavItems>???????????????</NavItems>
                <NavItems>?????????</NavItems>
              </Nav>
            </ListHeader>
            <StudyList>
              <StudyName>
                ????????? ??????
                <Heart />
              </StudyName>
              <StudyInput>
                ????????? ??????~~~~
                <br />
                <br />
                <br />
                ?????? : ?????????
                <br />
                ?????? : ?????????, ?????????, ?????????, ?????????
                <LastStudy>
                  ?????? ?????? : 2022??? 10??? 08???<StudyCnt>???????????? 2???</StudyCnt>
                </LastStudy>
              </StudyInput>
            </StudyList>
            <StudyList />
            <StudyList />
            <BtnWrap>
              <StudyBtn
                background={palette('PsBtn')}
                color={palette('PsYellow')}
                width='74rem'
                height='3.5rem'
                name='????????? ??????'
              />
            </BtnWrap>
          </ListWrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}

export default ActivityLog;
