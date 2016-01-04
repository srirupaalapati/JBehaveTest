Scenario: Browsing around the site for cast and crew - Positive case

Given I am on imdb.com
When I search for Star Wars: Episode I
And Go to list of cast and crew
Then Check if Jim Morris has a special thanks


Scenario: Browsing around the site for cast and crew - Negative case

Given I am on imdb.com
When I search for Star Wars: Episode I
And Go to list of cast and crew
Then Check if Jim Morris has a special thanks1234