package com.sda.zdtestpol128;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/googleSearch.feature",
        glue = "com.sda.zdtestpol128",
        plugin = {"pretty", "json:target/cucumber-reports.json",
                "html:target/cucumber-reports.html",
                "junit:target/cucumber-reports.xml"}
)
public class TestRunner {
}
