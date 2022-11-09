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
  width: absolute;
  height: absolute;
`;

const WrapSearchbar = styled.div`
  padding: 0;
  float: right;
  margin: 2rem 10rem;
`;
const Wrap=styled.div`
  margin-top: 60px;
  
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-template-rows: repeat(4, 1fr);
  gap: 0rem;
  width: 100%;
  max-height: 100vh;
  height: auto;
  overflow: auto;
  &::-webkit-scrollbar {
    width: 11px;
    height: 8px;
    border-radius: 10px;
  }
  &::-webkit-scrollbar-track {
    background: #eeeeee;
    border-radius: 5px;
  }
  &::-webkit-scrollbar-thumb {
    background: ${palette('PsGreen')};
    border-radius: 10px;
  }
`
const WrapContent=styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`
const WrapInfo = styled.div`
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
          <WrapContent>
            <BookImage/>
            <WrapInfo>
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

              </WrapInfo>
            </WrapContent>
            <WrapContent>
            <BookImage/>
            <WrapInfo>
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

              </WrapInfo>
            </WrapContent>
            
            
            <WrapContent>
            <BookImage/>
            <WrapInfo>
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

              </WrapInfo>
            </WrapContent>
            <WrapContent>
            <BookImage/>
            <WrapInfo>
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

              </WrapInfo>
            </WrapContent>
            <WrapContent>
            <BookImage/>
            <WrapInfo>
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

              </WrapInfo>
            </WrapContent>
            <WrapContent>
            <BookImage/>
            <WrapInfo>
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

              </WrapInfo>
            </WrapContent>
            <WrapContent>
            <BookImage/>
            <WrapInfo>
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

              </WrapInfo>
            </WrapContent>
            <WrapContent>
            <BookImage/>
            <WrapInfo>
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

              </WrapInfo>
            </WrapContent>
            <WrapContent>
            <BookImage/>
            <WrapInfo>
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

              </WrapInfo>
            </WrapContent>
  
            
      </Wrap>
      
      
        </MainWrap>
      


      </ThemeProvider>
      
      
    </div>
    
  )
}

export default BR_BorrowList;