import React from 'react';
import styled from 'styled-components';
import RegButton from '../../Components/Btn.jsx';
import Input from '../../Components/Input.jsx';

const Wrap = styled.div`
  margin: 12rem auto 0rem auto;
  width: fit-content;
  height: fit-content;
  background-color: rgb(218, 201, 194);
  padding: 3rem;
  box-sizing: content-box;
`;

const WrapContent = styled.div`
  display: flex;
  /* margin: auto 0; */
`;

const BookImage = styled.div`
  width: 15rem;
  height: 19rem;
  background-color: #ffffff;
`;

const WrapReview = styled.div`
  margin-left: 3rem;
`;
const OneLineReview = styled.div`
  /* width: fit-content;
  height: fit-content;
  background-color: white;
  border-radius: 0.2rem; */
`;

const WrapDetailReview = styled.div`
  width: fit-content;
  height: 13.3rem;
  padding: 1rem;
  background-color: rgb(186, 176, 176);
  border-radius: 0.2rem;
  margin-top: 1rem;
  /* float: right; */
`;

const WrapStarScore = styled.div`
  display: flex;
`;

const StarScore = styled.div`
  margin-right: 1rem;
  margin-bottom: 1rem;
`;

const DetailReview = styled.div`
  margin-bottom: 1rem;
`;

const WrapRegButton = styled.div`
  float: right;
`;

function BR_ReviewReg() {
  return (
    <div>
      <Wrap>
        <WrapContent>
          <BookImage />
          <WrapReview>
            <OneLineReview>
              <Input width={'40rem'} height={'2.3rem'} placeholder='한줄평' />
            </OneLineReview>
            <WrapDetailReview>
              <WrapStarScore>
                <StarScore>난이도</StarScore>
                <StarScore>평점</StarScore>
              </WrapStarScore>
              <DetailReview>
                <Input width={'38rem'} height={'7rem'} placeholder='상세평' />
              </DetailReview>
              <WrapRegButton>
                <RegButton
                  background={'rgba(179, 146, 131)'}
                  width={'5rem'}
                  height={'2rem'}
                  name='등 록'
                />
              </WrapRegButton>
            </WrapDetailReview>
          </WrapReview>
        </WrapContent>
      </Wrap>
    </div>
  );
}

export default BR_ReviewReg;
