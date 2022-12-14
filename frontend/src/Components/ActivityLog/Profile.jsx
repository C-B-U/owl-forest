import React from 'react';
import styled from 'styled-components';
import { palette } from 'styled-tools';

const Pf = styled.div`
  width: 20rem;
  height: 45rem;
  border-radius: 1rem;
  margin: 3rem;
  margin-left: 5rem;
  padding-top: 4.5rem;
  display: inline-block;
  background-color: ${palette('PsLightBrown')};
`;

const Circle = styled.div`
  width: 8rem;
  height: 8rem;
  border-radius: 100%;
  background-color: rgba(217, 217, 217, 1);
  margin: auto;
  margin-top: 5rem;
`;

const Name = styled.div`
  width: 5rem;
  height: 2rem;
  text-align: center;
  align-items: center;
  justify-content: center;
  display: flex;
  font-size: 15pt;
  margin: auto;
  margin-top: 1rem;
`;

const EnjoyStudy = styled.div`
  width: 16rem;
  height: 16rem;
  margin: auto;
  margin-top: 4rem;
  display: flex;
  align-items: center;
  justify-content: left;
`;

const StudyList = styled.ul`
  text-align: center;
`;

const Study = styled.li`
  width: 8.5rem;
  list-style: none;
  list-style-position: inside;
  margin: 1rem;
  padding: 0.3rem;
  background-color: rgba(217, 217, 217, 1);
`;

function Profile() {
  return (
    <div>
      <Pf>
        <Circle />
        <Name>이름</Name>
        <EnjoyStudy>
          <StudyList>
            참여중인 스터디
            <Study>스터디1</Study>
            <Study>스터디2</Study>
            <Study>스터디3</Study>
          </StudyList>
        </EnjoyStudy>
      </Pf>
    </div>
  );
}

export default Profile;
