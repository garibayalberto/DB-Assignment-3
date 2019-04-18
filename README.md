# DB-Assignment-3
# Assignment3 Normalized Database with Fake Data
* Name: Alfonso Castanos, Alberto Garibay, & Kolby Ramirez
* SID: 2283681, 2271460, 2277817
* Class: CPSC 408-01 (Professor Rene)

## Program Description
This Assignment is based off the beginning stages of our final project. However, although this project is based off the idea of using fake data using python, this program is able to correctly organize a flat excel sheet into the correct normalized database:
* Python Faker  
    1) Input the within the command line python FakerData.py [insert name of file] [number of rows] to generate the a csv file with all the columns of our excel sheet. 
    2) Use that csv file that you were able to create within the this file and use it within the java program, which can be specifically found in the CSVFileReader.java. 
    3) In addition, before you begin the java scripts you must go into data grip when you are able to create the server and create the four different tables of the normalized database, which can be found in the Datagrip.txt. 
* Java
    1) After downloading the java files, a pre-made csv file has been provided to test the csv file reader. Or you can provide your own self generated csv file using the python program above. 
    2) Running Main creates an instance of file csvreader and the database.
    3) Connects to the database and runs the csv file in the csvFileReader, prints out connecting to database and after it normalizes the database and attributes are added into the appropriate tables. Once done it closes the connection and program ends.

## Program Overview:
* CPSC 408 - Assignment 3
* Spring 2019
* Develop the following Applications/Database.
1) Create and design a normalized database Schema. This database should consist of at least 5 tanles in 3NF. 
2) Once you have completed your database schema, develop a utility/tool that generates data (not normalized,
flat file) and exports it to a csv text file. This data will be used to populate the tables
in your normalized database. Your data generation tool should take as a command line parameter
the file name to be created and the number tuples to be generated.

        a) There are plenty of data generation libraries available, but a popular one is Faker for php. 
        This will require a concerted effort, if you don't know php, but there are others similar to Faker
        for python and Java. Having said that, it is up to you how you will generate your data.
3) Last but not least, develop an application that imports your unstructured data from your csv text file
into your normalized database.

## Deliverables:
* Submit your commented source code README etc. to your GitHub repository and provide the link in Blackboard.
The README should include any special instructions for running.

## Grading:
* Your  program will be evaluted for correctness and elegance. Make sure you code includes methods and good 
naming conventions. Use all the good practice methods you have learned throughout the semseter. 
