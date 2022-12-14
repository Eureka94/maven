package com.Maven_Project1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_Class {
	public static WebDriver driver;

	public static void url(String name) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\WIPRO\\eclipse-workspace\\selenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(name);
	}

	public static void maxi() {
		driver.manage().window().maximize();

	}

	public static void send_Values(WebElement element, String values) {
		element.sendKeys(values);

	}

	public static void click(WebElement element) {
		Actions a = new Actions(driver);
		a.click(element).build().perform();
	}

	public static void down() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	public static void enter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void screenshot(String path) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(path);
		FileUtils.copyFile(src, des);

	}

	public static void title() {
		String title = driver.getTitle();
		System.out.println(title);

	}

	public static void implicitly_Wait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	public static void alert_Yes() {
		Alert simple = driver.switchTo().alert();
		simple.accept();

	}

	public static void alert_No() {
		Alert simple1 = driver.switchTo().alert();
		simple1.dismiss();

	}

	public static void alert_text(String name) {
		Alert text = driver.switchTo().alert();
		text.sendKeys(name);

	}

	public static void select_Value(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);

	}

	public static void select_Value(WebElement element, String name) {
		Select s = new Select(element);
		s.selectByValue(name);
	}

	public static void select_Text(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);

	}

	public static void js_Click(String action, String name) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", name);

	}

	public static void js_Sendkeys(String action, String name) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='action'", name);
	}

	public static void js_Scroll(String action, String name) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", name);
	}
	public static void actions_Contextclick(WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick(element);
		

	}

}
