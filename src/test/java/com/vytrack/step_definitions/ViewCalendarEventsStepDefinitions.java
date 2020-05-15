package com.vytrack.step_definitions;

import com.vytrack.pages.activities.CalendarsEventsPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;

public class ViewCalendarEventsStepDefinitions {

    CalendarsEventsPage calendarsEventsPage = new CalendarsEventsPage();

    @Then("View Per Page menu should have following options")
    public void view_Per_Page_menu_should_have_following_options(List<String> dataTable) {
        System.out.println("Expected values: " + dataTable);
        Assert.assertEquals(dataTable, calendarsEventsPage.getViewPerPageOptions());

    }


}
