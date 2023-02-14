import React from 'react';
import styled from 'styled-components';

// 데이터 서버로 보내기 위해 submit으로 타입 변경 -> 에러로 다시 button 타입으로 변경
export const BtnStyle = styled.button`
  //export 추가해서 다른 페이지에서 작업할 때 덮어쓰기 할 수 있게 추가됨.
  font-size: 1rem;
  font-family: 'Noto Sans KR', sans-serif;
  text-align: center;
  cursor: pointer;
  border-radius: ${(props) => props.borderRadius};
  border-style: ${(props) => props.borderStyle};
  color: ${(props) => props.color};
  background-color: ${(props) => props.background};
  width: ${(props) => props.width};
  height: ${(props) => props.height};
  font-size: ${(props) => props.fontSize};
  font-weight: ${(props) => props.fontWeight};
  margin-top: ${(props) => props.marginTop};
  margin-right: ${(props) => props.marginRight};
  margin-left: ${(props) => props.marginLeft};
  margin-bottom: ${(props) => props.marginBottom};
  &:hover {
    background-color: ${(props) => props.hoverBackgroundColor};
    transform: ${(props) => props.transform};
    transition: ${(props) => props.transition};
  }
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
  fontWeight,
  marginTop,
  marginBottom,
  marginLeft,
  marginRight,
  onClick,
  transform,
  transition,
  hoverBackgroundColor,
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
      fontWeight={fontWeight}
      marginTop={marginTop}
      marginBottom={marginBottom}
      marginLeft={marginLeft}
      marginRight={marginRight}
      onClick={onClick}
      transform={transform}
      transition={transition}
      hoverBackgroundColor={hoverBackgroundColor}
    >
      {name}
    </BtnStyle>
  );
}
