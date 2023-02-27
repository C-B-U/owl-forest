import React, { useEffect } from 'react';
import { useCookies } from 'react-cookie';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

function MLLogin() {
  const code = new URL(window.location.href).searchParams.get('code');
  const [cookies, setCookie] = useCookies();
  const navigate = useNavigate();

  useEffect(() => {
    async function NaverLogin() {
      const res = await axios.get(
        `${process.env.REACT_APP_BASE_URL}auth/login/naver`
      );
      const ACCESS_TOKEN = res.headers.authorization;
      const REFRESH_TOKEN = res.headers.refresh_token;
      setCookie('accessToken', ACCESS_TOKEN);
      setCookie('refreshToken', REFRESH_TOKEN);
    }

    async function KakaoLogin() {
      const res = await axios.get(
        `${process.env.REACT_APP_BASE_URL}auth/login/kakao`
      );
      const ACCESS_TOKEN = res.headers.authorization;
      const REFRESH_TOKEN = res.headers.refresh_token;
      setCookie('accessToken', ACCESS_TOKEN);
      setCookie('refreshToken', REFRESH_TOKEN);
    }

    async function GoogleLogin() {
      const res = await axios.get(
        `${process.env.REACT_APP_BASE_URL}auth/login/google`
      );
      const ACCESS_TOKEN = res.headers.authorization;
      const REFRESH_TOKEN = res.headers.refresh_token;
      setCookie('accessToken', ACCESS_TOKEN);
      setCookie('refreshToken', REFRESH_TOKEN);
    }
  });
}

export default MLLogin;
