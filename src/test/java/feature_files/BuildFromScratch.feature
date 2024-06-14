#Author: Ashok Kumar Saw

Feature: Ways to Earn
  I want to use this template for my feature file

  @buildfromscratch @waystoearn
  Scenario Outline: As an admin user, I should be able to build a template from scratch
    Given user is on shopify dashboard "shopify_email", "shopify_password"
    When user selects the store <store_name>
    And selects the Rippl Reward staging extension
    And navigates to Add Ways to Earn - Build From Scratch
    And fills up the build from scratch form with appropriate data <challenge_name>, <short_description>, <action_description>, <startdate>, <enddate>, <filterByTags>, <tracking_instruction>, <reward_points>, <water_saved>, <plastic_saved>, <trees_planted>, <optional_email_settings>, <content>, <correlated_task>
    And uploads banner image and publishes the challenge
    Then verify created <challenge_name> is displayed in Ways to Earn challenges list
    And verify created challenge contains exactly the same details filled in the form during creation  <challenge_name>, <short_description>, <action_description>, <startdate>, <enddate>, <filterByTags>, <tracking_instruction>, <reward_points>, <water_saved>, <plastic_saved>, <trees_planted>, <optional_email_settings>, <content>, <correlated_task>

    Examples: 
      | store_name                   | challenge_name            | short_description                           | action_description                                                                                                                                                                                                                                                                                                                                                               | startdate    | enddate      | filterByTags | tracking_instruction | reward_points | water_saved | plastic_saved | trees_planted | optional_email_settings        | content | correlated_task          |
      | "Staging May 2 Test Store 1" | "Fitness Bingo challenge" | "Engage in a variety of fitness activities" | "Participants will receive a bingo card with various fitness-related activities in each square, such as jogging for 30 minutes, completing a yoga session, or doing 50 push-ups. They must complete these activities to mark off the corresponding squares on their card. The goal is to achieve a bingo pattern (horizontal, vertical, or diagonal) within the given timeframe" | "06-20-2024" | "06-30-2024" | "base_tier"  | "send evidence"      | "1"           | "1"         | "1"           | "1"           | "abhik.khandelwal01@gmail.com" | "test"  | "Drink a glass of water" |
