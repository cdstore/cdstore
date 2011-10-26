CSI5380: Systems and Architectures for Electronic Commerce
Project Part 1: “DreamTeam” CD Store – README

Daniel Antwi
Khaled El Ghayesh
Elena Ciobanu
Cristian Gadea

October 2011


===== Building & Deploying CDStore on Windows (no Eclipse required) =====

1. Tomcat
- Download & unzip tomcat (ex: http://apache.mirror.iweb.ca/tomcat/tomcat-7/v7.0.22/bin/apache-tomcat-7.0.22.zip )
- Set TOMCAT_HOME to the root of the tomcat server (ex: J:\work\apache-tomcat-7.0.22) (this is needed because Tomcat's servlet libraries are required by ant to build the code - in the future we will ideally auto-deploy the jars/wars to the correct folder relative to TOMCAT_HOME through ant, but for debugging it's better to deploy wars manually while watching the server log)
- set up SSL as follows:
	- run the following from command line while in a folder that has write access (PATH environment variable must contain JRE or JDK bin folder):
	keytool -genkeypair -keyalg RSA -alias tomcat -keystore keystore.jks  -validity 999 -keysize 512
	- enter the password 'asdasd' (you *must* use this password since it is in the code for accessing SSL-based Web Services)
	- re-enter the password 'asdasd' 
	- for "First and last name" enter 'localhost'
	- for "Organizational unit" enter 'SITE'
	- for "Name of organization" enter  'University of Ottawa'
	- for "City or locality" enter 'Ottawa'
	- for "State or province" enter 'ON'
	- for "Two letter country code" enter 'CA'
	- enter 'Yes' to confirm the information
	- press RETURN when asked to enter the password again
	- move the generated keystore.jks file into yout TOMCAT_HOME/conf folder and modify your TOMCAT_HOME/conf/server.xml file to replace the following commented xml section:
	<!--
	  <Connector port="8443" protocol="HTTP/1.1" SSLEnabled="true"
		   maxThreads="150" scheme="https" secure="true"
		   clientAuth="false" sslProtocol="TLS" />
	-->
	with the following uncommented XML section:
	    <Connector port="8443" protocol="HTTP/1.1" SSLEnabled="true"
		       maxThreads="150" scheme="https" secure="true"
		       clientAuth="false" sslProtocol="TLS" keystoreFile="conf\keystore.jks"
		       keystorePass="asdasd" />
	- if you run Tomcat and you receive a "SSLCertificateFile must be defined when using SSL with APR" exception, comment out the following line near the top of server.xml:
	<Listener className="org.apache.catalina.core.AprLifecycleListener" SSLEngine="on" />
	
2. Ant
- Download & unzip ant (ex: http://apache.parentingamerica.com//ant/binaries/apache-ant-1.8.2-bin.zip )
- Add the ant 'bin' folder to PATH (ex: C:\Program Files\apache-ant-1.8.2\bin) so that you can run 'ant' from command line
- As required by ant, set your JAVA_HOME environment variable to your JDK (ex: C:\Program Files\Java\jdk1.7.0)

3. MySQL
- Install mysql with TCP/IP support and such that you can type 'mysql' at command line (if the installer didn't do it, ensure PATH contains "C:\Program Files\MySQL\MySQL Server 5.5\bin" or similar)
- Run 'mysql -u root -p' from command line (if first run, press enter for the password)
- Set the 'root' user password to 'asdasd' by entering the following two lines:
UPDATE mysql.user SET Password=PASSWORD('asdasd') WHERE User='root';
flush privileges;
- To insert the sample data, run the following from command line (using the correct path to the provided cdstore.sql) and enter the password:
mysql -u root -p < C:\cdstore.sql

4. Build & Deploy
- see "Third-Party Dependencies" section below and complete all steps
- ensure Tomcat is not already started
- Use command line to browse to the 'Utilities' folder and enter 'ant'
- copy the Utilities.jar file from the 'CDStore\antbuild' folder into '%TOMCAT_HOME%\lib'
- Use command line to browse to the 'CatalogService' folder and enter 'ant'
- Copy the CatalogService.war file from the 'CatalogService\antbuild' folder into '%TOMCAT_HOME%\webapps'
- Use command line to browse to the 'OrderService' folder and enter 'ant'
- Copy the OrderService.war file from the 'OrderService\antbuild' folder into '%TOMCAT_HOME%\webapps'
- Use command line to browse to the 'CDStore' folder and enter 'ant'
- Copy the CDStore.war file from the 'CDStore\antbuild' folder into '%TOMCAT_HOME%\webapps'

5. Run
- Start Tomcat by running %TOMCAT_HOME%\bin\startup.bat
- Browse to https://localhost:8443/CDStore/


===== Additional Notes for Developers =====
- Ensure you have TOMCAT_HOME set, JAVA_HOME set to v1.7, MySQL etc. set up as per instructions above
- Download & unzip Eclipse Indigo 3.7.1 (ex: http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/indigo/SR1/eclipse-jee-indigo-SR1-win32.zip&url=http://mirror.csclub.uwaterloo.ca/eclipse/technology/epp/downloads/release/indigo/SR1/eclipse-jee-indigo-SR1-win32.zip&mirror_id=492 )
- From the "Project" menu, make sure "Build Automatically" is unchecked since we will be using ant to build
- File > Import > Existing Projects Into Workspace
- Provide the location of the 'cdstoreproject' folder obtained from git as the 'root directory' to import from (five projects should appear for import)
- Once imported, right click on build.xml from CDStore (for example) and select Run As > Ant Build to create CDStore.war in the 'antbuild' folder
- While ant should work fine, Eclipse will show errors in the project because it doesn't know where Tomcat's servlet libraries are, so add Tomcat to Elipse (Servers tab at the bottom > right click in white area > New > Server > Apache Tomcat v7 > Next > Browse... > Select your Tomcat folder > Finish)
- the keystore.jks was generated using the following command line, password 'asdasd', and other information as per the table on http://www.site.uottawa.ca/~lpeyton/csi5389ssl.html:
keytool -genkeypair -keyalg RSA -alias tomcat -keystore keystore.jks  -validity 999 -keysize 512
- for client-side debugging with Eclipse when Tomcat is started in a separate process:
	- start tomcat using the following (instead of the usual startup.bat):
	catalina jpda start
	(this way it will open port 8000 for Eclipse to connect to)
	- from Eclipse, Run > Debug Configuration, double click "Remote Java Application" on the right side to create a new profile (it should already have localhost/8000 as the defaults) and give it a name at the top
	- start browsing the CDStore jsps to create a session on the server
	- click the bug icon in Eclipse and select the debug profile name you entered before and provide eclipse with the location of the source files by adding the projects


===== Included Files =====

This assignment submission (csi5380part1dreamteam.zip) consists of:
- this README.txt
- DesignDocumentation.pdf
- test data (cdstore.sql)
- context.xml for defining the connection pool for Tomcat
- "cdstoreproject" folder containing the source code and build scripts for the different components
- "testscripts" folder containing unit tests and expected test results


===== Project Files =====

Identifying the source code locations:

= DBAgent Project =

In DBAgent/src as part of com.cdstore.dbagent:
	- DBAgent.java

In DBAgent/src 
	- queries.properties

= Utilities Project =

In Utilities/src as part of com.cdstore.entities:
	- Account.java
	- Address.java
	- Category.java
	- CD.java
	- Order.java
	- OrderDetails.java

In Utilities/src as part of com.cdstore.shoppingcart:
	- ShoppingCart.java
	- ShoppingCartItem.java

= CatalogService Project =
	- In CatalogService/src as part of com.cdstore.catalogservice:
	- ProductCatalog.java
	- ProductCatalogImpl.java

In CatalogService/WebContent/WEB-INF:
	- sun-jaxws.xml
	- web.xml

= OrderService Project = 

In OrderService/src as part of com.cdstore.orderprocess:
	- OrderProcess.java
	- OrderProcessImpl.java

In OrderService/WebContent/WEB-INF:
	- sun-jaxws.xml
	- web.xml

= CDStore Project =

In CDStore/src as part of com.cdstore.beans
	- CDStoreBean.java
	- OrderBean.java

In CDStore/src as part of com.cdstore.catalogservice:
	- ProductCatalog.java
	- ProductCatalogServiceClient.java

In CDStore/src as part of com.cdstore.controller
	- SessionController.java

In CDStore/src as part of com.cdstore.filter
	- SessionController.java

In CDStore/src as part of com.cdstore.orderservice
	- OrderProcess.java
	- OrderProcessServiceClient.java

In CDStore/src as part of com.cdstore.orderservice
	- navigation.properties

In CDStore/WebContent/css:
	- style.css

In CDStore/WebContent/jspf:
	- footer.jspf
	- header.jspf

In CDStore/WebContent/view:
	- cart.jsp
	- cdstore.jsp
	- checkout.jsp
	- resultpage.jsp

In CDStore/WebContent/WEB-INF:
	- web.xml

In CDStore/WebContent:
	- creataccount.jsp
	- createaccountaction.jsp
	- index.jsp
	- loginaction.jsp

Descriptions of all files are available in the included design document.


===== Third-Party Dependencies =====

In addition to the above, the following external libraries (JARs) are used in this project and are required for building or at runtime:

- JAX-WS Reference Implementation
	- Download the latest distribution from http://jax-ws.java.net/ (ex: http://jax-ws.java.net/2.2.5/JAXWS2.2.5-20110729.zip )
	- From the jaxws-ri/lib folder within the zip, copy the following JARs to your TOMCAT_HOME/lib:
		- ha-api.jar
		- jaxb-impl.jar
		- jaxws-api.jar
		- jaxws-rt.jar
		- gmbal-api-only.jar
		- management-api.jar
		- stax-ex.jar
		- streambuffer.jar
		- policy.jar

- MySQL Connector/J 5.1.18
	- download via http://dev.mysql.com/downloads/connector/j/ (ex: ftp://mirror.csclub.uwaterloo.ca/mysql/Downloads/Connector-J/mysql-connector-java-5.1.17.zip )
	- copy mysql-connector-java-5.1.17-bin.jar from the root of the zip to cdstoreproject/DBAgent/lib

- Apache TagLibs 1.1.2
	- download via http://archive.apache.org/dist/jakarta/taglibs/standard/binaries/jakarta-taglibs-standard-1.1.2.zip
	- copy the two jars from the /lib folder in the zip (jstl-impl-1.2.jar and jstl-api-1.2.jar) to the cdstoreproject/CDStore/WebContent/WEB-INF/lib folder


===== Identification of Other Code Used in this Project =====
- The JAX-WS code used is based on the "Hello World" example provided by Mkyong at http://www.mkyong.com/webservices/jax-ws/deploy-jax-ws-web-services-on-tomcat/
- The CDStore project contains concepts and sample code from http://netbeans.org/kb/docs/javaee/ecommerce/page-views-controller.html (Oracle Corporation) that illustrate MVC separation with servlets and a shopping cart  


===== Running the Test Scripts/Driver =====
- Browse to https://localhost:8443/CDStore/
- Import the project in Eclipse
- download JWebUnit 3.0 http://sourceforge.net/projects/jwebunit/files/
- add the jars from the zip file to the Eclipse project (right click the project, select properties in the libraries tab add external jars)
- run the test project (it should run as a junit test case)
- the provided "testscripts" folder contains a screenshot.jpg of what should be obtained (all tests passing)
- the provided "testscripts" folder also contains TestCaseDocumentation.docx with the expected results and logs


===== List of Member Contributions =====
Daniel Antwi - DBAgent, SessionController
Khaled El Ghayesh - Web Services, Documentation
Elena Ciobanu - DB Schema, Unit Tests
Cristian Gadea - JSP/Servlets, Documentation