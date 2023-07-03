package com.sda.zdtestpol128.steps;

import com.sda.zdtestpol128.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("BROWSER IS STARTING NOW FOR SCENARIO: " + scenario.getName());
        WebDriverFactory.startDriver();
    }
    @After
    public void afterScenario(Scenario scenario) throws IOException {
        System.out.println("BROWSER IS CLOSED AFTER SCENARIO: " + scenario.getName());
        WebDriverFactory.processExecutedScenario(scenario);
    }

}
