# Tradex_Automation_Using_Selenium_Performance_Testing_By_JMeter
### This is a complete project where an [Crypto-currency site](https://exchange-tradex.nftarttoken.xyz/) site is automated by writing test suites using selenium-webdriver and TestNg as testing framework and also perform performance testing (load testing & stress testing) by JMeter.
The following key modules/pages are automated:
- **SignUp** 
- **Login**
- **Logout**
- **Forgot password**
- **Reset password**
- **2FA Security Method Unavailable?**
- **Security Settings**

Key test cases (total **75**) are written & automation performed (total **56**) for each module and test suites created including the positive and negative test cases.
For failed test cases it will take a screenshot aswell at the point of failure. </br>
**The test runner code can be extracted from this:**
[TestRunner](https://github.com/tanvirmitul/Tradex_Automation_Selenium_Performance_Testing_JMeter/tree/main/src/test/java/testrunner)</br>
**The test cases are written following standard test case format in this excel file:**
[Test_cases](https://docs.google.com/spreadsheets/d/1mXh8u5QwzKij1wrGjaf6hGOwgcsra5Zl6mkPvbuaRsY/edit?usp=sharing) </br>
**The checklist are written following standard format in this google docs file:**
[Checklist](https://drive.google.com/file/d/1EfPJvi9S8yPvjQOLY1LoOV2oVSeFKVEZ/view?usp=sharing) </br>
**The documented test plan is written following standard format in this google docs file:**
[Testplan](https://drive.google.com/file/d/15NUeBli3kFdyMXcrnEwzHOivbiq53Y2r/view?usp=sharing) </br>

### Technology: </br>
- Tool: Selenium Webdriver
- IDE: Intellij IDEA
- Build tool: Gradle
- Language: Java
- Testing Framework : TestNG

### Prerequisite: </br>
- Need to install jdk 1.8, gradle and allure
- Configure Environment variable for jdk 1.8, gradle and allure
- Clone this project and unzip it
- Open the project folder
- Double click on "build.gradle" and open it through IntellIJ IDEA
- Let the project build successfully
- Click on "Terminal" and run the automation scripts

### Run the Automation Script by the following command:
 ```
 gradle clean test 
 ```
- Selenium will open the browser and start automating.
- After automation to view allure report , give the following commands:
 ```
allure generate allure-results --clean -o allure-report
allure serve allure-results
 ```

**Here is my allure overview report docs file:** [Test_report](https://drive.google.com/file/d/1OSDWwJMzDtZUMTebgL_trGctwWzHoy8h/view?usp=sharing) </br>

**Below is my overall report:** </br>
![testreportform](https://user-images.githubusercontent.com/59876702/233624074-17f9faf6-8b83-4765-ba88-03370a749cc7.PNG) </br>

![Allure1](https://user-images.githubusercontent.com/59876702/233625095-f2a2d7a9-6031-47f7-8125-08e344f755d3.PNG)  </br>

![Allure2](https://user-images.githubusercontent.com/59876702/233625158-e5b9021d-22aa-4d39-b1a4-842ac5fb530a.PNG)  </br>

![Allure3](https://user-images.githubusercontent.com/59876702/233625207-0a7d8609-d30f-4443-b591-4f5225b20940.PNG)  </br>

![Allure4](https://user-images.githubusercontent.com/59876702/233625237-870643be-1dd3-409d-88bf-f0f2f709e476.PNG)  </br>

![Allure5](https://user-images.githubusercontent.com/59876702/233625281-b5f1c0b5-b005-4710-b6ac-1a2ce14c957e.PNG)  </br>

![Allure7](https://user-images.githubusercontent.com/59876702/233625554-296e7fcb-2bb5-47f7-97e0-c5359bc1522e.PNG)  </br>                            
![Package](https://user-images.githubusercontent.com/59876702/233764027-cb987d80-6476-455b-ad39-a80258e71dd3.PNG)  </br>                            


- **Here is the overall walkthrough of the project:** [Video](https://drive.google.com/file/d/1l_4NF-x4bpDsFrXfGaIwO12qdkuEpN2S/view?usp=sharing) </br>

 
 # Performance testing
 
## **Load testing**

- Find out the actual TPS for if 2000 user can give load within 1 hour **Expected load:** 2000 user, per hour.
- **Actual load:** what TPS? Breakdown the expected TPS in spread sheet and find out the actual TPS.
- For 600, 900s and 1200s load, add Jmeter UI screenshot </br>
- The load testing strategy is written in standard form: </br> </br>
![Load testing strategy](https://user-images.githubusercontent.com/59876702/233617891-ecfdbe85-3c98-47ac-a0ee-0053a4b635b6.PNG) </br>

### **Load_testing Summary Report**
![loadreport1](https://user-images.githubusercontent.com/59876702/233621454-005d8c2b-4f0a-47a3-945e-51864fb43208.PNG) </br>
![loadreport2](https://user-images.githubusercontent.com/59876702/233621585-a3ed9d52-780d-4921-912a-3466063dddae.PNG)  </br>
![loadreport3](https://user-images.githubusercontent.com/59876702/233621664-a3a92309-cea0-4f26-8ba0-a7618518ee67.PNG)  </br>


## **Stress testing**

- Find out that maximum load server can handle.
- **Server capacity:** Constant the time in 600 secs and increases the user apply load untill the error has occured.
- For 600 secs, User: 333, 400, 500, 600 </br>
- The stress testing strategy is written in standard form: </br> </br>
 ![Stresstestingstrategy](https://user-images.githubusercontent.com/59876702/233622464-8afdadc5-4469-41a3-af0c-5e519d1a3180.PNG) </br>

### **Stress_testing Summary Report**
![stressreport1](https://user-images.githubusercontent.com/59876702/233622923-6b754cce-4d91-4d54-a241-167f4d8f5baf.PNG) </br>
![stressreport2](https://user-images.githubusercontent.com/59876702/233623010-d06a3b1a-4fea-4fbc-a73a-74e0adc83617.PNG)  </br>
![stressreport3](https://user-images.githubusercontent.com/59876702/233623098-788eb3a3-8ea5-4b39-8c79-72f590a37016.PNG)  </br>
