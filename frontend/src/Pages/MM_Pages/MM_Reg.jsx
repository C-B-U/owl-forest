import React from 'react'
import styled from 'styled-components'
import { InputStyle } from '../../Components/Input'
import imgfile from '../../Image/Home.png';

const All = styled.div`
  position : absolute;    //absolute 추가(세로 중앙정렬)
  width :100%;
  height: 100%;
  align-items:center;
  justify-content:center;
  flex-direction: column;
  display:flex;
  text-align: center;
  margin : 0 auto;    //세로 중앙정렬을 위한 margin 값
`

const Squbox = styled.div`
  width : 35rem;
  height : 35rem;
  border-radius:2rem;
  border: 0.1rem solid rgba(128, 109, 70);
  margin-top: 2rem;
  text-align: center;
  padding-top: 1rem;
`

const Regi = styled(InputStyle)`
  border: 0.15rem solid rgba(247, 232, 211);
  background-color : rgba(247, 232, 211);
  border-radius:4rem;
  display: block;
  padding: 0rem 1.5rem;
  margin : auto;
  margin-bottom : 1.5rem;
  margin-top: 1.5rem;
`

const BtnWrap = styled.div`
  display: flex;
  justify-content: space-evenly;
  z-index: 1;
`

const Msg = styled.div`
  font-size: 2rem;
`

const Imghome = styled.img`
  width: 3rem;
  height: 3rem;
  z-index: 2;
`

const Btn = styled.div`
  width: 5rem;
  height: 2rem;
  background-color: red;
`

function MM_Reg() {
  return (
    <All>
      <Msg>회원가입 페이지</Msg><Imghome src={imgfile}/>
      <Squbox>
          <Regi width={'22rem'} height={'2.8rem'} placeholder={'Email '} ></Regi>
          <Regi width={'22rem'} height={'2.8rem'} placeholder={'Id '} ></Regi>
          <Regi width={'22rem'} height={'2.8rem'} placeholder={'Password '} ></Regi>
          <Regi width={'22rem'} height={'2.8rem'} placeholder={'Confirm password '} ></Regi>
          <Regi width={'22rem'} height={'2.8rem'} placeholder={'Name '} ></Regi>
          <Regi width={'22rem'} height={'2.8rem'} placeholder={'Student Id '} ></Regi>

          <BtnWrap>
            <Btn color={'black'} background={'rgba(179, 146, 131)'} width={'4rem'} height={'2rem'} >
              <Imghome src={imgfile}/>
            </Btn>
            <Btn color={'black'} background={'rgba(179, 146, 131)'} width={'6rem'} height={'2rem'} name={'회원가입'} />
          </BtnWrap>
      </Squbox>
    </All>
  )
}

export default MM_Reg