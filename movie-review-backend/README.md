# Backend Development for a Movie Review Application 

### Technology Stack:
Java, Spring Boot, Spring Security (with JWT), MongoDB

### Description:
This backend project deals with the generic APIs usually involved in an application for fetching data from or saving data to a database.
The APIs have also been linked with authentication and most of the simple yet useful scenarios are covered.

Please keep in mind that this is a project to demonstrate or rather practice backend development.

FYI - This project was developed on IntelliJ

### Setup:
- MongoDB - import sample date into your database via MongoDB compass using the files inside [mongo_db_setup](./src/main/resources/mongo_db_setup/). Ensure that the Document and Collection names match the names present in relevant [entity](./src/main/java/com/movie/review/entity) classes.
- [application.properties](./src/main/resources/application.properties) - please note there are values fetched from a .env file which has been git-ignored for privacy purposes.
Please ensure to add relevant data.
- [pom.xml](pom.xml) - please ensure all dependencies are present
- Postman API collection - to test the APIs once the app is running, open Postman and just import the files from [here](./src/main/resources/postman_api_and_screenshots/api_collection/movie_review_app.postman_collection.json)

### Running the application:
- Once the setup is complete and all the code is understood, run the [MovieReviewApplication.java](src/main/java/com/movie/review/MovieReviewApplication.java) class.
- The APIs should be live now. Check the run logs to see the localhost port, usually it's 8080 - `http://localhost:8080/`.


