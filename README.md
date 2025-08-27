SecuritEase QE Tech Assessment - Back-End Automation

This project contains the automated API tests for the Back-End Automation Task as part of the SecuritEase QE Tech Assessment. The primary goal is to demonstrate best practices in API test automation, including schema validation, data validation, robust test design, and professional reporting.

The tests are written in Java and use the Maven build tool, JUnit 5 for the testing framework, REST Assured for API interaction, and the Allure Framework for reporting.



Scenarios Covered

This project automates the three back-end scenarios for the restcountries.com API:

Scenario 1: Schema Validation: Validates that the API response structure conforms to a predefined JSON schema. 

Scenario 2: Confirmation of Countries: Validates the total number of countries returned by the API. 

Scenario 3: Validate Languages: Validates the official languages for a specific country.



Tech Stack

    Language: Java 11

    Build Tool: Maven

    Testing Framework: JUnit 5

    API Automation: REST Assured

    Reporting: Allure Framework

Setup and Installation

Prerequisites

Before running the project, please ensure the following tools are installed and configured on your system:

    Java Development Kit (JDK), version 11 or newer

    Apache Maven

    Git

    Allure Commandline



    Certainly. Here is a complete README.md file for your back-end automation project, based on the structure we discussed. You can copy and paste this content directly into your README.md file on GitHub.

SecuritEase QE Tech Assessment - Back-End Automation

This project contains the automated API tests for the Back-End Automation Task as part of the SecuritEase QE Tech Assessment. The primary goal is to demonstrate best practices in API test automation, including schema validation, data validation, robust test design, and professional reporting.

The tests are written in Java and use the Maven build tool, JUnit 5 for the testing framework, REST Assured for API interaction, and the Allure Framework for reporting.

✅ Scenarios Covered

This project automates the three back-end scenarios for the restcountries.com API:

    Scenario 1: Schema Validation: Validates that the API response structure conforms to a predefined JSON schema. 

Scenario 2: Confirmation of Countries: Validates the total number of countries returned by the API. 

Scenario 3: Validate Languages: Validates the official languages for a specific country. 

🛠️ Tech Stack

    Language: Java 11

    Build Tool: Maven

    Testing Framework: JUnit 5

    API Automation: REST Assured

    Reporting: Allure Framework

🚀 Setup and Installation

Prerequisites

Before running the project, please ensure the following tools are installed and configured on your system:

    Java Development Kit (JDK), version 11 or newer

    Apache Maven

    Git

    Allure Commandline

Installation Steps

    Clone the Repository:
    Bash

git clone <repository-url>
cd <repository-directory>

Install Dependencies: Maven will handle this automatically when you run the test command for the first time.



Running the Tests and Generating the Report

This project uses the Allure Framework to generate an interactive HTML report.

1. Run the Tests: This command executes the JUnit tests and generates the raw data for the Allure report.

    mvn test

2. Generate and View the Report: This command processes the raw data and opens the HTML report in your web browser.

    mvn allure:serve



Notes and Findings

This section documents key findings and design decisions made during the implementation of the tests.

Scenario 2 Discrepancy (Country Count)

    Requirement: The assessment user story was to confirm that there are 195 countries in the world. 

    Finding: The restcountries.com API actually returns 250 entries, as it includes various non-sovereign territories and regions.

    Action: The automated test was written to assert against the actual API behavior (250). This ensures the test accurately validates the current state of the system while acknowledging the discrepancy with the requirement.

Scenario 3 Discrepancy (Language Validation)

    Requirement: The assessment user story was to validate that South African Sign Language is listed as an official language of South Africa. 

Finding: Manual and automated validation confirmed that "South African Sign Language" is not present in the list of languages returned by the API for South Africa.

Action: The test for this scenario is designed to fail as expected. This test failure correctly proves that the API does not currently meet the specified requirement.