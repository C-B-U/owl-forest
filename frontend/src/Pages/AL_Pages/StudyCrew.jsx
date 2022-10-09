import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import theme from '../../Components/Color';
import { palette } from 'styled-tools';
import Logo10 from '../../Image/Logo10.png';
import Input from '../../Components/Input';
// import Scroll from '../../Components/Scroll';

const HeaderWrapper = styled.div`
  height: 4rem;
  display: flex;
  background-color: ${palette('PsGreen', 0)};
  padding: 0 5rem;
`;

const Logo = styled.div`
  width: 4rem;
  height: 4rem;
  border-radius: 100%;
  display: flex;
  margin-right: 1rem;
  background-image: url(${Logo10});
  background-size: 4.4rem;
  background-repeat: no-repeat;
  background-position: center;
`;

const Title = styled.h1`
  font-style: normal;
  font-weight: bold;
  font-size: 20pt;
  display: flex;
`;

const MainWrap = styled.div`
  display: flex;
  background-color: ${palette('PsCocoa', 0)};
  background-size: cover;
`;

const ListWrap = styled.div`
  display: inline-block;
`;

const OutLine = styled.div`
  width: 90rem;
  height: 45rem;
  border-radius: 1rem;
  margin-left: 4rem;
  margin-right: 4rem;
  background-color: ${palette('PsLightBrown')};
  display: inline-block;
`;

const StudyIndex = styled.div`
  width: 200rem;
  display: flex;
  margin: 1rem;
  align-items: center;
`;

const StudyHeader = styled.header`
  width: 10rem;
  height: 4rem;
  margin-top: 1rem;
  padding-left: 4rem;
  font-size: 20pt;
  font-weight: bold;
  align-items: center;
  justify-content: left;
  display: flex;
`;

function StudyCrew() {
  return (
    <div>
      <ThemeProvider theme={theme}>
        <HeaderWrapper>
          <Logo />
          <Title>활동일지 서비스</Title>
        </HeaderWrapper>
        <MainWrap>
          <ListWrap>
            <StudyHeader>스터디 수정</StudyHeader>
            <OutLine>
              {/* <Scroll> */}
              <StudyIndex>
                <StudyHeader>스터디 개요</StudyHeader>
                <Input width={'40rem'} height={'10rem'} />
              </StudyIndex>
              <StudyIndex>
                <StudyHeader>팀장</StudyHeader>
                <Input width={'7rem'} height={'4rem'} />
                <Input width={'30rem'} height={'4rem'} />
              </StudyIndex>
              <StudyIndex>
                <StudyHeader>팀원</StudyHeader>
                <Input width={'7rem'} height={'4rem'} />
                <Input width={'30rem'} height={'4rem'} />
              </StudyIndex>
              <StudyIndex>
                <StudyHeader></StudyHeader>
                <Input width={'7rem'} height={'4rem'} />
                <Input width={'30rem'} height={'4rem'} />
              </StudyIndex>
              <StudyIndex>
                <StudyHeader></StudyHeader>
                <Input width={'7rem'} height={'4rem'} />
                <Input width={'30rem'} height={'4rem'} />
              </StudyIndex>
              <StudyIndex>
                <StudyHeader></StudyHeader>
                <Input width={'7rem'} height={'4rem'} />
                <Input width={'30rem'} height={'4rem'} />
              </StudyIndex>
              {/* </Scroll> */}
            </OutLine>
          </ListWrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}

export default StudyCrew;
