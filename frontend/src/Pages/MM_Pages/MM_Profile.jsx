import React from 'react'
import styled, { ThemeProvider } from 'styled-components'
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import { InputStyle } from '../../Components/Input'
import imgfile from '../../Image/Logo10.png';


const Wrap = styled.div`
  position:relative;
  display:flex;
  
`
const LeftFixedWrap = styled.div` //왼쪽 자신의 프로필 화면을 fixed시키기 위한 Wrap
  position:fixed;
`
const LeftWrap = styled.div`  //Left로 프로필 화면부분을 감싸줌
  background-color:aqua;
  height:50rem;
  width:10rem;
  flex-grow:1;
  border: 1px solid gray;
  @media (max-width:50rem){
    display:none;
  }
`

const RightWrap = styled.div`   //Right로 오른쪽에 부원리스트 화면 부분 나타내는 영역임
  border: 1px solid gray;
  background-color:tomato;
  flex-grow:5;
  margin-left:1rem;

`
const Profileimg = styled.img`    //자신의 프로필 이미지
  width:5rem;
  height:5rem;
  border-radius :100%;
`;

function MM_Profile() {
  return (
    <div>
      <Wrap>
        <LeftWrap>
          <LeftFixedWrap>
          </LeftFixedWrap>
        </LeftWrap>
        <RightWrap>
        </RightWrap>
      </Wrap>
    </div>

  )
}

export default MM_Profile