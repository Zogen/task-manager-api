# Task Manager API

A minimal Spring Boot REST API for managing tasks, built to practice backend development and clean architecture principles.

## Features

- Create, read, update, delete tasks
- Filter tasks by status (`PENDING`, `IN_PROGRESS`, `COMPLETED`)
- Error handling with custom exceptions
- Use of DTOs and a mapper for clean data transfer
- Includes `createdAt` and `dueDate` timestamps

## Stack

- Java 17
- Spring Boot
- Spring Web
- Maven

## Endpoints

| Method | Endpoint                  | Description        |
|--------|---------------------------|--------------------|
| GET    | `/tasks`                  | List all tasks     |
| GET    | `/tasks/{id}`             | Get task by ID     |
| GET    | `/tasks/status/{status}`  | Filter by status   |
| POST   | `/tasks`                  | Create a task      |
| PUT    | `/tasks/{id}`             | Update a task      |
| DELETE | `/tasks/{id}`             | Delete a task      |

## Coming Soon

- Database integration
- Unit tests
- Frontend (React) client
