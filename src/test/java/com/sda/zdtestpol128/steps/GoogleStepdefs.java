package com.sda.zdtestpol128.steps;

import com.sda.zdtestpol128.pages.GooglePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;

public class GoogleStepdefs {

    GooglePage googlePage = new GooglePage();

    @Given("Google page is opened")
    public void googlePageIsOpened() {
        googlePage.openGooglePage();
    }

    @When("I click Accept All button")
    public void iClickAcceptAllButton() {
        googlePage.clickAcceptAllButton();
    }

    @And("I search for {string} in search bar")
    public void iSearchForInSearchBar(String searchPhrase) {
        googlePage.searchForPhrase(searchPhrase);
    }

    @Then("I see search results")
    public void iSeeSearchResults() {
        googlePage.verifyThatSearchResultsAreVisible();
    }

    @And("I click Enter in search bar")
    public void iClickEnterInSearchBar() {
        googlePage.clickEnterKey();
    }

    @Then("I don't see search results")
    public void iDonTSeeSearchResults() {
        assertThat("Search results should not be visible, but they are presented",
                !googlePage.isSearchResultsVisible());


    }
}
