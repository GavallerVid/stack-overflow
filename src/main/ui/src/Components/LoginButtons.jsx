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

    function logout () {
        localStorage.clear();
        window.location.reload();
    }

    return (
        <div id="user">
            {localStorage.getItem("user") ? <div>
                    <text className= "text-light-emphasis">Logged in: {JSON.parse(localStorage.getItem("user")).user_name} </text>
                    <button onClick={logout}>Logout</button>
            </div> :
                <div>
                    <button onClick={registerNavigate}>Register</button>
                    <button onClick={()=>navigate("/users/login")}>Login</button>
                </div>}
        </div>
    )
}