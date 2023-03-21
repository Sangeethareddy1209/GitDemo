Feature: Place the order for products
@PlaceOrder
Scenario Outline: Search Experience for product search and adding items to the cart
Given User is on Greenkart Landing page
When user searched with shortname <Name> and extracted actual name of product
And Added "3" items of the selected product to cart
Then user proceeds to CheckOut and validate the <Name> items in checkout page
And verify user has ability to enter promo code and place the order
Examples:
| Name |
| Tom |
