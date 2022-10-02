import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import FindId from './Pages/MM_FindId';
import FindPw from './Pages/MM_FindPw';
import Login from './Pages/MM_Login';
import MemList from './Pages/MM_MemList';
import MemListCon from './Pages/MM_MemListCon';
import Reg from './Pages/MM_Reg';
import Profile from './Pages/MM_Profile';

function App() {
  return (
    <div className='App'>
      <Router>
        <Routes>
          <Route path='/' element={<Login />} />
          <Route path='/FindId' element={<FindId />} />
          <Route path='/FindPw' element={<FindPw />} />
          <Route path='/MemList' element={<MemList />} />
          <Route path='/MemListCon' element={<MemListCon />} />
          <Route path='/Reg' element={<Reg />} />
          <Route path='/Profile' element={<Profile />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;