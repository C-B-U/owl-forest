/* eslint-disable no-undef */
/* eslint-disable no-plusplus */
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import styled, { ThemeProvider } from 'styled-components';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
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

const WritingBox = styled.div`
  width: 71rem;
  height: 60rem;
  border-radius: 1rem;
  margin-top: 0.8rem;
  padding: 1.5rem;
  display: flex;
  flex-direction: column;
  background-color: ${palette('PsLightBrown')};
`;

const WritingTitle = styled.div`
  width: 100%;
  height: 3rem;
  margin-left: 1rem;
  margin-bottom: 0.5rem;
  font-size: 15pt;
  font-weight: bold;
  display: flex;
  align-items: center;
`;

const MemberWrap = styled.div`
  width: 100%;
  height: 3rem;
  margin-left: 1rem;
  margin-bottom: 0.5rem;
  font-size: 15pt;
  display: flex;
  align-items: center;
`;

const Member = styled.div`
  width: 6rem;
  height: 3rem;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-right: 1rem;
  font-size: 12pt;
  background-color: ${palette('PsWhite')};
`;

const DateWrap = styled.div`
  width: 100%;
  height: 3rem;
  margin-left: 1rem;
  margin-bottom: 0.5rem;
  font-size: 15pt;
  display: flex;
  align-items: center;
`;

const Wave = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 0 1rem;
`;

const Date = styled.div`
  width: 15rem;
  height: 3rem;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 12pt;
  background-color: ${palette('PsWhite')};
`;

const Place = styled.div`
  width: 15rem;
  height: 3rem;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-left: 1rem;
  font-size: 12pt;
  background-color: ${palette('PsWhite')};
`;

const WritingInput = styled.div`
  width: 96%;
  height: 15rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  font-size: 12pt;
  margin-left: 1rem;
  padding-left: 1rem;
  background-color: ${palette('PsWhite')};
`;

function Writing() {
  const baseurl = process.env.REACT_APP_BASE_URL;
  const [getWriting, setGetWriting] = useState([]);

  useEffect(() => {
    axios.get(`${baseurl}`).then((response) => {
      setGetWriting(response.data);
    });
  }, []);

  const [value, onChange] = useState(new Date());
  const [newEvent, setNewEvent] = useState({ title: '', end: '' });
  const [allEvents, setAllEvents] = useState(events);

  function handleAddEvent() {
    for (let i = 0; i < allEvents; i++) {
      const d1 = new Date(allEvents[i].start);
      const d2 = new Date(newEvent.start);
      const d3 = new Date(allEvents[i].end);
      const d4 = new Date(newEvent.end);

      if ((d1 <= d2 && d2 <= d3) || (d1 < d4 && d4 <= d3)) {
        alert('CRASH');
        break;
      }
    }
    setAllEvents([...allEvents, newEvent]);
  }

  return (
    <ThemeProvider theme={theme}>
      <Header />
      <MainWrap>
        <Profile />
        <RightMainWrap>
          <HeaderWrap>
            <HeaderTitle>1주차 활동일지</HeaderTitle>
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
            </BtnWrap>
          </HeaderWrap>
          <Scroll>
            <WritingBox>
              <WritingTitle>참여 인원</WritingTitle>
              <MemberWrap>
                <Member>김부엉</Member>
                <Member>씨부엉</Member>
                <Member>부엉이</Member>
              </MemberWrap>
              <WritingTitle>활동 장소</WritingTitle>
              <Place>비대면 zoom</Place>
              <WritingTitle>활동 일시</WritingTitle>
              <DateWrap>
                <Date>2023/01/16</Date>
                <Wave>~</Wave>
                <Date>2023/01/16</Date>
                <DatePicker
                  placeholderText='Start Date'
                  selected={newEvent.start}
                  onChange={(start) => setNewEvent({ ...newEvent, start })}
                />
                <DatePicker
                  placeholderText='End Date'
                  selected={newEvent.end}
                  onChange={(end) => setNewEvent({ ...newEvent, end })}
                />
              </DateWrap>
              <WritingTitle>활동 내용</WritingTitle>
              <WritingInput />
              <WritingTitle>과제</WritingTitle>
              <WritingInput />
            </WritingBox>
          </Scroll>
        </RightMainWrap>
      </MainWrap>
    </ThemeProvider>
  );
}

export default Writing;
