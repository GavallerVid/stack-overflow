import {Container, Navbar} from "react-bootstrap";
import {Outlet, useNavigate} from "react-router-dom";
import React from "react";

export default function LoginButtons() {
    const navigate = useNavigate();

    return (
        <div id="user">
            <button onClick={()=>navigate("/users/add")}>Register</button>
            <button>Login</button>
        </div>
    )
}