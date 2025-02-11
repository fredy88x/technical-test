import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

export default function companyPage (){
    return (
        <div className="card shadow-lg rounded-lg p-4">
        <div className="card-body">
            <form>
                <div className="row">
                    <div className="col-md-6 mb-3">
                        <label htmlFor="nitInput" className="form-label">Nit</label>
                        <input type="text" className="form-control" id="nitInput" placeholder="Enter Nit" />
                    </div>
                    <div className="col-md-6 mb-3">
                        <label htmlFor="nameInput" className="form-label">Name</label>
                        <input type="text" className="form-control" id="nameInput" placeholder="Enter Name" />
                    </div>
                </div>
                <div className="row">
                    <div className="col-md-6 mb-3">
                        <label htmlFor="addressInput" className="form-label">Address</label>
                        <input type="text" className="form-control" id="addressInput" placeholder="Enter Address" />
                    </div>
                    <div className="col-md-6 mb-3">
                        <label htmlFor="phoneInput" className="form-label">Phone Number</label>
                        <input type="text" className="form-control" id="phoneInput" placeholder="Enter Phone Number" />
                    </div>
                </div>
                <div className="text-end mt-4">
                    <button type="submit" className="btn btn-success">Save</button>
                </div>
            </form>
        </div>
    </div>
    );
}