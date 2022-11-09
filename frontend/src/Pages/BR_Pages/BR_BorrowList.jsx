/* eslint-disable camelcase */
import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import Search from '../../Components/Search';
import BorrowButton from '../../Components/Btn.jsx';
// import {Scrollbars} from 'react-custom-scrollbars';

const MainWrap= styled.div`
  display: inline-block;
  width: 100%;
  
`

const ListWrap = styled.div`
  /* position: absolute; */
  margin-top: 4rem;
  background-color: ${palette('PsCocoa', 0)};
  width: 100%;
  height: 100%;
  display: flex;
`;

const WrapSearchbar = styled.div`
  background-color: ${palette('PsCocoa', 0)};
  padding: 0.5rem 0;
  position: fixed;
  margin-right: -10rem;
  width: 100%;

`;

const Wrap=styled.div`
  margin-top: 60px;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 0rem;
  width: 100%;
  height: 100%;

  overflow: hidden;
  
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
        <MainWrap>
        <Header/>
        <ListWrap>
          
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
      
      
        </ListWrap>
      </MainWrap>
      


      </ThemeProvider>
      
      
    </div>
    
  )
}

export default BR_BorrowList;