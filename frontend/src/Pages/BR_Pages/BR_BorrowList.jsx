/* eslint-disable camelcase */
import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import Search from '../../Components/Search';
import BorrowButton from '../../Components/Btn.jsx';

const MainWrap = styled.div`
  display: inline-block;
  width: 100%;
  height: 100%;
`;

const ListWrap = styled.div`
  /* position: absolute; */
  margin-top: 5rem;
  background-color: ${palette('PsCocoa', 0)};
  width: 100%;
`;

const WrapSearchbar = styled.div`
  float: right;
  margin-left: auto;
`;

const WrapBtn = styled.div`
    width: 5rem;
    height: 2.5rem;
    border-radius: 10px;
    margin-left: 1rem;
    justify-content: center;
    color: ${palette('PsCocoa', 0)};
    background-color:  ${palette('PsLightBrown', 0)};
    font-weight:bold;
    cursor: pointer;
`;

const Wrap = styled.div`
  margin-top: 60px;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 0rem;
  width: 100%;
  max-height: 91.9vh;
  overflow: auto;
  &::-webkit-scrollbar {
    width: 8px;
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
`;
const WrapContent = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;
const WrapInfo = styled.div`
  float: center;
  margin-left: 1rem;
`;
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
  return (
    <div>
      <ThemeProvider theme={theme}>
        <MainWrap>
          <Header />
          <ListWrap>
            <WrapSearchbar>
              <Search />
              <BorrowButton
                    color={palette('PsYellow')}
                    background={palette('PsBtn')}
                    width='5.5rem'
                    height='2.5rem'
                    name='채팅이동'
                  />
                  <BorrowButton
                    color={palette('PsYellow')}
                    background={palette('PsBtn')}
                    width='5.5rem'
                    height='2.5rem'
                    name='전체북리뷰'
                  />
                  <BorrowButton
                    color={palette('PsYellow')}
                    background={palette('PsBtn')}
                    width='5.5rem'
                    height='2.5rem'
                    name='내북리스트'
                  />
                  <BorrowButton
                    color={palette('PsYellow')}
                    background={palette('PsBtn')}
                    width='5.5rem'
                    height='2.5rem'
                    name='도서등록'
                  />
          

            </WrapSearchbar>
            <Wrap>
              <WrapContent>
                <BookImage />
                <WrapInfo>
                  <p>책이름</p>
                  <p>저자 출판사</p>
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
                    name='대여하기'
                  />
                </WrapInfo>
              </WrapContent>
              <WrapContent>
                <BookImage />
                <WrapInfo>
                  <p>책이름</p>
                  <p>저자 출판사</p>
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
                    name='대여하기'
                  />
                </WrapInfo>
              </WrapContent>

              <WrapContent>
                <BookImage />
                <WrapInfo>
                  <p>책이름</p>
                  <p>저자 출판사</p>
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
                    name='대여하기'
                  />
                </WrapInfo>
              </WrapContent>
              <WrapContent>
                <BookImage />
                <WrapInfo>
                  <p>책이름</p>
                  <p>저자 출판사</p>
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
                    name='대여하기'
                  />
                </WrapInfo>
              </WrapContent>
              <WrapContent>
                <BookImage />
                <WrapInfo>
                  <p>책이름</p>
                  <p>저자 출판사</p>
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
                    name='대여하기'
                  />
                </WrapInfo>
              </WrapContent>
              <WrapContent>
                <BookImage />
                <WrapInfo>
                  <p>책이름</p>
                  <p>저자 출판사</p>
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
                    name='대여하기'
                  />
                </WrapInfo>
              </WrapContent>
              <WrapContent>
                <BookImage />
                <WrapInfo>
                  <p>책이름</p>
                  <p>저자 출판사</p>
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
                    name='대여하기'
                  />
                </WrapInfo>
              </WrapContent>
              <WrapContent>
                <BookImage />
                <WrapInfo>
                  <p>책이름</p>
                  <p>저자 출판사</p>
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
                    name='대여하기'
                  />
                </WrapInfo>
              </WrapContent>
              <WrapContent>
                <BookImage />
                <WrapInfo>
                  <p>책이름</p>
                  <p>저자 출판사</p>
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
                    name='대여하기'
                  />
                </WrapInfo>
              </WrapContent>
              <WrapContent>
                <BookImage />
                <WrapInfo>
                  <p>책이름</p>
                  <p>저자 출판사</p>
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
                    name='대여하기'
                  />
                </WrapInfo>
              </WrapContent>
            </Wrap>
          </ListWrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}

export default BR_BorrowList;
