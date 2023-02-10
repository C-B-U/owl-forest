import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import axios from 'axios';
import { palette } from 'styled-tools';
import profileimg from '../../Image/cbu_circle.png';

const List = styled.div`
  width: 75rem;
  height: 3.5rem;
  border-radius: 3rem;
  margin-top: 0.7rem;
  padding-left: 1.5rem;
  display: flex;
  background-color: ${palette('PsLightBrown')};
  margin-left: 1.5rem;
`;
const MemListInput = styled.div`
  font-size: 1.2rem;
  font-weight: bold;
  display: flex;
  align-items: center;
`;

const Photo = styled.div`
  width: 3rem;
  height: 3rem;
  border-radius: 100%;
  background-color: rgba(217, 217, 217, 1);
  background-image: url(${profileimg});
  background-position: center;
  background-size: 3.5rem;
  background-repeat: no-repeat;
`;

const NameInfo = styled.div`
  width: 5rem;
  margin-left: 1.3rem;
`;

const MajorInfo = styled.div`
  width: 11rem;
  text-align: left;
  margin-left: 3.8rem;
`;

const GradeInfo = styled.div`
  width: 5rem;
  margin-left: 2.5rem;
`;

function MLList() {
  const [user, setUsers] = useState([]);
  const users = [
    {
      id: '923736cb-5cb6-4192-96c9-69228bfdb2f8',
      name: '새이름',
      grade: 2,
      major: '메카트로닉스공학과',
      email: 'email.ac.com',
      blogUrl: 'http://blog.com',
      githubId: 'phjppo0918',
      profileUrl: '자기소개입니다',
      introduction: 'profile',
    },
    {
      id: '923736cb-5cb6-4192-96c9-69228bfdb2f8',
      name: '성은',
      grade: 2,
      major: 'COMPUTER',
      email: 'email.ac.com',
      blogUrl: 'http://blog.com',
      githubId: 'phjppo0918',
      profileUrl: '자기소개입니다',
      introduction: 'profile',
    },
  ];
  useEffect(() => {
    axios.get('/api/users').then((response) => {
      setUsers(response.data);
    });
  }, []);

  const list = users.map((v) => (
    <div>
      <List>
        <MemListInput>
          <Photo />
          <NameInfo>{v.name}</NameInfo>
          <MajorInfo>{v.major}</MajorInfo>
          <GradeInfo>{v.grade}학년</GradeInfo>
        </MemListInput>
      </List>
    </div>
  ));

  return <div>{list}</div>;
}
export default MLList;
