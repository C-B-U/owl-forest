import React, { useEffect, setState, useState } from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import { useNavigate, Navigate } from 'react-router-dom';
import axios from 'axios';
import imgfile from '../../Image/Loginlogo.png';
import theme from '../../Components/Color';
import Btn from '../../Components/Btn';

const LoginWrap = styled.div`
  position: absolute;
  width: 100%;
  height: 100%;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  display: flex;
  text-align: center;
  margin: 0 auto;
  background-color: ${palette('PsWhite')};
`;
const Mainlogo = styled.img`
  width: 10rem;
  height: 10rem;
  display: flex;
  padding: 0.8rem;
`;

const InputWrap = styled.div`
  margin: 0.7rem;
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const InputBox = styled.input`
  width: 18rem;
  height: 2.8rem;
  background-color: ${palette('PsLightBrown')};
  border-radius: 5rem;
  padding: 0rem 1.5rem;
  font-family: 'Noto Sans KR', sans-serif;
  &:focus {
    outline: none;
  }
  border: none;
  line-height: 1rem;
  margin-bottom: 1rem;
`;

const LogBtnWrap = styled.div`
  margin-top: 1rem;
  margin-bottom: 1.3rem;
  white-space: pre;
  font-family: 'Noto Sans KR', sans-serif;
`;

const SelectBox = styled.select`
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  width: 12rem;
  height: 2.8rem;
  background-color: ${palette('PsLightBrown')};
  border-radius: 3rem;
  font-family: 'Noto Sans KR', sans-serif;
  &:focus {
    outline: none;
  }
  border: none;
  line-height: 1rem;
  margin-bottom: 1rem;
  max-height: 3rem;
  padding-left: 1.7rem;
`;

function AddInfo() {
  const [id, setId] = useState('');
  const [value, setValue] = useState('');
  const [name, setName] = useState('');

  const handleId = (e) => {
    setId(e.target.value);
  };
  const handleName = (e) => {
    setName(e.target.value);
  };
  const handleValue = (e) => {
    setValue(e.target.value);
  };

  const AddLogin = () => {
    axios.put('/api/users', {
      params: {
        generation: value,
        name,
        id,
      },
    });
  };

  return (
    <div>
      <ThemeProvider theme={theme}>
        <LoginWrap>
          <Mainlogo src={imgfile} />
          <InputWrap>
            <p>다음 정보를 입력해주세요.</p>
            
            <InputBox
              value={name}
              name='name'
              onChange={handleName}
              placeholder='Name'
            />
            <InputBox
              value={id}
              name='id'
              onChange={handleId}
              placeholder='Student-id'
            />
          </InputWrap>
          <LogBtnWrap>
            <Btn
              width='15rem'
              height='2.8rem'
              background={palette('PsGreen')}
              borderStyle='none'
              borderRadius='3rem'
              padding='0rem 1.5rem 0rem 0.5rem'
              onClick={AddLogin()}
              hoverBackgroundColor='#7ebe57'
              transition='0.3s'
              name='완료'
            />
            
          </LogBtnWrap>
        </LoginWrap>
      </ThemeProvider>
    </div>
  );
}

export default AddInfo;
