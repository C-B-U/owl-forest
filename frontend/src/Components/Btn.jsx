import React from 'react';
import styled from 'styled-components';

export const BtnStyle = styled.button`
  //export 추가해서 다른 페이지에서 작업할 때 덮어쓰기 할 수 있게 추가됨.
  font-size: 1rem;
  text-align: center;
  border-radius: ${(props) => props.borderRadius};
  border-style: ${(props) => props.borderStyle};
  color: ${(props) => props.color};
  background-color: ${(props) => props.background};
  width: ${(props) => props.width};
  height: ${(props) => props.height};
  font-size: ${(props) => props.fontSize};
`;

export default function Btn({
  color,
  background,
  width,
  height,
  name,
  borderRadius,
  borderStyle,
  fontSize,
  onClick,
}) {
  return (
    <BtnStyle
      color={color}
      background={background}
      width={width}
      height={height}
      borderRadius={borderRadius}
      borderStyle={borderStyle}
      fontSize={fontSize}
      onClick={onClick}
    >
      {name}
    </BtnStyle>
  );
}
