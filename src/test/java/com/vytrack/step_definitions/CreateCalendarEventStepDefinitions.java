package com.vytrack.step_definitions;

import com.vytrack.pages.activities.CalendarsEventsPage;
import io.cucumber.java.en.Then;

public class CreateCalendarEventStepDefinitions {

    CalendarsEventsPage calendarsEventsPage = new CalendarsEventsPage();

    @Then("user clicks on create calendar event button")
    public void user_clicks_on_create_calendar_event_button() {
        System.out.println("User clicks on create calendar event button");
        calendarsEventsPage.clickToCreateCalendarEvent();
    }

    @Then("user enters {string} as title")
    public void user_enters_as_title(String string) {
        System.out.println("User enters title: " + string);
        calendarsEventsPage.enterCalenderEventTitle(string);
    }

    @Then("user enters {string} as description")
    public void user_enters_as_description(String string) {
        System.out.println("User enters description: " + string);
      calendarsEventsPage.enterCalenderEventDescription(string);
    }

    @Then("user clicks on save and close button")
    public void user_clicks_on_save_and_close_button() {
        System.out.println("User click on save and close button");
        calendarsEventsPage.clickOnSaveAndClose();
    }


}
