Feature: As a user of trading view application I should be able to perform search

  @Search 
  Scenario: Validate search functionality of Trading View Application
    Given I attempt to navigate to Trading View signIn page
    When I attempt to signIn with username as "testuser02" and password as "Passw0rd"
		And I navigate to "Asia" currency rates page
    And I search for currency "FX: GBPJPY"
    And I see the overview
		Then I verify currency as "British" in rates page
	  And I signout from Trading View Application