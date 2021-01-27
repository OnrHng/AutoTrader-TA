package com.autotrader.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdvanceSearchPage extends Base{

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


  public void enterZipCode(String code) {
    zipCode.clear();
    zipCode.sendKeys(code);
  }

  public void selecCertifiedChechBox(String checkBox) {
    if (checkBox.equals(certified.getText())) {
      certified.click();
    } else {
      scrollDown(convertible);
      convertible.click();
    }
  }


}
