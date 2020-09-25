import React from 'react';
import Product from './Product';
import './Store.css';

export default class Store extends React.Component {
  state = {
    products: [],
  }

  componentDidMount = async () => {
    try {
      const response = await fetch('http://localhost:8080/product');
      const products = await response.json();
      this.setState({ 'products': products });
    } catch (error) {
      console.log(error);
    }
  }

  render() {
    return (
      <section className="page" id="store">
        {this.state.products.map(product => <Product product={product} handleAddCart={this.props.handleAddCart} key={product.name}/>)}
      </section>
    )
  }
};
