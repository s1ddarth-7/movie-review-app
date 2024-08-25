The "movies.json" file (present in resources) is the copy of documents of a collection from MongoDB used for this backend

Set up mongo DB with the JSON data as follows:
- open mongo DB
- create collection named "movies"
- add data to "movies" -> import json

Postman APIs to test:
----------------------
GET     - http://localhost:8080/
GET     - http://localhost:8080/gibberish
GET     - http://localhost:8080/api/v1/movies
GET     - http://localhost:8080/api/v1/movies/66c76c2a46665bf78645560f
GET     - http://localhost:8080/api/v1/movies/gibberish
GET     - http://localhost:8080/api/v1/movies/imdb/tt6443346

POST    - http://localhost:8080/api/v1/reviews (needs a review input in simple raw JSON)
Note the update on the MongoDB collection named "reviews"
sample input:
    {
        "reviewBody": "Nice action movie!",
        "imdbId": "tt6443346"
    }

DELETE  - http://localhost:8080/api/v1/reviews/delete (needs a reviewId input in raw text, any one picked from MongoDB)
Note the changes (deletion) on the MongoDB collection named "reviews"