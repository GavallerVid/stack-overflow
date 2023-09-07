import QuestionsList from "./Pages/QuestionsList";
import AddNewQuestion from "./Pages/AddNewQuestion";

export default function HomePage() {
    return (
        <div>
            <AddNewQuestion />
            <QuestionsList />
        </div>
    )
}