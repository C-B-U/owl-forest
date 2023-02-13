import React, { useState, useEffect } from 'react';
import axios from 'axios';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import Btn from '../../Components/Btn';
import StudyManageProfile from '../../Components/ActivityLog/StudyManageProfile';

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

const StudyList = styled.div`
  width: 71rem;
  height: 8rem;
  border-radius: 1rem;
  margin-top: 0.8rem;
  padding: 1.5rem;
  display: flex;
  background-color: ${palette('PsLightBrown')};
`;

const StudyName = styled.div`
  font-size: 15pt;
  font-weight: bold;
  align-items: center;
  justify-content: left;
  display: flex;
  padding: 1rem;
  margin: 1rem;
`;

const StudyInput = styled.div`
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

function StudyManage() {
  const baseurl = process.env.REACT_APP_BASE_URL;
  const [profile, setProfile] = useState();
  const [boxInput, setBoxInput] = useState([]);

  useEffect(() => {
    axios.get(`${baseurl}`).then((response) => {
      setProfile(response.data);
    });
  }, []);

  return (
    <ThemeProvider theme={theme}>
      <Header />
      <MainWrap>
        <StudyManageProfile />
        <RightMainWrap>
          <HeaderWrap>
            <HeaderTitle>활동 일지</HeaderTitle>
            <BtnWrap>
              <BtnItems>
                <Btn
                  background={palette('PsBtn')}
                  color={palette('PsYellow')}
                  width='7rem'
                  height='3rem'
                  name='일지 수정'
                />
              </BtnItems>
              <BtnItems>
                <Btn
                  background={palette('PsBtn')}
                  color={palette('PsYellow')}
                  width='7rem'
                  height='3rem'
                  name='일지 삭제'
                />
              </BtnItems>
              <BtnItems>
                <Btn
                  background={palette('PsBtn')}
                  color={palette('PsYellow')}
                  width='7rem'
                  height='3rem'
                  name='일지 생성'
                />
              </BtnItems>
            </BtnWrap>
          </HeaderWrap>
          <Scroll>
            <StudyList>
              <StudyName>1차</StudyName>
              <StudyInput>
                날짜 : 2022-9-27
                <br />
                <br />
                시간 : 00:00 ~ 12:00
                <br />
                <br />
                활동 장소 : 비대면 zoom
                <br />
                <br />
                참여 인원 : 가나, 나다, 다라, 마바
              </StudyInput>
            </StudyList>
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

export default StudyManage;
