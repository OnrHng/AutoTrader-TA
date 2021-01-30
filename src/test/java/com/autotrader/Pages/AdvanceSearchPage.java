package com.autotrader.Pages;

import com.autotrader.utils.MyDriver;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AdvanceSearchPage extends Base{
  Logger logger = LoggerFactory.getLogger(AdvanceSearchPage.class);

  @FindBy(xpath = "//input[contains(@name,'zip')]")
  public WebElement zipCode;


  @FindBy(xpath = "//div[contains(text(),'Certified')]")
  public WebElement certified;


  @FindBy(xpath = "//div[contains(text(),'Convertible')]")
  public WebElement convertible;

  @FindBy(xpath = "//select[contains(@name,'startYear')]")
  public WebElement fromYear;


  @FindBy(xpath = "//select[contains(@name,'endYear')]")
  public WebElement toYear;

  @FindBy(xpath = "//select[contains(@name,'makeFilter0')]")
  public WebElement carModel;

  @FindBy(xpath = "//button[contains(text(),'Search')]")
  public WebElement advanceSearchButton;

//  @FindBys("//div[@data-cmp='inventoryListing']")
//  public List<WebElement> listingsOfCars;


  public void enterZipCode(String code) {
    // should clean cookies, cause search button is not working
    // by automated browser, after this all process.
    MyDriver.get().manage().deleteAllCookies();

    waitSomeTime(1000);
    zipCode.clear();
    zipCode.sendKeys(code);
  }

  public void selectCertifiedCheckBox(String checkBox) {
    if (checkBox.equals(certified.getText())) {
      certified.click();
    } else {
      scrollDown(convertible);
      convertible.click();
    }
  }

  public void modelYears(String startYear, String endYear) {
    scrollDown(fromYear);
    Select selectFromYear = new Select(fromYear);
    selectFromYear.selectByValue(startYear);

    Select selectToYear = new Select(toYear);
    selectToYear.selectByValue(endYear);
  }

  public void chooseModel(String model) {
//    waitSomeTime(100);
    scrollDown(carModel);
    Select modelOfCar =  new Select(carModel);
    modelOfCar.selectByValue(model);
  }

  public void clickSearchButton() {
    scrollDown(advanceSearchButton);
    advanceSearchButton.click();
  }

  public boolean verifySelectedCarInListing(String model) {
    //div[@data-cmp='inventoryListing']
    List<WebElement> listCars = MyDriver.get().findElements(By.xpath("//div[@data-cmp='subheading']"));

    boolean isBMW = true;
    for (WebElement webElement : listCars){
      isBMW = !webElement.getText().contains(model);
    }
    logger.info("ALL CARS ARE BMW");
    return isBMW;

  }
}






