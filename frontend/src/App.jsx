import './App.css';

import Btn from './Components/Btn';
import FilterBtn from './Components/FilterBtn';
import Input from './Components/Input';
import PlusBtn from './Components/PlusBtn';
import MinusBtn from './Components/MinusBtn';
import Menu from './Components/Menu';
import Scroll from './Components/Scroll';
import Popup from './Components/Popup';
import Search from './Components/Search';

function App() {
  return (
    <div>
      <Btn />
      <FilterBtn />
      <Input />
      <PlusBtn />
      <MinusBtn />
      <Menu />
      <Scroll />
      <Popup />
      <Search />
    </div>
  );
}

export default App;
