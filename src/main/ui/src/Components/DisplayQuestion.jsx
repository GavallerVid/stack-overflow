import {Button, Card, ListGroup} from "react-bootstrap";
import "./DisplayQuestions.css";

export default function DisplayQuestion({question, answers, onBack}) {
    return (
        <div className="questionConatiner">
            <Card className="question">
                <Card.Body>
                    <Card.Title>{question.title}</Card.Title>
                    <Card.Text>
                        {question.description}
                    </Card.Text>
                    <ListGroup variant="flush">
                        <ListGroup.Item><h5>Answers:</h5></ListGroup.Item>
                        {answers.map((answer) => (
                            <ListGroup.Item>{answer.description}</ListGroup.Item>
                        ))}
                    </ListGroup>
                </Card.Body>
                <Button className="button" type="button" onClick={onBack}>Back</Button>
            </Card>
        </div>
    )
}