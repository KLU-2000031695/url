package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class fire {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://codeforces.com/enter?back=%2Fprofile%2Flogin");
        driver.findElement(By.id("handleOrEmail")).sendKeys("2000031695@kluniversity.in");
        driver.findElement(By.name("password")).sendKeys("Sneha@123457890");
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("font-size:1.1rem;")).click();
    }
}
