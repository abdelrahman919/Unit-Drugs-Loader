package com.hamada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DrugsLoader {

    private final WebDriver driver;
    private final By nameInput = By.id("name");
    private final By typeSelect = By.id("type");
    private final By submitButton = By.tagName("button");

    public DrugsLoader(WebDriver driver) {
        this.driver = driver;
    }


    public void loadDrugs() {
        List<Drug> drugs = FileHandler.readDrugList();
        WebElement nameElem = driver.findElement(nameInput);
        Select typeElem = new Select(driver.findElement(typeSelect));
        WebElement button = driver.findElement(submitButton);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        drugs.forEach(drug -> {
            nameElem.sendKeys(drug.name);
            typeElem.selectByVisibleText(drug.type);
            button.click();
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        });


    }




}
