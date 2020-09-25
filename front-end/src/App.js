import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Store from './components/store/Store';
import './App.css';

function App() {
  return (
    <div className="App">
      <Router>
        <Route exact path="/" component={Store} />
      </Router>
    </div>
  );
}

export default App;
