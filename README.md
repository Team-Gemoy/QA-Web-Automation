# QA-Web-Automation

## Java and Maven Configuration:

- **Java Version:**
    - Source and target compatibility set to Java 20.

- **Maven Compiler Plugin:**
    - Version 3.11.0

- **Surefire Plugin:**
    - Version 3.0.0-M5
    - Configured to run TestNG tests specified in the `testng.xml` file.
    - Uses Maven properties, including the suite XML file (`testng.xml`).

## Folder Structure

The folder structure is as following:

    QA-Web-Automation
    ├─ report
    ├─ src
        ├─ main     
            ├─ java
                ├─ factories             # Browser & driver manager
                ├─ helpers               # Java faker & keyword selenium
        ├─ test
             ├─ java
                ├─ features              # Gherkin test cases 
                ├─ pages                 # Page object
                ├─ runners               # Testng runner
                ├─ steps                 # Step definitions
            ├─ resources
    ├─ target                            # Reports are generated in the target/reports directory
    ├─ .gitignore
    ├─ pom.xml
    ├─ README.MD
    ├─ testng.xml