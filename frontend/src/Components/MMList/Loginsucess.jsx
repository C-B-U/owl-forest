import React, { useEffect } from 'react'
import { useCookies } from 'react-cookie';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

function Loginsuccess(){
  const [cookies, setCookie] = useCookies();
  const navigate = useNavigate();
  console.log("test");
  useEffect(()=>{
    async function KakaoLogin() {
      const res = await axios.get(
        `${process.env.REACT_APP_BASE_URL}auth/login/kakao`
      );
      const ACCESS_TOKEN = res.headers.authorization;
      const REFRESH_TOKEN = res.headers.refresh_token;
      setCookie('accessToken', ACCESS_TOKEN);
      setCookie('refreshToken', REFRESH_TOKEN);
      console.log(ACCESS_TOKEN);
      console.log(REFRESH_TOKEN);
    }
    KakaoLogin();
    

    if(cookies !== null){
        navigate('/memlist', { replace: true });
    }else {
        navigate('/addinfo', { replace: false });
    }

  }, []);
  
}
export default Loginsuccess;