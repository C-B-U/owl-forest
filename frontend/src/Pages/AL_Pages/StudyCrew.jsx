import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import theme from '../../Components/Color';
import { palette } from 'styled-tools';
import Logo10 from '../../Image/Logo10.png';
import Input from '../../Components/Input';
import Btn from '../../Components/Btn';
import Plus from '../../Image/PlusButton.png';
import Minus from '../../Image/MinusButton.png';

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
  width: 100vw;
  height: 100vh;
  text-align: center;
`;

const StudyWrap = styled.div`
  display: inline-block;
  text-align: center;
`;

const OutLine = styled.div`
  width: 100rem;
  height: 40rem;
  border-radius: 1rem;
  /* margin: auto; */
  padding: 4rem;
  background-color: ${palette('PsLightBrown')};
  display: inline-block;
  text-align: center;
`;

/** 블럭 간격 조절 */
const StudyIndex = styled.div`
  display: flex;
  margin-top: 1rem;
  margin-bottom: 1rem;
`;

/** 스크롤 */
const ScrollBar = styled.div`
  margin-bottom: 1rem;
  overflow-y: auto;
  height: 25rem;
  &::-webkit-scrollbar {
    width: 0.5rem;
    height: 1rem;
    border-radius: 0.4rem;
  }
  &::-webkit-scrollbar-thumb {
    height: 20rem;
    background: ${palette('PsBtn')};
    border-radius: 0.4rem;
  }
  &::-webkit-scrollbar-track {
    background: #efebe9;
    border-radius: 0.4rem;
  }
`;

const BtnWrap = styled.div`
  display: flex;
  margin-left: 1rem;
`;

const Team = styled.div`
  display: flex;
  justify-content: center;
`;

const WordWrap = styled.div`
  display: inline-block;
`;

const BlockWrap = styled.div`
  display: inline-block;
`;

const StudyHeader = styled.header`
  width: 60rem;
  height: 4rem;
  margin-top: 4rem;
  margin-left: 1rem;
  font-size: 20pt;
  font-weight: bold;
  align-items: center;
  justify-content: left;
  display: flex;
`;

/** 스터디 개요 */
const StudySummary = styled.header`
  width: 10rem;
  height: 4rem;
  margin-top: 0.3rem;
  margin-bottom: 5.8rem;
  margin-right: 1rem;
  font-size: 20pt;
  font-weight: bold;
  align-items: center;
  justify-content: right;
  display: flex;
`;

/** 팀장 */
const StudyLeader = styled.header`
  width: 10rem;
  height: 4rem;
  /* margin-top: 1rem; */
  margin-right: 1rem;
  font-size: 20pt;
  font-weight: bold;
  align-items: center;
  justify-content: right;
  display: flex;
`;

/** 팀원 */
const StudyMember = styled.header`
  width: 10rem;
  height: 4rem;
  margin-top: 0.1rem;
  margin-right: 1rem;
  font-size: 20pt;
  font-weight: bold;
  align-items: center;
  justify-content: right;
  display: flex;
`;

const PlusBtn = styled.button`
  background-image: url(${Plus});
  background-repeat: no-repeat;
  background-position: center;
  background-size: 2rem;
  background-color: ${palette('PsLightBrown')};
  border: 0em;
  width: 3rem;
  height: 3rem;
  margin-left: 0.5rem;
`;

const MinusBtn = styled.button`
  background-image: url(${Minus});
  background-repeat: no-repeat;
  background-position: center;
  background-size: 2rem;
  background-color: ${palette('PsLightBrown')};
  border: 0em;
  width: 3rem;
  height: 3rem;
  margin-left: 0.5rem;
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
              <Team>
                {/* 글씨 블럭 */}
                <WordWrap>
                  <StudySummary>스터디 개요</StudySummary>
                  <StudyLeader>팀장</StudyLeader>
                  <StudyMember>팀원</StudyMember>
                </WordWrap>

                {/* 블럭 */}
                <BlockWrap>
                  <StudyIndex>
                    {/* 스터디 개요 작성 */}
                    <Input width={'45rem'} height={'8rem'} />
                  </StudyIndex>
                  {/* 스크롤 */}
                  <ScrollBar>
                    <StudyIndex>
                      {/* 팀장 작성 */}
                      <Input
                        width={'7rem'}
                        height={'3rem'}
                        margin={'0 1rem 0 0'}
                      />
                      <Input width={'30rem'} height={'3rem'} />
                    </StudyIndex>
                    <StudyIndex>
                      {/* 팀원작성 */}
                      <Input
                        width={'7rem'}
                        height={'3rem'}
                        margin={'0 1rem 0 0'}
                      />
                      <Input width={'30rem'} height={'3rem'} />
                      <PlusBtn></PlusBtn>
                    </StudyIndex>
                    <StudyIndex>
                      <Input
                        width={'7rem'}
                        height={'3rem'}
                        margin={'0 1rem 0 0'}
                      />
                      <Input width={'30rem'} height={'3rem'} />
                      <MinusBtn></MinusBtn>
                    </StudyIndex>
                    <StudyIndex>
                      <Input
                        width={'7rem'}
                        height={'3rem'}
                        margin={'0 1rem 0 0'}
                      />
                      <Input width={'30rem'} height={'3rem'} />
                      <MinusBtn></MinusBtn>
                    </StudyIndex>
                    <StudyIndex>
                      <Input
                        width={'7rem'}
                        height={'3rem'}
                        margin={'0 1rem 0 0'}
                      />
                      <Input width={'30rem'} height={'3rem'} />
                      <MinusBtn></MinusBtn>
                    </StudyIndex>
                    <StudyIndex>
                      <Input
                        width={'7rem'}
                        height={'3rem'}
                        margin={'0 1rem 0 0'}
                      />
                      <Input width={'30rem'} height={'3rem'} />
                      <MinusBtn></MinusBtn>
                    </StudyIndex>
                    <StudyIndex>
                      <Input
                        width={'7rem'}
                        height={'3rem'}
                        margin={'0 1rem 0 0'}
                      />
                      <Input width={'30rem'} height={'3rem'} />
                      <MinusBtn></MinusBtn>
                    </StudyIndex>
                  </ScrollBar>

                  {/* 버튼 */}
                  <BtnWrap>
                    <Btn
                      background={palette('PsBtn')}
                      color={palette('PsYellow')}
                      width={'45.5rem'}
                      height={'3.5rem'}
                      name={'수정하기'}
                    />
                  </BtnWrap>
                </BlockWrap>
              </Team>
            </OutLine>
          </StudyWrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}

export default StudyCrew;
