import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import {Container, Navbar} from "react-bootstrap";
import {Outlet, useLocation} from "react-router-dom";
import LoginButtons from "./Components/LoginButtons";

export default function Layout() {

    return (
        <div>
            <Navbar className="bg-body-tertiary" data-bs-theme="dark">
                <Container>
                    <Navbar.Brand href="/">stack-overflow</Navbar.Brand>
                    <Navbar.Toggle />
                    <Navbar.Collapse className="justify-content-end">
                        <LoginButtons href={"/users/"}/>
                        <Navbar.Text>
                            By: Team team = new Team();
                        </Navbar.Text>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            <Outlet />
        </div>
    )
}