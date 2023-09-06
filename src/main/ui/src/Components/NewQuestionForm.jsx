export default function NewQuestionForm() {
    return (
        <div id={"formContainer"}>
            <form>
                <label htmlFor="question-title">Question Title:</label>
                <input type="text" id="question-title" name="question-title"/>
                <label htmlFor="question-description">Question:</label>
                <input type="text" id="question-description" name="question-description"/>
                <input type={"submit"}/>
            </form>
        </div>
    )
}
