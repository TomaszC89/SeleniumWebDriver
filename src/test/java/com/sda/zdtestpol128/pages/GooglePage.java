package com.sda.zdtestpol128.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GooglePage extends BasePage {

    private final String GOOGLE_URL = "https://www.google.com/";

    @FindBy(how = How.ID, using = "L2AGLb")
    WebElement acceptAllButton;

    @FindBy(how = How.NAME, using = "q")
    WebElement searchField;

    @FindBy(how = How.ID, using = "rcnt")
    WebElement searchResults;

    @FindBy(how = How.XPATH, using = "//*[@role='listbox']")
    WebElement searchListBox;

    public void openGooglePage() {
        driver.get(GOOGLE_URL);
    }

    public void clickAcceptAllButton() {
        acceptAllButton.click();
    }

    public void searchForPhrase(String searchPhrase) {
        searchField.clear();
        searchField.sendKeys(searchPhrase);
//        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(searchListBox));
        clickEnterKey();
    }

    public void verifyThatSearchResultsAreVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(searchResults));
    }

    public void clickEnterKey() {
        searchField.sendKeys(Keys.ENTER);
    }

    public boolean isSearchResultsVisible() {
        List<WebElement> searchResults = driver.findElements(By.id("rcnt"));
        return searchResults.size() > 0;
    }

}
