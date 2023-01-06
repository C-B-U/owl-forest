import React from 'react';
import styled from 'styled-components';
import { InputStyle } from '../../Components/Input';
import imgfile from '../../Image/Home.png';

const All = styled.div`
  position: absolute; //absolute 추가(세로 중앙정렬)
  width: 100%;
  height: 100%;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  display: flex;
  text-align: center;
  margin: 0 auto; //세로 중앙정렬을 위한 margin 값
`;

const Squbox = styled.div`
  width: 35rem;
  height: 35rem;
  border-radius: 2rem;
  border: 0.1rem solid rgba(128, 109, 70);
  margin-top: 1rem;
  text-align: start;
  padding-left: 2rem;
  padding-top: 1rem;
  padding-bottom: 1rem;
`;

const Regi = styled(InputStyle)`
  border: 0.15rem solid rgba(247, 232, 211);
  background-color: rgba(247, 232, 211);
  border-radius: 4rem;
  display: inline-block;
  padding: 0rem 1.5rem;
  margin: auto;
  margin-bottom: 0.5rem;
  margin-top: 1.5rem;
`;

const BtnWrap = styled.div`
  margin-top: 2rem;
  display: flex;
  justify-content: space-between;
  margin-right: 2rem;
  z-index: 1;
`;

const Msg = styled.div`
  font-size: 2rem;
`;

const Imghome = styled.img`
  width: 2rem;
  height: 2rem;
  z-index: 2;
`;

const Btn = styled.button`
  display: flex;
  width: 5rem;
  height: 2rem;
  border-radius: 4rem;
  border: 2px solid black;
  background-color: rgba(179, 146, 131);
  justify-content: center;
  &:last-child {
    width: 7rem;
    align-items: center;
  }
`;

const Item = styled.div`
  font-weight: bold;
`;

const Overlap = styled.button`
  width: 5rem;
  height: 2rem;
  margin-left: 1rem;
`;

function Reg() {
  return (
    <All>
      <Msg>회원가입 페이지</Msg>
      <Squbox>
        <Regi width='22rem' height='2.8rem' placeholder='Email ' />
        <Overlap>중복확인</Overlap>
        <Regi width='22rem' height='2.8rem' placeholder='Id ' />
        <Overlap>중복확인</Overlap>
        <Regi width='22rem' height='2.8rem' placeholder='Password ' />
        <Regi width='22rem' height='2.8rem' placeholder='Confirm password ' />
        <Regi width='22rem' height='2.8rem' placeholder='Name ' />
        <Regi width='22rem' height='2.8rem' placeholder='Student Id ' />
        <Overlap>중복확인</Overlap>

        <BtnWrap>
          <Btn
            color='black'
            background='rgba(179, 146, 131)'
            width='4rem'
            height='2rem'
          >
            <Imghome src={imgfile} />
          </Btn>
          <Btn
            onClick={() => alert('환영합니다!')}
            color='black'
            background='rgba(179, 146, 131)'
            width='6rem'
            height='2rem'
            name='회원가입'
          >
            <Item>회원가입</Item>
          </Btn>
        </BtnWrap>
      </Squbox>
    </All>
  );
}

export default Reg;
