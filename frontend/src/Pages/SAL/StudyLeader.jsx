import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import Btn from '../../Components/Btn';
import StudyLeaderProfile from '../../Components/ActivityLog/StudyLeaderProfile';

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

function StudyLeader() {
  const baseurl = process.env.REACT_APP_BASE_URL;
  const [name, setName] = useState();
  const [description, setDescription] = useState();
  const [members, setMembers] = useState();
  const [log, setLog] = useState([]);

  useEffect(() => {
    axios.get(`/study-groups/${1}`).then((response) => {
      setName(response.data.name);
      setDescription(response.data.description);
      setMembers(response.data.members);
    });
  }, []);

  useEffect(() => {
    axios
      .get(
        `/study-groups?page=${0}&size=${20}&sort=numOfStudyActivity`
      )
      .then((response) => {
        setLog(response.data);
      });
  }, []);

  const deleteStudyActivitie = () => {
    axios
      .delete(`/study-activities/${1}`)
      .then(alert('삭제되었습니다.'));
  };

  const navigate = useNavigate();
  const goToStudyActivityLog = () => {
    navigate('/StudyLog');
  };

  return (
    <ThemeProvider theme={theme}>
      <Header />
      <MainWrap>
        <StudyLeaderProfile
          name={name}
          description={description}
          members={members}
        />
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
                  onClick={goToStudyActivityLog}
                />
              </BtnItems>
              <BtnItems>
                <Btn
                  background={palette('PsBtn')}
                  color={palette('PsYellow')}
                  width='7rem'
                  height='3rem'
                  name='일지 삭제'
                  onClick={deleteStudyActivitie}
                />
              </BtnItems>
              <BtnItems>
                <Btn
                  background={palette('PsBtn')}
                  color={palette('PsYellow')}
                  width='7rem'
                  height='3rem'
                  name='일지 생성'
                  onClick={goToStudyActivityLog}
                />
              </BtnItems>
            </BtnWrap>
          </HeaderWrap>
          <Scroll>
            {log.map((log) => (
              <StudyList>
                <StudyName>{log.name}</StudyName>
                <StudyInput>
                  {log.studyTime}
                  <br />
                  <br />
                  {log.studyTime}
                  <br />
                  <br />
                  {log.place}
                  <br />
                  <br />
                  {log.activityMembers}
                  {/* {log.activityMembers.name} */}
                </StudyInput>
              </StudyList>
            ))}
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

export default StudyLeader;
