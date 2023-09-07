import {Form} from "react-bootstrap";
import {useState} from "react";
import {useNavigate} from "react-router-dom";

export default function RegisterUserForm() {

    const navigate = useNavigate();

    const [userName, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [registered, setRegistered] = useState(false);

    function handleUsernameInput(event) {
        setUsername(event.target.value)
    }

    function handlePasswordInput(event) {
        setPassword(event.target.value)
    }

    async function registerUser(enteredUsername, enteredPassword) {
        const body = {
            username: enteredUsername,
            password: enteredPassword
        }
        const response = await fetch('/users/', {
            method: 'POST',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json'
            }
        });
        const result = await response.json();
        console.log(result);
        console.log(response.status)
    }

    function handleSubmit(event) {
        event.preventDefault();
        registerUser(userName, password);
        setRegistered(true);
    }

    if (!registered) {
        return (
            <Form onSubmit={handleSubmit}>
                <div className="position-absolute top-50 start-50 translate-middle">
                <div className="mb-3">
                    <label htmlFor="username">Username</label>
                    <input required={true} onChange={handleUsernameInput} type="username" className="form-control" id="username"
                           aria-describedby="emailHelp"
                           placeholder="Enter username"/>
                    <small id="usernameHelp" className="form-text text-muted">Think about a unique username</small>
                </div>
                <div className="mb-3">
                    <label htmlFor="exampleInputPassword1">Password</label>
                    <input required={true} onChange={handlePasswordInput} type="password" className="form-control"
                           id="exampleInputPassword1" placeholder="Password"/>
                    <small id="usernameHelp" className="form-text text-muted">Dont ever let anyone find out your password fam</small>
                </div>
                <button type="submit" className="btn btn-secondary btn-lg">Register</button>
                </div>
            </Form>
        )
    } else {
        return (
            <div>
                <div>
                Welcome {userName} on the page! Successful registration.
                </div>
                <button onClick={() => navigate('/uses/login')}>Login</button>
                <button onClick={() => navigate('/')}>Return to homepage</button>
            </div>
        )
    }
}