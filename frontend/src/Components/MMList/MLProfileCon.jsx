import React from 'react';
import styled from 'styled-components';
import { palette } from 'styled-tools';
import profileimg from '../../Image/cbu_circle.png';

const Pf = styled.div`
  width: 25rem;
  height: 100vh;
  display: inline-block;
  background-color: ${palette('PsLightBrown')};
`;

const Profilepic = styled.div`
  width: 13rem;
  height: 13rem;
  border-radius: 100%;
  background-color: rgba(217, 217, 217, 1);
  margin: auto;
  margin-top: 3rem;
  background-image: url(${profileimg});
  background-position: center;
  background-size: 14.5rem;
`;

const Gisu = styled.div`
  width: 5rem;
  height: 2rem;
  text-align: center;
  align-items: center;
  justify-content: center;
  font-family: 'Noto Sans KR', sans-serif;
  display: flex;
  font-size: 17pt;
  margin: auto;
  margin-top: 2rem;
`;

const Name = styled.div`
  width: 10rem;
  height: 2rem;
  text-align: center;
  align-items: center;
  justify-content: center;
  display: flex;
  font-family: 'Noto Sans KR', sans-serif;
  font-size: 25pt;
  margin: auto;
  margin-top: 0.5rem;
  font-weight: bolder;
`;

const ProfileList = styled.ul`
  text-align: center;
  margin-top: 3rem;
`;

const Info = styled.li`
  width: 20rem;
  height: 3rem;
  border-radius: 1.5rem;
  list-style: none;
  list-style-position: inside;
  background-color: rgba(179, 146, 131, 1);
  align-items: center;
  font-family: 'Noto Sans KR', sans-serif;
  justify-content: center;
  display: flex;
  margin-top: 1.2rem;
`;

const InfoButton = styled.button`
  width: 9rem;
  height: 2.8rem;
  background-color: ${palette('PsGreen')};
  border-radius: 3rem;
  font-family: 'Noto Sans KR', sans-serif;
  border: none;
  font-size: 12pt;
  margin-top: 3rem;
  margin-right: 2rem;
  font-weight: bolder;
`;

function MLProfileCon() {
  return (
    <div>
      <Pf>
        <Profilepic />
        <Gisu>1241기</Gisu>
        <Name>부엉이</Name>
        <ProfileList>
          <Info>컴퓨터공학과 2학년</Info>
          <Info>스터디</Info>
          <Info style={{ height: '14rem' }}>한줄 소개</Info>
          <InfoButton>수정</InfoButton>
          <InfoButton>탈퇴</InfoButton>
        </ProfileList>
      </Pf>
    </div>
  );
}

export default MLProfileCon;
