Feature: To create a new booking in restful-booker

Scenario Outline: To create new booking using cucumber Data Table

Given User creates a booking with "<firstname>","<lastname>","<totalprice>","<depositpaid>","<checkin>","<checkout>","<additionalneeds>"
When User has access to "booking" API with "POST" request
Then API call got success with the status code 200
And User validates the response

Examples:
|firstname	|lastname	|totalprice		|depositpaid	|checkin		|checkout		|additionalneeds  |
| John      | Doe      |       1200 	| true        	| 2021-05-05 	| 2021-05-15 	| Breakfast       |
| Jane      | Doe      |       2400 	| false       	| 2021-06-01 	| 2021-07-10 	| Dinner          |