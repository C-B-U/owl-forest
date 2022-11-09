/* eslint-disable camelcase */
import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import Search from '../../Components/Search';
import BorrowButton from '../../Components/Btn.jsx';


const MainWrap = styled.div`
  position: absolute;
  background-color: ${palette('PsCocoa', 0)};
  width: 100%;
  height: calc(100% - 4rem);
`;

const WrapSearchbar = styled.div`
  float: right;
  margin: 2rem 10rem;
`;
const Wrap=styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`
const WrapContent = styled.div`
  float: center;
  margin-left: 1rem;
`
const BookImage = styled.div`
  width: 13rem;
  height: 18rem;
  background-color: white;
`;
const WrapStarScore = styled.div`
  display: flex;
  flex-direction: column;
`;

const StarScore = styled.div`
  margin-right: 1rem;
  margin-bottom: 1rem;
`;

function BR_BorrowList() {
  return(
    <div>
      <ThemeProvider theme={theme}>
        <Header />
        <MainWrap>
          <WrapSearchbar>
            <Search/>
          </WrapSearchbar>
          <Wrap>
  
            <BookImage/>
            <WrapContent>
          <p>책이름</p>
      <p>저자   출판사</p>
      <WrapStarScore>
        <StarScore>난이도</StarScore>
        <StarScore>평점</StarScore>
      </WrapStarScore>
      
      <p>마감일:</p>
      <p>대여일:</p>
      <BorrowButton
        color={palette('PsYellow')}
        background={palette('PsBtn')}
        width='5.5rem'
        height='2.5rem'
        name='대여하기'/>

        </WrapContent>
      
      </Wrap>
      
        </MainWrap>
      


      </ThemeProvider>
      
      
    </div>
    
  )
}

export default BR_BorrowList;