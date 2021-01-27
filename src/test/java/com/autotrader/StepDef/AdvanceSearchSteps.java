package com.autotrader.StepDef;

import com.autotrader.Pages.AdvanceSearchPage;
import com.autotrader.utils.ConfigurationReader;
import com.autotrader.utils.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AdvanceSearchSteps {

  AdvanceSearchPage advanceSearchPage = new AdvanceSearchPage();

  @Given("User is on Advance Search page")
  public void userClickAdvanceSearchLinkOnTheHomePage() {
    MyDriver.get().get(ConfigurationReader.getProperty("advanceSearchUrl"));

    // check if the title is right
    Assert.assertEquals("Search for Cars For Sale Online - Find a Car at Autotrader", MyDriver.get().getTitle());
  }

  @Then("User enter {string} in the zip code text box")
  public void userEnterInTheZipCodeTextBox(String zipCode) {

    advanceSearchPage.enterZipCode(zipCode);
  }

  @Then("User select {string} check box under {string}")
  public void userSelectCheckBoxUnder(String certifiedCheckBox, String arg1) {
    advanceSearchPage.selecCertifiedChechBox(certifiedCheckBox);
  }

  @Then("user update Year {string} to {string}")
  public void userUpdateYearTo(String arg0, String arg1) {
  }

  @Then("user select {string} car from Make,Model and Trim section")
  public void userSelectCarFromMakeModelAndTrimSection(String arg0) {
  }

  @Then("User clicks Search button")
  public void userClicksSearchButton() {
  }

  @Then("User verifies that he is in result page")
  public void userVerifiesThatHeIsInResultPage() {
  }

  @Then("User verifies that he sees only {string} cars in listing")
  public void userVerifiesThatHeSeesOnlyCarsInListing(String arg0) {
  }

  @Then("Display in console, the number of cars listed in result page")
  public void displayInConsoleTheNumberOfCarsListedInResultPage() {
  }
}
