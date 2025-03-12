import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { useNavigate } from "react-router-dom";

function SignUp({onBack}){
    const [validated, setValidated] = useState(false);
    const [emailError, setEmailError] = useState("");
    const [passwordError, setPasswordError] = useState("");
    const [error, setError] = useState("");
    const navigate = useNavigate();

    const [Name, setName] = useState("");
    const [phone, setphone] = useState("");
    const [email, setEmail] = useState("");
    const [newPassword, setNewPassword] = useState("");
    const [confirmNewPassword, setConfirmNewPassword] = useState("");

    const validateEmail = (value) => {
        if (!value) {
          setEmailError("Email is required");
        } else if (!/\S+@\S+\.\S+/.test(value)) {
          setEmailError("Invalid email format");
        } else {
          setEmailError("");
        }
      };
    
      const validatePassword = (value) => {
        if (!value) {
          setPasswordError("Password is required");
        } else if (value.length < 6) {
          setPasswordError("Password must be at least 6 characters");
        } else {
          setPasswordError("");
        }
      };
    
    function handleSignUp(event) {
        event.preventDefault();
        validateEmail(email);
        validatePassword(newPassword);
        if (newPassword !== confirmNewPassword) {
          alert("Passwords do not match!");
          return;
        }
        if (!Name || !email || !phone || !newPassword || !confirmNewPassword) {
          setError("All fields are required!");
          return;
        }
        setError(""); // Clear error
        alert("Form submitted successfully!");
        onBack();
        }

        function onBack(){
          navigate("/login")
        }
    const styles={
        card: { width: "400px",  background: "linear-gradient(to right, rgb(142, 144, 170), rgb(8, 13, 119)", boxShadow: "0px 10px 20px 2px rgb(106, 117, 106)"},
        
    };
    return(
        <div className="bg-primary-subtle">
            {/*Nav bar */}
        
            <div className="container vh-100 d-flex justify-content-center align-items-center" style={styles.page}>
                <div className="card p-4 " style={ styles.card}>
                    <h2 className="text-center mb-4 text-white">Sign Up</h2>
                    <form onSubmit={handleSignUp} noValidate className={validated ? "was-validated" : ""}>

                    <div className="mb-3">
                        <label className="form-label text-white">Name:</label>
                        <input 
                        type="name" 
                        className="form-control fst-italic" 
                        value={Name} 
                        onChange={(e) => setName(e.target.value)} 
                        required 
                        />
                    
                    </div>

                    <div className="mb-3">
                        <label className="form-label text-white"> Phone</label>
                        <input 
                        type="phone" 
                        className="form-control fst-italic" 
                        value={phone} 
                        onChange={(e) => setphone(e.target.value)} 
                        required
                        />
                    </div>

                    <div className="mb-3">
                        <label className="form-label text-white">Email</label>
                        <input 
                            type="Email" 
                            className={`form-control ${emailError ? "is-invalid" : ""}`} 
                            id="email" 
                            value={email}
                            onChange={(e) => {
                            setEmail(e.target.value);
                            validateEmail(e.target.value);
                            }}
                            />
                        {emailError && <div className="invalid-feedback">{emailError}</div>}
                        </div>
            
                    <div className="mb-3">
                        <label className="form-label text-white">Password</label>
                        <input 
                            type="Password" 
                            className={`form-control ${passwordError ? "is-invalid" : ""}`} 
                            id="password" 
                            value={newPassword}
                            onChange={(e) => {
                            setNewPassword(e.target.value);
                            validatePassword(e.target.value);
                            }}
                            />
                            {passwordError && <div className="invalid-feedback">{passwordError}</div>}
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

                    {error && <p className="text-danger fs-5 fw-bolder ">{error}</p>}

                     {/* SignUp Button */}

                    <button type="submit" className="btn btn-primary w-50 d-grid mx-auto" >Sign Up</button>
                    
                    {/* Login Button */}

                    <button className="btn btn-link d-grid w-100 mx-auto text-white"  onClick={onBack}>login</button>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default SignUp