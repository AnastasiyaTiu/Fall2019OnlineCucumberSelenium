
  Feature: View all calendar events
    As a user, I want to be able to see all calendar events as a table

    Scenario: User permissions
      Given user is on the login page
      When user navigates to "Activities" and "Calendar Events"
      Then View Per Page menu should have following options
        | 10  |
        | 20  |
        | 50  |
        | 100 |