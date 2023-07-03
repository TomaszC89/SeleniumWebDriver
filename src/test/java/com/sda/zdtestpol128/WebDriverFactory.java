package com.sda.zdtestpol128;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class WebDriverFactory {

    public static RemoteWebDriver DRIVER;

    public static void startDriver() {

        switch (getBrowserName()) {
            case "chrome":
                DRIVER = new ChromeDriver();
                break;
            case "firefox":
                DRIVER = new FirefoxDriver();
                break;
            case "edge":
                DRIVER = new EdgeDriver();
                break;
            default:
                throw new IllegalStateException("UNSUPPORTED BROWSER!!!");
        }
    }

    public static void destroyDriver() {
        DRIVER.quit();
    }

    public static String getBrowserName() {
        return System.getProperty("browserName", "edge");
    }

    private static void embedScreenshot(Scenario scenario) {
        byte[] screenshot = DRIVER.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "screenshot");
    }

    private static void saveScreenshotFile(Scenario scenario) throws IOException {
        File srcFile = ((TakesScreenshot) DRIVER).getScreenshotAs(OutputType.FILE);
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        FileUtils.copyFile(srcFile, new File(currentPath + "/screenshots/" + scenario.getName() + ".png"));
    }

    public static void processExecutedScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed() && DRIVER != null) {
            embedScreenshot(scenario);
            saveScreenshotFile(scenario);
        }
        destroyDriver();
    }
}
