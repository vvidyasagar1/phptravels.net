
package com.cucumber.framework.helper.Alert;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class DateHelper{
	 public static LocalDate getAfter2WeeksDate() {
	        LocalDate today = LocalDate.now();
	        LocalDate next2Week = today.plus(2, ChronoUnit.WEEKS);
		      System.out.println("next 2 weeks"+next2Week);
	            return next2Week;  	
	    }

	public static LocalDate getAfter4WeeksDate() {
	    LocalDate today = LocalDate.now();
	      LocalDate next4Week = today.plus(4, ChronoUnit.WEEKS);
	      System.out.println("next 4 weeks"+next4Week);
	   return next4Week;     	
	    }
}
