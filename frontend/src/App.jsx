import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Welcome from './Pages/Welcome';
import StudyActivityLog from './Pages/SAL_Pages/StudyActivityLog';
import PlanMake from './Pages/SAL_Pages/PlanMake';
import StudyCreation from './Pages/SAL_Pages/StudyCreation';
import StudyCrew from './Pages/SAL_Pages/StudyCrew';
import StudyLeader from './Pages/SAL_Pages/StudyLeader';
import StudyManage from './Pages/SAL_Pages/StudyManage';
import StudyLog from './Pages/SAL_Pages/StudyLog';
import Writing from './Pages/SAL_Pages/Writing';
import FindId from './Pages/MM_Pages/MM_FindId';
import FindPw from './Pages/MM_Pages/MM_FindPw';
import Login from './Pages/MM_Pages/MM_Login';
import MemList from './Pages/MM_Pages/MM_MemList';
import MemListCon from './Pages/MM_Pages/MM_MemListCon';
import Reg from './Pages/MM_Pages/MM_Reg';
import Profile from './Pages/MM_Pages/MM_Profile';
import ChangePw from './Pages/MM_Pages/MM_ChangePw';
import BookReg from './Pages/BR_Pages/BR_BookReg';
import BorrowList from './Pages/BR_Pages/BR_BorrowList';
import ReviewDetail from './Pages/BR_Pages/BR_ReviewDetail';
import ReviewList from './Pages/BR_Pages/BR_ReviewList';
import ReviewReg from './Pages/BR_Pages/BR_ReviewReg';

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
          {/* ---- 북리뷰 ---- */}
          <Route path='/BorrowList' element={<BorrowList />} />
          <Route path='/BookRegister' element={<BookReg />} />
          <Route path='/ReviewDetail' element={<ReviewDetail />} />
          <Route path='/ReviewList' element={<ReviewList />} />
          <Route path='/ReviewRegister' element={<ReviewReg />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
