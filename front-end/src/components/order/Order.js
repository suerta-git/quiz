import React from 'react';

const Order = props => (
  <tr>
    <td>{props.order.name}</td>
    <td>{props.order.price.toFixed(2)}</td>
    <td>{props.order.amout}</td>
    <td>{props.order.unit}</td>
    <td><button onClick={() => {props.handleDeleteOrder(props.order);}}>删除</button></td>
  </tr>
);

export default Order;
