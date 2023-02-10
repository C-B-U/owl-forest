/* eslint-disable no-unused-vars */
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import { useHistory } from 'react-router';

import theme from '../../Components/Color';
import MLProfile from '../../Components/MMList/MLProfile';
import MLList from '../../Components/MMList/MLList';
import Btn from '../../Components/Btn';
import profileimg from '../../Image/cbu_circle.png';

// import MLList from '../../Components/MMList/MLList';

// 가로 정렬
const MainWrap = styled.div`
  display: flex;
  background-color: ${palette('PsWhite')};
`;

const SecondWrap = styled.div`
  display: inline-block;
  overflow-x: hidden;
`;

const LineUp = styled.div`
  width: 100vw;
  height: 75.5vh;
  overflow: auto;
  margin-top: -0.5rem;
`;

// 마이페이지, 검색의 가로 정렬을 위해 사용
const SearchWrap = styled.div`
  display: flex;
  white-space: wrap;
`;

const SearchBox = styled.input`
  width: 10rem;
  height: 2rem;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 2rem;
  font-family: 'Noto Sans KR', sans-serif;
  padding: 0rem 1rem;
  border: 0.5rem;
  font-size: 12pt;
  margin-top: 2.8rem;
  font-weight: bolder;
  margin-left: 1rem;
  margin-right: 1rem;
`;

const MemListInput = styled.div`
  font-size: 1.2rem;
  font-weight: bold;
  display: flex;
`;
const MemNav = styled.div`
  width: 75rem;
  height: 5rem;
  border-radius: 3rem;
  margin-top: 0.8rem;
  padding-left: 1.5rem;
  display: flex;
  background-color: ${palette('PsLightBrown')};
  margin-left: 1.5rem;
  align-items: center;
  margin-bottom: 3rem;
`;

const Scroll = styled.div`
  overflow: auto;
`;

const SortOption = styled.div`
  margin-top: -2.2rem;
  margin-bottom: 0rem;
  margin-left: 67rem;
  position: absolute;
`;

const SelectBox = styled.select`
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  width: 5rem;
  height: 2rem;
  background-color: ${palette('PsGreen')};
  border-radius: 3rem;
  font-family: 'Noto Sans KR', sans-serif;
  &:focus {
    outline: none;
  }
  border: none;
  padding-left: 1.7rem;
  margin-top: 3rem;
  margin-left: 43.2rem;
`;

const PhotoInfo = styled.div``;

const NameInfo = styled.div`
  margin-left: 1.5rem;
`;

const MajorInfo = styled.div`
  margin-left: 6rem;
  text-align: left;
`;

const GradeInfo = styled.div`
  margin-left: 9rem;
`;
const InterstinInfo = styled.div`
  margin-left: 3rem;
`;

const Photo = styled.div`
  width: 3rem;
  height: 3rem;
  border-radius: 100%;
  background-color: rgba(217, 217, 217, 1);
  background-image: url(${profileimg});
  background-position: center;
  background-size: 3.5rem;
  background-repeat: no-repeat;
`;

const List = styled.div`
  width: 75rem;
  height: 3.5rem;
  border-radius: 3rem;
  margin-top: 0.7rem;
  padding-left: 1.5rem;
  display: flex;
  background-color: ${palette('PsLightBrown')};
  margin-left: 1.5rem;
`;

function MemList() {
  const [users, setUsers] = useState([]);
  useEffect(() => {
    axios.get('/api/users').then((response) => {
      setUsers(response.data);
    });
  }, []);
  // const history = useHistory();
  // useEffect(() => {
  //   history.push({
  //     pathname: '',
  //   });
  // });
  return (
    <div>
      <ThemeProvider theme={theme}>
        <MainWrap>
          <MLProfile />

          <SecondWrap>
            <SearchWrap>
              <Btn
                width='15rem'
                height='2.8rem'
                background={palette('PsGreen')}
                borderStyle='none'
                borderRadius='3rem'
                fontSize='12pt'
                fontWeight='bolder'
                marginTop='2rem'
                marginLeft='1.7rem'
                hoverBackgroundColor='#7ebe57'
                transition='0.3s'
                name='마이 페이지'
              />
              <SelectBox name='generation'>
                <option value='none'> 이름 </option>
                <option value='1기'>학과</option>
              </SelectBox>
              <SearchBox />
            </SearchWrap>
            <MemNav>
              <MemListInput style={{ fontSize: '1.8rem' }}>
                <PhotoInfo>프사</PhotoInfo>
                <NameInfo>이름</NameInfo>
                <MajorInfo>학과</MajorInfo>
                <GradeInfo>학년</GradeInfo>
                <InterstinInfo>관심분야</InterstinInfo>
              </MemListInput>
            </MemNav>
            <SortOption>
              <b>이름순&nbsp;</b> 학과순&nbsp; 학년순
            </SortOption>
            <LineUp>
              <Scroll>
                <MLList />
              </Scroll>
            </LineUp>
          </SecondWrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}

export default MemList;

// function MLList() {
//   const [user, setUsers] = useState([]);

//   useEffect(() => {
//     axios.get('/api/users').then((response) => {
//       setUsers(response.data);
//     });
//   }, []);

//   const list = users.map((v) => (
//     <div>
//       <List>
//         <MemListInput>
//           <Photo />
//           <NameInfo>{v.name}</NameInfo>
//           <MajorInfo>{v.major}</MajorInfo>
//           <GradeInfo>{v.grade}</GradeInfo>
//         </MemListInput>
//       </List>
//     </div>
//   ));

//   return <div>{list}</div>;
// }
