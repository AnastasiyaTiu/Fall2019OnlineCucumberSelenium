@activities
Feature: Create Calendar event
  As user, I want to be able to create calendar events.

  Scenario: Create calendar event as sales manager
    Given user is on the login page
    When user logs in as a sales manager
    And user navigates to "Activities" and "Calendar Events"
    Then user clicks on create calendar event button
    And user enters "Sprint Retrospective" as title
    And user enters "on this meeting we discuss what went well, what went wrong and what can be improved" as description
    Then user clicks on save and close button