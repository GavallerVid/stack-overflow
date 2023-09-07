import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import Layout from "./Layout";
import HomePage from "./HomePage";

import GetQuestion from "./Pages/GetQuestion";

import LoginPage from "./Pages/LoginPage";

import RegisterUserForm from "./Components/RegisterUserForm";

import NewQuestionForm from "./Components/NewQuestionForm";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Layout />,
        children: [
            {
                path: "/",
                element: <HomePage />,
            },
            {
                path: "/questions/:id",
                element: <GetQuestion />,
            },

                path: "/users/add",
                element: <RegisterUserForm/>,
            },
            {

                path:"/users/login",
                element: <LoginPage/>,
            },
            {
                path: "/add-new-question",
                element: <NewQuestionForm />
            }
        ]
    }
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={router}/>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
