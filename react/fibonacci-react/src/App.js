import React, { Component } from "react";
import { Label } from "reactstrap";
import FibonacciForm from "./FibonacciForm";
import FibonacciHeader from "./FibonacciHeader";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      series: [],
      sorted: [],
    };
  }

  updateValues(seq, sort) {
    this.setState({ series: seq, sorted: sort });
  }

  render() {
    const seqItems = this.state.series.map((seq) => <li>{seq}</li>);
    const seqSortedItems = this.state.sorted.map((seqSort) => (
      <li>{seqSort}</li>
    ));
    return (
      <div className="App Container">
        <FibonacciHeader />
        <div>
          <FibonacciForm
            data={{
              series: this.state.series,
              sorted: this.state.sorted,
              updateValues: this.updateValues.bind(this),
            }}
          />
        </div>
        <div>
          <div>
            <Label>Fibonacci Sequence: </Label>
            <p>
              <ul>{seqItems}</ul>
            </p>
            <Label>Sorted Series:</Label>
            <p>
              <ul>{seqSortedItems}</ul>
            </p>
          </div>
        </div>
      </div>
    );
  }
}

export default App;
