import React, { useState, useEffect } from 'react';
import axios from 'axios';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import DatePicker from 'react-datepicker';
import { InputStyle } from '../../Components/Input';
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

const LogBox = styled.div`
  width: 71rem;
  height: 60rem;
  border-radius: 1rem;
  margin-top: 0.8rem;
  padding: 1.5rem;
  display: flex;
  flex-direction: column;
  background-color: ${palette('PsLightBrown')};
`;

const SelectBox = styled.select`
  width: 3rem;
  height: 2rem;
  outline: none;
  border: none;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-left: 1rem;
  text-align: center;
  font-size: 12pt;
  font-weight: bold;
`;

const LogTitle = styled.div`
  width: 100%;
  height: 3rem;
  margin-left: 1rem;
  margin-bottom: 0.5rem;
  font-size: 15pt;
  font-weight: bold;
  display: flex;
  align-items: center;
`;

const LogInput = styled(InputStyle)`
  width: 86%;
  height: 3rem;
  display: flex;
  align-items: center;
  font-size: 12pt;
  margin-left: 2rem;
  padding-left: 1rem;
  border: none;
  background-color: ${palette('PsWhite')};
`;

const PlusSection = styled.div`
  width: 86%;
  height: 3rem;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 12pt;
  margin-left: 2rem;
  padding-left: 1rem;
  background-color: ${palette('PsWhite')};
`;

const Log = styled(InputStyle)`
  width: 95%;
  height: 20rem;
  display: flex;
  align-items: center;
  font-size: 12pt;
  margin-left: 1rem;
  margin-bottom: 1rem;
  padding-left: 1rem;
  border: none;
  background-color: ${palette('PsWhite')};
`;

const DateWrap = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;

const SelectDate = styled(DatePicker)`
  width: 15rem;
  height: 2rem;
  font-size: 12pt;
  font-weight: bold;
  text-align: center;
  margin: 0 2rem;
  border: none;
`;

const PlusBtn = styled.label`
  width: 2rem;
  height: 2rem;
  display: flex;
  justify-content: center;
  align-items: center;
  border: none;
  background-color: ${palette('PsBtn')};
  color: ${palette('PsYellow')};
`;

function StudyLog() {
  const baseurl = process.env.REACT_APP_BASE_URL;

  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());

  const [title, setTitle] = useState();
  const [week, setWeek] = useState();
  const [place, setPlace] = useState();
  const [description, setDescription] = useState();
  const [assignment, setAssignment] = useState();
  const [members, setMembers] = useState([]);

  const [fileImage, setFileImage] = useState('');
  const [fileIma, setFileIma] = useState('');

  const handleSelect = async (e) => {
    const file = e.target.files[0];
    const Image = URL.createObjectURL(file);
    setFileIma(Image);
    setFileImage(file);
  };

  const deleteImage = () => {
    URL.revokeObjectURL(fileImage);
    URL.revokeObjectURL(fileIma);
    setFileIma('');
    setFileImage('');
  };

  const studyData = {
    title: `${title}`,
    week: `${week}`,
    place: `${place}`,
    description: `${description}`,
    assignment: `${assignment}`,
    members: `${members}`,
    studyTime: {
      startTime: `${startDate}`,
      endTime: `${endDate}`,
    },
  };

  const handleSubmit = useEffect(() => {
    axios
      .post(`study-activities/1`, {
        studyData,
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
          <HeaderWrap>
            <HeaderTitle>활동일지 작성</HeaderTitle>
            <BtnWrap>
              <BtnItems>
                <Btn
                  background={palette('PsBtn')}
                  color={palette('PsYellow')}
                  width='7rem'
                  height='3rem'
                  name='저장'
                  onClick={() => {
                    handleSubmit();
                  }}
                />
              </BtnItems>
            </BtnWrap>
          </HeaderWrap>
          <Scroll>
            <LogBox>
              <LogTitle>
                제목
                <LogInput
                  onChange={(e) => {
                    setTitle(e.target.value);
                  }}
                />
              </LogTitle>
              <LogTitle>
                스터디 차수
                <SelectBox
                  onChange={(e) => {
                    setWeek(e.target.value);
                  }}
                >
                  <option>1</option>
                  <option>2</option>
                </SelectBox>
              </LogTitle>
              <LogTitle>
                활동 일시
                <DateWrap>
                  <SelectDate
                    selected={startDate}
                    onChange={(date) => setStartDate(date)}
                  />
                  ~
                  <SelectDate
                    selected={endDate}
                    onChange={(date) => setEndDate(date)}
                  />
                </DateWrap>
              </LogTitle>
              <LogTitle>
                활동 장소
                <LogInput
                  placeholder='비대면 zoom'
                  onChange={(e) => {
                    setPlace(e.target.value);
                  }}
                />
              </LogTitle>
              <LogTitle>
                참여 인원
                <PlusSection
                  onChange={(e) => {
                    setMembers(e.target.value);
                  }}
                >
                  <Btn
                    id='name'
                    type='file'
                    onChange={handleSelect}
                    background={palette('PsBtn')}
                    color={palette('PsYellow')}
                    borderStyle='none'
                    width='2rem'
                    height='2rem'
                    name='+'
                  />
                </PlusSection>
              </LogTitle>
              <LogTitle>활동 내용</LogTitle>
              <Log
                onChange={(e) => {
                  setDescription(e.target.value);
                }}
              />
              <LogTitle>
                과제
                <LogInput
                  onChange={(e) => {
                    setAssignment(e.target.value);
                  }}
                />
              </LogTitle>
              <LogTitle>
                활동 사진
                <PlusSection>
                  <PlusSection>
                    {fileIma && (
                      <img
                        alt='sample'
                        id='sample'
                        width='200px'
                        height='200px'
                        src={fileIma}
                      />
                    )}
                    <PlusBtn>
                      +
                      <input
                        hidden
                        id='name'
                        type='file'
                        accept='image/*'
                        onChange={handleSelect}
                      />
                    </PlusBtn>
                  </PlusSection>
                </PlusSection>
              </LogTitle>
            </LogBox>
          </Scroll>
        </RightMainWrap>
      </MainWrap>
    </ThemeProvider>
  );
}

export default StudyLog;
