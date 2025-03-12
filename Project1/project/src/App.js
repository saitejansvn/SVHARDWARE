import React, { useState } from "react";
import { BrowserRouter as Router, Routes, Route, Navigate, useNavigate } from "react-router-dom";
import Login from "./UnamePwd/Login";
import CreateCustomer from "./customer/Create_customer";
import CreateOrder from "./Order/CreateOrder";
import Sidebar from "./sidebar_navbar/sidebar";
import Navbar from "./sidebar_navbar/navbar";
import Home from "./Home/Home";
import ChangePassword from "./UnamePwd/ChangePassword";
import SignUp from "./UnamePwd/SignUp";

function App(){

  
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const navigate = useNavigate();

    // Function to navigate to Create Customer
    const goToCreateCustomer = () => {
        navigate("/create-customer");
    };
  return (
    
      <div>
        <Navbar /> 
      <div style={{ display: "flex" }}>
        <Sidebar /> 
        {isLoggedIn && <Sidebar />}
        {/* Main Content Area */}
        <div style={{
          marginLeft: "10px",   
          width: "100%",
          overflow: "auto",
          marginTop: "60px",
          minHeight: "auto",   
          backgroundColor: "#f8f9fa", 
        }}>
          <Routes path="/">
            <Route index path="/login" element={<Login goToCreateCustomer={goToCreateCustomer} /> } />
            <Route path="/forgot-password" element={< ChangePassword/>}/>
            <Route path="/sign-up" element={< SignUp/>}/>
            <Route path="/home" element={<Home />} />
            <Route path="/create-customer" element={<CreateCustomer/>} />
            <Route path="/create-order" element={<CreateOrder />} />
            {/* Redirect to login if not logged in */}
            {!isLoggedIn && <Route path="*" element={<Navigate to="/login" />} />}
          </Routes>
        </div>
      </div>
      </div>
  );
}

export default App