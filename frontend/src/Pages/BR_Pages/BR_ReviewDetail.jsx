import React from 'react';
import { palette } from 'styled-tools';
import styled, { ThemeProvider } from 'styled-components';
import theme from '../../Components/Color';
import Header from '../../Components/ActivityLog/Header';
import RegButton from '../../Components/Btn.jsx';
import Input from '../../Components/Input.jsx';

const MainWrap = styled.div`
  position: absolute;
  background-color: ${palette('PsCocoa', 0)};
  width: 100%;
`;
const Wrap = styled.div`
  margin: 8rem auto 0rem auto;
  width: fit-content;
  height: fit-content;
  background-color: ${palette('PsCocoa', 1)};
  padding: 3rem;
  box-sizing: content-box;
`;
const WrapContent = styled.div`
  display: flex;
`;

const Title = styled.h1`
  color: ${palette('PsYellow')};
`;

const BookInfos = styled.div`
  height: fit-content;
  font-size: 13pt;
  position: absolute;
  top: -1rem;
`; // 책정보 책이름|저자

const BookPublisher = styled.div`
  height: fit-content;
  font-size: 10pt;
  top: 0.5rem;
  position: absolute;
`; // 책 출판사

const BookImage = styled.div`
  width: 23rem;
  height: 26rem;
  background-color: #ffffff;
`; // 책이미지

const OneLineReview = styled.div`
  margin-top: 2rem;
`; // 책한줄평

const WrapReview = styled.div`
  margin-left: 3rem;
  width: fit-content;
  height: fit-cotent;
  padding: 1rem;
  background-color: ${palette('PsCocoa', 1)};
  border-radius: 0.2rem;
  margin-top: 1rem;
  position: relative;
`;

const WrapStarScore = styled.div`
  margin-top: 3rem;
  display: flex;
`;
const WrapotherStarScore = styled.div`
  display: flex;
  height: fit-content;
  right: 0.5rem;
  top: 1rem;
  position: absolute;
`;

const StarScore = styled.div`
  margin-right: 1rem;
  margin-bottom: 1rem;
`; // 별 평점 난이도

const DetailReview = styled.div`
  margin-top: 0.5rem;
  margin-bottom: 1rem;
`;

const ReviewName = styled.div`
  margin-bottom: 0.5rem;
`; // 한줄평, 상세평 글자

const Scrollbar = styled.nav`
  overflow: auto;
  height: 13rem;
  &::-webkit-scrollbar {
    width: 0.5rem;
    height: 1rem;
    border-radius: 0.4rem;
    background: rgba(158, 197, 124);
  }
  &::-webkit-scrollbar-thumb {
    background: rgba(0, 0, 0, 0.3);
    border-radius: 0.4rem;
  }
`; // 댓글 및 다른리뷰 스크롤 내리면서 볼수있게구현

const Comment = styled.div`
  margin-top: 2rem;
  margin-bottom: 1rem;
`; // 댓글

const CommentView = styled.div`
  position: relative;
  min-width: 30rem;
  width: fit-content;
  height: 6rem;
  background-color: #eef6e8;
  border-radius: 0.2rem;
  border: 0.05rem solid #98f791;
  margin-bottom: 1rem;
`; // 하나의 댓글 상자

const Commenter = styled.div`
  margin-left: 1rem;
  margin-top: 1rem;
`; // 댓글작성자

const CommentContent = styled.div`
  margin-left: 1rem;
  margin-right: 1rem;
  margin-top: 0.5rem;
`; // 댓글 내용

const CommentName = styled.div`
  margin-bottom: 1rem;
`; // 댓글, 이책의 다른리뷰 글자 마진주기위해서 commentname 컴포넌트추가

const CommentInput = styled.div`
  margin-right: 1rem;
`; // 댓글 입력창

const CommentWrite = styled.div`
  display: flex;
`;
const OtherComment = styled.div`
  margin-top: 5rem;
`;

function BR_ReviewDetail() {
  return (
    <div>
      <ThemeProvider theme={theme}>
        <Header /> {/* 헤더 */}
        <MainWrap>
          <Wrap>
            <Title>북리뷰 상세</Title>
            <WrapContent>
              <BookImage />
              <WrapReview>
                <BookInfos>책이름 | 저자</BookInfos>
                <BookPublisher>출판사</BookPublisher>
                <OneLineReview>
                  <ReviewName>한줄평</ReviewName>
                  <Input
                    width='40rem'
                    height='2.3rem'
                    placeholder='한줄평을 작성해 주세요'
                  />
                </OneLineReview>

                <DetailReview>
                  <ReviewName>상세평</ReviewName>
                  <Input
                    width='40rem'
                    height='7rem'
                    placeholder='상세평을 작성해 주세요'
                  />
                </DetailReview>
                <WrapStarScore>
                  <StarScore>평점</StarScore>
                  <StarScore>난이도</StarScore>
                </WrapStarScore>
              </WrapReview>
            </WrapContent>
            <Comment>
              <CommentName>댓글</CommentName>
              <Scrollbar>
                <CommentView>
                  {/* comment view 한개가 댓글 1개 */}
                  <Commenter>작성자</Commenter>
                  <CommentContent>dsadadasdhakdsadjkh</CommentContent>
                </CommentView>
                <CommentView>
                  <Commenter>작성자</Commenter>
                  <CommentContent>dsadadasdhakdsadjkh</CommentContent>
                </CommentView>
                <CommentView>
                  <Commenter>작성자</Commenter>
                  <CommentContent>dsadadasdhakdsadjkhsddadadad</CommentContent>
                </CommentView>
                <CommentView>
                  <Commenter>작성자</Commenter>
                  <CommentContent>dsadadasdhakdsadjksdadh</CommentContent>
                </CommentView>
                <CommentView>
                  <Commenter>작성자</Commenter>
                  <CommentContent>
                    dsadadasdhakdsadjkhwqejqwjkqwekwqjehqkwehqwkeqweqweydggsdgsadsuydgyugwqeyugwqeyugwygqeyuwqegquegwqeuywqeuygqewqgye
                  </CommentContent>
                </CommentView>
              </Scrollbar>
            </Comment>
            <CommentWrite>
              <CommentInput>
                <Input width='40rem' height='2.3rem' placeholder='댓글' />
              </CommentInput>
              <RegButton
                color={palette('PsYellow')}
                background={palette('PsBtn')}
                width='5.5rem'
                height='2.5rem'
                name='등 록'
              />
            </CommentWrite>

            <OtherComment>
              <CommentName>이 책의 다른 리뷰</CommentName>
              <Scrollbar>
                <CommentView>
                  {/* comment view 하나가 리뷰 블록 1개 */}
                  <Commenter>작성자</Commenter>
                  <WrapotherStarScore>
                    <StarScore>난이도</StarScore>
                    <StarScore>평점</StarScore>
                  </WrapotherStarScore>
                  <CommentContent>
                    {/* 코멘트 내용 */}
                    dsadadasddasdasddadasdasdadasdadadasdasdadasdasdadasdsadasdasddasdasdadasdadadsa
                  </CommentContent>
                </CommentView>
                <CommentView>
                  <Commenter>작성자</Commenter>
                  <WrapotherStarScore>
                    <StarScore>난이도</StarScore>
                    <StarScore>평점</StarScore>
                  </WrapotherStarScore>
                  <CommentContent>
                    dsadadasddasdasddadasdasdadasdadadasdasdadasdasdadasdsadasdasddasdasdadasdadadsa
                  </CommentContent>
                </CommentView>
                <CommentView>
                  <Commenter>작성자</Commenter>
                  <WrapotherStarScore>
                    <StarScore>난이도</StarScore>
                    <StarScore>평점</StarScore>
                  </WrapotherStarScore>
                  <CommentContent>
                    dsadadasddasdasddadasdasdadasdadadasdasdadasdasdadasdsadasdasddasdasdadasdadadsa
                  </CommentContent>
                </CommentView>
                <CommentView>
                  <Commenter>작성자</Commenter>
                  <WrapotherStarScore>
                    <StarScore>난이도</StarScore>
                    <StarScore>평점</StarScore>
                  </WrapotherStarScore>
                  <CommentContent>
                    dsadadasddasdasddadasdasdadasdadadasdasdadasdasdadasdsadasdasddasdasdadasdadadsa
                  </CommentContent>
                </CommentView>
                <CommentView>
                  <Commenter>작성자</Commenter>
                  <WrapotherStarScore>
                    <StarScore>난이도</StarScore>
                    <StarScore>평점</StarScore>
                  </WrapotherStarScore>
                  <CommentContent>
                    dsadadasddasdasddadadsdadadasdadadadasdasdadasdadadasdasdadasdasdadasdsadasdasddasdasdadasdadadsa
                  </CommentContent>
                </CommentView>
              </Scrollbar>
            </OtherComment>
          </Wrap>
        </MainWrap>
      </ThemeProvider>
    </div>
  );
}

export default BR_ReviewDetail;
