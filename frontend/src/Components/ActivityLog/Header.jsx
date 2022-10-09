import React from 'react';
import styled from 'styled-components';
import { palette } from 'styled-tools';
import Logo10 from '../../Image/Logo10.png';

const HeaderWrapper = styled.div`
  height: 4rem;
  align-items: center;
  justify-content: center;
  display: flex;
  background-color: ${palette('PsGreen')};
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
  font-weight: bold;
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
  width: 7rem;
  height: 4rem;
  align-items: center;
  justify-content: center;
  display: flex;
  font-style: normal;
  font-weight: bold;
  font-size: 15pt;
  list-style: none;
  margin-right: 2rem;
  &:hover {
    cursor: pointer;
    background-color: ${palette('PsCocoa', 0)};
    border-top-left-radius: 30%;
    border-top-right-radius: 30%;
    color: ${palette('PsYellow')};
  }
`;

export default function Header() {
  return (
    <HeaderWrapper>
      <Logo />
      <Title>활동일지 서비스</Title>
      <Nav>
        <NavItem>활동일지</NavItem>
        <NavItem>북 리뷰</NavItem>
        <NavItem>부원관리</NavItem>
      </Nav>
    </HeaderWrapper>
  );
}
