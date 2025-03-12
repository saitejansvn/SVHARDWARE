import React from "react";
import { Link, useLocation } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

const Sidebar = () => {

  const location = useLocation();

  if (["/login", "/forgot-password", "/sign-up"].includes(location.pathname)) {
    return null;
}
  return (
    <div
      style={{
        width: "200px",
        height: "100vh",
        marginTop: "60px",
        backgroundColor: "rgb(13, 21, 144)",
        color: "white",
        paddingTop: "20px",
        position: "fixed",
      }}
    >
     
      <ul className="nav flex-column">
        <li className="nav-item">
          <Link className="nav-link text-white" to="/login">
            Login
          </Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link text-white" to="/create-customer">
            Create Customer
          </Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link text-white" to="/create-order">
            Create Order
          </Link>
        </li>
      </ul>
    </div>
  );
};

export default Sidebar;
