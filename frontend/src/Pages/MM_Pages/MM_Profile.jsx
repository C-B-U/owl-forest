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
  width:15rem;
  height:5rem;
  background-color:${palette('PsCocoa')};
  font-family: sans-serif;
  font-weight:bold;
  border-radius:0.2rem;
  color : white;
  margin: auto;       //블록요소인 div가운데 정렬
  padding :0.5rem;
  font-family: 'Noto Sans KR', sans-serif;
  display: flex;                  //
  align-items: center;            //요소 내부 세로 정렬
  justify-content: center;        //
  @media (max-width:60rem){   //화면 바뀌면 사이즈 키움
      width:20rem;
  }
`
const TechBox = styled.div`     //Tech Stack을 나타내는 박스
  width:14rem;
  height:18rem;
  padding :0.5rem;
  background-color:${palette('PsLightBrown')};
  margin: 3rem auto auto;       //블록요소인 div가운데 정렬
  border-radius:0.5rem;
  display:flex;
  flex-wrap: wrap;    //wrap속성을 통해서  Tech가 넘치면 다음줄로 넘어감
  align-content: flex-start;    //위에서부터 세로로 차례로 정렬
  @media (max-width:60rem){   //화면 바뀌면 사이즈 키움
      width:20rem;
  }
`

const TechMsg = styled.div`   //TechMessage줄임. 화면상에 TECH STACK을 표시하는 텍스트 영역
  font-size:20px;
  font-family: sans-serif;
`
const TechMsgWrap = styled.div`   //TechMsg를 감싸줌
  width : 100%;
  margin:1rem 0;
  font-size:20px;
  font-weight : bold;

`
const Tech = styled.div`
  height : 1.5rem;
  background-color:white;
  margin : 0.7rem 0.5rem;
  padding : 0.3rem 0.5rem;
  border-radius : 1rem;
  font-weight: 500;
  font-family: sans-serif;
`

function MM_Profile() {
  return (
    <div>
      <ThemeProvider theme={theme}>
        <Wrap>
          <LeftWrap>
            <Profileimg src={imgfile} />
            <Intro>자기소개 흰색으로 할까요? 검은색으로 할까요?</Intro>
            <TechBox>
              <TechMsgWrap>
                <TechMsg>Tech Stack</TechMsg>
              </TechMsgWrap>
              <Tech>Java</Tech><Tech>Python</Tech><Tech>C++</Tech><Tech>React</Tech><Tech>SpringBoot</Tech><Tech>Amazon AWS</Tech><Tech>Kotlin</Tech>
            </TechBox>
          </LeftWrap>
          <RightWrap>
          </RightWrap>
        </Wrap>
      </ThemeProvider>
    </div>

  )
}

export default MM_Profile