package org.example;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class softwaretestingfinalprojectmenudriven {
private static WebDriver driver;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice=0;
        while (choice != 7) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Open browser");
            System.out.println("2. Open URL");
            System.out.println("3. Open browser with credentials");
            System.out.println("4. Find element by ID");
            System.out.println("5. Find element by name");
            System.out.println("6. Find Element By cssId");
            System.out.println("7. Find Element By cssname");
            System.out.println("8. Radio Button");
            System.out.println("9. takescreenshot");
            System.out.println("10. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    openBrowser();
                    break;
                case 2:
                    openURL();
                    break;
                case 3:
                    openBrowserWithCredentials();
                    break;
                case 4:
                    findElementById();
                    break;
                case 5:
                    findElementByName();
                    break;
                case 6:
                    findElementBycssId();
                    break;
                case 7:
                    findElementBycssname();
                    break;
                case 8:
                    findElementByRadio();
                    break;
                case 9:
                     takescreenshot();
                    break;
                case 10:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        scanner.close();
        if (driver != null) {
            driver.quit();
        }
    }
    private static void takescreenshot() {
        if (driver == null) {
            System.out.println("Please open the browser first.");
            return;
        }
        try {
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String fileName = "screenshot_" + System.currentTimeMillis() + ".png";
            File targetFile = new File(fileName);
            FileUtils.copyFile(screenshotFile, targetFile);
            System.out.println("Screenshot saved to " + targetFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }
    private static void findElementByRadio() {
        if (driver == null) {
            System.out.println("Please open the browser first.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter radio button ID: ");
        String radioButtonId = scanner.nextLine();
        try {
            WebElement radioButton = driver.findElement(By.id(radioButtonId));
            radioButton.click();
            System.out.println("Radio button " + radioButtonId + " is clicked.");
        } catch (NoSuchElementException e) {
            System.out.println("Radio button " + radioButtonId + " is not found.");
        }
    }
    private static void findElementBycssname() {
        if (driver == null) {
            System.out.println("Please open the browser first.");
            return;
        }
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter element name: ");
        String elementName = scanner1.nextLine();
        try {
            WebElement element = driver.findElement(By.xpath("//input[@name='" + elementName + "']"));
            System.out.println("Element found: " + element);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found.");
        }
    }
    private static void findElementBycssId() {
        if (driver == null) {
            System.out.println("Please open the browser first.");
            return;
        }
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Enter element ID: ");
        String elementId = scanner2.nextLine();
        try {
            WebElement element = driver.findElement(By.cssSelector("[id='" + elementId + "']"));
            System.out.println("Element found: " + element);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found.");
        }
    }
    private static void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "https://codeforces.com/enter?back=%2Fprofile%2Flogin");
        driver = new FirefoxDriver();
        System.out.println("Browser opened.");
    }
    private static void openURL() {
        if (driver == null) {
            System.out.println("Please open the browser first.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter URL: ");
        String url = scanner.nextLine();
        driver.get(url);
        System.out.println("URL opened: " + url);
    }
    private static void openBrowserWithCredentials() {
        if (driver != null) {
            driver.quit();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (username.equals("admin") && password.equals("password")) {
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
            driver = new FirefoxDriver();
            System.out.println("Browser opened.");
        } else {
            System.out.println("Invalid credentials. Browser not opened.");
        }
    }
    private static void findElementById() {
        if (driver == null) {
            System.out.println("Please open the browser first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter element ID: ");
        String elementId = scanner.nextLine();

        try {
            WebElement element = driver.findElement(By.id(elementId));
            System.out.println("Element found: " + element);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found.");
        }
    }
    private static void findElementByName() {
        if (driver == null) {
            System.out.println("Please open the browser first.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter element name: ");
        String elementName = scanner.nextLine();

        try {
            WebElement element = driver.findElement(By.name(elementName));
            System.out.println("Element found: " + element);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found.");
        }
    }
        }
