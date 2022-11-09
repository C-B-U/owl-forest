import React from 'react';
import theme from '../../Components/Color';
import styled, { ThemeProvider } from 'styled-components';
import Header from '../../Components/ActivityLog/Header';
import Profile from '../../Components/ActivityLog/Profile';
import { palette } from 'styled-tools';

const MainWrap = styled.div`
  display: flex;
  background-color: ${palette('PsCocoa', 0)};
`;

const RegSession = styled.div`
  display:flex;
  padding:1.5rem;
  justify-content: space-between;
  
  div{
    display: flex;
    align-items: center;
    padding-left:1rem;
    padding-right: 1rem;
    margin-right: 1rem;
  }

  div>div{
    width: 5rem;
    height: 2.5rem;
    border-radius: 10px;
    background-color: white;
    margin-left: 1rem;
    justify-content: center;
  }
`;
const ReferenceSession = styled.div`
  width: 50rem;
  padding: 18px 93px 39px 28px;
  margin: 4px 28px 48px 28px;
  border-radius: 10px;
  background-color: white;
`;
const DetailSession = styled.div`
  width: 50rem;
  height: 446px;
  margin: 4px 28px 48px 28px;
  padding: 18px 93px 39px 28px;
  border-radius: 10px;
  background-color: white;

`;

function PlanMake() {
  return <div>
    <ThemeProvider theme={theme}>
      <Header/>
      <MainWrap>
        <Profile />
        <div>
          <RegSession>
            <h2>스터디 계획서</h2>
            <div>
              <div>파일첨부</div>
              <div>저장</div>
            </div>
          </RegSession>
          <ReferenceSession>
            <h3>작성  시 참고사항</h3>
            <div> text ... </div>
          </ReferenceSession>
          <DetailSession>
            <h3>제목</h3>
            <div>
              details
            </div>
            <h3>기수(숫자만)</h3>
            <div>
              details
            </div>
            <h3>부원명</h3>
            <div>
              details
            </div>
            <h3>규칙</h3>
            <div>
              details
            </div>
          </DetailSession>
        </div>
      </MainWrap>
    </ThemeProvider>
    </div>;
}

export default PlanMake;
