# REST Web Service with spring-boot

An exemplary gym database project, developed using Spring Boot, to create a RESTful web service for efficient and organized gym management.

The database comprises three distinctive tables, each designed to manage specific sets of information.

Users Table: This table serves as a repository for fundamental user-related data. The 'Username' field acts as the primary key, uniquely identifying each user within the system. The 'Account Password' secures the user's account, while the 'User's Email' captures the contact information associated with each user's profile.

Reservations Table: This table focuses on storing information related to class reservations or activities. Each reservation is uniquely identified by the 'Reservation ID', which serves as the primary key. The table includes details such as the 'Class Name', 'Instructor', 'Location', 'Available Seats', 'Class Date and Time', and 'Enrolled Users' - pertinent information essential for managing class enrollments and scheduling.

News Table: This table is dedicated to managing news-related content within the system. Each news article is identified by the 'News ID', functioning as the primary key. The 'News Title' signifies the title or headline of the news piece, while the 'News Description' provides a comprehensive overview of the news content. Additionally, the 'Publication Date and Time' field records when the news was published or made available.


## Installing

 - Start psql and create database with automated script:
 
 `restartBBDD.sh`

  - Start spring-boot in terminal situated in proyect folder:
 
 `mvn spring-boot:run`

 # Functions avaliable:
 Prior to these actions, initiate an HTTP request to http://[serverIP]:[port]

 - Authenticate using 'username' and 'password':

 --/login?usuario=[username]&contrasena=[password]

 - Access the latest news feed:

 --/noticias

 - Register with 'username', 'email', and 'password':

 --/registro?usuario=[username]&email=[email]&contrasena=[password]

 - Reserve a class with 'username' and 'class_id':

 --/reservas/reservaaula?usuario=[username]&id=[class_id]

 - View reservations for 'username':

 --/verreservas?usuario=[username]

 
![Avaliable functions](/img/imgfunctions.png)
![Example DB information](/img/exampleimagedb.png)