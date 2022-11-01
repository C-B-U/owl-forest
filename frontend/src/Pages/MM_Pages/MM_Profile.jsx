import React from 'react'
import styled, { ThemeProvider } from 'styled-components'
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import { InputStyle } from '../../Components/Input'
import imgfile from '../../Image/Logo10.png';

const Profileimg = styled.img`
  width:5rem;
  height:5rem;
  border-radius :100%;
`;
const Wrap = styled.div`
  display:flex;
  flex-wrap:nowrap;
`
const Left = styled.div`
  flex-grow:1;
`

const Right = styled.div`
  flex-grow:3;
`
const Square = styled.div`
  width : 10rem;
  height : 30rem;
  background-color :tomato;
  position:fixed;
`
const Square2 = styled.div`
  width : 10rem;
  height : 30rem;
  background-color :blue;
`

function MM_Profile() {
  return (
    <div>
      <Wrap>
        <Left>
          <Profileimg src={imgfile}></Profileimg>
          <Square />
          <Square2 />
        </Left>
        <Right>
          <Profileimg src={imgfile}></Profileimg>
        </Right>
      </Wrap>
    </div>

  )
}

export default MM_Profile