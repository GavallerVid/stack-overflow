import {Container, Navbar} from "react-bootstrap";
import {Outlet, useLocation, useNavigate} from "react-router-dom";
import React from "react";

export default function LoginButtons() {
    const navigate = useNavigate()
    const location = useLocation()

    function registerNavigate () {
        if (location.pathname === "/users/add") {
            window.location.reload();
        } else {
            navigate("/users/add");
        }
    }

    return (
        <div id="user">
            <button onClick={registerNavigate}>Register</button>
            <button>Login</button>
        </div>
    )
}