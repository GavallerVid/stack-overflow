import {Form} from "react-bootstrap";
export default function RegisterUserForm() {

    return (
        <Form>
            <div className="form-group">
                <label htmlFor="username">Username</label>
                <input type="username" className="form-control" id="username" aria-describedby="emailHelp"
                       placeholder="Enter username"/>
                    <small id="usernameHelp" className="form-text text-muted">Think about a unique username</small>
            </div>
            <div className="form-group">
                <label htmlFor="exampleInputPassword1">Password</label>
                <input type="password" className="form-control" id="exampleInputPassword1" placeholder="Password"/>
            </div>
            <button onClick={} type="submit" className="btn btn-primary">Register</button>
        </Form>
    )
}