import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import axios from 'axios';
import { palette } from 'styled-tools';
import profileimg from '../../Image/cbu_circle.png';
import Btn from '../Btn';
import MLList from './MLList';

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

function MLProfile({ name, major, grade }) {
  return (
    <div>
      <Pf>
        <Profilepic />
        <Name>{name}</Name>
        <ProfileList>
          <Info>
            {major} {grade}학년
          </Info>
          <Info>스터디</Info>
          <Info style={{ height: '14rem' }}>한줄 소개</Info>
          <Btn
            width='15rem'
            height='2.8rem'
            background={palette('PsGreen')}
            borderStyle='none'
            borderRadius='3rem'
            fontSize='12pt'
            fontWeight='bolder'
            marginTop='3rem'
            marginRight='3rem'
            hoverBackgroundColor='#7ebe57'
            transition='0.3s'
            name='상세 보기'
          />
        </ProfileList>
      </Pf>
    </div>
  );
}

export default MLProfile;
