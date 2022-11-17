import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import SearchBar from '../../Components/Input';
import SearchIcon from '../../Image/SearchIcon.png';
import SearchButton from '../../Components/Btn';
import Input from '../../Components/Input.jsx';
import RegButton from '../../Components/Btn.jsx';

const MainWrap = styled.div`
  position: absolute;
  background-color: ${palette('PsCocoa', 0)};
  width: 100%;
  height: calc(100% - 4rem);
`;

const Wrap = styled.div`
  margin: 8rem auto 0rem auto;
  width: fit-content;
  height: fit-content;
  background-color: ${palette('PsCocoa', 1)};
  padding: 3rem;
  box-sizing: content-box;
`;

const Title = styled.h1`
  color: ${palette('PsYellow')};
`;

const WrapContent = styled.div`
  display: flex;

  /* margin: auto 0; */
`;

const WrapBookImage = styled.div`
  width: 15rem;
  height: 19rem;
  background-color: #ffffff;
`;

const WrapRegister = styled.div`
  margin-left: 3rem;
`;
const WrapBookTitle = styled.div`
  /* width: fit-content;
  height: fit-content;
  background-color: white;
  border-radius: 0.2rem; */
`;

const WrapBookDetail = styled.div`
  /* width: fit-content;
  height: fit-content;
  background-color: white;
  border-radius: 0.2rem; */
  margin-top: 1rem;
`;


const WrapBookReturn = styled.div`
  width: fit-content;
  height: 13.3rem;
  padding: 1rem;
  background-color: ${palette('PsLightBrown', 0)};
  /* background-color: white; */
  border-radius: 0.2rem;
  margin-top: 2rem;
  /* float: right; */
`;

const WrapReturnAlert = styled.div`
  display: flex;
`;

const ReturnAlert = styled.div`
  margin-right: 1rem;
  margin-bottom: 1rem;
`;

const DetailDate = styled.div`
  margin-bottom: 1rem;
`;

const WrapRegButton = styled.div`
  float: right;
  /* margin-right: auto; */
`;


function BR_BookReg() {
  return (
    <div>
      <ThemeProvider theme={theme}>
        <Header />
        <MainWrap>
          <Wrap>
            <Title>도서 등록</Title>
            <WrapContent>
              <WrapBookImage />
              <WrapRegister>
                <WrapBookTitle>
                  <Input
                    width={'40rem'}
                    height={'2.3rem'}
                    placeholder='책 제목'
                  />
                </WrapBookTitle>
                <WrapBookDetail>
                  <Input
                    width={'40rem'}
                    height={'2.3rem'}
                    placeholder='( 작가 | 출판사 | 출판일 )'
                  />
                </WrapBookDetail>
                <WrapBookReturn>
                  <WrapReturnAlert>
                    <ReturnAlert>반납 마감일</ReturnAlert>
                    <ReturnAlert>반납날짜 : 연도 | 월 | 일 </ReturnAlert>
                  </WrapReturnAlert>
                  <DetailDate>
                    <Input
                      width={'38rem'}
                      height={'7rem'}
                      placeholder='달력..이미지 어떡하죠'
                    />
                  </DetailDate>
                  <WrapRegButton>
                    <RegButton
                      color={palette('PsYellow')}
                      background={palette('PsBtn')}
                      width={'5.5rem'}
                      height={'2.5rem'}
                      name='게시하기'
                    />
                  </WrapRegButton>
                </WrapBookReturn>
              </WrapRegister>
            </WrapContent>
          </Wrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}

export default BR_BookReg;
