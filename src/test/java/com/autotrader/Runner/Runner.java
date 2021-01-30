package com.autotrader.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        // Glue path should begin after java path
        // if it is began src folder , you'll get an error.
        glue = "com.autotrader.StepDef",
        dryRun =false,
        strict = true,
//        tags = "@smoke_test,@unit_test",
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json",
        }
)
public class Runner {

}
