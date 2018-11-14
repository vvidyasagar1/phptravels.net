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

