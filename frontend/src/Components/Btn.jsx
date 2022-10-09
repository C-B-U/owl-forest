import React from 'react';
import styled from 'styled-components';

export const Btn = styled.button`
  font-size: 1rem;
  text-align: center;
  border-radius: 1rem;
  color: ${(props) => props.color};
  background-color: ${(props) => props.background};
  width: ${(props) => props.width};
  height: ${(props) => props.height};
`;

export default function Btn1({ color, background, width, height, name }) {
  return (
    <Btn color={color} background={background} width={width} height={height}>
      {name}
    </Btn>
  );
}
