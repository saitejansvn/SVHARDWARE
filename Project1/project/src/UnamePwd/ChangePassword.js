import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { useNavigate } from "react-router-dom";

function ChangePassword({onBack}){

    const [email, setEmail] = useState("");
    const [newPassword, setNewPassword] = useState("");
    const [confirmNewPassword, setConfirmNewPassword] = useState("");
    const navigate = useNavigate();


    function handleChangePassword(event){
        event.preventDefault();
        if (newPassword !== confirmNewPassword) {
        alert("Passwords do not match!");
        return;
        }
        alert("Password changed successfully!");
        onBack();
    }

    function onBack(){
        navigate("/login")

    }
    const styles={
        card: { width: "400px",  background: "linear-gradient(to right, rgb(142, 144, 170), rgb(8, 13, 119)", boxShadow: "0px 10px 20px 2px rgb(106, 117, 106)"},
        navbar: {backgroundColor: "rgb(3, 5, 54)"}
    };

    return(
        <div className="bg-primary-subtle">
           
            <div className="container vh-100 d-flex justify-content-center align-items-center">
            <div className="card p-4" style={ styles.card}>
                <h2 className="text-center mb-4 text-white">Change Password</h2>
                <form onSubmit={handleChangePassword}>

                    <div className="mb-3">
                        <label className="form-label text-white">Email</label>
                        <input 
                            type="Email" 
                            className="form-control fst-italic" 
                            value={email} 
                            onChange={(e) => setEmail(e.target.value)} 
                            required
                        />
                    </div>
            
                    <div className="mb-3">
                        <label className="form-label text-white">New Password</label>
                        <input 
                            type="Password" 
                            className="form-control fst-italic" 
                            value={newPassword} 
                            onChange={(e) => setNewPassword(e.target.value)} 
                            required
                        />
                    </div>
            
                    <div className="mb-3">
                        <label className="form-label text-white">Confirm Password</label>
                        <input 
                            type="Confirm Password" 
                            className="form-control fst-italic" 
                            value={confirmNewPassword} 
                            onChange={(e) => setConfirmNewPassword(e.target.value)} 
                            required
                        />
                    </div>

                    {/* Change password button  */}

                    <button type="submit" className="btn btn-primary w-50 d-grid mx-auto" >Change Password</button>
                    
                    
                </form>
            </div>
            </div>
        </div>
    );
}

export default ChangePassword