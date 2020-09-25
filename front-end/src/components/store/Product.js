import React from 'react';

const Product = props => (
  <div id={props.product.name}>
    <img src={props.product.image} alt={props.product.name} />
    <h4>{props.product.name}</h4>
    <p>单位:{props.product.price}元/{props.product.unit}</p>
    <button>+</button>
  </div>
);

export default Product;
