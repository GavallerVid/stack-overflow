import {useState} from "react";

export default function NewQuestionForm() {
    const [inputs, setInputs] = useState({});

    const handleChange = (event) => {
        const questionTitle = event.target.questionTitle;
        const questionDescription = event.target.questionDescription;
        setInputs(values => ({...values, [questionTitle]: questionDescription}))
    }
    const handleSubmit = (event) => {
        event.preventDefault();
        console.log(inputs.questionTitle)
    }

    return (
        <div id={"formContainer"}>
            <form onSubmit={handleSubmit}>
                <label htmlFor="question-title">Question Title:</label>
                <input type="text" id="questionTitle" name="questionTitle"
                value={inputs.questionTitle} onChange={handleChange}/>
                <label htmlFor="question-description">Question:</label>
                <input type="text" id="questionDescription" name="questionDescription"
                       value={inputs.questionDescription} onChange={handleChange}/>
                <input type={"submit"}/>
            </form>
        </div>
    )
}
