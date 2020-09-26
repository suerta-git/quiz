import React from 'react';
import Order from './Order';
import './Orders.css';

export default class Orders extends React.Component {
  render() {
    return (
      <section className="page" id="orders">
        <table>
          <thead>
            <tr>
              <th>名字</th>
              <th>单价</th>
              <th>数量</th>
              <th>单位</th>
              <th>操作</th>
            </tr>
          </thead>
          <tbody>
            {this.props.orders.map(order => <Order order={order} key={order.name} handleDeleteOrder={this.props.handleDeleteOrder} />)}
          </tbody>
        </table>
      </section>
    );
  }
}

