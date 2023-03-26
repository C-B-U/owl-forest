import React, { useEffect, useState } from 'react';
import { useCookies } from 'react-cookie';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const KakaoRedirect = (props) => {
  const [cookies, setCookie, removeCookie] = useCookies(['Authorization']);

  const navigate = useNavigate();
  const token = cookies.Authorization;

  if(token !== null){
    navigate('/memlist', {replace: true});
  } else {
    navigate('/addinfo', {replace: false});
  }
};

export default KakaoRedirect;