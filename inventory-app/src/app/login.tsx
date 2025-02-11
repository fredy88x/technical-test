"use client"
import { useState } from "react";

const fakeAuth = (user: string, password: string) => {
  return user === "user@example.com" && password === "password123";
};

export default function LoginPage() {
  const [user, setUser] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleLogin = (e: { preventDefault: () => void; }) => {
    e.preventDefault();
    if (fakeAuth(user, password)) {
      alert("Login successful!");
    } else {
      setError("Invalid email or password");
    }
  };

  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-100">
      <div className="card w-96">
          <div className="card-header">
              <h5 className="card-title">Login</h5>
          </div>
          <div className="card-body">
              <form onSubmit={handleLogin}>
              <div className="mb-4">
                <input
                  type="text"
                  placeholder="User"
                  value={user}
                  onChange={(e) => setUser(e.target.value)}
                  required
                />
              </div>
              <div className="mb-4">
                <input
                  type="password"
                  placeholder="Password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  required
                />
              </div>
                <button type="submit" className="btn btn-primary">
                  Login
                </button>
              </form>
          </div>
      </div>
    </div>
  );
}