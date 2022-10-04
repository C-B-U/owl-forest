import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import BookReg from './Pages/BR_BookReg';
import BorrowList from './Pages/BR_BorrowList';
import ReviewDetail from './Pages/BR_ReviewDetail';
import ReviewList from './Pages/BR_ReviewList';
import ReviewReg from './Pages/BR_ReviewReg';
import Popup from './Components/Popup';

function App() {
  return (
    <div className='App'>
      <Router>
        <Routes>
          <Route path='/' element={<BorrowList />} />
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
