import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";

const Home = () => {

    const styles={
        card: { width: "600px",  background: "linear-gradient(to right, rgb(142, 144, 170), rgb(8, 13, 119)", boxShadow: "0px 10px 20px 2px rgb(106, 117, 106)"},
    }
     
    return(
        <div className="bg-primary-subtle" >
            <div className="container vh-100 d-flex justify-content-center align-items-center">
                <div className="card p-4 " style={ styles.card}>
                    <h2 className="text-center mb-4 text-white" >Welcome to SV Infotech!</h2>
                </div>
            </div>
        </div>
    );
}

export default Home