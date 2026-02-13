# Growth Log Application (Working Title)

A task and activity tracking web application built with Spring Boot.

This application is a growth tracking web application built with Spring Boot.

Users can create daily tasks, mark them as completed, and automatically
generate timeline logs to visualize their personal progress.

This project started as a login system and was extended into a
task and activity tracking application.

---

## Key Features

### Authentication
- User registration
- Secure login
- Password hashing with BCrypt
- Role-based user structure (USER / ADMIN)

### Todo Management
- Create new tasks
- Mark tasks as DONE
- Automatic completion timestamp
- Task status management (ACTIVE / DONE)

### Timeline Log System
- Automatic log creation when a task is completed
- Manual note posting
- Logs grouped by date
- Optional relation to Todo (nullable foreign key)

---

## Tech Stack

- Java 17
- Spring Boot
- MyBatis
- MySQL
- HTML / CSS / JavaScript
- BCrypt

---

## Database Design

### ER Diagram

![ER Diagram](docs/er-diagram.png)

### Design Decisions

- A user can create multiple todos.
- A log entry is automatically generated when a todo is completed.
- Logs may exist without being linked to a todo.
- All tables use BIGINT primary keys for scalability.
- Foreign key constraints ensure relational integrity.

---

## Deployment Strategy

### Development Environment
- Local MySQL
- Backend: IntelliJ IDEA
- Database Management: DBeaver

### Production Deployment (Portfolio Setup)
- EC2 instance hosting Spring Boot application
- MySQL running on EC2 for cost-efficient deployment

### Production Architecture (Scalable Design)
In a real production environment, the recommended architecture would be:

- EC2 (Application Layer)
- AWS RDS (Managed MySQL Database)
- Separate database instance for improved scalability and reliability

RDS is not currently used to minimize cloud costs during development.

---

## Future Improvements

- React frontend migration
- Streak tracking feature
- Public shareable timeline
- AWS EC2 deployment automation
- Flyway database migration

---

## Purpose

This project demonstrates:

- Backend API design
- Authentication implementation
- Relational database design
- Transaction handling
- Deployment strategy planning
- Full-stack integration
