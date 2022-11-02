import React from 'react'
import styled, { ThemeProvider } from 'styled-components'
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import imgfile from '../../Image/Logo10.png';


const Wrap = styled.div`
  position:relative;
  display:flex;
  @media (max-width:50rem){
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
  @media (max-width:50rem){   //창화면이 커지면 자신의 프로필을 사라지게 함.
    display:none;
  }
`

const RightWrap = styled.div`   //Right로 오른쪽에 부원리스트 화면 부분 나타내는 영역임
  border: 1px solid gray;
  flex-grow:5;
  margin-left:1rem;
  @media (max-width:50rem){   //창화면 작아지면 리스트화면을 화면가득 채움
    width:100vw;
    height:100vh;
    margin-left:0;
  }
`
const Profileimg = styled.img`    //자신의 프로필 이미지
  width:12rem;
  height:12rem;
  border-radius :100%; 
  margin-top: 5rem;
  
`


function MM_Profile() {
  return (
    <div>
      <ThemeProvider theme={theme}>
        <Wrap>
          <LeftWrap>
            <Profileimg src={imgfile} />
          </LeftWrap>
          <RightWrap>
          </RightWrap>
        </Wrap>
      </ThemeProvider>
    </div>

  )
}

export default MM_Profile