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
const LeftFixedWrap = styled.div`
  height:10rem;
  width:10rem;
  background-color:blue;
  position:fixed;
`
const LeftWrap = styled.div`
  height:50rem;
  width:10rem;
  flex-grow:1;
  border: 1px solid gray;
  margin-right:1rem;
`

const RightWrap = styled.div`
  border: 1px solid gray;
  flex-grow:5;
`
const Profileimg = styled.img`
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