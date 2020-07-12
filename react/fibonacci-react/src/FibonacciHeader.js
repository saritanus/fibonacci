import React, { Component } from "react";
import { Card, CardHeader, CardText } from "reactstrap";

export default class FibonacciHeader extends React.Component {
  render() {
    return (
      <div>
        <Card body inverse color="primary">
          <CardHeader className="text-center">FIBONACCI APPLICATION</CardHeader>
          <CardText className="text-center">
            This application will generate fibonacci series for an input which
            has range from 1 - 100.
          </CardText>
        </Card>
      </div>
    );
  }
}
