
import {Link} from "react-router-dom";

export default function addNewQuestion(){
    return (
        <div id={"addNewQuestionButtonContainer"}>
                <Link to={"/add-new-question"}>
                    <button id={"addButton"}>
                        Add New Question
                    </button>
                </Link>
        </div>
    )
}