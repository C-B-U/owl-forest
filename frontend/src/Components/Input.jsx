import React from 'react';
import styled from 'styled-components';

export const InputStyle = styled.input`
  //export 추가해서 다른 페이지에서 작업할 때 덮어쓰기 할 수 있게 추가됨.
  width: ${(props) => props.width};
  height: ${(props) => props.height};
  margin: ${(props) => props.margin};
  border: 0.15rem solid rgba(128, 109, 70);
  border-radius: 0.3rem;
  padding: 0rem 1.5rem 0rem 0.5rem;
  font-family: 'Noto Sans KR', sans-serif;

  &:focus {
    outline: none;
  }
`;

export default function Input({ width, height, margin, placeholder }) {
  return (
    <div>
      <InputStyle
        width={width}
        height={height}
        margin={margin}
        placeholder={placeholder}
      />
    </div>
  );
}
