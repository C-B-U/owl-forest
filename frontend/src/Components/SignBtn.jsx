import React from 'react';
import styled from 'styled-components';

const Sign = styled.button`
  font-size: 1rem;
  align-items: center;
  justify-content: center;
  display: flex;
  border: 0.1rem solid black;
  border-radius: 100%;
  background-color: white;
  color: ${(props) => props.color};
  background: ${(props) => props.background};
  width: ${(props) => props.width};
  height: ${(props) => props.height};
`;

export default function SignBtn(color, background, width, height, sign) {
  return (
    <Sign color={color} background={background} width={width} height={height}>
      {sign}
    </Sign>
  );
}
