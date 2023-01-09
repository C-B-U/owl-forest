const CLIENT_ID = 'df2abb134f2827818d99787305272526';
const REDIRECT_URL = 'http://localhost:3000/api/auth/login/kakao';

export const KAKAO_AUTH_URL = `https://kauth.kakao.com/oauth/authorize?client_id=${CLIENT_ID}&redirect_uri=${REDIRECT_URL}&response_type=code`;
