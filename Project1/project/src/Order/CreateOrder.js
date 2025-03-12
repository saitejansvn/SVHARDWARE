import React, { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

function CreateOrder(){

    
    const [error, setError] = useState("");

    const [customername, setcustomername] = useState("");
    const [operationtype, setoperationtype] = useState("");
    const [servicefor, setservicefor] = useState("");
    const [laptopmaker, setlaptopmaker] = useState("");
    const [servicetype, setservicetype] = useState("");
    const [totalamount, settotalamount] = useState("");
    const [advanceamount, setadvanceamount] = useState("");
    const [balanceamount, setbalanceamount] = useState("");
    const [paymentmode, setpaymentmode] = useState("");

    function check(){
        if (!customername || !operationtype || !servicefor || !laptopmaker || !servicetype || !totalamount || !advanceamount || !balanceamount || !paymentmode) {
            setError("All fields are required!");
            return;
          }
          else
          setError("");
          alert("Order created!");
          handleReset();
      }
      useEffect(() => {
        const total = parseFloat(totalamount) || 0;
        const advance = parseFloat(advanceamount) || 0;
        setbalanceamount(total - advance);
    }, [totalamount, advanceamount]);

    function handleCreateOrder(event){
        event.preventDefault();
        check();
    }

    function handleReset(){
        setcustomername("");
        setoperationtype("");
        setservicefor("");
        setlaptopmaker("");
        setservicetype("");
        settotalamount("");
        setadvanceamount("");
        setbalanceamount("");
    }

    const styles={
        card: { width: "600px",  background: "linear-gradient(to right, rgb(142, 144, 170), rgb(8, 13, 119)", boxShadow: "0px 10px 20px 2px rgb(106, 117, 106)"},
        
        select: {height: "40px", width: "243px"},
        button: {height: "40px"}
      };

    return(
        <div className="bg-primary-subtle">
        {/*Nav bar */}
        
        <div className="container vh-100 d-flex justify-content-center align-items-center ">
           <div className="card p-4" style={ styles.card}>
                <h2 className="text-center mb-4 text-white">Create Order</h2>
                <form onSubmit={handleCreateOrder}>
                
                <div class="row">
                    {/*Customer name*/}
                    <div className="col">
                        <label className="form-label text-white">Customer Name</label>
                        <select 
                            className="form-select-sm mb-3" 
                            style={styles.select} 
                            aria-label="Large select example"
                            value={customername} 
                            onChange={(e) => setcustomername(e.target.value)} >
                            <option value="">Select customer name</option>
                            <option value="Hari">Hari</option>
                            <option value="Priya">Priya</option>
                        </select>
                    </div>

                    {/*Secondary Email*/}
                    <div class="col">
                    <label className="form-label text-white">Operation Type</label>
                    <br/>
                    <select class="form-select-sm mb-3" style={styles.select} aria-label="Large select example" 
                    value={operationtype} 
                    onChange={(e) => setoperationtype(e.target.value)} >
                        <option value="">select operation Type</option>
                        <option value="sales">Sales</option>
                        <option value="service">Service</option>
                    </select>
                    </div>
                </div>

                <div class="row">
                     {/*Service for*/}
                    <div class="col">
                    <label className="form-label text-white">Service for</label>
                    <select class="form-select-sm mb-3" style={styles.select} aria-label="Large select example" 
                    value={servicefor} 
                    onChange={(e) => setservicefor(e.target.value)} >
                        <option value="">select service for</option>
                        <option value="operatingystem">Operating System</option>
                        <option value="hardware">Hardware</option>
                        <option value="desktop">Desktop</option>
                        <option value="laptop">Laptop</option>
                    </select>
                    </div>

                     {/*Laptop maker*/}
                    <div class="col">
                    <label className="form-label text-white">Laptop maker</label>
                    <select class="form-select-sm mb-3" style={styles.select} aria-label="Large select example"  
                    value={laptopmaker} 
                    onChange={(e) => setlaptopmaker(e.target.value)}>
                        <option value="">select laptop maker</option>
                        <option value="apple">apple</option>
                        <option value="lenovo">Lenovo</option>
                        <option value="dell">Dell</option>
                        <option value="hp">hp</option>
                        <option value="acer">acer</option>
                    </select>
                    </div>
                </div>
                
                <div class="row">
                     {/*Service type*/}
                    <div class="col">
                    <label className="form-label text-white">Service type</label>
                    <select class="form-select-sm mb-3" 
                    style={styles.select} 
                    aria-label="Large select example" 
                    value={servicetype} 
                    onChange={(e) => setservicetype(e.target.value)}>
                        <option value="">select service type</option>
                        <option value="keyboard">Keyboard problem</option>
                        <option value="screen">Screen problem</option>
                        <option value="battery">Battery problem</option>
                        <option value="camera">Camera problem</option>
                        <option value="speaker">Speaker problem</option>
                    </select>
                    </div>
                     {/*Total Amount*/}
                    <div class="col"> 
                    <label className="form-label text-white">Total Amount</label>
                    <input 
                        type="number" 
                        className="form-control fst-italic" 
                        style={{width:"250px"}}
                        value={totalamount} 
                        onChange={(e) => {
                            settotalamount(e.target.value);
                          }}
                        required
                    />
                    </div>
                </div>

                <div class="row">
                     {/*Advance Amount*/}
                    <div class="col">
                    <label className="form-label text-white">Advance Amount</label>
                    <input 
                        type="number" 
                        className="form-control fst-italic" 
                        style={{width:"250px"}}
                        value={advanceamount} 
                        onChange={(e) => {
                            setadvanceamount(e.target.value);
                          }} 
                        required
                    />
                    </div>
                     {/*Balance Amount*/}
                    <div class="col">
                    <label className="form-label text-white" >Balance Amount</label>
                    <input 
                            type="number" 
                            className="form-control fst-italic" 
                            style={{width:"250px"}}
                            value={balanceamount} 
                            readOnly
                            />
                    </div>
                </div>
               
                    <div class="row">
                        {/*Payment mode*/}
                    <div class="col">
                    <label className="form-label mt-3 text-white">Payment Mode</label><br/>
                    <select class="form-select-sm mb-3" style={styles.select} aria-label="Large select example"  
                    value={paymentmode} 
                    onChange={(e) => setpaymentmode(e.target.value)}>
                        <option value="">select payment mode</option>
                        <option value="cash">Cash</option>
                        <option value="upi">UPI</option>
                        <option value="instrument">Instrument</option>
                    </select>
                    
                    </div>  
                    
                    </div>

                    {error && <p className="text-danger fs-5 fw-bolder">{error}</p>}   
                    <div class="col" className="d-flex justify-content-center" style={styles.button}>
                        <button class="btn btn-primary me-md-2" type="button" onClick={check}>Create</button>
                        <button class="btn btn-primary" type="button" onClick={handleReset}>Cancel</button>
                    </div>            
                </form>
           </div>
        </div>
     </div>
    );
}
export default CreateOrder