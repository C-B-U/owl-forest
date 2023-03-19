import React, { useEffect } from 'react';
import { useCookies } from 'react-cookie';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

function KakaoRedirect() {
  const code = new URL(window.location.href).searchParams.get('code');
  const [cookies, setCookie] = useCookies();
  const navigate = useNavigate();

  useEffect(() => {
    async function KakaoLogin() {
      const res = await axios.get(
        `${process.env.REACT_APP_BASE_URL}auth/login/kakao`
      );
      const ACCESS_TOKEN = res.headers.authorization;
      const REFRESH_TOKEN = res.headers.refresh_token;
      setCookie('accessToken', ACCESS_TOKEN);
      setCookie('refreshToken', REFRESH_TOKEN);
    }
    KakaoLogin();
    // navigate('/memlist', { replace: true });
    if (cookies !== null) {
      navigate('/memlist', { replace: true });
    } else {
      navigate('/addinfo', { replace: false });
    }
  }, []);
}
export default KakaoRedirect;
