 @login
Feature: Login feature
  Agile Story: As a user, I should be able to login with correct credentials
  to different accounts. And dashboard should be displayed.

  #this is how you comment in feature file

  @librarian @employee @sunday  # we can give any tag name
  Scenario: Librarian login scenario
    Given User is on the login page
    When User logs in as a librarian
    Then User should see dashboard

  @student
  Scenario: Student login scenario
    Given User is on the login page
    When User logs in as a student
    Then User should see dashboard

  @admin @employee @sunday
  Scenario: Admin login scenario
    Given User is on the login page
    When User logs in as an admin
    Then User should see dashboard