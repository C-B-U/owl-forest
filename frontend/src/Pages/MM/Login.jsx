import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';

import MLLogin from '../../Components/MMList/MLLogin';
import imgfile from '../../Image/Loginlogo.png';
import googlebtn from '../../Image/googlebtn.png';
import kakaobtn from '../../Image/kakaobtn.png';
import naverbtn from '../../Image/naverbtn.png';
import theme from '../../Components/Color';
import kakao from '../../Image/Kakao.png';
import google from '../../Image/Google.png';
import naver from '../../Image/Naver.png';

const Mainlogo = styled.img`
  width: 10rem;
  height: 10rem;
  display: flex;
  padding: 1.2rem;
`;

const LoginWrap = styled.div`
  position: absolute;
  width: 100%;
  height: 100%;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  display: flex;
  text-align: center;
  margin: 0 auto;
  background-color: ${palette('PsWhite')};
`;

const SocialWrap = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const GoogleSocialImg = styled.img`
  width: 3.5rem;
  height: 3.5rem;
  border-radius: 3rem;
  position: absolute;
`;

const DoubleSocialImg = styled.img`
  width: 3.5rem;
  height: 3.5rem;
  border-radius: 3rem;
  opacity: 0;
  &:hover {
    width: 20rem;
    transform: scale(1.2);
    opacity: 1;
  }
`;
const KakaoSocialImg = styled.img`
  width: 3.5rem;
  height: 3.5rem;
  border-radius: 3rem;
  position: absolute;
  margin-top: 6.7rem;
`;

const NaverSocialImg = styled.img`
  width: 3.5rem;
  height: 3.5rem;
  border-radius: 3rem;
  position: absolute;
  margin-top: 12.5rem;
`;
function Login() {
  const base_url = process.env.REACT_APP_BASE_URL;
  const KAKAO_AUTH_URL = `${base_url}/auth/login/kakao`;
  const GOOGLE_AUTH_URL = `${base_url}/auth/login/google`;
  const NAVER_AUTH_URL = `${base_url}/auth/login/naver`;

  // 선언
  return (
    <div>
      <ThemeProvider theme={theme}>
        <LoginWrap>
          <Mainlogo src={imgfile} />
          <SocialWrap>
            <GoogleSocialImg style={{ margin: '1rem' }} src={googlebtn} />
            <a href={GOOGLE_AUTH_URL}>
              <DoubleSocialImg style={{ margin: '1rem' }} src={google} />
            </a>

            <KakaoSocialImg style={{}} src={kakaobtn} />
            <a href={KAKAO_AUTH_URL}>
              <DoubleSocialImg style={{ margin: '1rem' }} src={kakao} />
            </a>

            <NaverSocialImg style={{}} src={naverbtn} />
            <a href={NAVER_AUTH_URL}>
              <DoubleSocialImg style={{ margin: '1rem' }} src={naver} />
            </a>
          </SocialWrap>
        </LoginWrap>
      </ThemeProvider>
    </div>
  );
}
export default Login;
