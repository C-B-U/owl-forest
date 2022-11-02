import React from 'react'
import styled, { ThemeProvider } from 'styled-components'
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import imgfile from '../../Image/Logo10.png';
import { InputStyle } from '../../Components/Input'


const Wrap = styled.div`
  position:relative;
  display:flex;
  @media (max-width:60rem){
    height:100%;
    width:100%;
  }
  background-color: ${palette('PsWhite')};
`

const LeftWrap = styled.div`  //Left로 프로필 화면부분을 감싸줌
  height:50rem;
  width:10rem;
  flex-grow:1;
  text-align: center;
  border: 1px solid gray;
  @media (max-width:60rem){   //창화면이 커지면 자신의 프로필만 나타나게 함.
    text-align: center;
  }
`

const RightWrap = styled.div`   //Right로 오른쪽에 부원리스트 화면 부분 나타내는 영역임
  border: 1px solid gray;
  flex-grow:5;
  margin-left:1rem;
  @media (max-width:60rem){   //창화면 작아지면 프로필 수정 영역 안보이게 함.
    display:none;
  }
`
const Profileimg = styled.img`    //자신의 프로필 이미지
  width:12rem;
  height:12rem;
  border-radius :100%; 
  margin: 5rem 0 2rem;
`
const Intro = styled.div`   //introduction 줄여서 intro ->한 줄 소개하는 영역
  width:18rem;
  height:5rem;
  background-color:${palette('PsBtn')};
  margin: auto;       //블록요소인 div가운데 정렬
  font-family: 'Noto Sans KR', sans-serif;
  display: flex;
  align-items: center;
  justify-content: center;
`

function MM_Profile() {
  return (
    <div>
      <ThemeProvider theme={theme}>
        <Wrap>
          <LeftWrap>
            <Profileimg src={imgfile} />
            <Intro>짧은 자기소개를 해주세요.</Intro>
          </LeftWrap>
          <RightWrap>
          </RightWrap>
        </Wrap>
      </ThemeProvider>
    </div>

  )
}

export default MM_Profile