Feature: Test add product to cart functionality
  Background: user is logged in
    Given user is on login page
    When user enters email and password
    And clicks on login button
    Then user is navigated to the account page

  Scenario Outline: Add product to cart successfully
    Given user is on home page
    When user hovers on <item> and click Add to cart
    Then the item is added to cart

    Examples:
      | item                  |
      | Printed Chiffon Dress |
      | Blouse                |
      |Faded Short Sleeve T-shirts|
