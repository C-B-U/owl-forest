/* eslint-disable no-undef */
import React from 'react';
import styled from 'styled-components';
import Btn from './Btn';

const Wrap = styled.div`
  width: ${(props) => props.width};
  height: ${(props) => props.height};
  border-radius: 0.3rem;
  border: 0.15rem solid ${(props) => props.color};
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
  /* display: inline-flex */
  /* margin: 0.5rem; */
`;

export default function Popup({ color, width, height, title, message }) {
  return (
    <Wrap>
      <Title>{title}</Title>
      <Message>{message}</Message>
      <Buttons>
        <Btn
          color='white'
          background='blue'
          width='5rem'
          height='3rem'
          name='확인'
        />
        <Btn
          color='white'
          background='red'
          width='5rem'
          height='3rem'
          name='취소'
        />
      </Buttons>
    </Wrap>
  );
}
