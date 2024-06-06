#Author: your.email@your.domain.com
Feature: Ways to Earn program Creation

  @WaystoEarn @BuildfromScracth
  Scenario Outline: Verify build from scratch feature in ways to earn
    Given user is on shopify home page
    When user enters valid <email>, <password> and clicks on login button
    Then user is on shopify dashboard
    When user selects the store "Staging May 2 Test Store 1"
    And clicks on "Rippl Reward staging"
    And navigates to the program-points-"Add Ways to Earn"-"Build From Scratch"
    And enters valid data in <name> and <short_discription> fields
    And enters "action description"
    And selects  <startdate>, <enddate>,<Filter_by_customer_tags>,<image_tracking_type>
    And enters <reward_points> and impact details <water_saved>,<plastic_saved>,<Trees_planted>
    And enters <optional_email_settings> and details of <content>,<correlated_task>
    And uploads the banner image and click on publish button
    Then ways to earn program is created successfully using build from scratch feature

    Examples: 
      | email                          | password    | name                      | short_discription                           | startdate    | enddate      | Filter_by_customer_tags | image_tracking_type  | reward_points | water_saved | plastic_saved | Trees_planted | optional_email_settings        | content | correlated_task          |
      | "abhik.khandelwal01@gmail.com" | "Rippl@321" | "Fitness Bingo challenge" | "Engage in a variety of fitness activities" | "20-05-2024" | "25-05-2024" | "base_tier"             | "Live image capture" | "1"           | "1"         | "1"           | "1"           | "abhik.khandelwal01@gmail.com" | "test"  | "Drink a glass of water" |
