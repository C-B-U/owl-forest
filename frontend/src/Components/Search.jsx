import React from 'react';
import styled, { keyframes } from 'styled-components';
import SearchIcon from '../Image/searchIcon.jpeg';

const boxFade = keyframes`
100%{
  width:200px;
  transform:translateX(-50%);
}
`;

const inputFade = keyframes`
0%{
  opacity:0;
}
100%{
  opacity:1;
}
`;

const SearchBox = styled.form`
  position: relative;
  top: 50%;
  left: 50%;
  width: 3rem;
  height: 3rem;
  background-image: url(${SearchIcon});
  background-size: 2.7rem;
  background-repeat: no-repeat;
  box-sizing: border-box;
  border-radius: 25px;
  border: 4px solid rgba(128, 109, 70);
  padding: 5px;
  &:hover {
    cursor: pointer;
    animation: ${boxFade} 1s forwards;
  }
`;

const InputBox = styled.input`
  position: absolute;
  top: 0;
  left: 0;
  width: 9.5rem;
  height: 2.5rem;
  line-height: 30px;
  outline: 0;
  border: 0;
  opacity: 0;
  font-size: 1em;
  border-radius: 20px;
  padding: 0 20px;
  &:hover {
    display: block;
    cursor: pointer;
    animation: ${inputFade} 1s forwards;
  }
`;

export default function Search() {
  return (
    <SearchBox action=''>
      <InputBox type='text' placeholder='Search' onChange />
    </SearchBox>
  );
}
