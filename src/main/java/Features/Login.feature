Feature: Guru 99 login
  Scenario: Login to Guru with valid user name and password

    Given I have user name and password
 
    
    When I successfully login 
 

    Then I should navigate to the home page