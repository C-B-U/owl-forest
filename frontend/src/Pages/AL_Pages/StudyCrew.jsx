import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import theme from '../../Components/Color';
import { palette } from 'styled-tools';
import Logo10 from '../../Image/Logo10.png';
import Input from '../../Components/Input';
import Btn from '../../Components/Btn';
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
  display: inline-block;
  background-color: ${palette('PsCocoa', 0)};
  background-size: cover;
  width: 100%;
  height: 100%;
  text-align: center;
`;

const StudyWrap = styled.div`
  display: inline-block;
  text-align: center;
`;

const OutLine = styled.div`
  width: 60rem;
  height: 48rem;
  border-radius: 1rem;
  margin: auto;
  background-color: ${palette('PsLightBrown')};
  display: inline-block;
  text-align: center;
`;

const StudyIndex = styled.div`
  display: flex;
  margin: 1rem;
  align-items: center;
`;

const StudyHeader = styled.header`
  width: 60rem;
  height: 4rem;
  margin-top: 1rem;
  margin-left: 1rem;
  font-size: 20pt;
  font-weight: bold;
  align-items: center;
  justify-content: left;
  display: flex;
`;

const Studylist = styled.header`
  width: 10rem;
  height: 4rem;
  margin-top: 1rem;
  margin-right: 1rem;
  font-size: 20pt;
  font-weight: bold;
  align-items: center;
  justify-content: right;
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
          <StudyWrap>
            <StudyHeader>스터디 수정</StudyHeader>
            <OutLine>
              {/* <Scroll> */}
              <StudyIndex>
                <Studylist>스터디 개요</Studylist>
                <Input width={'40rem'} height={'10rem'} />
              </StudyIndex>
              <StudyIndex>
                <Studylist>팀장</Studylist>
                <Input width={'7rem'} height={'3rem'} />
                <Input width={'30rem'} height={'3rem'} />
              </StudyIndex>
              <StudyIndex>
                <Studylist>팀원</Studylist>
                <Input width={'7rem'} height={'3rem'} />
                <Input width={'30rem'} height={'3rem'} />
              </StudyIndex>
              <StudyIndex>
                <Studylist></Studylist>
                <Input width={'7rem'} height={'3rem'} />
                <Input width={'30rem'} height={'3rem'} />
              </StudyIndex>
              <StudyIndex>
                <Studylist></Studylist>
                <Input width={'7rem'} height={'3rem'} />
                <Input width={'30rem'} height={'3rem'} />
              </StudyIndex>
              <StudyIndex>
                <Studylist></Studylist>
                <Input width={'7rem'} height={'3rem'} />
                <Input width={'30rem'} height={'3rem'} />
              </StudyIndex>
              {/* </Scroll> */}
              <Btn
                background={palette('PsBtn')}
                color={palette('PsYellow')}
                width={'50rem'}
                height={'3.5rem'}
                name={'수정하기'}
              />
            </OutLine>
          </StudyWrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}

export default StudyCrew;
