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
    };
    this.recYdsTeam = this.recYdsTeam.bind(this);
  }
  recYdsTeam() {
    fetch(`https://randomuser.me/api`)
      .then((res) => res.json())
      .then((data) => {
        this.setState({
          string: data.results[0].email,
        });
      });
  }
  render() {
    return (
      <div className='App'>
        <h1 className='title'>CSDS 341 Final Project</h1>
        <h2 className='members'>Aman, Rishik, Lauren, Jack</h2>
        <div className='query-div'>
          <div className='button-div' id='recyds-team'>
            <button onClick={this.recYdsTeam}>
              Get the teamid and average of values for the "receiving yards"
              stat for each team in the NFC division
            </button>
            <h1>{this.state.string}</h1>
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
          </div>
        </div>
      </div>
    );
  }
}

export default App;
