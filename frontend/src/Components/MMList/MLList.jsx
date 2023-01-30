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
const name = ['부엉1', '부엉2', '부엉3'];
const major = ['컴공', '소공', '경영'];
const grade = ['1학년', '2학년', '3학년'];

function MLList() {
  return (
    <div>
      <List>
        <MemListInput>
          <Photo />
          &emsp;&nbsp;&nbsp;
          {name[0]}&emsp; {major[0]} &emsp;&nbsp;&nbsp;
          {grade[0]} &emsp;&emsp; 자바, 코틀린 등
        </MemListInput>
      </List>
    </div>
  );
}
export default MLList;
