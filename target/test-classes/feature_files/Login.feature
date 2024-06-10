#Author: your.email@your.domain.com
Feature: Ways to Earn program Creation

  @WaystoEarn @BuildfromScracth
  Scenario Outline: Verify build from scratch feature in ways to earn
    Given user is on shopify home page
    When user enters valid <email>, <password> and clicks on login button
    Then user is on shopify dashboard
    When user selects the store Staging May two Test Store one
    And clicks on Rippl Reward staging
    And navigates to the program-points-Add Ways to Earn-Build From Scratch
    And enters valid data in <name> and <short_description> fields
    And enters <action_description>
    And selects  <startdate>, <enddate>,<Filter_by_customer_tags>,<tracking_instruction>
    And enters <reward_points> and impact details <water_saved>,<plastic_saved>,<Trees_planted>
    And enters <optional_email_settings> and details of <content>,<correlated_task>
    And uploads the banner image and click on publish button
    Then ways to earn program is created successfully using build from scratch feature

    Examples: 
      | email                          | password    | name                      | short_description                           | action_description                                                                                                                                                                                                                                                                                                                                                               | startdate    | enddate      | Filter_by_customer_tags | tracking_instruction | reward_points | water_saved | plastic_saved | Trees_planted | optional_email_settings        | content | correlated_task          |
      | "abhik.khandelwal01@gmail.com" | "Rippl@321" | "Fitness Bingo challenge" | "Engage in a variety of fitness activities" | "Participants will receive a bingo card with various fitness-related activities in each square, such as jogging for 30 minutes, completing a yoga session, or doing 50 push-ups. They must complete these activities to mark off the corresponding squares on their card. The goal is to achieve a bingo pattern (horizontal, vertical, or diagonal) within the given timeframe" | "06-20-2024" | "06-30-2024" | "base_tier"             | "send evidence"      | "1"           | "1"         | "1"           | "1"           | "abhik.khandelwal01@gmail.com" | "test"  | "Drink a glass of water" |
