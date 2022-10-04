import React from "react";
import styled from "styled-components";

const HeaderWrapper = styled.div`
  height: 100px;

  display: flex;
  justify-content: space-between;

  background-color: #ffffff;

  padding: 0px 150px;
`;
const Title = styled.h1`
  font-style: normal;
  font-weight: 700;
  font-size: 24px;
  display: flex;
  align-items: center;
`;
const Nav = styled.ul`
  display: flex;
  align-items: center;
`;
const NavItem = styled.li`
  font-style: normal;
  font-weight: 700;
  font-size: 20px;
  line-height: 29px;
  list-style: none;

  margin: 0px 34px;
  color: ${({ clicked }) => (clicked ? "#6C63FF" : "#000000")};

  cursor: pointer;
`;
export default function Header() {
  return (
    <HeaderWrapper>
      <Title>활동일지 서비스</Title>
      <Nav>
        <NavItem clicked>활동일지 서비스</NavItem>
        <NavItem>북 리뷰 서비스</NavItem>
        <NavItem>부원관리 서비스</NavItem>
      </Nav>
    </HeaderWrapper>
  );
}
