@SANITY
Feature: Testing different requests on student application
 

  @SMOKE
  Scenario: Check if the student application can be access by users
  Given User sends a GET request to the list endpoint, they must get back a valid status code 200
  
  @REGRESSION
  Scenario Outline: Create a new student and varify if the student is added
  Given User create a student by providing the information firstName <firstName> lastName <lastName> email <email> programme <programme> courses <courses>
  Then User varify that the student with <email> is created
  
  Examples:
  |firstName |lastName |email           |programme       |courses|
  |Mir       |Mamun    |mir14@gmail.com |Computer Science|Java   |
  |Mir1      |Mamun1   |1mir14@gmail.com|Computer Science|Java   |