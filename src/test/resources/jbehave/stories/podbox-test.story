Scenario:  Right number of results
Given my podbox challenge is launched
When I send a top10 request
Then I receive 10 results

Scenario:  Test the title of the Top
Given my podbox challenge is launched
When I send a top10 request
Then the title with 1 is The Hills