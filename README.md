# Cinema API

A seamless backend experience between customers, screens and movies for the sector-leading BrightCinema chain of cinemas.

## Who we are
We are the team behind Cinema - 4 members of Cohort 6 from the Bright Network Technology Academy!

- Yongran
	- (Github)[https://github.com/YoyoMai98]
	- (LinkedIn)[https://www.linkedin.com/in/yongran-mai/]

- Tariq
	- (Github)[https://github.com/Tariq-Hennache]
	- (LinkedIn)[https://www.linkedin.com/in/tariq-hennache/]
- Guy
	- (Github)[https://github.com/GuyTheCoder]
	- (LinkedIn)[https://www.linkedin.com/in/guy-chalk/]
- Kat
	- (Github)[https://github.com/katfagg]
	- (LinkedIn)[https://www.linkedin.com/in/katfagg/]
	- (Email)katjfagg@gmail.com


## Table of Contents
- [Project Overview](#project-overview)
- [Project Structure](#project-structure)
- [Install and Run](#install-and-run)
- [Using the API - HTTP Requests](#using-the-api---http-request)
- [Further Extensions](#further-extensions)
- [Acknowledgements](#acknowledgments)


## Project Overview
Given the broad scope to create an API;
- We have designed a cinema API which allows you to select information from our different classes and get this brought up in Postman and Postico.
- We have used mainly Java as our primary Backend language, but have also used some SQL for the data and some Postman for helping us with running our app.
- We faced many challenges throughout making our app, these included: merge errors and issues with git/github, dependency loops failing, testing our code with it giving errors, having foreign key constraint issues.
- To mitigate our issues we regularly discussed them with one another, and would ask for help when we needed it. Our teamwork was key for getting us to complete this project together.

## Project Structure
### Unified Modelling Language Diagrams (UML):

![UML](https://github.com/katfagg/cinema_project/blob/main/Class%20Diagram%20Final.png)

### Entity Relationship Diagram (ERD):

![ERD](https://github.com/katfagg/cinema_project/blob/main/ERD%20Final.png)

## Install and Run

1. This Spring Boot API runs on Java 17. Ensure you have an IDE, API platform and PostgreSQL client before running this API. We used IntelliJ, Postman & Postico, respectively. 
2. Clone the repository (`git clone`) [git@github.com:katfagg/cinema_project.git]. Open project in IDE.
3. Create a database called “cinema” (`createdb cinema`); this will allow you to use your PostgreSQL client to view your tables.
4. Run the application and open your API platform. Interact with the API and make HTTP queries via “localhost:8080/{query}” in the CLI.


## Using the API - HTTP Requests

localhost:8080/…

| HTTP Request Path                                                        | Request Type | Description                                      |
|:-------------------------------------------------------------------------|:-------------|:-------------------------------------------------|
| `.../cinemas` |`GET` | Get All Cinemas |
|`.../cinemas/{id}`| `GET` | Get Cinema By ID |
|`.../cinemas/movies` |`GET` | Get All Movies  |
|`.../cinemas/movies/{id}`|`GET`| Get Movie By ID|
| `.../cinemas/{id}/movies/{movieId}`  | `DELETE`  | Cancel Movie  |
| `.../cinemas/{id}/movies`  | `POST`  | Add Movie To Cinema  |
| `.../cinemas/{id}/screens`  | `POST`  | Add Screen To Cinema |
| `.../cinemas`  | `POST`  | Create Cinema  |
| `.../customers` | `GET` | Get All Customers |
|`.../customers/{id}` | `GET` | Get Customer By ID |
| `.../customers` | `POST` | Create New Customers |
| `.../screens` | `GET` | Get All Screens 
| `.../screens/{id}` | `GET` | Get Screen By ID |
| `.../screens/screenings` | `GET` | Get All Screenings |
| `.../screens/{id}/screenings` | `GET` | Get Screening By ID |
| `.../screens` | `POST` | Create New Screen |
| `.../screens/{screenId}?screeningId={screeningId}` | `POST` | Create/Add New Screening To Screen |
| `.../screens/{screenId}/screenings/{screeningId}` | `POST` | Add New Customer/Movie To Screening |
| `.../screens/{screenId}?cinemaId={cinemaId}&screeningId={screeningId}` | `DELETE` | Delete Screening/Movie By ID |


## Further Extensions
Here are a few ideas on how we would like to expand on this API:
- Change `Cinema` and `Movie` one-to-many relationship to many-to-many
- Add `showTime` property in `Screening` model
- Create `Booking` model to handle price for a ticket
- Create `Genre` table to list movies’ genres in one cinema


## Acknowledgements
We would like to thank the [BNTA](https://techacademy.brightnetwork.co.uk/) team and our trainers!
