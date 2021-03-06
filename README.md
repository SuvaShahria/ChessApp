# Project-2: Chess App 
## Team Members:

* Suva Shahria - Team Lead, Chess Logic, Chess Visualization + Chess CSS, Communication between front-end and backend for chess logic.
* Matthew LaFleur- Login/Registration with the use of AuthGuard, CSS for all pages.
* Max Goncharov - Documentation and CSS on home page.
* Andrew Curry - Spring MVC, Handled majority of the backend and Testing.

## Executive Summary
Chess App is a full-stack web application that allows users to login and play chess against each other online. Users can challenge other users to a game. Replay old games that they've played. Users can customize the theme of the board and the pieces.

## Chess App User Stories 
* Users can register and create a new account. 
* Users can login.
* Users can reskin the chessboard and chess pieces according to their preferences. 
* Users can challenge other users to a chess match over the internet.
* Users can play chess against other users online.
* Users can replay their old games.
* Users can view all users, their incomplete games, and pending games. 
* Users can logout. 

## Technology Stack

### Front-End
* We used **Angular**, **Bootstrap**, **HTML**, **CSS**, **JavaScript**, and **TypeScript** to create the front-end of the application.
* We implemented **chess.js API** and **chessboard.js API** for the chess logic and chessboard graphics. 

### Back-End
* We used **SpringMVC** to leverage the Dispatcher-Servlet to create a FrontController design pattern to communicate with the back-end.
* The back-end system uses **SpringMVC** along with **Hibernate** to connect to an **AWS RDS Postgres database**. 
* Passwords are encrypted in **Java** and securely stored in the database. 
* The middle tier follows proper layered architecture and has reasonable (~70%) test coverage of the service layer. 

### Misc
* We employed the **scrum** methodology and the **agile** development framework during the two-week sprint.
* **GitHub** and **GitBash** for version control.
* **Slack**, **Zoom**, and **Discord** for team communication and stand-up meetings.

## Sample Views
<img src="./img/login.png" alt="sample view" width="800"/>
<img src="./img/main.png" alt="sample view" width="800"/>
<img src="./img/play.png" alt="sample view" width="800"/>
<img src="./img/playvs.png" alt="sample view" width="800"/>
<img src="./img/register.png" alt="sample view" width="800"/>
<img src="./img/replay.png" alt="sample view" width="800"/>
<img src="./img/theme2.png" alt="sample view" width="800"/>
<img src="./img/themes.png" alt="sample view" width="800"/>
