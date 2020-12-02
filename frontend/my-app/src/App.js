import logo from './logo.svg';
import './App.css';
import React, { Component } from 'react';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      team: '',
      number: -1,
      name: '',
      string: '',
      teams: {},
    };
    this.recYdsTeam = this.recYdsTeam.bind(this);
  }
  recYdsTeam() {
    fetch(`http://localhost:8080/api/getAFCWinner`)
      .then((res) => res.text())
      .then((data) => {
        this.setState({ string: data });
      });
  }
  render() {
    return (
      <div className='App'>
        <h1 className='title'>CSDS 341 Final Project</h1>
        <h2 className='members'>Aman, Rishik, Lauren, Jack</h2>
        <div className='query-div'>
          <div className='button-div' id='afc-winner-div'>
            <button onClick={this.recYdsTeam}>Who won the AFC</button>
            <h1 className='afc-winner'>{this.state.string}</h1>
          </div>
          <div id='nfc-teams' className='button-div'>
            <button>Get the teamid for every team in NFC division</button>
          </div>
          <div id='most-wins-afc' className='button-div'>
            <button>
              Find the team in the AFC division who has the best record
            </button>
          </div>
          <div id='team-best-kicker' className='button-div'>
            <button>Get name of the kicker with most field goals made</button>
          </div>
          <div id='chargers-rbs' className='button-div'>
            <button>Find number of runningbacks on the Chargers</button>
          </div>
          <div className='button-div' id='johnsmith-qb'>
            <button>Is there a quarterback named John Smith</button>
            {/* <h2>No</h2> */}
          </div>
        </div>
      </div>
    );
  }
}

export default App;
