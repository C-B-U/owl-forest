import React from 'react';
import axios from 'axios';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Welcome from './Pages/Welcome';
import StudyActivityLog from './Pages/SAL/StudyActivityLog';
import PlanMake from './Pages/SAL/PlanMake';
import StudyCreation from './Pages/SAL/StudyCreation';
import StudyCrew from './Pages/SAL/StudyCrew';
import StudyLeader from './Pages/SAL/StudyLeader';
import StudyManage from './Pages/SAL/StudyManage';
import StudyLog from './Pages/SAL/StudyLog';
import Writing from './Pages/SAL/Writing';
import FindId from './Pages/MM/FindId';
import FindPw from './Pages/MM/FindPw';
import Login from './Pages/MM/Login';
import MemList from './Pages/MM/MemList';
import MemListCon from './Pages/MM/MemListCon';
import Reg from './Pages/MM/Reg';
import Profile from './Pages/MM/Profile';
import ChangePw from './Pages/MM/ChangePw';
import AddInfo from './Pages/MM/AddInfo';
import BookReg from './Pages/BR/BookReg';
import Borrow from './Pages/BR/Borrow';
import BorrowList from './Pages/BR/BorrowList';
import MyBookList from './Pages/BR/MyBookList';
import ReviewDetail from './Pages/BR/ReviewDetail';
import ReviewList from './Pages/BR/ReviewList';
import ReviewReg from './Pages/BR/ReviewReg';
import KakaoRedirect from './Components/MMList/KakaoRedirect';
import GoogleRedirect from './Components/MMList/GoogleRedirect';
import NaverRedirect from './Components/MMList/NaverRedirect';
import loginsuccess from './Components/MMList/loginsuccess';

axios.defaults.baseURL = process.env.REACT_APP_BASE_URL;
axios.defaults.withCredentials = true;

function App() {
  return (
    <div className='App'>
      <Router>
        <Routes>
          {/* ---- 메인페이지 ---- */}
          <Route path='/' element={<Welcome />} />
          {/* ---- 활동일지 ---- */}
          <Route path='/StudyActivityLog' element={<StudyActivityLog />} />
          <Route path='/PlanMake' element={<PlanMake />} />
          <Route path='/StudyCreation' element={<StudyCreation />} />
          <Route path='/StudyCrew' element={<StudyCrew />} />
          <Route path='/StudyLeader' element={<StudyLeader />} />
          <Route path='/StudyLog' element={<StudyLog />} />
          <Route path='/StudyManage' element={<StudyManage />} />
          <Route path='/Writing' element={<Writing />} />
          {/* ---- 회원관리 ---- */}
          <Route path='/Login' element={<Login />} />
          <Route path='/FindId' element={<FindId />} />
          <Route path='/FindPw' element={<FindPw />} />
          <Route path='/MemList' element={<MemList />} />
          <Route path='/MemListCon' element={<MemListCon />} />
          <Route path='/Reg' element={<Reg />} />
          <Route path='/Profile' element={<Profile />} />
          <Route path='/ChangePw' element={<ChangePw />} />
          <Route path='/AddInfo' element={<AddInfo />} />
          {/* ---- 북리뷰 ---- */}
          <Route path='/Borrow' element={<Borrow />} />
          <Route path='/BorrowList' element={<BorrowList />} />
          <Route path='/BookRegister' element={<BookReg />} />
          <Route path='/MyBookList' element={<MyBookList />} />
          <Route path='/ReviewDetail' element={<ReviewDetail />} />
          <Route path='/ReviewList' element={<ReviewList />} />
          <Route path='/ReviewRegister' element={<ReviewReg />} />
          {/* ---- 로그인 리다이렉트 ---- */}
          <Route path='/authkakao' element={<KakaoRedirect />} />
          <Route path='/authgoogle' element={<GoogleRedirect />} />
          <Route path='/authnaver' element={<NaverRedirect />} />
          <Route path='/login-success' element={<loginsuccess />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
