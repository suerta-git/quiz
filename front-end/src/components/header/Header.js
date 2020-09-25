import React from 'react';
import { NavLink } from 'react-router-dom';
import { HomeOutlined, ShoppingCartOutlined } from '@ant-design/icons';

const Header = () => (
  <header id="header">
    <ul>
      <li>
        <NavLink activeClassName="active-link" to="/">
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
          <span>+</span>
          添加商品
        </NavLink>
      </li>
    </ul>
  </header>
);

export default Header;
