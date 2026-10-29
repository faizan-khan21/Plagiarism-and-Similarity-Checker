# Plagiarism / Similarity Checker for Code & Text Assignments

A **Java/Spring Boot web application** that helps instructors detect potentially similar student submissions, including text assignments and Java programming assignments. The system is designed to combine text similarity algorithms with **Abstract Syntax Tree (AST)-based code analysis**.

Built as a semester project for B.Tech CSE (Object-Oriented Programming).

---

## 📋 Features

- **Batch Submission:** Upload multiple student submissions for an assignment.
- **Text Similarity:** Compare text using cosine similarity and Levenshtein distance.
- **Code Similarity:** Analyze Java source code using JavaParser and AST-based structural comparison.
- **Configurable Threshold:** Flag submission pairs above a selected similarity score.
- **Dashboard:** View similarity scores and flagged submissions.
- **Side-by-Side Comparison:** Review potentially similar submissions.
- **PDF Reports:** Export analysis results for instructor review.
- **Result History:** Store batches, submissions, and similarity results.

---

## 🛠 Technologies Used

- Java
- Spring Boot
- Spring MVC
- Thymeleaf
- MySQL / H2 Database
- Spring Data JPA / Hibernate
- JavaParser
- Apache Commons Text
- Bootstrap
- Chart.js
- Maven
- JUnit 5
- Git & GitHub

---

## 📁 Project Structure

```text
Plagiarism-and-Similarity-Checker
│
├── src
│   ├── main
│   │   ├── java/com/myteam/plagiarismchecker
│   │   │   ├── controller
│   │   │   ├── entity
│   │   │   ├── repository
│   │   │   ├── service
│   │   │   ├── analyzer
│   │   │   └── config
│   │   │
│   │   └── resources
│   │       ├── templates
│   │       ├── static
│   │       └── application.properties
│   │
│   └── test
│
├── pom.xml
└── README.md
```

---

## 🗄 Core Data Model

- **Batch:** Stores assignment details and analysis settings.
- **Submission:** Stores student submission metadata.
- **SimilarityResult:** Stores similarity scores between two submissions.

---

## ⚙ Installation

### Clone Repository

```bash
git clone https://github.com/faizan-khan21/Plagiarism-and-Similarity-Checker.git
cd Plagiarism-and-Similarity-Checker
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

Open the application at:

`http://localhost:8080`

Ensure Java and Maven are installed and the database configuration in `application.properties` matches your environment.

---

## 🏗 System Workflow

1. Create an assignment batch.
2. Upload student submissions.
3. Validate and preprocess the uploaded files.
4. Calculate text or code similarity for each unique pair.
5. Flag pairs exceeding the configured threshold.
6. Review results on the dashboard.
7. Export a report for further investigation.

---

## 🚀 Future Enhancements

- Support for Python, C++, and JavaScript.
- Improved AST-based structural comparison.
- Cross-batch plagiarism detection.
- Interactive similarity heatmaps.
- Authentication and role-based access.
- Moodle and Google Classroom integration.
- ML-based similarity scoring.

---

## ⚠️ Note

Similarity scores identify submissions that may require further review; they do not independently prove plagiarism. Actual features depend on the current implementation.

---

## 👨‍💻 Author

**Faizan Khan**

GitHub: [FaizanKhan21](https://github.com/Faizan-Khan21)

Project Repository: [Plagiarism-and-Similarity-Checker](https://github.com/faizan-khan21/Plagiarism-and-Similarity-Checker)

⭐ If you find this project useful, consider giving the repository a star!
