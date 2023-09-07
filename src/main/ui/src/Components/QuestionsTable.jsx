import Table from 'react-bootstrap/Table';

export default function QuestionsTable({ questions }) {

    return (
        <Table striped bordered hover>
            <thead>
            <tr>
                <th>Question title</th>
                <th>Answers</th>
                <th>Date</th>
            </tr>
            </thead>
            <tbody>
                {questions.map((question) => (
                    <tr key={question.id}>
                        <td>{question.title}</td>
                        <td>{question.answerCount}</td>
                        <td>{question.created.substring(0, 10) + " " + question.created.substring(11, 16)}</td>
                    </tr>
                ))}
            </tbody>
        </Table>
    )
}