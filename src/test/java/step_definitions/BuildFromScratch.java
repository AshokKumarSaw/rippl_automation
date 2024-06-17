package step_definitions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.BuildFromScratchPage;
import page_objects.ShopifyLandingPage;
import page_objects.Rippl_RewardsPage;
import page_objects.ShopifyLoginPage;

public class BuildFromScratch {
	ShopifyLoginPage shopifyLoginPage = new ShopifyLoginPage(Hook.driver);
	ShopifyLandingPage shopifyLandinPage = new ShopifyLandingPage(Hook.driver);
	Rippl_RewardsPage rippl_RewardsPage = new Rippl_RewardsPage(Hook.driver);
	BuildFromScratchPage buildFromScratchPage = new BuildFromScratchPage(Hook.driver);

	@Given("user is on shopify dashboard {string}, {string}")
	public void user_is_on_shopify_dashboard(String shopify_email, String shopify_password) {
		shopifyLoginPage.loginShopify(shopify_email, shopify_password);
	}

	@When("user selects the store {string}")
	public void user_selects_the_store(String store_name) {
		shopifyLandinPage.selectStore(store_name);
	}

	@When("selects the Rippl Reward staging extension")
	public void selects_the_rippl_reward_staging_extension() {
		shopifyLandinPage.clickRipplRewardStagingLnk();
	}

	@When("navigates to Add Ways to Earn - Build From Scratch")
	public void navigates_to_add_ways_to_earn_build_from_scratch() {
		rippl_RewardsPage.navigateToBuildFromScratchTemplate();
	}

	@When("fills up the build from scratch form with appropriate data {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void fills_up_the_build_from_scratch_form_with_appropriate_data(String challenge_name,
			String short_description, String action_description, String startdate, String enddate, String filterByTags,
			String tracking_instruction, String reward_points, String water_saved, String plastic_saved,
			String Trees_planted, String optional_email_settings, String content, String correlated_task) {
		buildFromScratchPage.buildFromScratchFormData(challenge_name, short_description, action_description, startdate,
				enddate, filterByTags, tracking_instruction, reward_points, water_saved, plastic_saved, Trees_planted,
				optional_email_settings, content, correlated_task);

	}

	@When("uploads banner image and publishes the challenge")
	public void uploads_banner_image_and_publishes_the_challenge() {
		buildFromScratchPage.publish();
	}

	@Then("verify created {string} is displayed in Ways to Earn challenges list")
	public void verify_created_is_displayed_in_ways_to_earn_challenges_list(String challenge_name) {
		rippl_RewardsPage.verifyNewlyCreatedChallengeFromWaysToEarnList(challenge_name);
	}

	@Then("verify created challenge contains exactly the same details filled in the form during creation  {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void verify_created_challenge_contains_exactly_the_same_details_filled_in_the_form_during_creation(
			String challenge_name, String short_description, String action_description, String startdate,
			String enddate, String filterByTags, String tracking_instruction, String reward_points, String water_saved,
			String plastic_saved, String Trees_planted, String optional_email_settings, String content,
			String correlated_task) {

		Map<String, String> challengeDetails = new HashMap<>();
		challengeDetails.put("challengeName", challenge_name);
		challengeDetails.put("shortDescription", short_description);
		challengeDetails.put("actionDescription", action_description);
		challengeDetails.put("startDate", startdate);
		challengeDetails.put("endDate", enddate);
		challengeDetails.put("filter_By_Tags", filterByTags);
		challengeDetails.put("trackinginstruction", tracking_instruction);
		challengeDetails.put("rewardpoints", reward_points);
		challengeDetails.put("watersaved", water_saved);
		challengeDetails.put("plasticsaved", plastic_saved);
		challengeDetails.put("treesplanted", Trees_planted);
		challengeDetails.put("optionalEmailSettings", optional_email_settings);
		challengeDetails.put("Content", content);
		challengeDetails.put("correlatedTask", correlated_task);
		buildFromScratchPage.verifyChallengeDetails(challengeDetails);

	}

}
