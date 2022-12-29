import React, { useState, useRef } from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { palette } from 'styled-tools';
import theme from '../Components/Color';
import SearchIcon from '../Image/SearchIcon.png';

const Form = styled.form`
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
  background-color: ${palette('PsCocoa', 0)};
  background-image: url(${SearchIcon});
  background-size: 1rem;
  background-repeat: no-repeat;
  background-position: center;
  width: ${(props) => (props.barOpened ? '10rem' : '1rem')};
  cursor: ${(props) => (props.barOpened ? 'auto' : 'pointer')};
  padding: 1rem;
  height: 1rem;
  border-radius: 10rem;
  transition: width 300ms cubic-bezier(0.645, 0.045, 0.355, 1);
`;

const Input = styled.input`
  font-size: 10pt;
  line-height: 1;
  background-color: ${palette('PsCocoa', 0)};
  width: 100%;
  margin-left: ${(props) => (props.barOpened ? '1rem' : '0rem')};
  border: none;
`;

const SearchBtn = styled.button`
  line-height: 1;
  pointer-events: ${(props) => (props.barOpened ? 'auto' : 'none')};
  cursor: ${(props) => (props.barOpened ? 'pointer' : 'none')};
  background-color: transparent;
  border: none;
  outline: none;
  color: white;
`;
export default function Search() {
  const [input, setInput] = useState('');
  const [barOpened, setBarOpened] = useState(false);
  const formRef = useRef();
  const inputFocus = useRef();

  const onFormSubmit = (e) => {
    e.preventDefault();
    setInput('');
    setBarOpened(false);
  };

  return (
    <div>
      <ThemeProvider theme={theme}>
        <Form
          barOpened={barOpened}
          onClick={() => {
            setBarOpened(true);
            inputFocus.current.focus();
          }}
          onFocus={() => {
            setBarOpened(true);
            inputFocus.current.focus();
          }}
          onBlur={() => {
            setBarOpened(false);
          }}
          onSubmit={onFormSubmit}
          ref={formRef}
        >
          <SearchBtn type='submit' barOpened={barOpened} />
          <Input
            onChange={(e) => setInput(e.target.value)}
            ref={inputFocus}
            value={input}
            barOpened={barOpened}
            placeholder='search for ...'
          />
        </Form>
      </ThemeProvider>
    </div>
  );
}
