import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';

import imgfile from '../../Image/Loginlogo.png';
import theme from '../../Components/Color';

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
  padding: 1.2rem;
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

const LoginButton = styled.button`
  width: 15rem;
  height: 2.8rem;
  background-color: ${palette('PsGreen')};
  border-radius: 3rem;
  padding: 0rem 1.5rem 0rem 0.5rem;
  font-family: 'Noto Sans KR', sans-serif;
  border: none;
  font-size: 12pt;
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
  return (
    <div>
      <ThemeProvider theme={theme}>
        <LoginWrap>
          <Mainlogo src={imgfile} />
          <InputWrap>
            다음 정보를 입력해주세요.
            <SelectBox style={{ marginTop: '1rem' }} name='Generation'>
              <option value='none'> * 클릭해서 기수 선택 * </option>
              <option value='1기'>1</option>
              <option value='2기'>2</option>
              <option value='3기'>3</option>
              <option value='4기'>4</option>
            </SelectBox>
            <InputBox placeholder='Name' />
            <InputBox placeholder='Student-id' />
          </InputWrap>
          <LogBtnWrap>
            <LoginButton>완료</LoginButton>
          </LogBtnWrap>
        </LoginWrap>
      </ThemeProvider>
    </div>
  );
}

export default AddInfo;
