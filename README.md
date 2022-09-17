# Cinema API

A seamless backend experience among customers, screens and movies for the sector-leading BrightCinema chain of cinemas.

## Who we are
We are the Debug Demons team behind Cinema - 4 members of Cohort 6 from the Bright Network Technology Academy!

- Yongran
	- [Github](https://github.com/YoyoMai98)
	- [LinkedIn](https://www.linkedin.com/in/yongran-mai/)

- Tariq
	- [Github](https://github.com/Tariq-Hennache)
	- [LinkedIn](https://www.linkedin.com/in/tariq-hennache/)
- Guy
	- [Github](https://github.com/GuyTheCoder)
	- [LinkedIn](https://www.linkedin.com/in/guy-chalk/)
- Kat
	- [Github](https://github.com/katfagg)
	- [LinkedIn](https://www.linkedin.com/in/katfagg/)
	- [Email](katjfagg@gmail.com)


## Table of Contents
- [Project Overview](#project-overview)
- [Project Structure](#project-structure)
- [Install and Run](#install-and-run)
- [Using the API - HTTP Requests](#using-the-api---http-request)
- [Further Extensions](#further-extensions)
- [Acknowledgements](#acknowledgments)


## Project Overview
Given the broad scope to our cinema-management-API:
- We have designed a cinema API which uses POJOs and allows you to select information from our different models and get this brought up in Postman and Postico.
- A handy API allows cinemas to add new movies, search for movies, add new show time and screens for movies and manage customers. It also allows customers to book movies' tickets.
- We have used Java as our primary Backend language, but have also used SQL for the data.
- Our main challenges included removing dependency loops between screening, screen, movie and cinema models, fixing foreign key constraints, and version control errors. 
- To mitigate our issues we regularly discussed them with one another, and would ask for help when we needed it. Our teamwork was key for getting us to complete this project together.

## Project Structure
### Unified Modelling Language Diagrams (UML):

![UML](https://github.com/katfagg/cinema_project/blob/main/Class%20Diagram%20Final.png)

![UML](https://github.com/katfagg/cinema_project/blob/main/UML%20Final.png)

### Entity Relationship Diagram (ERD):

![ERD](https://github.com/katfagg/cinema_project/blob/main/ERD%20Final.png)

## Install and Run

1. This Spring Boot API runs on Java 17. Ensure you have an IDE, API platform and PostgreSQL client before running this API. We used IntelliJ, Postman & Postico, respectively. 
2. Clone the repository `git clone git@github.com:katfagg/cinema_project.git`. Open project in IDE.
3. Create a database called “cinema” (`createdb cinema_app`); this will allow you to use your PostgreSQL client to view your tables.
4. Run the application and open your API platform. Interact with the API and make HTTP queries via `localhost:8080/{query}` in the CLI.


## Using the API - HTTP Requests

`localhost:8080/…`

| HTTP Request Path                                                        | Request Type | Description                                      |
|:-------------------------------------------------------------------------|:-------------|:-------------------------------------------------|
| `.../cinemas` |`GET` | Get All Cinemas |
|`.../cinemas/{id}`| `GET` | Get Cinema By ID |
|`.../cinemas/{id}/movies` |`GET` | Get All Movies  |
|`.../cinemas/{id}/movies/{movieId}`|`GET`| Get Movie By ID|
|`.../cinemas/{id}/movies?genre={genre}`|`GET`| Get Movie By Genre |
|`.../cinemas/{id}/movies/title={title}`|`GET`| Get Movie By Title|
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
| `.../screens/{screenId}/screenings/{screeningId}?cinemaId={cinemaId}&customerId={customerId}` | `POST` | Add New Customer To Screening |
| `.../screens/{screenId}/screenings/{screeningId}?cinemaId={cinemaId}&movieId={movieId}` | `POST` | Add New Movie To Screening |
| `.../screens/{screenId}?cinemaId={cinemaId}&screeningId={screeningId}` | `DELETE` | Delete Screening By ID |
| `.../screens/{screenId}?cinemaId={cinemaId}&screeningId={screeningId}?movieId={movieId}` | `DELETE` | Delete Movie By ID |


## Further Extensions
Here are a few ideas on how we would like to expand on this API:
- Change `Cinema` and `Movie` one-to-many relationship to many-to-many
- Add `showTime` property in `Screening` model
- Create `Booking` model to handle price for a ticket
- Create `Genre` table to list movies’ genres in one cinema


## Acknowledgements
We would like to thank the [BNTA](https://techacademy.brightnetwork.co.uk/) team and especially to our trainers Anna, Colin, Eoan, Richard and Zsolt!
