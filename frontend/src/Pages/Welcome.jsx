import React from 'react';
import { useNavigate } from 'react-router-dom';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../Components/Color';
import Btn from '../Components/Btn';
import CbuIcon from '../Image/CbuIcon.png';

const MainWrap = styled.div`
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: auto;
`;

const WelcomeImage = styled.div`
  width: 20rem;
  height: 20rem;
  margin: 0 5rem;
  background-image: url(${CbuIcon});
  background-position: center;
  background-repeat: no-repeat;
  background-size: 20rem;
`;

function Welcome() {
  const navigate = useNavigate();

  const goReg = () => {
    navigate('/Reg');
  };

  const goLogin = () => {
    navigate('/Login');
  };

  return (
    <div>
      <ThemeProvider theme={theme}>
        <MainWrap>
          <Btn
            background={palette('PsBtn')}
            color={palette('PsYellow')}
            width='20rem'
            height='20rem'
            borderRadius='100%'
            borderStyle='none'
            fontSize='20pt'
            onClick={goReg}
            transform='scale(1.5)'
            transition='0.5s'
            name='회원가입'
          />
          <WelcomeImage />
          <Btn
            background={palette('PsBtn')}
            color={palette('PsYellow')}
            width='20rem'
            height='20rem'
            borderRadius='100%'
            borderStyle='none'
            fontSize='20pt'
            onClick={goLogin}
            transform='scale(1.5)'
            transition='0.5s'
            name='로그인'
          />
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}

export default Welcome;
