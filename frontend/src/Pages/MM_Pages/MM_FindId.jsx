/* eslint-disable no-undef */
import React from 'react'
import styled, { ThemeProvider } from 'styled-components'
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import { InputStyle } from '../../Components/Input'
import Btn from '../../Components/Btn'
import imgfile from '../../Image/CbuIcon.png';

const All = styled.div`
  position : absolute;    //absolute 추가(세로 중앙정렬)
  width :100%;
  height: 100%;
  align-items:center;
  justify-content:center;
  display:flex;
  text-align: center;
  margin : 0 auto;    //세로 중앙정렬을 위한 margin 값
`

const Squbox = styled.div`      //Squarebox 줄여서 Squbox
  width : 35rem;
  height : 25rem;
  border-radius:2rem;
  border: 0.2rem solid ${palette('PsCocoa', 1)};
  align-items:center;
  justify-content:center;
  display:inline-block;
  text-align: center;
`
const FindKey = styled(InputStyle)`
  border: 0.15rem solid rgba(247, 232, 211);
  background-color : rgba(247, 232, 211);
  border-radius:4rem;
  display:block;
  margin : auto;
  margin-bottom : 0.45rem;  
`
const FindWrap = styled.div`    //div로 버튼 감싸서 버튼 위치 조정 (div로 감싸주지 않으면 btn 내부에서만 속성이 바뀌기 때문에 div로 감싸줘야 함)
  margin-top : 3rem;
`

const CbuImg = styled.img`
  width : 2rem;
  height : 2rem;
  border-radius: 100%;
  display:flex;
  padding-right : 0.5rem;
  padding-left : 0.5rem;

`

const Msg = styled.div`   //Message 줄여서 Msg
  display:flex;
  font-size: 12pt;
  font-family: 'Noto Sans KR', sans-serif;
  align-items:center;
  justify-content:center;
  padding:3rem;
  text-align: center;
  
`


function MM_FindId() {
  return (
    <ThemeProvider theme={theme}>
      <All>
        <Squbox>
          <Msg><CbuImg src={imgfile} />아이디가 기억이 안나시나요?<CbuImg src={imgfile} /></Msg>
          <FindKey width={'22rem'} height={'2rem'} placeholder={'이름'} />
          <FindKey width={'22rem'} height={'2rem'} placeholder={'학번'} />
          <FindKey width={'22rem'} height={'2rem'} placeholder={'이메일'} />
          <FindWrap>
            <Btn color={'black'} background={'rgba(179, 146, 131)'} width={'4rem'} height={'2rem'} name={'찾기'} />
          </FindWrap>
        </Squbox>
      </All >
    </ThemeProvider>
  )
}

export default MM_FindId