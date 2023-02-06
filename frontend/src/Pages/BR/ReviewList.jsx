/* eslint-disable camelcase */
import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import Search from '../../Components/Search';

function ReviewList() {
  return (
    <div>
      <ThemeProvider theme={theme}>
        <Header />
      </ThemeProvider>
    </div>
  );
}

export default ReviewList;
