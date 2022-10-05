import React from 'react';
import styled from 'styled-components';
import StudyBtn from '../../Components/Btn';
import Header from '../../Components/ActivityLog/Header';
import Profile from '../../Components/ActivityLog/Profile';

const MainWrap = styled.div`
  display: flex;
`;

const ListWrap = styled.div`
  display: inline-block;
`;

const ListHeader = styled.header`
  width: 75rem;
  height: 4rem;
  border: 0.1rem solid black;
  margin-top: 3rem;
`;

const StudyList = styled.div`
  width: 75rem;
  height: 11rem;
  border-radius: 1rem;
  border: 0.1rem solid black;
  margin-top: 0.8rem;
`;

const BtnWrap = styled.div`
  margin-top: 1.5rem;
`;

function ActivityLog() {
  return (
    <div>
      <Header />
      <MainWrap>
        <Profile />
        <ListWrap>
          <ListHeader />
          <StudyList />
          <StudyList />
          <StudyList />
          <BtnWrap>
            <StudyBtn
              background={'#6C63FF'}
              color={'white'}
              width={'75rem'}
              height={'3.5rem'}
              name={'스터디 생성'}
            ></StudyBtn>
          </BtnWrap>
        </ListWrap>
      </MainWrap>
    </div>
  );
}

export default ActivityLog;
