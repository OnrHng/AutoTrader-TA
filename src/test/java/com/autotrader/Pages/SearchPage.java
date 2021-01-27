package com.autotrader.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends Base {

  @FindBy(xpath = "//button[contains(text(),'Browse by Make')]")
  public WebElement browseByMake;


  @FindBy(xpath = "//button[contains(text(),'Browse by Style')]")
  public WebElement browseByStyle;


  @FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
  public WebElement advanceSearch;

  @FindBy(xpath = "  //a[contains(text(),'Advanced Search')]")
  public WebElement advanceSearchButton;


  @FindBy(xpath = "//select[@id='makeCode']")
  public WebElement anyMake;

  @FindBy(xpath = "//select[@id='ModelCode']")
  public WebElement anyModel;

  public void verifyTheFields(String value) {
    if (value.equals(browseByMake.getText())) {
      Assert.assertEquals(value, browseByMake.getText());
    } else if (value.equals(browseByStyle.getText())) {
      Assert.assertEquals(value, browseByStyle.getText());
    } else if (value.equals(advanceSearch.getText())) {
      Assert.assertEquals(value, advanceSearch.getText());
    }
  }

  public void verifySearchButton() {
    Assert.assertTrue(advanceSearchButton.isDisplayed() && advanceSearchButton.isEnabled());
  }

  public void verifyAnyMakeAndAnyModel(String make, String model) {
    Assert.assertTrue(anyMake.isDisplayed() && anyModel.isDisplayed());

  }




}