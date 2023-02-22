import React, { useState, useEffect } from 'react';
import axios from 'axios';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import StudyBtn from '../../Components/Btn';
import Header from '../../Components/ActivityLog/Header';
import Profile from '../../Components/ActivityLog/Profile';
import Input from '../../Components/Input';

const MainWrap = styled.div`
  display: flex;
  height: calc(100vh - 64px);
  background-color: ${palette('PsCocoa', 0)};
`;

const ContextWrap = styled.div`
  background-color: ${palette('PsLightBrown')};
  border-radius: 10px;
  padding: 3rem 2rem;
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  align-items: flex-end;
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
  margin: 3rem 0px;
  width: 100%;
  margin-right: 5rem;
`;

const BtnWrap = styled.div`
  width: calc(100% - 7rem);
  margin-top: 0.5rem;
  margin-left: auto;
`;

const InputTitle = styled.div`
  font-size: 20px;
  font-weight: 500;
  margin-top: 0.8rem;
  margin-right: 1rem;
  width: 6rem;
  text-align: end;
`;

const InputWrapper = styled.div`
  display: flex;
  align-items: flex-start;
  justify-content: flex-end;
  margin: 0.8rem 0;
`;

const Center = styled.div`
  margin: 0 auto;
`;

const InputMemberWrapper = styled.div`
  width: 636.8px;
  display: flex;
  & > div:nth-child(1) {
    margin-right: 0.4rem;
  }
`;

const ScorllWrapper = styled.div`
  width: 100%;
  height: 270px;
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

const InputIcon = styled.div`
  font-size: 36px;
  font-weight: bold;
  display: flex;
  flex: 1;
  justify-content: center;
  align-items: center;
  padding-bottom: 0.5rem;
  color: ${(props) => (props.color ? props.color : '#000000')};
`;

function StudyCreation() {
  const baseurl = process.env.REACT_APP_BASE_URL;
  const [title, setTitle] = useState();
  const [activity, setActivity] = useState();
  const [leaderName, setLeaderName] = useState();
  const [leaderNumber, setLeaderNumber] = useState();
  const [memberName, setMemberName] = useState([]);
  const [memberNumber, setMemberNumber] = useState([]);

  const studyData = {
    title: `${title}`,
    activity: `${activity}`,
    leaderName: `${leaderName}`,
    leaderNumber: `${leaderNumber}`,
    memberName: `${memberName}`,
    memberNumber: `${memberNumber}`,
  };

  const handleSubmit = useEffect(() => {
    axios
      .post(`/study-groups`, studyData, {
        headers: {
          'Content-Type': 'application/json',
        },
      })
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
  });

  return (
    <ThemeProvider theme={theme}>
      <Header />
      <MainWrap>
        <Profile />
        <RightMainWrap>
          <HeaderTitle>스터디 생성</HeaderTitle>
          <ContextWrap>
            {/* <Center onSubmit={handleSubmit}> */}
            <Center>
              <InputWrapper>
                <InputTitle>스터디 이름</InputTitle>
                <Input
                  width='600px'
                  height='50px'
                  placeholder='스터디 이름'
                  onChange={(e) => {
                    setTitle(e.target.value);
                  }}
                />
              </InputWrapper>
              <InputWrapper>
                <InputTitle>스터디 개요</InputTitle>
                <Input
                  width='600px'
                  height='200px'
                  placeholder='스터디 개요'
                  onChange={(e) => {
                    setActivity(e.target.value);
                  }}
                />
              </InputWrapper>

              <ScorllWrapper>
                <InputWrapper>
                  <InputTitle>팀장</InputTitle>
                  <InputMemberWrapper>
                    <Input
                      width='130px'
                      height='50px'
                      placeholder='이름'
                      onChange={(e) => {
                        setLeaderName(e.target.value);
                      }}
                    />
                    <Input
                      width='360px'
                      height='50px'
                      placeholder='학번'
                      onChange={(e) => {
                        setLeaderNumber(e.target.value);
                      }}
                    />
                  </InputMemberWrapper>
                </InputWrapper>
                <InputWrapper>
                  <InputTitle>팀원</InputTitle>
                  <InputMemberWrapper>
                    <Input
                      width='130px'
                      height='50px'
                      placeholder='이름'
                      onChange={(e) => {
                        setMemberName(e.target.value);
                      }}
                    />
                    <Input
                      width='360px'
                      height='50px'
                      placeholder='학번'
                      onChange={(e) => {
                        setMemberNumber(e.target.value);
                      }}
                    />
                    <InputIcon>+</InputIcon>
                  </InputMemberWrapper>
                </InputWrapper>
                <InputWrapper>
                  <InputTitle>팀원</InputTitle>
                  <InputMemberWrapper>
                    <Input width='130px' height='50px' placeholder='이름' />
                    <Input width='360px' height='50px' placeholder='학번' />
                    <InputIcon color='red'>-</InputIcon>
                  </InputMemberWrapper>
                </InputWrapper>
                <InputWrapper>
                  <InputTitle>팀원</InputTitle>
                  <InputMemberWrapper>
                    <Input width='130px' height='50px' placeholder='이름' />
                    <Input width='360px' height='50px' placeholder='학번' />
                    <InputIcon color='red'>-</InputIcon>
                  </InputMemberWrapper>
                </InputWrapper>
                <InputWrapper>
                  <InputTitle>팀원</InputTitle>
                  <InputMemberWrapper>
                    <Input width='130px' height='50px' />
                    <Input width='360px' height='50px' />
                    <InputIcon color='red'>-</InputIcon>
                  </InputMemberWrapper>
                </InputWrapper>
                <InputWrapper>
                  <InputTitle>팀원</InputTitle>
                  <InputMemberWrapper>
                    <Input width='130px' height='50px' />
                    <Input width='360px' height='50px' />
                    <InputIcon color='red'>-</InputIcon>
                  </InputMemberWrapper>
                </InputWrapper>
              </ScorllWrapper>

              <BtnWrap>
                <StudyBtn
                  background={palette('PsBtn')}
                  color={palette('PsYellow')}
                  width='100%'
                  height='3.5rem'
                  name='생성하기'
                  onClick={handleSubmit}
                />
              </BtnWrap>
            </Center>
          </ContextWrap>
        </RightMainWrap>
      </MainWrap>
    </ThemeProvider>
  );
}

export default StudyCreation;
