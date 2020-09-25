import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Store from './components/store/Store';
import Orders from './components/order/Orders';
import './App.css';

export default class App extends React.Component {
  state = {
    orders: []
  }
  render() {
    return (
      <div className="App">
        <Router>
          <Route exact path="/" children={<Store handleAddCart={this.handleAddCart} />} />
          <Route path="/orders" children={<Orders orders={this.state.orders} />} />
        </Router>

        <p>TW Mall @2018 Created by ForCheng</p>
      </div>
    );
  }

  handleAddCart = product => {
    const orders = this.state.orders.concat();
    const name = product.name;
    let index = -1;
    orders.forEach((order, i) => {
      if (order.name === name) {
        index = i;
      }
    });
    if (index !== -1) {
      orders[index].amout++;
    } else {
      orders.push({
        name: product.name,
        price: product.price,
        amout: 1,
        unit: product.unit
      });
    }
    this.setState({
      orders: orders
    });
  }
}

