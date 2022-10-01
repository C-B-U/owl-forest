/* eslint-disable no-undef */
import React from 'react';
import styled from 'styled-components';
import Btn from './Btn';

const Wrap = styled.div`
  width: 25rem;
  height: wrap-content;
  border-radius: 0.3rem;
  border: 0.15rem solid rgba(128, 109, 70);
  font-family: 'Noto Sans KR', sans-serif;
  div {
    margin: 1.2rem;
  }
`;

const Title = styled.div`
  font-weight: bold;
  font-size: 1.4rem;
`;
const Message = styled.div``;

const Buttons = styled.div`
  text-align: right;
`;

export default function Popup({ color, background, width, height }) {
  return (
    <Wrap>
      <Title>제목 확인</Title>
      <Message>메세지 확인</Message>
      <Buttons>
        <Btn
          color={color}
          background={background}
          width={width}
          height={height}
        />
        <Btn
          color={color}
          background={background}
          width={width}
          height={height}
        />
      </Buttons>
    </Wrap>
  );
}
