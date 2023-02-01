import React, { useState } from 'react';
import styled from 'styled-components';
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
  margin-left: 2.5rem;
`;

const MajorInfo = styled.div`
  margin-left: 3rem;
  width: 11rem;
  text-align: left;
`;

const GradeInfo = styled.div`
  margin-left: 5rem;
`;
function MLList() {
  const users = [
    { name: '부엉1', major: '컴퓨터공학과', grade: '1학년' },
    { name: '부엉2', major: '메카트로닉스공학과', grade: '3학년' },
    { name: '부엉3', major: '경영학과', grade: '4학년' },
    { name: '부엉4', major: '디자인학부', grade: '5학년' },
    { name: '부엉5', major: '컴퓨터공학과', grade: '2학년' },
    { name: '부엉6', major: '전자공학과', grade: '3학년' },
    { name: '부엉7', major: '기계공학과', grade: '1학년' },
  ];

  const list = users.map((v) => (
    <div>
      <List>
        <MemListInput>
          <Photo />
          <NameInfo>{v.name}</NameInfo>
          <MajorInfo>{v.major}</MajorInfo>
          <GradeInfo>{v.grade}</GradeInfo>
        </MemListInput>
      </List>
    </div>
  ));

  return <div>{list}</div>;
}
export default MLList;
