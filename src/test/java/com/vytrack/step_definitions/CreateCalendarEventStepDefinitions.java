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

}
