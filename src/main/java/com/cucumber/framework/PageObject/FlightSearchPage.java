package com.cucumber.framework.PageObject;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.Alert.DateHelper;
import com.cucumber.framework.helper.Alert.GenericHelper;
import com.cucumber.framework.helper.Alert.LoggerHelper;
import com.cucumber.framework.helper.Alert.WaitHelper;

public class FlightSearchPage {


	WebDriver driver;
	WaitHelper waitHelper;
	GenericHelper genericHelper;
	private final Logger log = LoggerHelper.getLogger(FlightSearchPage.class);
	JavascriptExecutor executor;

	@FindBy(xpath = "//*[@id='flights']/form/div[9]/div[2]/div/label")
	WebElement radbtnRoundTrip;

	@FindBy(xpath = ".//a[@title='Flights']")
	WebElement lnkFlights;

	@FindBy(xpath = "//*[@id='s2id_location_from']/a/span[1]")
	WebElement txtFromLoc;    

	@FindBy(xpath = ".//*[@id='s2id_location_to']/a/span[1]")
	WebElement txtToLoc;  

	@FindBy(xpath = "//*[@id='select2-drop']/ul/li[1]/div")
	WebElement selectcity;    

	@FindBy(xpath = ".//*[@id='flights']/form/div[4]/div/input")
	WebElement dateReturn;

	@FindBy(xpath = ".//*[@id='flights']/form/div[3]/div/input")
	WebElement dateDeparture;

	@FindBy(xpath = "//*[@id='flights']/form/div[6]/button")
	WebElement btnSearch;

	@FindBy(xpath = ".//*[@id='body-section']/div[2]/div/form/div[5]/div/i")
	WebElement txtGuests;

	@FindBy(xpath = ".//*[@id='manual_flightTravelers']/div/div/div[2]/section/div/div[1]/div[1]/select")
	WebElement numAdults;

	@FindBy(xpath = ".//*[@id='manual_flightTravelers']/div/div/div[2]/section/div/div[2]/div[1]/select")
	WebElement numChild;

	@FindBy(xpath = ".//*[@id='sumManualPassenger']")
	WebElement btnDone;

	@FindAll(value= {@FindBy(xpath="//*[@id='body-section']/div[4]/div/div[2]/div/div[2]/div/label")})
	List txtFilterAirlines;	

	@FindAll(value= {@FindBy(xpath="html/body/div[14]/div[1]/table/tbody/tr/td")})
	List tdCalenderDates;	

	@FindAll(value= {@FindBy(xpath=".//*[@id='body-section']/div[4]/div/div[2]/div/div[2]/div/label//preceding::ins")})
	List chkbxFilterAirlines;	

	@FindAll(value= {@FindBy(xpath="//*[@id='load_data']/tbody/tr/td/div[2]/p/span")})
	List lblPrice;

	@FindAll(value= {@FindBy(xpath=".//*[@id='bookbtn']")})
	List btnBookNow;

	@FindBy(xpath = "html/body/div[14]/div[1]/table/thead/tr[1]/th[3]")
	WebElement btnCalRight;

	@FindBy(xpath = "html/body/div[14]/div[1]/table/thead/tr[1]/th[1]")
	WebElement btnCalLeft;


	public FlightSearchPage(WebDriver driver) {
		System.out.println("2");
		System.out.println(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		genericHelper = new GenericHelper();
		//      waitHelper.waitForElement(driver, saveBtn, ObjectRepo.reader.getExplicitWait());
		executor = (JavascriptExecutor) driver;
	}

	public void clickFlightsTab() {
		// executor.executeScript("arguments[0].click();", lnkFlights);
		lnkFlights.click();
	}

	public void selectFromCity(String city) {
		Actions action =new Actions(driver);
		action.moveToElement(txtFromLoc).click().sendKeys(city).perform();
		action.moveToElement(selectcity).click().build().perform();
	}

	public void selectToCity(String city) {
		Actions action =new Actions(driver);
		action.moveToElement(txtToLoc).click().sendKeys(city).perform();
		action.moveToElement(selectcity).click().build().perform();
	}

	public void clickRoundTrip() {
		radbtnRoundTrip.click();
	}

	public void selectDepDate() throws InterruptedException {
		int targetDay = 0;
		int targetMonth = 0;
		int targetYear = 0;
		int currenttDate = 0;
		int currenttMonth = 0;
		int currenttYear = 0;
		int jumMonthBy = 0;
		boolean increment = true;
		String depDate = DateHelper.getAfter2WeeksDate().toString();
		Calendar cal = Calendar.getInstance();
		currenttDate = cal.get(Calendar.DAY_OF_MONTH);
		currenttMonth = cal.get(Calendar.MONTH) + 1;
		currenttYear = cal.get(Calendar.YEAR);

		int firstIndex = depDate.indexOf("-");
		int lastIndex = depDate.lastIndexOf("-");
		String year = depDate.substring(0, firstIndex);
		targetYear = Integer.parseInt(year);
		String month = depDate.substring(firstIndex + 1, lastIndex);
		targetMonth = Integer.parseInt(month);
		String day = depDate.substring(lastIndex + 1, depDate.length());
		targetDay = Integer.parseInt(day);

		if ((targetMonth - currenttMonth) > 0) {
			jumMonthBy = targetMonth - currenttMonth;
		} else {
			jumMonthBy = currenttMonth - targetMonth;
			increment = false;
		}

		dateDeparture.click();

		for (int i = 0; i < jumMonthBy; i++) {
			if (increment) {
				driver.findElement(By.xpath("html/body/div[14]/div[1]/table/thead/tr[1]/th[3]")).click();
			} else {
				driver.findElement(By.xpath("html/body/div[14]/div[1]/table/thead/tr[1]/th[1]")).click();
			}
		}
		Thread.sleep(2000);
		List calenderDates=driver.findElements(By.xpath("html/body/div[14]/div[1]/table/tbody/tr/td"));
		System.out.println(calenderDates.size());
		for(int i=0;i<calenderDates.size();i++) {
			System.out.println("targetdate"+targetDay);
			WebElement calD=(WebElement) calenderDates.get(i);
			System.out.println(calD.getText());
			if(calD.getText().equals(""+targetDay))
			{
				Thread.sleep(3000);
				calD.click();
				break;
			}
		}
	}

	public void selectRetDate() throws InterruptedException {
		int targetDay = 0;
		int targetMonth = 0;
		int targetYear = 0;
		int currenttDate = 0;
		int currenttMonth = 0;
		int currenttYear = 0;
		int jumMonthBy = 0;
		boolean increment = true;
		String RetDate = DateHelper.getAfter4WeeksDate().toString();
		System.out.println(RetDate);
		Calendar cal = Calendar.getInstance();
		currenttDate = cal.get(Calendar.DAY_OF_MONTH);
		currenttMonth = cal.get(Calendar.MONTH) + 1;
		currenttYear = cal.get(Calendar.YEAR);

		int firstIndex = RetDate.indexOf("-");
		int lastIndex = RetDate.lastIndexOf("-");
		String year = RetDate.substring(0, firstIndex);
		targetYear = Integer.parseInt(year);
		String month = RetDate.substring(firstIndex + 1, lastIndex);
		targetMonth = Integer.parseInt(month);
		String day = RetDate.substring(lastIndex + 1, RetDate.length());
		targetDay = Integer.parseInt(day);

		if ((targetMonth - currenttMonth) > 0) {
			jumMonthBy = targetMonth - currenttMonth;
		} else {
			jumMonthBy = currenttMonth - targetMonth;
			increment = false;
		}

		//dateReturn.click();

		for (int i = 0; i < jumMonthBy; i++) {
			if (increment) {
				driver.findElement(By.xpath("html/body/div[15]/div[1]/table/thead/tr[1]/th[3]")).click();
			} else {
				driver.findElement(By.xpath("html/body/div[15]/div[1]/table/thead/tr[1]/th[1]")).click();
			}
		}
		Thread.sleep(2000);
		List calenderDates=driver.findElements(By.xpath("html/body/div[15]/div[1]/table/tbody/tr/td"));
		System.out.println(calenderDates.size());
		for(int i=0;i<calenderDates.size();i++) {
			System.out.println(targetDay);
			WebElement calD=(WebElement) calenderDates.get(i);
			System.out.println(calD.getText());
			if(calD.getText().equals(""+targetDay))
			{
				calD.click();
				break;
			}
		}
	}


	public void selectRetDate(String date) {
		dateReturn.sendKeys(date);
	}

	public void selectAdults(String a) {
		numAdults.sendKeys(a);
	}

	public void selectChild(String c) {
		numChild.sendKeys(c);
	}

	public void clicksearch() {
		btnSearch.click();
	}

	public void filterCarrier(String airlines) {

	}

	public void clickBookNow() {
		((WebElement) btnBookNow).click();
	}


}
