import React, { useCallback, useState, useEffect } from 'react';
import axios from 'axios';
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

function StudyLeaderProfile({ name, description, members }) {
  const baseurl = process.env.REACT_APP_BASE_URL;

  const canSubmit = useCallback(
    () => name !== '' && description !== '',
    [name, description, members]
  );

  const handleModification = useEffect(() => {
    // 수정할 데이터 넣어야 함
    axios
      .put(`${baseurl}/study-groups/${1}`, {
        headers: {
          'Content-Type': 'application/json',
        },
      })
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [canSubmit]);

  const deleteStudy = () => {
    axios
      .delete(`${baseurl}/study-groups/${1}`)
      .then(alert('스터디가 삭제되었습니다.'));
  };

  return (
    <div>
      <Pf>
        <StudyTitle>{name}</StudyTitle>
        <StudyOutline>스터디 개요</StudyOutline>
        <OutlineWrap>{description}</OutlineWrap>
        <CrewTitle>부원</CrewTitle>
        <CrewWrap>
          {/* {members.map((member) => (
            <Crew>
              <CrewIcon />
              <CrewName>{member.name}</CrewName>
            </Crew>
          ))} */}
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
            {/* 테스트 필요 */}
            {canSubmit() ? (
              <Btn
                background={palette('PsWhite')}
                color={palette('PsPurple')}
                width='13rem'
                height='3rem'
                name='스터디 수정'
                onClick={handleModification}
              />
            ) : (
              <Btn
                background={palette('PsWhite')}
                color={palette('PsPurple')}
                width='13rem'
                height='3rem'
                name='스터디 수정'
              />
            )}
          </BtnItems>
          <BtnItems>
            <Btn
              background={palette('PsWhite')}
              color={palette('PsPurple')}
              width='13rem'
              height='3rem'
              name='스터디 마감'
            />
          </BtnItems>
          <BtnItems>
            <Btn
              background={palette('PsWhite')}
              color={palette('PsRed')}
              width='13rem'
              height='3rem'
              name='스터디 삭제'
              onClick={deleteStudy}
            />
          </BtnItems>
        </BtnWrap>
      </Pf>
    </div>
  );
}

export default StudyLeaderProfile;
