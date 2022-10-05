import React from 'react';
import styled from 'styled-components';

const Pf = styled.div`
  width: 20rem;
  height: 45rem;
  border-radius: 1rem;
  border: 0.1rem solid black;
  margin: 3rem;
  display: inline-block;
`;

const Circle = styled.div`
  width: 8rem;
  height: 8rem;
  border-radius: 100%;
  background-color: gray;
  margin: auto;
  margin-top: 3rem;
`;

const Name = styled.div`
  width: 5rem;
  height: 2rem;
  border: 0.1rem solid black;
  margin: auto;
  margin-top: 1rem;
`;

const EnjoyStudy = styled.div`
  width: 16rem;
  height: 16rem;
  border: 0.1rem solid black;
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
  margin: 1rem;
`;

function Profile() {
  return (
    <div>
      <Pf>
        <Circle />
        <Name />
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
