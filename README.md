<h1 style="text-align: center;">Healthcare System</h1>

___
<h2 style="text-align: center;">How to run the program</h2>


To run the program, follow these steps:


1. **Clone the Repository**: Begin by cloning the repository from GitHub to your local machine using Git.

2. **Open Visual Studio Code (VS Code)**: Once cloned, open VS Code and locate the project folder.

3. **Verify PostgreSQL Installation**: Ensure that PostgreSQL is installed and operational on your system.

4. **Configure Database Connection**: Proceed to configure the database connection in the application's configuration files. Specify the database URL, username, and password.

5. **Execute Maven Commands**: Utilize the terminal within VS Code to execute Maven commands for building and running the application.

6. **Access the Application**: After successful execution, access the application locally through a web browser.

7. **Upcoming Online Feature**: It's worth noting that an online feature will soon be added, enriching the application's functionality and accessibility.

By following these steps, you can successfully run the program on your local machine.


<h2 style="text-align: center;">Folder Structure</h2>

Here we will talk about the structure of the code base and what is within each folder.

- **dist**: Details files used for the documentation of our API.

- **healthcare_database**: Contains several SQL files used to create tables for the database.

Moving on to the `src` directory:

- **java**: Contains two folders:
  - **HCS.Back.End**: Houses the backend logic, including:
    - **controller**: Details mappings for each entity, such as creating a doctor or logging them in.
    - **dto**: Handles the transfer of data between the controller and service layer.
    - **entity**: Contains files corresponding to database tables and their parameters.
    - **exception**: Used to handle exceptions.
    - **mapper**: Maps objects to their corresponding DTOs.
    - **repository**: Contains interfaces representing basic CRUD operations.
    - **security**: Contains two folders:
      - **config**: Details how the security portion of our application is set up.
        - **auth**: Further details on security setup.
      - **google2FA**: Used to set up two-factor authentication.
    - **service**: Contains interface files and an `impl` folder:
      - **impl**: Details different services provided for each member in our database.
  - **util**: Houses utility functions.

- **resources**: Contains the location of static files and the configuration file of the entire Spring Boot application.
  - **htmx**: Contains the source code to use htmx on the frontend.
  - **static**: Contains different HTML, JavaScript, and CSS files defining the frontend.
