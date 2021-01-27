package com.autotrader.StepDef;

import com.autotrader.Pages.AdvanceSearchPage;
import com.autotrader.Pages.Base;
import com.autotrader.utils.ConfigurationReader;
import com.autotrader.utils.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

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
    advanceSearchPage.selectCertifiedCheckBox(certifiedCheckBox);
  }

  @Then("user update Year {string} to {string}")
  public void userUpdateYearTo(String startYear, String endYear) {
    advanceSearchPage.modelYears(startYear, endYear);
  }

  @Then("user select {string} car from Make,Model and Trim section")
  public void userSelectCarFromMakeModelAndTrimSection(String carModel) {
    advanceSearchPage.chooseModel(carModel);
  }

  @Then("User clicks Search button")
  public void userClicksSearchButton() {
    advanceSearchPage.clickSearchButton();
  }

  @Then("User verifies that he is in result page")
  public void userVerifiesThatHeIsInResultPage() {
    // wait some, in order to get right webpage title
    //MyDriver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    Base.waitSomeTime(2000);

    String expected = "Certified BMW Convertibles for Sale in Alpharetta, GA (with Photos) - Autotrader";
//    String actual = "Certified BMW Convertibles for Sale in Alpharetta, GA (with Photos) - Autotrader";
    String actual = MyDriver.get().getTitle();
    Assert.assertEquals(expected, actual);
  }

  @Then("User verifies that he sees only {string} cars in listing")
  public void userVerifiesThatHeSeesOnlyCarsInListing(String model) {
    Assert.assertTrue(advanceSearchPage.verifySelectedCarInListing(model));
  }

  @Then("Display in console, the number of cars listed in result page")
  public void displayInConsoleTheNumberOfCarsListedInResultPage() {
  }
}
