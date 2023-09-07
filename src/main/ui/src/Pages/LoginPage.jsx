import {Form} from "react-bootstrap";
import React, {useEffect, useState} from 'react';
import Loading from "../Components/Loading";
import {useNavigate, useSubmit} from "react-router-dom";
import Layout from "../Layout";
import {useUser} from "../Components/UserContext";

//url should not contain the password, but it's okay for now
function fetchUser(username, password) {
    return fetch("/users/" + username + "+" + password).then((res) => res.json());
}
export default function LoginPage() {
    const {handleLogin} = useUser();
    const [loading, setLoading] = useState(false);
    const navigate = useNavigate();
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    if (loading) {
        return <Loading/>
    }

    function handleLoginCLick() {
        setLoading(true)
        fetchUser(username, password).then((user) => {
            setLoading(false);
            if (user.id > 0) {
                handleLogin(user)
                navigate('/')
            } else {
                navigate('/users/login')
            }
        });
        if (loading) {
            return <Loading/>
        }

    }

    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
    };

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    };

    return (
        <Form>
            <div className="position-absolute top-50 start-50 translate-middle">
                <div className="mb-3">
                    <label htmlFor="username">Username</label>
                    <input onChange={(event) => handleUsernameChange(event)} type="username" className="form-control"
                           id="username" aria-describedby="emailHelp"
                           placeholder="Enter username"/>
                </div>
                <div className="mb-3">
                    <label htmlFor="exampleInputPassword1">Password</label>
                    <input onChange={(event) => handlePasswordChange(event)} type="password" className="form-control"
                           id="exampleInputPassword1" placeholder="Password"/>
                </div>
                <button onClick={event => {
                    event.preventDefault();
                    handleLoginCLick()
                }} type="submit" className="btn btn-secondary btn-lg">Login
                </button>
            </div>
        </Form>
    )
}