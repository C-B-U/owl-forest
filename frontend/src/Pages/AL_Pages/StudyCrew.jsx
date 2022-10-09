import React from 'react';
import styled from 'styled-components';
import { palette } from 'styled-tools';
import Logo10 from '../../Image/Logo10.png';

const HeaderWrapper = styled.div`
  height: 4rem;
  display: flex;
  background-color: ${palette('PsGreen', 0)};
  padding: 0 5rem;
`;

const Logo = styled.div`
  width: 4rem;
  height: 4rem;
  border-radius: 100%;
  display: flex;
  margin-right: 1rem;
  background-image: url(${Logo10});
  background-size: 4.4rem;
  background-repeat: no-repeat;
`;

const Title = styled.h1`
  font-style: normal;
  font-weight: bold;
  font-size: 20pt;
  display: flex;
`;

function StudyCrew() {
  return (
    <div>
      <HeaderWrapper>
        <Logo />
        <Title>활동일지 서비스</Title>
      </HeaderWrapper>
    </div>
  );
}

export default StudyCrew;
