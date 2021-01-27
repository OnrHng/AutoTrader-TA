package com.autotrader.StepDef;

import com.autotrader.utils.ConfigurationReader;
import com.autotrader.utils.MyDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Hooks {

  Logger logger = LoggerFactory.getLogger(Hooks.class);

  @Before
  public void setup() {
    logger.info("##### SETUP STARTED (HOOK) ######");
    MyDriver.get().manage().deleteAllCookies();

    MyDriver.get().manage().window().maximize();

    MyDriver.get().manage().deleteAllCookies();

    // elementlerin yuklenmesi icin kodu beklemesini saglar
    MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    // verilen sureden daha erken bir sekilde page yuklenirse bu surenin sonuna kadar beklemeden
      // kodu calismasina devam ettir.

    // cookileri temizlemek icin
//    MyDriver.get().manage().deleteAllCookies();
//    MyDriver.get().navigate().refresh();

  }

  @After
  public void after(Scenario scenario){
    if(scenario.isFailed()){
      logger.error("!!!!Test Failed! check the screenshot!!!!");

      // raporun altina screenshot u attach ediyor eger scenario fail olursa
      byte[] screenshot= ((TakesScreenshot)MyDriver.get()).getScreenshotAs(OutputType.BYTES);
      scenario.attach(screenshot,"images/png","Screenshot");
      //scenario.embed(screenshot,"images/png"); versiyon 4.7.4

    }else {
      logger.info("Test Completed");
    }
    logger.info("###### END OF TESTS #####");

    MyDriver.close();
  }


}
