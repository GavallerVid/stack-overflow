import {useState} from "react";

export default function NewQuestionForm() {

    const [questionTitle, setQuestionTitle] = useState("");
    const [questionDescription, setQuestionDescription] = useState("");
    const handleQuestionTitleChange = (event) => {
        setQuestionTitle(event.target.value)
    }
    const handleQuestionDescriptionChange = (event) => {
        setQuestionDescription(event.target.value)
    }
    const handleSubmit = (event) => {
        event.preventDefault();
        console.log(questionTitle + " " +questionDescription)
        const newQuestion = {questionTitle: questionDescription}
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
            .then(data => console.log(data));
    }

    return (
        <div id={"formContainer"}>
            <form onSubmit={handleSubmit}>
                <label htmlFor="question-title">Question Title:</label>
                <input type="text" id={"questionTitle"} name={"questionTitle"}
                       defaultValue={questionTitle} onChange={handleQuestionTitleChange}/>
                <label htmlFor="question-description">Question:</label>
                <input type="text" id={"questionDescription"} name={"questionDescription"}
                       defaultValue={questionDescription}
                       onChange={handleQuestionDescriptionChange}/>
                <input type={"submit"}/>
            </form>
        </div>
    )
}
