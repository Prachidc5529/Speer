package com.miit.selenium;

import static org.testng.Assert.expectThrows;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {

	private WebDriver driver;
	static int n = 20;
	String wlink = "https://en.wikipedia.org/wiki/Main_Page";
	final String CHROM_DRIVE = "C:\\Users\\prach\\Downloads\\chromedriver_win32\\chromedriver.exe";

	public NewTest(String str) {
		// TODO Auto-generated constructor stub
	}

	public NewTest(com.miit.selenium.NewTest1.String str) {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void getWikiLinks() {

		boolean wikilink_status = getValidateLink(wlink);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(wlink);
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of Links in the Page is " + links.size());
		if (wikilink_status && links.size()== n) {
			// links.forEach(link -> System.out.println(link.getText()));
			Set<String> wikiset = new HashSet<String>();
			for (int i = 1; i <= n; i = i + 1) {
				wikiset.add(links.get(i).getText());
			}
			System.out.println("link=>"+wikiset);
		} else {
			System.out.println("In valid Link");
			try
			{
			throw new NewTest();
			}
			catch(NewTest e)
			{
				System.out.println("caught exception");
				System.out.println(e.getMessage()));
			}
	}

	public boolean getValidateLink(String wlink) {

		String regex = "\\//en.wikipedia.org\\/([\\w%]+)";
		String str = wlink;

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);

		while (matcher.find()) {

			if (matcher.group(0).equals(null)) {
				return false;
			} else {
				System.out.println("==>"+matcher.group(0));
				return true;
			}
		}
		return false;
	}

	
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\prach\\Downloads\\chromedriver_win32_63\\chromedriver.exe");

		driver = new ChromeDriver();
	}

	

}
