package com.cucumber.framework.stepdefinition;

import org.openqa.selenium.By;

import com.cucumber.framework.PageObject.FlightSearchPage;
import com.cucumber.framework.helper.TestBase.TestBase;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchFlights {
	FlightSearchPage flightSearchPage=new FlightSearchPage(TestBase.driver);
	
	@Given("^User navigated to FACEBOOK\\.COM$")
	public void user_navigated_to_FACEBOOK_COM() throws Throwable {
		TestBase.driver.get("https://www.phptravels.net/");
	}

	@When("^user enter Username as \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void user_enter_Username_as_and_Password(String arg1, String arg2) throws Throwable {
		TestBase.driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(arg1);
		TestBase.driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys(arg2);
	}

	@When("^user click on login button$")
	public void user_click_on_login_button() throws Throwable {
		TestBase.driver.findElement(By.xpath(".//*[@id='loginbutton']")).click();
	}

	@Then("^login should be successful$")
	public void login_should_be_successful() throws Throwable {
		TestBase.driver.findElement(By.xpath(".//*[@id='loginbutton']")).click();
	}
	
	@Given("^I visit https://www\\.phptravels\\.net website$")
	public void i_visit_https_www_phptravels_net_website() throws Throwable {
		TestBase.driver.get("https://www.phptravels.net/");
	}

	@Given("^I click FLIGHTS$")
	public void i_click_FLIGHTS() throws Throwable {
		Thread.sleep(3000);
		flightSearchPage.clickFlightsTab();
		}

	@Given("^I select from London City Arpt$")
	public void i_select_from_London_City_Arpt() throws Throwable {
		Thread.sleep(3000);
		flightSearchPage.selectFromCity("London City");
	}

	@Given("^I select to Dubai Intl Arpt$")
	public void i_select_to_Dubai_Intl_Arpt() throws Throwable {
		Thread.sleep(2000);
		flightSearchPage.selectToCity("Dubai Intl");
	}

	@Given("^I select Return Trip$")
	public void i_select_Return_Trip() throws Throwable {
		Thread.sleep(2000);
		flightSearchPage.clickRoundTrip();
	}

	@Given("^I select departure date (\\d+) weeks from today's date$")
	public void i_select_departure_date_weeks_from_today_s_date(int arg1) throws Throwable {
		flightSearchPage.selectDepDate();
	}

	@Given("^I select return date (\\d+) weeks from departure date$")
	public void i_select_return_date_weeks_from_departure_date(int arg1) throws Throwable {
		flightSearchPage.selectRetDate();
	}

	@Given("^I select (\\d+) Adult$")
	public void i_select_Adult(int arg1) throws Throwable {
		TestBase.driver.get("https://www.phptravels.net/");
	}

	@Given("^I select (\\d+) Child$")
	public void i_select_Child(int arg1) throws Throwable {
		TestBase.driver.get("https://www.phptravels.net/");
	}

	@When("^I click SEARCH button$")
	public void i_click_SEARCH_button() throws Throwable {
		TestBase.driver.get("https://www.phptravels.net/");
	}

	@When("^I filter by the following flight carrier$")
	public void i_filter_by_the_following_flight_carrier(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		TestBase.driver.get("https://www.phptravels.net/");
	}

	@When("^I click on BOOK NOW with the cheapest price$")
	public void i_click_on_BOOK_NOW_with_the_cheapest_price() throws Throwable {
		TestBase.driver.get("https://www.phptravels.net/");
	}

	@Then("^I am taken to booking page$")
	public void i_am_taken_to_booking_page() throws Throwable {
		TestBase.driver.get("https://www.phptravels.net/");
	}

}
