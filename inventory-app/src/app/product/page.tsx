"use client";
import React, {useEffect, useState} from 'react';
import axios from 'axios';

interface Company {
    nit: string;
    name: string;
    address: string;
    phone_number: string;
}

interface Product {
    code: string;
    name: string;
    company: string;
    attributes: string;
    price: number;
    categories: Category[];
}

interface Category {
    id: number;
    name: string;
}

export default function ProductPage() {
    const [product, setProduct] = useState<Product>({
        code: '',
        name: '',
        company: '',
        attributes: '',
        price: 0,
        categories: []
    });
    const [alert, setAlert] = useState<string | null>(null);
    const [companies, setCompanies] = useState<Company[]>([]);
    const [selectedCompany, setSelectedCompany] = useState<string>('');
    const [categories, setCategories] = useState<Category[]>([]);
    const [selectedCategories, setSelectedCategories] = useState<number[]>([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/company')
            .then(response => {
                console.log('Companies:', response.data);
                setCompanies(response.data);
            })
            .catch(error => {
                console.error('Error fetching companies:', error);
            });
            const fixedCategories = [{id: 1, name: 'Category 1'}, {id: 2, name: 'Category 2'}, {id: 3, name: 'Category 3'}];
            setCategories(fixedCategories);
    }, []);

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/company', product);
            console.log('Product saved:', response.data);
            setAlert('Product saved successfully!');
            setProduct({
                code: '',
        name: '',
        company: '',
        attributes: '',
        price: 0,
        categories: []
            });
        } catch (error) {
            console.error('Error saving company:', error);
            setAlert('Error saving company: ');
        }
    };

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
            const { id, value } = e.target;
            setProduct({ ...product, [id]: value });
        };

    const handleCompanyChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
        setSelectedCompany(e.target.value);
    };

    const handleCategoryChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
        const selectedOptions = Array.from(e.target.selectedOptions, option => parseInt(option.value));
        setSelectedCategories(selectedOptions);
    };

    return (
         <div className="card shadow-lg rounded-lg p-4">
        <div className="card-body">
            {alert && <div className={`alert ${alert.includes('Error') ? 'alert-danger' : 'alert-success'}`} role="alert">{alert}</div>}
            <form onSubmit={handleSubmit}>
                <div className="row">
                    <div className="col-md-6 mb-3">
                        <label htmlFor="code" className="form-label">Code</label>
                        <input type="text" className="form-control" id="code" placeholder="Enter code" value={product.code} onChange={handleChange}/>
                    </div>
                    <div className="col-md-6 mb-3">
                        <label htmlFor="name" className="form-label">Name</label>
                        <input type="text" className="form-control" id="name" placeholder="Enter Name" value={product.name} onChange={handleChange}/>
                    </div>
                    <div className="col-md-6 mb-3">
                        <label htmlFor="company" className="form-label">Company</label>
                        <select className="form-select" id="company" value={selectedCompany} onChange={handleCompanyChange}>
                            <option value="">Select Company</option>
                                {companies.map((company) => (
                                    <option key={company.nit} value={company.nit}>{company.name}</option>
                                ))}
                        </select>
                    </div>
                </div>
                <div className="row">
                    <div className="col-md-6 mb-3">
                        <label htmlFor="attributes" className="form-label">Attributes</label>
                        <input type="text" className="form-control" id="attributes" placeholder="Enter Attributes" value={product.attributes} onChange={handleChange}/>
                    </div>
                    <div className="col-md-6 mb-3">
                        <label htmlFor="price" className="form-label">Price</label>
                        <input type="number" className="form-control" id="price" placeholder="Enter Price" value={product.price} onChange={handleChange}/>
                    </div>
                    <div className="col-md-6 mb-3">
                        <label htmlFor="category" className="form-label">Categories</label>
                        <select multiple className="form-select" id="category" value={selectedCategories.map(String)} onChange={handleCategoryChange}>
                            <option value="">Select Categories</option>
                                {categories.map((category) => (
                                    <option key={category.id} value={category.id}>{category.name}</option>
                                ))}
                        </select>
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