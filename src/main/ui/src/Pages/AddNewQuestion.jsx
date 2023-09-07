import "./AddNewQuestion.css"
import {Link} from "react-router-dom";
import {Button} from "react-bootstrap";

export default function addNewQuestion(){
    return (
        <div className="button-container" id={"addNewQuestionButtonContainer"}>
                <Link to={"/add-new-question"}>
                    <Button id={"addButton"}>
                        Add New Question
                    </Button>
                </Link>
        </div>
    )
}