import React from 'react';
import styled from 'styled-components';

const Body = styled.div`
  box-sizing: border-box;
  border: 0.2rem solid rgba(128, 109, 70);
  width: 10rem;
  height: 5rem;
`;

const Scrollbar = styled.nav`
  display: flex;
  overflow: auto;
  height: 4rem;
  &::-webkit-scrollbar {
    width: 0.5rem;
    height: 1rem;
    border-radius: 0.4rem;
    background: rgba(158, 197, 124);
  }
  &::-webkit-scrollbar-thumb {
    background: rgba(0, 0, 0, 0.3);
    border-radius: 0.4rem;
  }
`;

export default function Scroll() {
  return (
    <Body>
      <Scrollbar>
        <ul>
          <li>1</li>
          <li>1</li>
          <li>1</li>
          <li>1</li>
          <li>1</li>
          <li>1</li>
          <li>1</li>
          <li>1</li>
          <li>1</li>
          <li>1</li>
        </ul>
      </Scrollbar>
    </Body>
  );
}
