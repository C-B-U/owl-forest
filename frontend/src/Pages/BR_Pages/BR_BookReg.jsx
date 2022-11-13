import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import SearchBar from '../../Components/Input';
import SearchIcon from '../../Image/SearchIcon.png';
import SerachButton from '../../Components/Btn';
const WrapPopupBackground = styled.div`
  position: absolute;
  width: 100vw;
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.5);
  /* background-color: rgba(255, 255, 255, 0.2); */
`;

// Wrap 뒤로

const WrapPopup = styled.div`
  position: absolute;
  width: 60rem;
  height: 35rem;
  background-color: ${palette('PsCocoa')};
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
`;

const Title = styled.div`
  font-size: 3rem;
  margin-top: 2rem;
  margin: auto;
`;

const WrapSearchbar = styled.div`
  border: 1px solid black;
  display: flex;
  align-items: center;
  justify-content: center;
`;

const WrapSearchIcon = styled.div`
  height: 3rem;
  width: 3rem;
  background-size: 3rem;
  background-position: center;
  background-repeat: no-repeat;
  background-image: url(${SearchIcon});
`;

function BR_BookReg() {
  return (
    <ThemeProvider theme={theme}>
      <WrapPopupBackground>
        <WrapPopup>
          <Title>ISBN 검색</Title>
          <WrapSearchbar>
            <SearchBar
              width={'40rem'}
              height={'3.2rem'}
              placeholder='ISBN을 적어주세요.'
            ></SearchBar>
            <WrapSearchIcon />
          </WrapSearchbar>
        </WrapPopup>
      </WrapPopupBackground>
    </ThemeProvider>
  );
}

export default BR_BookReg;
