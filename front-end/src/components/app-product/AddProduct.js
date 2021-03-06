import React from 'react';
import { Modal, Input } from 'antd';

export default class AddProduct extends React.Component {
  state = {
    "add-name": "",
    "add-price": "",
    "add-unit": "",
    "add-image": "",
    message: "",
  };

  render() {
    return (
      <section className="page" id="add-product">
        <h2>添加商品</h2>
        <form>
          <label htmlFor="add-name">
            <span>*</span>名称:
          </label>
          <Input
            type="text"
            id="add-name"
            name="add-name"
            placeholder="名称"
            value={this.state["add-name"]}
            onChange={this.handleChange}
          />
          <label htmlFor="add-price">
            <span>*</span>价格:
          </label>
          <Input
            type="number"
            min="1"
            id="add-price"
            name="add-price"
            placeholder="价格"
            value={this.state["add-price"]}
            onChange={this.handleChange}
          />
          <label htmlFor="add-unit">
            <span>*</span>单位:
          </label>
          <Input
            type="text"
            id="add-unit"
            name="add-unit"
            placeholder="单位"
            value={this.state["add-unit"]}
            onChange={this.handleChange}
          />
          <label htmlFor="add-image">
            <span>*</span>图片:
          </label>
          <Input
            type="text"
            id="add-image"
            name="add-image"
            placeholder="URL"
            value={this.state["add-image"]}
            onChange={this.handleChange}
          />
          <button
            type="button"
            disabled={!this.isValid()}
            onClick={this.handleSubmit}
          >
            提交
          </button>
        </form>
        <h3 id="add-product-message">{this.state.message}</h3>
      </section>
    );
  }

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value,
    });
  };

  isValid = () => {
    return (
      this.state["add-name"].length > 0 &&
      this.state["add-price"].length > 0 &&
      !Number.isNaN(Number(this.state["add-price"])) &&
      this.state["add-unit"].length > 0 &&
      this.state["add-image"].length > 0
    );
  };

  handleSubmit = async () => {
    const product = {
      name: this.state["add-name"],
      price: Number(this.state["add-price"]),
      unit: this.state["add-unit"],
      image: this.state["add-image"],
    };
    this.clear();

    try {
      this.message("正在创建商品……", true);
      const response = await fetch("http://localhost:8080/product", {
        method: "POST",
        mode: "cors",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(product),
      });
      if (response.status !== 201) {
        throw new Error();
      }
      this.message("商品创建成功！");
    } catch (ignore) {
      this.message("商品创建失败！");
    }
  };

  message = (info, isPermanent = false) => {
    this.setState({
      message: info,
    });
    if (!isPermanent) {
      setTimeout(() => this.setState({ message: "" }), 3000);
    }
  };

  clear = () => {
    this.setState({
      "add-name": "",
      "add-price": "",
      "add-unit": "",
      "add-image": "",
    });
  };
}
