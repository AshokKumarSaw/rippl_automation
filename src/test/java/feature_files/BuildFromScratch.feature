#Author: Ashok Kumar Saw
Feature: Ways to Earn
  I want to use this template for my feature file

  @buildfromscratch @waystoearn
  Scenario Outline: As an admin user, I should be able to build a template from scratch
    Given user is on shopify dashboard "shopify_email", "shopify_password"
    When user selects the store <store_name>
    And selects the Rippl Reward staging extension
    And navigates to Add Ways to Earn - Build From Scratch
    And fills up the build from scratch form with appropriate data "challenge_name", <short_description>, <action_description>, <startdate>, <enddate>, <filterByTags>, <tracking_instruction>, <reward_points>, <water_saved>, <plastic_saved>, <trees_planted>, <optional_email_settings>, <content>, <correlated_task>
    And uploads banner image and publishes the challenge
    Then verify created "challenge_name" is displayed in Ways to Earn challenges list
    And verify created challenge contains exactly the same details filled in the form during creation  "challenge_name", <short_description>, <action_description>, <startdate>, <enddate>, <filterByTags>, <tracking_instruction>, <reward_points>, <water_saved>, <plastic_saved>, <trees_planted>, <optional_email_settings>, <content>, <correlated_task>
    And verify the created "challenge_name" is visible on user dash widget under Actions for Base_Tier customers <filterByTags>
    And verify user can view the challenge "challenge_name" in widget dash only if the challenege status <challenge_status> is set as active
    And verify user is assigned and able to view base tier <filterByTags> by default in widget dash
    And verify same <short_description> is visible on user dash widget under Actions just below the "challenge_name"
    And verify same <action_description> is visible under details when user selects the "challenge_name"
    And verify user can view same <tracking_instruction> in widget dash while completing the challenge set during challenge creation
    And verify user is able to complete the "challenge_name" only once
    And verify users account is credited with the same <reward_points> on completing the "challenge_name" which was configured
    And verify on approving the completed action, a <correlated_task> configured in the challenge is created in the Tasks
    And verify imapct reward point <reward_points> should only be credited to the users account if the action is approved
    And verify on completing an action "challenge_name" a confirmation email should be sent to the registered users email address
    And verify user can not view the challenge "challenge_name" in widget dash if the challenege status <challenge_status> is set as Inactive
    And verify user can not view the challenge "challenge_name" in widget dash after the challenge is expired <enddate>



    Examples: 
      | store_name                   | short_description                           | action_description                                                                                                                                                                                                                                                                                                                                                               | startdate    | enddate      | filterByTags | tracking_instruction | reward_points | water_saved | plastic_saved | trees_planted | optional_email_settings        | content | correlated_task          |
      | "Staging May 2 Test Store 1" | "Engage in a variety of fitness activities" | "Participants will receive a bingo card with various fitness-related activities in each square, such as jogging for 30 minutes, completing a yoga session, or doing 50 push-ups. They must complete these activities to mark off the corresponding squares on their card. The goal is to achieve a bingo pattern (horizontal, vertical, or diagonal) within the given timeframe" | "12-20-2024" | "11-30-2026" | "base_tier"  | "send evidence"      | "1"           | "1"         | "1"           | "1"           | "abhik.khandelwal01@gmail.com" | "test"  | "Drink a glass of water" |
