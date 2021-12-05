# KriegerDigital_Automation

Maven (For managing dependencies) IntelliJ or Eclipse Installation
Install from git (using git clone) Run "mvn clean test" from project directory

Setup automation project
*. Checkout the project

*. Download and install JDK 1.8.

*. Add the environment paths

Type defaults write com.apple.finder AppleShowAllFiles YES in terminal to view hidden files

Alt+Right click on finder and click relaunch to activate changes

Navigate to your user's directory

If you don't have a .bash_profile file, you can create one by following these steps: Start up Terminal Type cd ~/ to go to your home folder Type touch .bash_profile to create your new file. Edit .bash_profile with your favorite editor (or you can just type open -e .bash_profile to open it in TextEdit.

Add the following to the bash_profile: export JAVA_HOME=/Library/Java/JavaVirtualMachines/{jdk version}/Contents/Home/ export PATH=${JAVA_HOME}/bin:$PATH

*. Import the project in Eclipse/IntelliJ IDEA (using import from external model Gradle) and do a Gradle sync

*. Install Cucumber for Java plugin on the IDE(Eclipse/IntelliJ) From the menu, select Eclipse IDEA -> Go to Help Click on the eclipse marketplace Search Cucumber and then Select Cucumber for Java and click install You will have to restart Eclipse

From the menu, select IntelliJ IDEA -> Preferences Go to Plugins Click Install JetBrains plugins Select Cucumber for Java and click install You will have to restart IntelliJ


*. Run tests

Right-click on a test src\test\java\StepDefinitions\FunctionalTest.java file and select Run As cucumber or click on the TestRuner class and Run as TestNG


Note:
I used the "Thread.sleep" on my code for better visibility of actions of any steps(I always use the implicit and explicit wait on selenium).

Maven & Jenkins Integration with Selenium: 
Steps to install Maven and use it with TestNG Selenium
For this tutorial, we will use Eclipse (Juno) IDE for Java Developers to set up Selenium WebDriver Project. Additionally, we need add m2eclipse plugin to Eclipse to facilitate the build process and create pom.xml file.
Let’s add m2eclipse plugin to Eclipse with following steps:

Steps to Install Jenkins and configure it to Run Maven with TestNg Selenium
Installation

Step 1) Go to http://jenkins-ci.org/and download correct package for your OS. Install Jenkins.

Step 2) Unzip Jenkins to specified folder. Run exe file

Step 3) In Jenkins Setup window click on Next button.

Step 4) Click on Install button in the end.

Step 5) Once installation is done, navigate to the Jenkins Dashboard (http://localhost:8080 by default) in the browser window.

Step 6) Click on the New Item link to create a CI job.

Step 7) Select the Maven project radio button as shown in the following screenshot:

Using the Build a Maven Project option, Jenkins supports building and testing Maven projects.

Step 8) Click on OK button. A new job with name “WebdriverTest” is created in Jenkins Dashboard.

Step 9) Go to Manage Jenkins => Configure System 

Click on JDK installations and configure JDK

Step 10) Go to the Build section of new job.

In the Root POM textbox, enter full path to pom.xml

In Goals and options section, enter “clean test”

Step 11) Click on Apply button.

Step 12) On the WebdriverTest project page, click on the Build Now link.

Maven will build the project. It will then have TestNG execute the test cases.

Step 13) Once the build process is completed, in Jenkins Dashboard click on the WebdriverTest project

Step 14) The WebdriverTest project page displays the build history and links to the results

Step 15) Click on the “Latest Test Result” link to view the test results as shown

Step 16) Select specific build, and you will see the current status by clicking on “console output“.

![image](https://user-images.githubusercontent.com/72441279/144740502-7ff596c3-2b9a-4b9a-a8e8-2d6b8207e7b5.png)

Scheduling Jenkins for automatic execution.

Scheduling builds(Selenium Tests) is one of the important features of Jenkins where it automatically triggers the build, based on defined criteria. Jenkins provides multiple ways to trigger the build process under the Build Trigger configuration.

For example:
Enter 0 23 * * * in the Schedule textbox as shown in the following screenshot. This will trigger the build process every day at 11 p.m.
![image](https://user-images.githubusercontent.com/72441279/144740510-c803c41d-2e6f-435e-aa03-c91eb94c3269.png)

Using Jenkings without Maven
To run pure TestNg script in Jenkins, enter the following in build

D:>java -cp “Pathtolibfolder\lib\*;Pathtobinfolder\bin” org.testng.TestNG testng.xml
![image](https://user-images.githubusercontent.com/72441279/144740519-52d1506d-fc15-485a-80b1-d1151a1a4218.png)

Click on Save button.

Note: The actual path of lib and bin folder need to add in above command.

After saving the command, Jenkins will build project in predefined time, and this command will be run using TestNG.

Result will be stored in custom report HTML file that can be sent via email with a Jenkin configuration

Output of the code will be
![image](https://user-images.githubusercontent.com/72441279/144740527-17c98f5a-838a-43e4-8885-1840999184ef.png)

https://www.softwaretestinghelp.com/integration-of-jenkins-with-selenium-webdriver/
