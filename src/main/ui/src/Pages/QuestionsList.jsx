import {useEffect, useState} from "react";
import QuestionsTable from "../Components/QuestionsTable";
import Loading from "../Components/Loading";

const fetchQuestions = () => {
    return fetch("/questions/all").then((res) => res.json());
};

export default function QuestionsList() {
    const [loading, setLoading] = useState(true);
    const [questions, setQuestions] = useState(null);

    useEffect(() => {
        fetchQuestions().then((questions) => {
            setLoading(false);
            setQuestions(questions);
        });
    }, []);

    if (loading) {
        return <Loading />
    }

    return (
        <div>
            <QuestionsTable questions={questions} />
        </div>
    )
}