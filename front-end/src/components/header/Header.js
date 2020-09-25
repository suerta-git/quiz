import React from 'react';
import { NavLink } from 'react-router-dom';
import { HomeOutlined, ShoppingCartOutlined, PlusOutlined } from '@ant-design/icons';
import './Header.css';

const Header = () => (
  <header id="header">
    <ul>
      <li>
        <NavLink activeClassName="active-link" exact to="/">
          <HomeOutlined className="icon" />
          商城
        </NavLink>
      </li>
      <li>
        <NavLink activeClassName="active-link" to="/orders">
          <ShoppingCartOutlined className="icon" />
          订单
        </NavLink>
      </li>
      <li>
        <NavLink activeClassName="active-link" to="/add-product">
          <PlusOutlined className="icon" />
          添加商品
        </NavLink>
      </li>
    </ul>
  </header>
);

export default Header;
