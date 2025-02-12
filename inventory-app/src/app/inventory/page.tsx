"use client"
import React, { useState, useEffect } from 'react';
import axios from 'axios';

interface Product {
    code: string;
    name: string;
    company: string;
    attributes: string;
    price: number;
}

export default function InventoryPage() {
    const [items, setItems] = useState<Product[]>([]);


    useEffect(() => {
        axios.get('http://localhost:8083/api/product')
            .then(response => {
                console.log('Products:', response.data);
                setItems(response.data);
            })
            .catch(error => {
                console.error('Error fetching products:', error);
            });
    }, []);
    

    return (
        <div className="container mt-5">
            <div className="card shadow-lg rounded-lg p-4 mt-4">
                <div className="card-body">
                    <h2 className="card-title">Inventory List</h2>
                    <table className="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Name</th>
                                <th scope="col">Attributes</th>
                                <th scope="col">Company</th>
                                <th scope="col">Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            {items.map((item, index) => (
                                <tr key={index}>
                                    <th scope="row">{index + 1}</th>
                                    <td>{item.name}</td>
                                    <td>{item.attributes}</td>
                                    <td>{item.company}</td>
                                    <td>{item.price}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}