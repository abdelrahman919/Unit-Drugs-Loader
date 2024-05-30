package com.hamada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Config {
    private static WebDriver driver;
    public static DrugsLoader setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file://D:\\java-projects\\Unit-Drugs-Loader\\DrugSaveForm.html");

        return new DrugsLoader(driver);
    }
}
