import React from 'react';
import Product from './Product';

export default class Store extends React.Component {
  state = {
    products: []
  }

  componentDidMount = async () => {
    try {
      const response = await fetch('http://localhost:3000/product');
      const products = await response.json();
      this.setState({ 'products': products });
    } catch (error) {
      console.log(error);
    }
  }

  render() {
    return (
      <section id="store">
        {this.state.products.map(product => <Product product={product} key={product.name}/>)}
      </section>
    )
  }
};
