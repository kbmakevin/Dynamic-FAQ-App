Dynamic FAQ Application
---
This is the assignment 3 submission for COMP303 by Group KOPS.
Group Members:
	Kevin Ma				300867968
	Ostap Hamarnyk			300836326
	Poulad Ashraf Pour		300858337
	Suthas Ganeshathasan	300838430
---

Using a JSP page, MVC architecture, Servlets, JPA, EL, and JPQL, this application obtains the information to create a dynamic FAQ web page from a local MySQL database that consists of Topics and FAQ tables.

The user is able to execute case-insensitive searches for topic names and is displayed questions and answers from the local MySQL database whose topic matches the queried topic name.

How to compile/run the application:
---

1. Open MySQL Workbench
2. Open the "init.sql" file inside of your MySQL Workbench
3. Run the "init.sql" script
4. Open Eclipse and start your WildFly (JBoss) server.
5. Open your favorite browser and navigate to http://localhost:9990 to enter the management console for your WildFly server
6. Click on "Start" beside "Create a Datasource" under the "Configuration" section
7. Click on "Subsystems > Datasources > Non-XA > Add"
8. Select "MySQL Datasource"
9. Enter Datasource Attributes Name: FaqDS and JNDI Name: java:/jndi/faq 
10. Click on Detected Driver and select "mysql"
11. Enter in the appropiate connection settings. Change these to match your own settings!!!
	e.g. Connection URL: jdbc:mysql://localhost:3306/faq_db
		 Username: root
		 Password: password
12. Click through remaining settings to finish creating data source, test connection and reload the server.
13. Go back to eclipse and import the EAR file included in this zip file into Eclipse.
14. Deploy the application and run it on your WildFly server.
15. Open your favorite browser and navigate to http://localhost:8080/GroupKOPS_COMP303_Assignment3_Web/
