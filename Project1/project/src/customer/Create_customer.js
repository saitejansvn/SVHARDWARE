import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { useNavigate } from "react-router-dom";
import Select from 'react-select';
import axios from 'axios';

function CreateCustomer({ onCreateOrder }) {
    const navigate = useNavigate();
    const [validated, setValidated] = useState(false);
    const [primaryEmailError, setPrimaryEmailError] = useState("");
    const [secondaryEmailError, setSecondaryEmailError] = useState("");
    const [error, setError] = useState("");

    const [surtname, setSurname] = useState("");
    const [firstname, setFirstname] = useState("");
    const [middlename, setMiddlename] = useState("");
    const [lastname, setLastname] = useState("");
    const [primarycontact, setPrimaryContact] = useState("");
    const [secondarycontact, setSecondaryContact] = useState("");
    const [primaryEmail, setPrimaryEmail] = useState("");
    const [secondaryEmail, setSecondaryEmail] = useState("");
    const [customerexists, setCustomerExists] = useState("");

    const options = [
        { value: 'yes', label: 'Yes' },
        { value: 'no', label: 'No' }
    ];

    const validatePrimaryEmail = (value) => {
        if (!value) {
            setPrimaryEmailError("Primary Email is required");
        } else if (!/\S+@\S+\.\S+/.test(value)) {
            setPrimaryEmailError("Invalid email format");
        } else {
            setPrimaryEmailError("");
        }
    };

    const validateSecondaryEmail = (value) => {
        if (!value) {
            setSecondaryEmailError("Secondary Email is required");
        } else if (!/\S+@\S+\.\S+/.test(value)) {
            setSecondaryEmailError("Invalid email format");
        } else {
            setSecondaryEmailError("");
        }
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        
        validatePrimaryEmail(primaryEmail);
        validateSecondaryEmail(secondaryEmail);

        if (!surtname || !firstname || !lastname || !primarycontact || !secondarycontact || !primaryEmail || !secondaryEmail) {
            setError("All fields are required!");
            return;
        }

        if (primaryEmailError || secondaryEmailError) {
            return; // Stop submission if there are validation errors
        }

        setError("");

        // Create a customer object
        const customerData = {
            surname: surtname,
            firstName: firstname,
            middleName: middlename,
            lastName: lastname,
            primaryContact: +primarycontact,
            secondaryContact: +secondarycontact,
            primaryEmail: primaryEmail,
            secondaryEmail: secondaryEmail,
            customerExists: customerexists
        };
        console.log(customerData);

        try {
            const response = await axios.post('http://localhost:9887/customer/saveCustomer', customerData, {
                headers: {
                  'Content-Type': 'application/json',
                  // Add any other headers if necessary
                },
              });
            alert("Customer created successfully!");
            console.log("Response:", response.data);
            handleReset();
        } catch (error) {
            console.error("Error creating customer:", error);
            setError("Failed to create customer. Please try again.");
        }
    };

    const handleReset = () => {
        setSurname("");
        setFirstname("");
        setMiddlename("");
        setLastname("");
        setPrimaryContact("");
        setSecondaryContact("");
        setPrimaryEmail("");
        setSecondaryEmail("");
        setCustomerExists("");
        setError("");
    };

    return (
        <div className="bg-primary-subtle">
            <div className="container vh-100 d-flex justify-content-center align-items-center">
                <div className="card p-4" style={{ width: "600px", background: "linear-gradient(to right, rgb(142, 144, 170), rgb(8, 13, 119)", boxShadow: "0px 10px 20px 2px rgb(106, 117, 106)" }}>
                    <h2 className="text-center mb-4 text-white">Create Customer</h2>
                    <form onSubmit={handleSubmit} noValidate className={validated ? "was-validated" : ""}>

                        <div className="col">
                            <label className="form-label text-white">Is customer exists</label>
                            <Select options={options} onChange={(option) => setCustomerExists(option.value)} />
                        </div>

                        <div className="row">
                            <div className="col">
                                <label className="form-label text-white">Sur name</label>
                                <input type="text" className="form-control fst-italic" value={surtname} onChange={(e) => setSurname(e.target.value)} required />
                            </div>
                            <div className="col">
                                <label className="form-label text-white">First name</label>
                                <input type="text" className="form-control fst-italic" value={firstname} onChange={(e) => setFirstname(e.target.value)} required />
                            </div>
                        </div>

                        <div className="row">
                            <div className="col">
                                <label className="form-label text-white">Middle name</label>
                                <input type="text" className="form-control fst-italic" value={middlename} onChange={(e) => setMiddlename(e.target.value)} required />
                            </div>
                            <div className="col">
                                <label className="form-label text-white">Last name</label>
                                <input type="text" className="form-control fst-italic" value={lastname} onChange={(e) => setLastname(e.target.value)} required />
                            </div>
                        </div>

                        <div className="row">
                            <div className="col">
                                <label className="form-label text-white">Primary Contact</label>
                                <input type="text" className="form-control fst-italic" value={primarycontact} onChange={(e) => setPrimaryContact(e.target.value)} required />
                            </div>
                            <div className="col">
                                <label className="form-label text-white">Secondary Contact</label>
                                <input type="text" className="form-control fst-italic" value={secondarycontact} onChange={(e) => setSecondaryContact(e.target.value)} required />
                            </div>
                        </div>

                        <div className="row">
                            <div className="col">
                                <label className="form-label text-white">Primary Email</label>
                                <input type="email" className={`form-control ${primaryEmailError ? "is-invalid" : ""}`} value={primaryEmail} onChange={(e) => setPrimaryEmail(e.target.value)} required />
                                {primaryEmailError && <div className="invalid-feedback">{primaryEmailError}</div>}
                            </div>
                            <div className="col">
                                <label className="form-label text-white">Secondary Email</label>
                                <input type="email" className={`form-control ${secondaryEmailError ? "is-invalid" : ""}`} value={secondaryEmail} onChange={(e) => setSecondaryEmail(e.target.value)} required />
                                {secondaryEmailError && <div className="invalid-feedback">{secondaryEmailError}</div>}
                            </div>
                        </div>

                        {error && <p className="text-danger fs-6 fw-bolder">{error}</p>}

                        <div className="text-center mt-3">
                            <button type="submit" className="btn btn-primary w-50 d-grid mx-auto">Create</button>
                            <button type="button" className="btn btn-secondary w-50 d-grid mx-auto mt-3" onClick={handleReset}>Cancel</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    );
}

export default CreateCustomer;
