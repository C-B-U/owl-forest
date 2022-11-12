import React from 'react';
import theme from '../../Components/Color';
import styled, { ThemeProvider } from 'styled-components';
import Header from '../../Components/ActivityLog/Header';
import Profile from '../../Components/ActivityLog/Profile';
import { palette } from 'styled-tools';

const MainWrap = styled.div`
  /* 데스크톱 */
  @media all and (min-width:1024px) {display: flex;}
  padding-bottom: 1rem;
  justify-content:center;
  background-color: ${palette('PsCocoa', 0)};
`;

const RegSession = styled.div`
  display:flex;
  padding:1.5rem;
  justify-content: space-between;
  margin: auto;
  
  div{
    display: flex;
    align-items: center;
    padding-left:1rem;
    padding-right: 1rem;
    margin-right: 1rem;
  }
`;

const FileBtn = styled.div`
    width: 5rem;
    height: 2.5rem;
    border-radius: 10px;
    margin-left: 1rem;
    justify-content: center;
    color: #fafad2;
`
const SubmitBtn = styled.button`
    width: 6rem;
    height: 2.5rem;
    border: none;
    border-radius: 10px;
    margin-left: 1rem;
    justify-content: center;
    color: ${palette('PsCocoa', 0)};
    background-color:  ${palette('PsLightBrown', 0)};
    font-weight:bold;
    cursor: pointer;
`
const ReferenceSession = styled.div`
  /* 데스크톱 */
  @media all and (min-width:1024px) {
    width: 50rem;
    margin: 0px 28px 48px 28px;
  }

  /* 테블릿 가로, 테블릿 세로 (해상도 768px ~ 1023px)*/
  @media all and (max-width:1023px) { 
    width: 70%;
    margin:auto;
    margin-bottom: 20px;
  }

  padding: 18px 93px 39px 28px;
  border-radius: 10px;
  background-color:  white;
`;

const DetailSession = styled.div`
  /* 데스크톱 */
  @media all and (min-width:1024px) {
    width: 50rem;
    margin: 0px 28px 48px 28px;
  }

  /* 테블릿 가로, 테블릿 세로 (해상도 768px ~ 1023px)*/
  @media all and (max-width:1023px) { 
    width: 70%;
    margin:auto;
    margin-bottom: 10px;
  }

  padding: 18px 93px 39px 28px;
  border-radius: 10px;
  background-color:  white;

  h3{
    margin-left: 3rem;
  }
  div{
    background-color: #d3d3d3;
    padding: 1rem;
    border-radius: 10px;
    align-items: center;
  }
`;

const ContentWrap = styled.div`
  /* 데스크톱 */
  @media all and (min-width:1024px) {
    height: 45rem;
    overflow: scroll;
  }

  /* 테블릿 가로, 테블릿 세로 (해상도 768px ~ 1023px)*/
  @media all and (min-width:768px) and (max-width:1023px) { 
    justify-content: center;
    margin-bottom: 4rem;
  }
`;

const StyledInput = styled.input`
  width: 90%;
  height: 30pt;
  font-size: 15pt;
  border-radius: 5px;
  border: none;
  padding: 5px 0rem 5px 2rem;
  justify-items:center;
  background-color: ${palette('PsLightBrown', 0)};
`;

function PlanMake() {
  return <div>
    <ThemeProvider theme={theme}>
      <Header/>
      <MainWrap>
        <Profile />
        <ContentWrap>
          <form action='' method='post'>

            <RegSession>
              <h2>스터디 계획서</h2>
              <div>
                <FileBtn>파일첨부</FileBtn>
                <SubmitBtn type='submit'>저장</SubmitBtn>
              </div>
            </RegSession>
            <ReferenceSession>
              <h3>작성  시 참고사항</h3>
              <div> text ... </div>
            </ReferenceSession>
            <DetailSession>
              <h3>제목</h3>
              <StyledInput placeholder='details'/> 

              <h3>기수(숫자만)</h3>
              <StyledInput placeholder='details'/> 

              <h3>부원명</h3>
              <StyledInput placeholder='details'/> 

              <h3>규칙</h3>
              <StyledInput placeholder='details'/> 

            </DetailSession>


          </form>
        </ContentWrap>
      </MainWrap>
    </ThemeProvider>
    </div>;
}

export default PlanMake;
