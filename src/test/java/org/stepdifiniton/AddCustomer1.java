package org.stepdifiniton;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
//import junit.framework.Assert;

public class AddCustomer1 {
	static WebDriver driver;

	@Given("launch and direct to url")
	public void launch_and_direct_to_url() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ADMIN\\eclipse-workspace\\maven-cucumber\\dri\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/index.html");
	}

	@When("click the add customer")
	public void click_the_add_customer() {
		driver.findElement(By.xpath("//a[text()='Add Customer'][1]")).click();
	}

	@When("enter the details and submit")
	public void enter_the_details_and_submit(DataTable dataTable) {
		List<Map<String, String>> cusdetails = dataTable.asMaps(String.class, String.class);
		driver.findElement(By.xpath("//label[text()='Done']")).click();
		driver.findElement(By.id("fname")).sendKeys(cusdetails.get(0).get("fname"));
		driver.findElement(By.id("lname")).sendKeys(cusdetails.get(1).get("lname"));
		driver.findElement(By.name("emailid")).sendKeys(cusdetails.get(1).get("email"));
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(cusdetails.get(0).get("add"));
		driver.findElement(By.name("telephoneno")).sendKeys(cusdetails.get(0).get("pho"));
		driver.findElement(By.name("submit")).click();

	}

	@Then("generate a id")
	public void generate_a_id() {
		Assert.assertTrue(driver.getCurrentUrl(), true);
		driver.findElement(By.tagName("h3"));
		driver.quit();
	}

}
