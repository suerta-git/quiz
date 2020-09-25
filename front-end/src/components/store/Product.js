import React from 'react';

const Product = props => (
  <div id={props.product.name} className="product">
    <img src={props.product.image} alt={props.product.name} />
    <h4>{props.product.name}</h4>
    <p>单位:{props.product.price.toFixed(2)}元/{props.product.unit}</p>
    <button>+</button>
  </div>
);

export default Product;
