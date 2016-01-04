Here is the documentation about the automated test cases

Step 1:

> Create an automated test which
Opens http://www.imdb.com
Search for "Star Wars: Episode I"
Go to list of cast and crews
Check if Jim Morris has a special thanks

This has been written in Selenium and Junit

1. PureSeleniumTest is the one which is the automated test and can be executed by adding to the eclipse project and junit library.

Step 2 , 3 and 4

> Create a user story in BDD format, use jbehave & selenium to run the test.
> Test should run standalone using maven
> Share the code in a public repository

I have choosen the same above scenario to automate using Jbehave, Selenium and Maven. 
To execute the test case standalone using maven please follow the below steps.
 
1. Download and install java jdk
2. Set environment variable JAVA_HOME
3. Download and install apache maven
4. Set MAVEN_HOME , add MAVEN_HOME/bin to the PATH environment variable
5. Unzip the DomainTest.zip (Please rename it to .zip . It might have .txt extension due to the security reasons over email transfer)
6. Open command prompt, Go to unzip location -> then DomainTest folder (where pom.xml exists)

7. The project can then be build issuing the following command:

mvn compile

8. The required style-files for the reporting can be downloaded using this command (required only once):

mvn generate-resources

9. Afterwards the tests can be executed using this command:

mvn integration-test

Note: Commands must be executed from the project directory that is also containing the pom.xml-file.

 
9. The story report html file exists in the 

target/jbehave/view/com.imdb.jbehave.i_m_d_b_scenarios.html

10. Attached the output.html is the report generated after the execution.

11. The story file contains two scenarios one is the positive scenario and other one is negative scenario which will make assertion failure.