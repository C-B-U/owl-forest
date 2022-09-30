import React from 'react';
import styled from 'styled-components';

const MenuBody = styled.div`
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  border-radius: 0.5rem;
  background: rgba(128, 109, 70);
  width: 20rem;
  height: 4rem;
  display: flex;
  align-items: center;
  justify-content: center;
`;

const List = styled.a`
  margin: 0.3rem;
  padding: 0.3rem;
  box-sizing: border-box;
  border-radius: 1rem;
  background: rgba(158, 197, 124);
  font-family: sans-serif;
  font-size: 1.5rem;
  text-align: center;
  &:hover {
    color: yellow;
  }
`;

export default function Menu() {
  return (
    <MenuBody>
      <List>home</List>
      <List>blog</List>
      <List>work</List>
      <List>about</List>
    </MenuBody>
  );
}
