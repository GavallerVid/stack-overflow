import Table from 'react-bootstrap/Table';

export default function QuestionsTable({ questions }) {

    return (
        <Table striped bordered hover>
            <thead>
            <tr>
                <th>Question title</th>
                <th>Description</th>
                <th>Date</th>
            </tr>
            </thead>
            <tbody>
                {questions.map((question) => (
                    <tr key={question.id}>
                        <td>{question.title}</td>
                        <td>{question.description}</td>
                        <td>{question.created.substring(0, 10)}</td>
                    </tr>
                ))}
            </tbody>
        </Table>
    )
}