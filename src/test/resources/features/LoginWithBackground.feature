@loginWithBackground
Feature: Login feature
  Agile Story: As a user, I should be able to login with correct credentials
  to different accounts. And dashboard should be displayed.


 Background: User is on the login page
   Given User is on the login page

  Scenario: Librarian login scenario
    When User logs in as a librarian
    Then User should see dashboard


  Scenario: Student login scenario
    When User logs in as a student
    Then User should see dashboard


  @db
  Scenario: Admin login scenario
    When User logs in as an admin
    Then User should see dashboard