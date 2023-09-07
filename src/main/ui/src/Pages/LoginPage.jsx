import {Form} from "react-bootstrap";
import React, {useEffect, useState} from 'react';
import Loading from "../Components/Loading";
import {useNavigate, useSubmit} from "react-router-dom";
import Layout from "../Layout";

function fetchUser(username,password){
    return  fetch("/users/"+username+"+"+password).then((res) => res.json());
}
export default function LoginPage() {

    const [loading, setLoading] = useState(true);
    const [user, setUser] = useState(null);
    const [user_id, setUser_id] = useState(null);
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');





    useEffect(() => {
        fetchUser(username).then((user) => {
            setLoading(false);
            setUser(user);

        });
    }, []);

    if (loading) {
        return <Loading />
    }
    function handleLoginCLick(){
        fetchUser(username,password).then((user) => {
            setLoading(false);
            setUser(user);
            setUser_id(user.id)
            console.log(user);
        });
        if (loading) {
            return <Loading />
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
                <input onChange={(event) => handleUsernameChange(event)} type="username" className="form-control" id="username" aria-describedby="emailHelp"
                       placeholder="Enter username"/>
            </div>
            <div className="mb-3">
                <label htmlFor="exampleInputPassword1">Password</label>
                <input onChange={(event) => handlePasswordChange(event)} type="password" className="form-control" id="exampleInputPassword1" placeholder="Password"/>
            </div>
                <button onClick={event => {event.preventDefault(); handleLoginCLick()}} type="submit" className="btn btn-secondary btn-lg">Login</button>
            </div>
        </Form>
    )
}