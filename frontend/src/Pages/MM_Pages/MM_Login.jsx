import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools'
import { Link } from 'react-router-dom';
import imgfile from '../../Image/Loginlogo.png';
import githubbtn from '../../Image/githubbtn.png'
import googlebtn from '../../Image/googlebtn.png'
import kakaobtn from '../../Image/kakaobtn.png'
import naverbtn from '../../Image/naverbtn.png'
import theme from '../../Components/Color';

//1rem = 대략 16px

const Mainlogo = styled.img`
  width: 10rem;
  height: 10rem;
  display: flex;
  padding: 1.2rem;
`;


const LoginWrap = styled.div`
  position : absolute;    
  width :100%;
  height: 100%;
  align-items:center;
  justify-content:center;
  flex-direction: column;
  display: flex;
  text-align: center;
  margin : 0 auto;    
  background-color: ${palette('PsWhite')};
`;

const InputWrap = styled.div`
  margin: 0.7rem;
  display: flex;
  flex-direction: column;
`;

const InputButton = styled.input`
  width: 18rem;
  height: 2.8rem;
  background-color: ${palette('PsLightBrown')};
  border-radius: 5rem;
  padding: 0rem 1.5rem;
  font-family: 'Noto Sans KR', sans-serif;
  &:focus {
    outline: none;
  }
  border: none;
  line-height: 1rem;
  margin-bottom: 1rem;
`;


const LogBtnWrap = styled.div`
  margin-top: 1rem;
  margin-bottom: 1.3rem;
  white-space: pre;
  font-family: 'Noto Sans KR', sans-serif;
`;


const LoginButton = styled.button`
  width: 15rem;
  height: 2.8rem;
  background-color: ${palette('PsGreen')};
  border-radius: 3rem;
  padding: 0rem 1.5rem 0rem 0.5rem;
  font-family: 'Noto Sans KR', sans-serif;
  border: none;
  font-size: 12pt;
`;


const LinkWrap = styled.div`
  align-items: center;
  justify-content: center;
  white-space: nowrap;
  font-family: 'Noto Sans KR', sans-serif;
  
`;

const Line = styled.div`
  margin-top: 1rem; //위의 아이디/비번 찾기와의 간격 띄우기 위함
  margin-bottom: 0.5rem;
`;


const SocialWrap = styled.div`
  display:flex;
`;



const SocialImg = styled.img`
  width: 3.5rem;
  height: 3.5rem;
  border-radius: 3rem;

`;

function MM_Login() {
  //선언
  return (
    <div>
      <ThemeProvider theme={theme}>
        <LoginWrap>
          
          <Mainlogo src={imgfile}/>

          <InputWrap>
            <InputButton placeholder='ID'/>
            <InputButton type="password" placeholder='Password' />
          </InputWrap>

          <LogBtnWrap>
            <LoginButton>로그인</LoginButton>
          </LogBtnWrap>

          <LinkWrap>
            아직 계정이 없으신가요?&nbsp;&nbsp;
            <Link to='/Reg' style={{ color: 'inherit', textDecoration: 'inherit' }}>
              회원가입
            </Link>
          </LinkWrap>

          <LinkWrap>
            
          <Link
              to='/FindId'
              style={{ color: 'inherit', textDecoration: 'inherit' }}
            >아이디 찾기&emsp;&emsp;</Link>
          
            
            <Link
              to='/FindPw'
              style={{ color: 'inherit', textDecoration: 'inherit' }}
            >비밀번호 찾기</Link>
          </LinkWrap>

          <Line>
            <hr style={{width: '25rem', }}></hr>
          </Line>

          <LinkWrap>
            소셜 계정으로 간단하게 로그인하세요!
          </LinkWrap>

        <SocialWrap>
          <SocialImg style={{margin: '1rem'}} src={googlebtn}/>
          <SocialImg style={{margin: '1rem'}} src={githubbtn}/>
          <SocialImg style={{margin: '1rem'}} src={kakaobtn}/>
          <SocialImg style={{margin: '1rem'}} src={naverbtn}/>
        </SocialWrap>

        </LoginWrap>

    </ThemeProvider>
    </div>
    
  );
}
export default MM_Login;
