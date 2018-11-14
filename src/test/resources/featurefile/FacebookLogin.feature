#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Search for Flights
Keywords Summary : This test will Search for Flights

Scenario: Search for the cheapest flight
Given I visit https://www.phptravels.net website
And I click FLIGHTS
And I select Return Trip
And I select from London City Arpt
And I select to Dubai Intl Arpt
#For the below date select, please use the the date picker
And I select departure date 2 weeks from today's date
And I select return date 2 weeks from departure date
And I select 2 Adult
And I select 2 Child
When I click SEARCH button
And I filter by the following flight carrier
|Turkish Airlines|
|Oman Air|
And I click on BOOK NOW with the cheapest price
Then I am taken to booking page

