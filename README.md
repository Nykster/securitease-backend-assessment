SecuritEase QE Tech Assessment - Back-End Automation

This project contains the automated API tests for the Back-End Automation Task as part of the SecuritEase QE Tech Assessment.

The tests are written in Java and use the Maven build tool, JUnit 5 for the testing framework, REST Assured for API interaction, and the Allure Framework for reporting.



SCENARIOS COVERED

Scenario 1: Schema Validation: Validates that the API response structure conforms to a predefined JSON schema. 

Scenario 2: Confirmation of Countries: Validates the total number of countries returned by the API. 

Scenario 3: Validate Languages: Validates the official languages for a specific country.



TECH STACK
    Language: Java 11

    Build Tool: Maven

    Testing Framework: JUnit 5

    API Automation: REST Assured

    Reporting: Allure Framework

SETUP AND INSTALLATION
PREREQUISITES

The following tools should be installed and configured on your system:

    Java Development Kit (JDK), version 11 or newer

    Apache Maven

    Git

    Allure Commandline


INSTALLATION STEPS

    Clone the Repository:
    Bash

git clone https://github.com/Nykster/securitease-backend-assessment.git
cd <repository-directory>

Maven will handle dependencies automatically when you run the test command for the first time.



RUNNING THE TEST AND TEST REPORT GENERATION

Allure Framework to generate an interactive HTML report.

1. Run the Tests: This command executes the JUnit tests and generates the raw data for the Allure report.

    mvn test

2. Generate and View the Report: This command processes the raw data and opens the HTML report in your web browser.

    mvn allure:serve

NOTES AND FINDINGS

Scenario 2 Discrepancy (Country Count)

    Requirement: Confirm there are 195 countries in the world. 

    Reality: The restcountries.com API returns 250 entries (all territories).

    Action: The automated tests assert actual API behaviour which is 250 countries. The test validates the current state of the system whilst acknowledging the different requirement. 

Scenario 3 Discrepancy (Language Validation)

    Requirement: Validate that SASL (South African Sign Language) is listed as an official language of South Africa. 

    Reality: My automated shows that SASL is not present in the list of languages returned by the API for South Africa.

    Action: The test for this scenario is designed to fail as expected. This test failure is correct and shows that the API does not currently meet the specified requirement.