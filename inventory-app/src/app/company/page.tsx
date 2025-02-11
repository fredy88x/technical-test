"use client"
import React, { useState } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

interface Company {
    nit: string;
    name: string;
    address: string;
    phone_number: string;
}

export default function CompanyPage (){
    const [company, setCompany] = useState<Company>({
        nit: '',
        name: '',
        address: '',
        phone_number: ''
    });
    const [alert, setAlert] = useState<string | null>(null);

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { id, value } = e.target;
        setCompany({ ...company, [id]: value });
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/company', company);
            console.log('Company saved:', response.data);
            setAlert('Company saved successfully!');
            setCompany({
                nit: '',
                name: '',
                address: '',
                phone_number: ''
            });
        } catch (error) {
            console.error('Error saving company:', error);
            setAlert('Error saving company: ');
        }
    };
    return (
        <div className="card shadow-lg rounded-lg p-4">
        <div className="card-body">
            {alert && <div className={`alert ${alert.includes('Error') ? 'alert-danger' : 'alert-success'}`} role="alert">{alert}</div>}
            <form onSubmit={handleSubmit}>
                <div className="row">
                    <div className="col-md-6 mb-3">
                        <label htmlFor="nit" className="form-label">Nit</label>
                        <input type="text" className="form-control" id="nit" placeholder="Enter Nit" onChange={handleChange} value={company.nit}/>
                    </div>
                    <div className="col-md-6 mb-3">
                        <label htmlFor="name" className="form-label">Name</label>
                        <input type="text" className="form-control" id="name" placeholder="Enter Name" onChange={handleChange} value={company.name}/>
                    </div>
                </div>
                <div className="row">
                    <div className="col-md-6 mb-3">
                        <label htmlFor="address" className="form-label">Address</label>
                        <input type="text" className="form-control" id="address" placeholder="Enter Address" onChange={handleChange} value={company.address}/>
                    </div>
                    <div className="col-md-6 mb-3">
                        <label htmlFor="phone_number" className="form-label">Phone Number</label>
                        <input type="text" className="form-control" id="phone_number" placeholder="Enter Phone Number" onChange={handleChange} value={company.phone_number}/>
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