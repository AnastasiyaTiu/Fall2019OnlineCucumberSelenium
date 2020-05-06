package com.vytrack.pages.fleet;

import com.vytrack.pages.AbstractPageBase;
import com.vytrack.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehiclesPage extends com.vytrack.pages.AbstractPageBase {

    @FindBy(partialLinkText = "Create Car")
    private WebElement createCar;

    @FindBy(css = "input[name='custom_entity_type[LicensePlate]']")
    private WebElement licencePlateInput;

    @FindBy(css = "input[name='custom_entity_type[Driver]']")
    private WebElement driverInput;

    @FindBy(css = "input[name='custom_entity_type[Location]']")
    private WebElement locationInput;

    @FindBy(css = "input[name='custom_entity_type[ModelYear]']")
    private WebElement modelYear;

    @FindBy(css = "input[name='custom_entity_type[Color]']")
    private WebElement colorInput;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    private WebElement submit;

    public void setLicencePlateInput(String licencePlate) {
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='custom_entity_type[LicensePlate]']")));
        wait.until(ExpectedConditions.visibilityOf(licencePlateInput));
        licencePlateInput.sendKeys(licencePlate);
    }

    public void setDriverInput(String driver) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='custom_entity_type[Driver]']")));
        wait.until(ExpectedConditions.visibilityOf(driverInput));
        BrowserUtilities.wait(3);
        driverInput.sendKeys(driver);
    }

    public void setLocationInput(String location) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='custom_entity_type[Location]']")));
        wait.until(ExpectedConditions.visibilityOf(locationInput));
        BrowserUtilities.wait(3);
        locationInput.sendKeys(location);
    }

    public void setModelYear(String year) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='custom_entity_type[ModelYear]']")));
        BrowserUtilities.wait(3);
        modelYear.sendKeys(year);
    }

    public void setColor(String color) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='custom_entity_type[Color]']")));
        wait.until(ExpectedConditions.visibilityOf(colorInput));
        BrowserUtilities.wait(3);
        colorInput.sendKeys(color);
    }

    public void submit() {
        submit.click();
    }

    public void clickToCreateCar() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        BrowserUtilities.wait(3);
        wait.until(ExpectedConditions.elementToBeClickable(createCar)).click();
    }

    public String getCarGeneralInfo(String parameter) {
        String xpath = "//label[text()='" + parameter + "']/following-sibling::div/div";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        BrowserUtilities.wait(3);
        return driver.findElement(By.xpath(xpath)).getText().trim();
    }
}