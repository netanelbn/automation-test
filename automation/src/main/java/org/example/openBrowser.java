package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class openBrowser {
    public static void main(String[] args) {
        // System Property for Chrome Driver
        WebDriverManager.chromedriver().setup();
        // Instantiate a ChromeDriver class.
        WebDriver driver=new ChromeDriver();



        // Launch Website
        driver.navigate().to("http://www.javatpoint.com/");

        //Maximize the browser
        driver.manage().window().maximize();


        // Click on the Search button
        driver.findElement(By.linkText("Core Java")).click();

    }
}
