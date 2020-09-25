import React from 'react';
import Product from './Product';

export default class Store extends React.Component {
  state = {
    goods: []
  }

  componentDidMount = async () => {
    try {
      const response = await fetch('http://localhost:3000/goods');
      const goods = await response.json();
      this.setState({ 'goods': goods });
    } catch (error) {
      console.log(error);
    }
  }

  render() {
    return (
      <section id="store">
        {this.state.goods.map(product => <Product product={product} key={product.name}/>)}
      </section>
    )
  }
};
