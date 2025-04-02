# Job Application Tracker – Backend

A Spring Boot REST API for tracking job applications, built as part of a full-stack project.

##  Features

- Create and manage job applications
- Assign applications to users
- Retrieve all users and applications
- Integrated with a React + Tailwind frontend
- Swagger UI for API testing

##  Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- H2 (in-memory DB)
- Maven

##  Setup

```bash
git clone https://github.com/swarna73/job-tracker-backend.git
cd job-tracker-backend
./mvnw spring-boot:run

App runs on: http://localhost:8080
Swagger UI: http://localhost:8080/swagger-ui/index.html

📁 API Endpoints
	•	GET /api/users – List all users
	•	POST /api/users – Add a user
	•	GET /api/applications – List all job applications
	•	POST /api/applications – Add a job application

✅ Todo
	•	PostgreSQL support
	•	Auth (optional)
	•	Filtering and search endpoints
