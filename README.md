
# Booking System

This is a movie booking system developed using Spring Boot, MySQL, and Spring Data JPA. 
The system allows users to book movie tickets by selecting a movie, location, theatre, and seat. It handles various entities like movies, locations, theatres, shows, seats, and bookings, as depicted in the ER diagram below.

## ER Diagram
![Booking System Database Design](./path-to-your-ER-diagram.png)

The ER diagram showcases the relationships between the entities in the booking system. The key entities include:
- **Movies**: Contains details of the movies like name, genre, language, and duration.
- **Locations**: Represents locations where movies are being shown.
- **Theatres**: Contains details of theatres and their seating capacities.
- **Shows**: Represents movie shows scheduled in specific theatres at certain times.
- **Seats**: Manages seat details and their status (available/booked).
- **Bookings**: Handles the booking information for a user, mapping it to specific shows, seats, and movies.

## Sequence Diagram

Here is a high-level sequence diagram that outlines the flow of actions during the booking process:



## Features

- Browse available movies by location and theatre.
- Select a movie, showtime, and seats.
- Book tickets with real-time seat availability checking.
- View booking history.

## Tech Stack

- **Backend**: Spring Boot, Spring Data JPA
- **Database**: MySQL
- **Frontend**: You can integrate a frontend with React, Angular, etc.
- **Build Tool**: Maven or Gradle

## Installation

To get started with the project locally, follow the steps below:

### Prerequisites
- Java 11 or later
- MySQL 5.7 or later
- Maven or Gradle

### Steps
1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/your-repository.git
    cd your-repository
    ```

2. Set up the MySQL database:
   - Create a new database named `booking_system`.
   - Update the `application.properties` (or `application.yml`) file with your MySQL configuration:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/booking_system
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Build and run the project using Maven:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4. The project should now be running on `http://localhost:8080`.

## Usage

1. **Create a Movie**:
    - POST `/movies`
    - Example payload:
      ```json
      {
        "name": "Inception",
        "genre": "Sci-Fi",
        "language": "English",
        "duration": 148
      }
      ```

2. **Create a Location**:
    - POST `/locations`
    - Example payload:
      ```json
      {
        "location_name": "New York"
      }
      ```

3. **Create a Theatre**:
    - POST `/theatres`
    - Example payload:
      ```json
      {
        "theatre_name": "AMC 10",
        "location_id": 1
      }
      ```

4. **Create a Show**:
    - POST `/shows`
    - Example payload:
      ```json
      {
        "movie_id": 1,
        "theatre_id": 1,
        "show_time": "2024-09-15T19:30:00"
      }
      ```

5. **Book a Seat**:
    - POST `/bookings`
    - Example payload:
      ```json
      {
        "show_id": 1,
        "user_id": 1,
        "seat_number": 12
      }
      ```

6. **Check Available Seats**:
    - GET `/seats/available?show_id=1`

## Database Schema

| Table Name      | Description                                      |
|-----------------|--------------------------------------------------|
| Movies          | Stores information about movies (ID, name, genre, etc.) |
| Locations       | Stores the location details where movies are shown |
| Theatres        | Manages theatres, their locations, and capacity  |
| Shows           | Represents shows for a particular movie in a theatre |
| Seats           | Stores seat information and status (available/booked) |
| Bookings        | Manages bookings including user, seat, show details |
