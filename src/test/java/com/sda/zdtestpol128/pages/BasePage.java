package com.sda.zdtestpol128.pages;

import com.sda.zdtestpol128.WebDriverFactory;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public final RemoteWebDriver driver;

    public BasePage() {
        this.driver = WebDriverFactory.DRIVER;
        PageFactory.initElements(driver, this);
    }
}
