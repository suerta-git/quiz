import React from 'react';

const Order = props => (
  <tr>
    <td>{props.order.name}</td>
    <td>{props.order.price}</td>
    <td>{props.order.amout}</td>
    <td>{props.order.unit}</td>
    <td><button>删除</button></td>
  </tr>
);

export default Order;
