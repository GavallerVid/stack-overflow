import {useState} from "react";
import {useNavigate} from "react-router-dom";
import {Button, Form} from "react-bootstrap";
import "./NewQuestionForm.css"

export default function NewQuestionForm() {
    const navigate = useNavigate()

    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const loggedInUserId = JSON.parse(localStorage.getItem("user")).id

    const handleQuestionTitleChange = (event) => {
        setTitle(event.target.value)
    }
    const handleQuestionDescriptionChange = (event) => {
        setDescription(event.target.value)
    }
    const handleSubmit = (event) => {
        event.preventDefault();
        console.log(title + " " + description)
        const newQuestion = {
            title: title,
            description: description, user_id: loggedInUserId
        }
        postQuestion(newQuestion)
    }

    async function postQuestion(newQuestion) {
        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(newQuestion)
        };
        fetch('/questions/', requestOptions)
            .then(response => response.json())
            .then(navigate('/'));
    }

    return (
        <div className="formContainer" id={"formContainer"}>
            <Form onSubmit={handleSubmit}>
                <Form.Group className="mb-3">
                    <Form.Label htmlFor="question-title">Question Title: </Form.Label>
                    <Form.Control type="text" id={"questionTitle"} name={"questionTitle"}
                                  defaultValue={title} onChange={handleQuestionTitleChange}/>
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label htmlFor="question-description">Question description: </Form.Label>
                    <Form.Control as="textarea" rows="5" type="text" id={"questionDescription"} name={"questionDescription"}
                                  defaultValue={description}
                                  onChange={handleQuestionDescriptionChange}/>
                </Form.Group>
                <Button type={"submit"}>Submit</Button>
            </Form>
        </div>
    )
}
