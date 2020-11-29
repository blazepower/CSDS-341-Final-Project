import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className='App'>
      <h1>CSDS 341 Final Project</h1>
      <h2>Aman, Rishik, Lauren, Jack</h2>
      <div id='most-wins-afc' className='button-div'>
        <button>
          Find the team in the AFC division who has the best record
        </button>
      </div>
      <div id='team-best-kicker' className='button-div'>
        <button>
          Get name of team who has the kicker with most field goals made
        </button>
      </div>
      <div id='chargers-rbs' className='button-div'>
        <button>Find number of runningbacks on the Chargers</button>
      </div>
    </div>
  );
}

export default App;
