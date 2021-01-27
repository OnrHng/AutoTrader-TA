package com.autotrader.StepDef;

import com.autotrader.Pages.SearchPage;
import com.autotrader.utils.ConfigurationReader;
import com.autotrader.utils.MyDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchSteps {

  // console da info yazdirmak icin
  Logger logger = LoggerFactory.getLogger(SearchSteps.class);

  SearchPage page = new SearchPage();

  @Given("User is on homepage")
  public void userIsOnHomepage() {
    MyDriver.get().get(ConfigurationReader.getProperty("url"));
    MyDriver.get().manage().deleteAllCookies();
    MyDriver.get().navigate().refresh();
    Assert.assertEquals("Used and New Car Sales, Review - Autotrader" , MyDriver.get().getTitle());
    logger.info("===Assertion successful===");
  }

  @Then("Verify that {string} is present")
  public void verifyThatIsPresent(String value) {
    page.verifyTheFields(value);
  }

  @And("Verify that Search button is present")
  public void verifyThatSearchButtonIsPresent() {
    page.verifySearchButton();
  }

  @Then("Verify that {string} and {string} is present")
  public void verifyThatAndIsPresent(String make, String model) {
    page.verifyAnyMakeAndAnyModel(make, model);
  }

}


