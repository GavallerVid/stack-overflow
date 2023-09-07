import React, { useState } from 'react';
import Table from 'react-bootstrap/Table';

export default function QuestionsTable({ questions }) {
    const [editableQuestionIndex, setEditableQuestionIndex] = useState(null);
    const [editedTitle, setEditedTitle] = useState('');
    const [editedDescription, setEditedDescription] = useState('');

    const handleEditClick = (index) => {
        setEditableQuestionIndex(index);
        const questionToEdit = questions[index];
        setEditedTitle(questionToEdit.title);
        setEditedDescription(questionToEdit.description);
    };

    const handleSaveClick = async (index) => {
        const questionToEdit = questions[index];
        const updatedQuestion = {
            title: editedTitle,
            description: editedDescription,
        };

        try {
            const response = await fetch(`/questions/${questionToEdit.id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(updatedQuestion),
            });

            if (response.ok) {
                setEditableQuestionIndex(null);
            } else {
            }
        } catch (error) {
            console.error('Error:', error);
        }
    };

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
            {questions.map((question, index) => (
                <tr key={question.id}>
                    <td>
                        {editableQuestionIndex === index ? (
                            <input
                                type="text"
                                value={editedTitle}
                                onChange={(e) => setEditedTitle(e.target.value)}
                            />
                        ) : (
                            question.title
                        )}
                    </td>
                    <td>
                        {editableQuestionIndex === index ? (
                            <input
                                type="text"
                                value={editedDescription}
                                onChange={(e) => setEditedDescription(e.target.value)}
                            />
                        ) : (
                            question.description
                        )}
                    </td>
                    <td>{question.created.substring(0, 10)}</td>
                    <td>
                        {editableQuestionIndex === index ? (
                            <button onClick={() => handleSaveClick(index)}>Save</button>
                        ) : (
                            <button onClick={() => handleEditClick(index)}>Edit</button>
                        )}
                    </td>
                </tr>
            ))}
            </tbody>
        </Table>
    );
}
