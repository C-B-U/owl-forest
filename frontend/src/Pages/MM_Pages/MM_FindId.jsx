/* eslint-disable no-undef */
import React from 'react'
import styled from 'styled-components'
import { Input1 } from '../../Components/Input'
import Btn from '../../Components/Btn'
import imgfile from '../../Image/CbuIcon.png';

const All = styled.div`
  width : 100%;
  height: 100%;
  align-items:center;
  justify-content:center;
  display:inline-block;
  text-align: center;
  margin-top : 5rem; //rem말고 진짜 세로 정렬하는 법?
`

const Squbox = styled.div`
  width : 35rem;
  height : 25rem;
  border-radius:2rem;
  border: 0.2rem solid rgba(128, 109, 70);
  align-items:center;
  justify-content:center;
  display:inline-block;
  text-align: center;
  
`
const FindKey = styled(Input1)`
  border: 0.15rem solid rgba(247, 232, 211);
  background-color : rgba(247, 232, 211);
  border-radius:4rem;
  display:block;
  margin : auto;
  margin-bottom : 0.45rem;  
`
const Find = styled(Btn)`
  display : block;
  margin-top : 2rem;
`
const CbuImg = styled.img`
  width : 2rem;
  height : 2rem;
  border-radius: 100%;
  display:flex;
  padding-right : 0.5rem;
  padding-left : 0.5rem;

`

const Msg = styled.div`
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
    <All>
      <Squbox>
        <Msg><CbuImg src={imgfile}></CbuImg>아이디가 기억이 안나시나요?<CbuImg src={imgfile}></CbuImg></Msg>
        <FindKey width={'22rem'} height={'2rem'} placeholder={'이름'} ></FindKey >
        <FindKey width={'22rem'} height={'2rem'} placeholder={'학번'} ></FindKey >
        <FindKey width={'22rem'} height={'2rem'} placeholder={'이메일'} ></FindKey >
        <Find color={'black'} background={'rgba(179, 146, 131)'} width={'4rem'} height={'2rem'}>  </Find>
      </Squbox>
    </All >

  )
}

export default MM_FindId