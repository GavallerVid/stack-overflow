import {Form} from "react-bootstrap";
import React, {useEffect, useState} from 'react';
import Loading from "../Components/Loading";

//const fetchUser = () => {
  //  return fetch("/users/:id").then((res) => res.json());
//};
export default function LoginPage() {

    const [loading, setLoading] = useState(true);
    const [user, setUser] = useState(null);
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
//
//    useEffect(() => {
//        fetchUser().then((user) => {
//            setLoading(false);
//            setUser(user);
//        });
//    }, []);
//
//    if (loading) {
//        return <Loading />
//    }


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
                <input onChange={handleUsernameChange} type="username" className="form-control" id="username" aria-describedby="emailHelp"
                       placeholder="Enter username"/>
            </div>
            <div className="mb-3">
                <label htmlFor="exampleInputPassword1">Password</label>
                <input onChange={handlePasswordChange} type="password" className="form-control" id="exampleInputPassword1" placeholder="Password"/>
            </div>
                <button type="submit" className="btn btn-secondary btn-lg">Login</button>
            </div>
        </Form>
    )
}