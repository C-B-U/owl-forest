import React from 'react';
import styled from 'styled-components';
import './BR_ReviewReg.scss';
import RegButton from '../../Components/Btn.jsx';
import Input from '../../Components/Btn.jsx';

// const Wrap = styled.div`
//   margin: 12rem auto 0rem auto;
//   width: 55rem;
//   height: fit-content;
//   background-color: rgb(218, 201, 194);
//   padding: 3rem;
// `;

// const Image = styled.div`
//   width: 12rem;
//   height: 15rem;
//   background-color: #ffffff;
//   display: flex;
// `;

// const OneLineReview = styled.div`
//   width: 22rem;
//   height: 5rem;
//   background-color: white;
//   margin-left: 30rem;
//   border-radius: 0.2rem;
// `;

function BR_ReviewReg() {
  return (
    <div>
      {/* <Wrap>
        <Image></Image>
        <OneLineReview></OneLineReview>
      </Wrap> */}
      <div className='wrap'>
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
              {/* <RegButton
                className='RegButton'
                background={'rgb(179, 146, 131)'}
                width={'5rem'}
                height={'2rem'}
                name={'등 록'}
              /> */}
              <RegButton
                background={'rgba(179, 146, 131)'}
                width={'5rem'}
                height={'2rem'}
                name={'등 록'}
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default BR_ReviewReg;
