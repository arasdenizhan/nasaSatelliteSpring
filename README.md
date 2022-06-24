# Satellite API - Spring Boot

- Spring Boot, JDBC, H2, NASA TLE API
- This Spring project gets all available Earth-orbiting object positions every 10 seconds and save these records to an embedded H2 Database. User can get last "X" records. Here "X" equals the desired record amount to get. Also user can delete the records of a Satellite by it's name.
- Dockerfile, Makefile and POSTMAN Request Set included.
- API serves at `http://localhost:8080`.
- H2 console available at `http://localhost:8080/h2-console`.
- To run project inside the container:
    - Find `Makefile` which is in the project's root folder:
        - Run `docker_build (M1_CHIP):` goal.

## What is NASA TLE API?
- The NASA TLE API provides access to two-line element (TLE) data for Earth-orbiting objects at a given point in time. A TLE set consists of two 69-character lines of data which can be used to determine the position and velocity of the associated object. This data is updated daily from CelesTrak. All data is returned in JSON format.
