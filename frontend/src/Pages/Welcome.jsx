import React from 'react';
import styled from 'styled-components';
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
  background-image: url(${CbuIcon});
  background-position: center;
  background-repeat: no-repeat;
  background-size: 20rem;
`;

function Welcome() {
  return (
    <div>
      <MainWrap>
        <Btn width='20rem' height='20rem' borderRadius='100%' name='회원가입' />
        <WelcomeImage />
      </MainWrap>
    </div>
  );
}

export default Welcome;
