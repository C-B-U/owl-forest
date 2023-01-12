import React from 'react';
import styled from 'styled-components';
import { palette } from 'styled-tools';
import Btn from '../Btn';

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

const StudyTitle = styled.div`
  width: 10rem;
  height: 4rem;
  text-align: center;
  align-items: center;
  justify-content: center;
  display: flex;
  font-size: 20pt;
  font-weight: bold;
  margin: auto;
`;

const StudyOutline = styled.div`
  width: 15rem;
  height: 2rem;
  text-align: left;
  align-items: center;
  display: flex;
  font-size: 15pt;
  margin: auto;
`;

const OutlineWrap = styled.div`
  width: 16rem;
  height: 8rem;
  margin: auto;
  margin-top: 1rem;
  align-items: center;
  display: flex;
  font-size: 12pt;
  border: solid 1px black;
`;

const CrewTitle = styled.div`
  width: 8rem;
  height: 3rem;
  text-align: center;
  align-items: center;
  justify-content: center;
  display: flex;
  font-size: 15pt;
  font-weight: bold;
  margin: auto;
  margin-top: 3rem;
`;

const CrewWrap = styled.div`
  width: 16rem;
  height: 8rem;
  margin: auto;
  align-items: center;
  justify-content: center;
  display: flex;
`;

const Crew = styled.div`
  width: 4rem;
  height: 7rem;
  margin: 0.5rem;
  align-items: center;
  justify-content: center;
  display: flex;
  flex-direction: column;
`;

const CrewIcon = styled.div`
  width: 4rem;
  height: 4rem;
  border-radius: 100%;
  background-color: rgba(217, 217, 217, 1);
`;

const CrewName = styled.div`
  width: 4rem;
  height: 2rem;
  margin-top: 0.1rem;
  font-size: 12pt;
  text-align: center;
  align-items: center;
  justify-content: center;
  display: flex;
`;

const BtnWrap = styled.div`
  width: 15rem;
  height: 13rem;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin: auto;
`;

const BtnItems = styled.div`
  font-size: 15pt;
  margin: 0.2rem;
  &:hover {
    cursor: pointer;
    text-decoration: underline;
    text-underline-position: under;
    text-decoration-thickness: 0.2rem;
    text-decoration-color: ${palette('PsPurple', 0)};
  }
`;

function StudyLeaderProfile() {
  return (
    <div>
      <Pf>
        <StudyTitle>스터디 명</StudyTitle>
        <StudyOutline>스터디 개요</StudyOutline>
        <OutlineWrap>이러한 스터디입니다.</OutlineWrap>
        <CrewTitle>부원</CrewTitle>
        <CrewWrap>
          <Crew>
            <CrewIcon />
            <CrewName>부원1</CrewName>
          </Crew>
          <Crew>
            <CrewIcon />
            <CrewName>부원2</CrewName>
          </Crew>
          <Crew>
            <CrewIcon />
            <CrewName>부원3</CrewName>
          </Crew>
        </CrewWrap>
        <BtnWrap>
          <BtnItems>
            <Btn
              background={palette('PsWhite')}
              color={palette('PsPurple')}
              width='13rem'
              height='3rem'
              name='스터디 수정'
            />
          </BtnItems>
          <BtnItems>
            <Btn
              background={palette('PsWhite')}
              color={palette('PsRed')}
              width='13rem'
              height='3rem'
              name='스터디 삭제'
            />
          </BtnItems>
        </BtnWrap>
      </Pf>
    </div>
  );
}

export default StudyLeaderProfile;
