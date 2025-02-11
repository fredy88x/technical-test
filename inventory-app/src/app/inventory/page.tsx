"use client"
import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

export default function InventoryPage() {
    const [items, setItems] = useState<{ name: string; quantity: string; price: string; }[]>([]);
    const [newItem, setNewItem] = useState({ name: '', quantity: '', price: '' });

    const handleInputChange = (e: { target: { id: any; value: any; }; }) => {
        const { id, value } = e.target;
        setNewItem({ ...newItem, [id]: value });
    };

    const handleAddItem = (e: { preventDefault: () => void; }) => {
        e.preventDefault();
        setItems([...items, newItem]);
        setNewItem({ name: '', quantity: '', price: '' });
    };

    return (
        <div className="container mt-5">
            <div className="card shadow-lg rounded-lg p-4">
                <div className="card-body">
                    <h2 className="card-title">Inventory Control</h2>
                    <form onSubmit={handleAddItem}>
                        <div className="row">
                            <div className="col-md-4 mb-3">
                                <label htmlFor="name" className="form-label">Item Name</label>
                                <input type="text" className="form-control" id="name" value={newItem.name} onChange={handleInputChange} placeholder="Enter item name" />
                            </div>
                            <div className="col-md-4 mb-3">
                                <label htmlFor="quantity" className="form-label">Quantity</label>
                                <input type="number" className="form-control" id="quantity" value={newItem.quantity} onChange={handleInputChange} placeholder="Enter quantity" />
                            </div>
                            <div className="col-md-4 mb-3">
                                <label htmlFor="price" className="form-label">Price</label>
                                <input type="number" className="form-control" id="price" value={newItem.price} onChange={handleInputChange} placeholder="Enter price" />
                            </div>
                        </div>
                        <div className="text-end mt-4">
                            <button type="submit" className="btn btn-success">Add Item</button>
                        </div>
                    </form>
                </div>
            </div>
            <div className="card shadow-lg rounded-lg p-4 mt-4">
                <div className="card-body">
                    <h2 className="card-title">Inventory List</h2>
                    <table className="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Name</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            {items.map((item, index) => (
                                <tr key={index}>
                                    <th scope="row">{index + 1}</th>
                                    <td>{item.name}</td>
                                    <td>{item.quantity}</td>
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