import {useNavigate, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import Loading from "../Components/Loading";
import DisplayQuestion from "../Components/DisplayQuestion";

const fetchQuestion = (id) => {
    return fetch(`/questions/${id}`)
        .then((res) => res.json());
};

const fetchAnswers = (id) => {
    return fetch(`/answers/${id}`)
        .then((res) => res.json());
}

export default function GetQuestion() {
    const {id} = useParams();
    const [question, setQuestion] = useState(null);
    const [questionLoading, setQuestionLoading] = useState(true);
    const [answers, setAnswers] = useState(null);
    const [answerLoading, setAnswerLoading] = useState(true);

    const navigate = useNavigate();

    useEffect(() => {
        setQuestionLoading(true);
        setAnswerLoading(true);
        fetchQuestion(id)
            .then((question) => {
                setQuestion(question);
                console.log(question);
                setQuestionLoading(false);
            })
        fetchAnswers(id).then((answers) => {
            setAnswers(answers);
            console.log(answers);
            setAnswerLoading(false);
        })

    }, [id]);

    if (questionLoading || answerLoading) {
        return <Loading/>;
    }

    return (
        <div>
            <DisplayQuestion
                question={question}
                answers={answers}
                onBack={() => navigate("/")}
            />
        </div>
    )
}