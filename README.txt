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

Initializing the Database
-
1. Open MySQL Workbench
2. Open the "init.sql" file inside of your MySQL Workbench
3. Run the "init.sql" script

Configuring JBOSS WildFly Application Server for MySQL DB Server 
You must configure a Wildfly module for MySQL in order to connect to MySQL databases through connections managed by the JEE application server.

***Please adjust the below install directory and verrsions to match those appropiate to your machine!

Define a new module for WildFly
-
4. In the WildFly install directory "...\wildfly-11.0.0.Final", locate and open subdirectory "modules\system\layers\base\com"
5. Copy the "mysql-connector-java-5.1.40-bin.jar" into the "com\mysql\driver\main" directory. Create this path and directory if it does not exist.
6. Make sure the directory "\wildfly-11.0.0.Final\modules\system\layers\base\com\mysql\driver\main\" contains two files:
	a. "mysql-connector-java-5.1.40-bin.jar"
	b. "module.xml"
7. Create module.xml if it does not exist. Modify its contents to the following:
	<?xml version="1.0" encoding="UTF-8"?>
	<module xmlns="urn:jboss:module:1.3" name="com.mysql.driver">
		<resources>
			<resource-root path="mysql-connector-java-5.1.40-bin.jar"/>
		</resources>
		<dependencies>
			<module name="javax.api"/>
			<module name="javax.transaction.api"/>
		</dependencies>
	</module>
8. Navigate to your "\wildfly-11.0.0.Final\standalone\configuration" directory and modify the "standalone.xml" file:
	Add a new driver under <drivers> for mysql:
	e.g.
		<drivers>
			<driver name="h2" module="com.h2database.h2">
				<xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
			</driver>
			<driver name="mysql" module="com.mysql.driver">
				<driver-class>com.mysql.jdbc.Driver</driver-class>
			</driver>
		</drivers>

Add a new Data Source using WildFly Console
-
9. Open Eclipse and start your WildFly (JBoss) server.
10. Open your favorite browser and navigate to http://localhost:9990 to enter the management console for your WildFly server
11. Click on "Start" beside "Create a Datasource" under the "Configuration" section
12. Click on "Subsystems > Datasources > Non-XA > Add"
13. Select "MySQL Datasource"
14. Enter Datasource Attributes Name: FaqDS and JNDI Name: java:/jndi/faq 
15. Click on Detected Driver and select "mysql"
16. Enter in the appropiate connection settings. Change these to match your own settings!!!
	e.g. Connection URL: jdbc:mysql://localhost:3306/faq_db
		 Username: root
		 Password: password
17. Click through remaining settings to finish creating data source, test connection and reload the server.

Import EAR into Eclipse and executing Project
-
18. Go back to eclipse and import the EAR file included in this zip file into Eclipse.
19. When importing the EAR, click next and select GroupKOPS_COMP303_Assignment3_JPA to not import it as an utility project.
20. Right click on "GroupKOPS_COMP303_Assignment3_JPA", go into Properties > Project Facets and make sure the Java version is using 1.8
21. Right click on "GroupKOPS_COMP303_Assignment3_Web", go into Properties > Project Facets and make sure the Java version is using 1.8
22. Deploy the application and run it on your WildFly server.
23. Open your favorite browser and navigate to http://localhost:8080/GroupKOPS_COMP303_Assignment3_Web/
