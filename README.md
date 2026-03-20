# Address Book App

This is a simple Spring Boot REST API project for managing Address Book contacts.

## Features
- Get all contacts
- Get contact by ID
- Add new contact
- Update contact by ID
- Delete contact by ID

## Tech Used
- Java
- Spring Boot
- Maven

## API Endpoints
- `GET /addressbook`
- `GET /addressbook/{id}`
- `POST /addressbook`
- `PUT /addressbook/{id}`
- `DELETE /addressbook/{id}`

## Run the Project
1. Open the project in IntelliJ
2. Load Maven dependencies
3. Run `AddressbookappApplication.java`

Or use:
```bash
mvn spring-boot:run
Test with CURL
Get all contacts
curl http://localhost:8080/addressbook
Get contact by ID
curl http://localhost:8080/addressbook/1
Add contact
curl -X POST http://localhost:8080/addressbook -H "Content-Type: application/json" -d "{\"name\":\"Akshaya\",\"city\":\"Chennai\",\"phoneNumber\":\"9876543210\"}"
Update contact
curl -X PUT http://localhost:8080/addressbook/1 -H "Content-Type: application/json" -d "{\"name\":\"Akshaya Priya\",\"city\":\"Coimbatore\",\"phoneNumber\":\"9999999999\"}"
Delete contact
curl -X DELETE http://localhost:8080/addressbook/1

