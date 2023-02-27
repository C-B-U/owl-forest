import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
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
  padding-left: 3.2rem;
  font-size: 20pt;
  font-weight: bold;
  color: #fafad2;
  align-items: center;
  justify-content: left;
  display: flex;
`;

const StudyList = styled.ul`
  width: 71rem;
  height: 8rem;
  border-radius: 1rem;
  margin-top: 0.8rem;
  padding: 1.5rem;
  display: inline-block;
  background-color: ${palette('PsLightBrown')};
`;

const StudyName = styled.li`
  font-size: 15pt;
  font-weight: bold;
  align-items: center;
  justify-content: center;
  display: flex;
`;

const StudyInput = styled.li`
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

function StudyActivityLog() {
  const navigate = useNavigate();

  const goStudyCreation = () => {
    navigate('/StudyCreation');
  };

  const baseurl = process.env.REACT_APP_BASE_URL;
  const [profile, setProfile] = useState();
  const [boxInput, setBoxInput] = useState([]);
  const [like, setLike] = useState();
  const [latestSort, setLatestSort] = useState([]);
  const [likeSort, setLikeSort] = useState([]);
  const [activitiesSort, setActivitiesSort] = useState([]);

  useEffect(() => {
    axios.get(`${baseurl}/study-groups/1`).then((response) => {
      setBoxInput(response.data);
    });
  }, []);

  const LatestSort = useEffect(() => {
    axios
      .get(`${baseurl}/study-groups?page=0&size=20&sort=createdAt,DESC`)
      .then((response) => {
        setLatestSort(response.data);
      });
  }, []);

  const LikeSort = useEffect(() => {
    axios
      .get(`${baseurl}/study-groups?page=0&size=20&sort=numOfLike,DESC`)
      .then((response) => {
        setLikeSort(response.data);
      });
  }, []);

  const ActivitiesSort = useEffect(() => {
    axios
      .get(
        `${baseurl}/study-groups?page=0&size=20&sort=numOfStudyActivity,DESC`
      )
      .then((response) => {
        setActivitiesSort(response.data);
      });
  }, []);

  return (
    <div>
      <ThemeProvider theme={theme}>
        <Header />
        <MainWrap>
          <Profile />
          <ListWrap>
            <ListHeader>
              스터디 목록
              <Nav>
                <NavItems onClick={() => LatestSort}>최신순</NavItems>
                <NavItems onClick={() => LikeSort}>활동일지순</NavItems>
                <NavItems onClick={() => ActivitiesSort}>인기순</NavItems>
              </Nav>
            </ListHeader>
            <StudyList>
              {boxInput.map((study) => (
                <StudyName>{study.name}</StudyName>
              ))}
              {boxInput.map((study) => (
                <StudyInput>
                  {study.description}
                  {study.likeCount}
                  {study.studyGroupoStatus}
                  {study.leader}
                  {study.members}
                </StudyInput>
              ))}
            </StudyList>
            <BtnWrap>
              <StudyBtn
                background={palette('PsBtn')}
                color={palette('PsYellow')}
                borderRadius='5rem'
                borderStyle='none'
                width='74rem'
                height='3.5rem'
                name='스터디 생성'
                onClick={goStudyCreation}
              />
            </BtnWrap>
          </ListWrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}

export default StudyActivityLog;
