package com.vytrack.step_definitions;

import com.vytrack.pages.activities.CalendarsEventsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

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

    @Then("user verifies that description of new calendar event is {string}")
    public void user_verifies_that_description_of_new_calendar_event_is(String string) {
        Assert.assertEquals(string, calendarsEventsPage.getGeneralInfoDescriptionText());
    }

    @Then("user verifies that title of new calendar event is {string}")
    public void user_verifies_that_title_of_new_calendar_event_is(String string) {
        Assert.assertEquals(string, calendarsEventsPage.getGeneralInfoTitleText());
    }

//    And user enters new calendar event information:
//            | description | On this meeting we discuss what went well, what went wrong and what can be improved |
//            |  title      | Sprint Retrospective                                                                |

    @Then("user enters new calendar event information:")
    public void user_enters_new_calendar_event_information(Map<String, String> dataTable) {
        calendarsEventsPage.enterCalenderEventDescription(dataTable.get("description"));
        calendarsEventsPage.enterCalenderEventTitle(dataTable.get("title"));
    }

    @Then("user verifies new calendar event was created successfully")
    public void user_verifies_new_calendar_event_was_created_successfully(Map<String, String> dataTable) {
        Assert.assertEquals(dataTable.get("description"), calendarsEventsPage.getGeneralInfoDescriptionText());
        Assert.assertEquals(dataTable.get("title"), calendarsEventsPage.getGeneralInfoTitleText());
    }

}
