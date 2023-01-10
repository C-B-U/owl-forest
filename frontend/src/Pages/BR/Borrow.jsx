import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import AskButton from '../../Components/Btn.jsx';
import Input from '../../Components/Input.jsx';

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
  padding: 3rem;
  box-sizing: content-box;
  background-color: ${palette('PsLightBrown')};
`;
const BookImage = styled.div`
  width: 20rem;
  height: 28rem;
  background-color: #ffffff;
`;
const WrapInfo = styled.div`
  /* float: center; */
  margin-left: 6.5rem;
  width: 18rem;
`;
const WrapContent = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;
const WrapButton = styled.div`
  margin-top: 13rem;
`;
function Borrow() {
  return (
    <div>
      <ThemeProvider theme={theme}>
        <Header />
        <MainWrap>
          <Wrap>
            <WrapContent>
              <BookImage />
              <WrapInfo>
                <h2>책 정보</h2>
                <h3>빌려주는 사람:</h3>
                <h3>반납 일:</h3>
                <h3>위치: </h3>
                <WrapButton>
                  <AskButton
                    color={palette('PsYellow')}
                    background={palette('PsBtn')}
                    width='10rem'
                    height='3rem'
                    name='문의 하기'
                  />
                </WrapButton>
              </WrapInfo>
            </WrapContent>
          </Wrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}

export default Borrow;
