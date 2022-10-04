import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ActivityLog from './Pages/ActivityLog';
import PlanMake from './Pages/PlanMake';
import StudyCreation from './Pages/StudyCreation';
import StudyCrew from './Pages/StudyCrew';
import StudyLeader from './Pages/StudyLeader';
import StudyManage from './Pages/StudyManage';
import StudyLog from './Pages/StudyLog';
import Writing from './Pages/Writing';

function App() {
  return (
    <div className='App'>
      <Router>
        <Routes>
          <Route path='/' element={<ActivityLog />} />
          <Route path='/PlanMake' element={<PlanMake />} />
          <Route path='/StudyCreation' element={<StudyCreation />} />
          <Route path='/StudyCrew' element={<StudyCrew />} />
          <Route path='/StudyLeader' element={<StudyLeader />} />
          <Route path='/StudyLog' element={<StudyLog />} />
          <Route path='/StudyManage' element={<StudyManage />} />
          <Route path='/Writing' element={<Writing />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
