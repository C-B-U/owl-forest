/* eslint-disable camelcase */
import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import Input from '../../Components/Input';
import Header from '../../Components/ActivityLog/Header';
import Search from '../../Components/Search';


const WrapSearchbar = styled.div`
  float: right;
  margin: 2rem 10rem;

`;
const BookImage = styled.div`
  width: 9rem;
  height: 13rem;
  background-color: #777777;
`;

function BR_BorrowList() {
  return(
    <div>
      <ThemeProvider theme={theme}>
        <Header />
      <WrapSearchbar>
        <Search/>
      </WrapSearchbar>
      <BookImage/>
      </ThemeProvider>
      
      
    </div>
    
  )
}

export default BR_BorrowList;