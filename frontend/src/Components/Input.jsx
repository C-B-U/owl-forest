import React from 'react';
import styled from 'styled-components';

export const Input1 = styled.input`
  width: ${(props) => props.width};
  height: ${(props) => props.height};
  border: 0.15rem solid rgba(128, 109, 70);
  border-radius: 0.3rem;
  padding: 0rem 1.5rem 0rem 0.5rem;
  font-family: 'Noto Sans KR', sans-serif;
  
  &:focus {
    outline: none;
  }
`;

export default function Input({ width, height, placeholder }) {
  return (
    <div>
      <Input1 width={width} height={height} placeholder={placeholder} />
    </div>
  );
}
