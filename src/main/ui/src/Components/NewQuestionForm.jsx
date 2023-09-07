import {useState} from "react";
import {useNavigate} from "react-router-dom";

export default function NewQuestionForm() {
    const navigate = useNavigate()

    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");

    const handleQuestionTitleChange = (event) => {
        setTitle(event.target.value)
    }
    const handleQuestionDescriptionChange = (event) => {
        setDescription(event.target.value)
    }
    const handleSubmit = (event) => {
        event.preventDefault();
        console.log(title + " " +description)
        const newQuestion = {questionTitle: description}
        postQuestion(newQuestion)
    }
    async function postQuestion (newQuestion) {
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({newQuestion})
        };
        fetch('/questions/', requestOptions)
            .then(response => response.json())
            .then(navigate('/'));
    }

    return (
        <div id={"formContainer"}>
            <form onSubmit={handleSubmit}>
                <label htmlFor="question-title">Question Title:</label>
                <input type="text" id={"questionTitle"} name={"questionTitle"}
                       defaultValue={title} onChange={handleQuestionTitleChange}/>
                <label htmlFor="question-description">Question:</label>
                <input type="text" id={"questionDescription"} name={"questionDescription"}
                       defaultValue={description}
                       onChange={handleQuestionDescriptionChange}/>
                <button type={"submit"}>Submit</button>
            </form>
        </div>
    )
}
