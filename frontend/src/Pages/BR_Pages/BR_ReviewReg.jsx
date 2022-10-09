import React from 'react';
import styled from 'styled-components';
import './BR_ReviewReg.scss';
import RegButton from '../../Components/Btn.jsx';
import Input from '../../Components/Btn.jsx';

const Wrap = styled.div`
  margin: 12rem auto 0rem auto;
  width: 55rem;
  height: fit-content;
  background-color: rgb(218, 201, 194);
  padding: 3rem;
  box-sizing: content-box;
`;

const WrapContent = styled.div`
  display: flex;
`;

const BookImage = styled.div`
  width: 12rem;
  height: 15rem;
  background-color: #ffffff;
`;

const WrapReview = styled.div`
  margin-left: 3rem;
`;
const OneLineReview = styled.div`
  width: 30rem;
  height: 3rem;
  background-color: white;
  border-radius: 0.2rem;
`;

const WrapDetailReview = styled.div`
  width: fit-content;
  height: fit-content;
  padding: 1rem;
  background-color: rgb(186, 176, 176);
  border-radius: 0.2rem;
  margin-top: 2rem;
`;

const WrapStarScore = styled.div`
  display: flex;
`;

const StarScore = styled.div`
  margin-left: 1rem;
  margin-bottom: 1rem;
`;

const DetailReview = styled.div`
  width: 30rem;
  height: 5rem;
  background-color: white;
  border-radius: 0.2rem;
  margin: auto;
`;
function BR_ReviewReg() {
  return (
    <div>
      <Wrap>
        <WrapContent>
          <BookImage></BookImage>
          <WrapReview>
            <OneLineReview></OneLineReview>
            <WrapDetailReview>
              <WrapStarScore></WrapStarScore>
              <DetailReview></DetailReview>
            </WrapDetailReview>
          </WrapReview>
        </WrapContent>
      </Wrap>
      {/* <div className='wrap'>
        <div className='wrap_content'>
          <div className='book_image'></div>
          <div className='wrap_review'>
            <Input
              id={styled.detailreview}
              width={'40rem'}
              height={'3rem'}
              placeholder={'한줄평'}
            />
            <div className='wrap_detailreview'>
              <div className='wrap_starscore'>
                <div className='difficulty'>난이도 ⭐️⭐️⭐️⭐️⭐️</div>
                <div className='score'> 평점 ⭐️⭐️⭐️⭐️⭐️</div>
              </div>

              <Input
                className='detailreview'
                width={'30rem'}
                height={'5rem'}
                placeholder={'한줄평'}
              />
              <RegButton
                background={'rgba(179, 146, 131)'}
                width={'5rem'}
                height={'2rem'}
                name={'등 록'}
              />
            </div>
          </div>
        </div>
      </div> */}
    </div>
  );
}

export default BR_ReviewReg;
