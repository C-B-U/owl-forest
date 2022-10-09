import React from 'react';
import styled from 'styled-components';
import { palette } from 'styled-tools';
import Logo10 from '../../Image/Logo10.png';

const HeaderWrapper = styled.div`
  height: 4rem;

  display: flex;
  justify-content: center;
  align-items: center;

  background-color: ${palette('PsGreen', 0)};
  padding: 0 5rem;
`;

const Logo = styled.div`
  width: 4rem;
  height: 4rem;
  border-radius: 100%;
  align-items: center;
  justify-content: center;
  display: flex;
  margin-right: 1rem;
  background-image: url(${Logo10});
  background-size: 4.4rem;
  background-repeat: no-repeat;
  background-position: center;
`;

const Title = styled.h1`
  font-style: normal;
  font-weight: 700;
  font-size: 20pt;
  display: flex;
  align-items: center;
`;

const Nav = styled.ul`
  display: flex;
  align-items: center;
  justify-content: center;
  margin-left: auto;
`;

const NavItem = styled.li`
  font-style: normal;
  font-weight: bold;
  font-size: 15pt;
  list-style: none;
  margin-right: 4rem;
  color: ${({ clicked }) => (clicked ? 'rgba(250,250,210,1)' : '#000000')};
  cursor: pointer;
`;

const NavItem2 = styled.li`
  width: 8rem;
  height: 5rem;
  align-items: center;
  justify-content: center;
  display: flex;
  border-top-left-radius: 30%;
  border-top-right-radius: 30%;
  text-align: center;
  font-style: normal;
  font-weight: bold;
  font-size: 15pt;
  list-style: none;
  background-color: rgba(179, 146, 131, 1);
  margin-right: 3rem;
  color: ${({ clicked }) => (clicked ? 'rgba(250,250,210,1)' : '#000000')};
`;
export default function Header() {
  return (
    <HeaderWrapper>
      <Logo />
      <Title>활동일지 서비스</Title>
      <Nav>
        <NavItem2 clicked>활동일지</NavItem2>
        <NavItem>북 리뷰</NavItem>
        <NavItem>부원관리</NavItem>
      </Nav>
    </HeaderWrapper>
  );
}
