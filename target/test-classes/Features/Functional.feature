#Author: r.janikeh@gmail.com 

@UITest
Feature: step 1 (Korpus) and step 6 (Türart) and add the article to the cart
  As a User, I want to select my favorite product on step 1 to 6

Scenario: Step 1
Given Go to the site.
When Select the radio button from the broad,height,Body color
And click on the Next step button.
Then it should redirect to step 2.

Scenario: Step 2
Given Go to Step 2.
When Select the radio button from the Door type part.
And click on the Next step button.
Then it should redirect to step 3.

Scenario: Step 3
Given Go to Step 3.
When Select the radio button from the Front Design,Front Color part.
And click on the Next step button.
Then it should redirect to step 4.

Scenario: Step 4
Given Go to Step 4.
When Select the radio button from the Handle variant.
And click on the Next step button.
Then it should redirect to step 5.

Scenario: Step 5
Given Go to Step 5.
When Select the radio button from the Interior decoration part.
And click on the Next step button.
Then it should redirect to step 6.

Scenario: Step 6
Given Go to Step 6.
When Adding the Equipment items from the list.
Then the price should updated.