import React from 'react'
import styled, { ThemeProvider } from 'styled-components'
import { palette } from 'styled-tools';
import theme from '../../Components/Color';
import { InputStyle } from '../../Components/Input'
import Btn from '../../Components/Btn'
import imgfile from '../../Image/Logo10.png';

const Profileimg = styled.img`
  width:5rem;
  height:5rem;
  border-radius :100%;
`;
const All = styled.div`
  display:flex;
  justify-content: space-around;
`
const Left = styled.div`
  display:flex;
`
const Right = styled.div`
  display:flex;
`


function MM_Profile() {
  return (
    <div>
      <All>
        <Left>
          <Profileimg src={imgfile}></Profileimg>
        </Left>
        <Right>
          <Profileimg src={imgfile}></Profileimg>
        </Right>
      </All>
    </div>

  )
}

export default MM_Profile