# BookApp

Simple application that has Rest API and H2 in-memory database.

Initial data is uploaded from data.sql file (5 books)

When application restarts, all the data is reset, since database is setup to be in-memory.

Application is setup to be launched on localhost with port 8080 (http://localhost:8080/)

H2 database gui can be reaced via address: (http://localhost:8080/h2-ui/); JDBC URL: jdbc:h2:mem:testdb

API:

GET method to receive all data:
http://localhost:8080/api/getAllBooks

Get methods for filtering data:

http://localhost:8080/api/getBookById/5
http://localhost:8080/api/getBookByTitle/{title}
http://localhost:8080/api/getBookByAuthor/{author}
http://localhost:8080/api/getBookYearOfRelease/{yearOfRelease}
http://localhost:8080/api/getBookByRating/{rating}

POST method to rate book with specific ID:
http://localhost:8080/api/rateBook/5
    This method requeires rating value to be provided in the body of request. Value has to be between 1 and 5.