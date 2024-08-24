The "movies.json" file is the copy of documents of a collection from MongoDB used for this backend

Set up mongo DB with the JSON data as follows:
- open mongo DB
- create collection
- add data -> import json

Postman APIs to test:
http://localhost:8080/api/v1/movies
http://localhost:8080/api/v1/movies/66c76c2a46665bf78645560f
http://localhost:8080/api/v1/movies/imdb/tt6443346
http://localhost:8080/api/v1/reviews (POST - needs review in simple raw JSON to be passed)