import React, { Component } from "react";
import axios from "axios";
import { Form, Label } from "reactstrap";

export default class FibonacciForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      value: 1,
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({ value: event.target.value });
  }
  handleSubmit(event) {
    event.preventDefault();
    const elements = this.state.value;

    axios.post("http://localhost:8080/fibonacci", { elements }).then(
      (response) => {
        this.props.data.updateValues(
          response.data.fibonacci,
          response.data.sorted
        );
        console.log(response);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  render() {
    return (
      <Form onSubmit={this.handleSubmit}>
        <div>
          <span>
            <table>
              <tr>
                <td></td>
              </tr>
              <tr>
                <td></td>
              </tr>
              <tr>
                <td>
                  <Label className="mr-5">No. Elements:</Label>
                  <input
                    name="elements"
                    type="number"
                    min={1}
                    max={100}
                    value={this.state.value}
                    onChange={this.handleChange}
                    className="mr-5"
                  ></input>
                  <input color="green" type="submit" value="Submit" />
                </td>
              </tr>
            </table>
          </span>
        </div>
      </Form>
    );
  }
}
