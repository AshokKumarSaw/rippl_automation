package step_definitions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.BuildFromScratchPage;
import page_objects.RipplUserDashboardPage;
import page_objects.ShopifyLandingPage;
import page_objects.Rippl_RewardsPage;
import page_objects.ShopifyLoginPage;

public class BuildFromScratch {
	ShopifyLoginPage shopifyLoginPage = new ShopifyLoginPage(Hook.driver);
	ShopifyLandingPage shopifyLandinPage = new ShopifyLandingPage(Hook.driver);
	Rippl_RewardsPage rippl_RewardsPage = new Rippl_RewardsPage(Hook.driver);
	BuildFromScratchPage buildFromScratchPage = new BuildFromScratchPage(Hook.driver);
	RipplUserDashboardPage ripplUserDashboardPage = new RipplUserDashboardPage(Hook.driver);

	@Given("user is on shopify dashboard {string}, {string}")
	public void user_is_on_shopify_dashboard(String shopify_email, String shopify_password) {

		shopifyLoginPage.clickShopifyLoginLnk();
		shopifyLoginPage.enterShopifyEmail(shopify_email);
		shopifyLoginPage.clickContinueWithEmail();
		shopifyLoginPage.enterShopifyPassword(shopify_password);
		shopifyLoginPage.clickShopifyLoginBtn();
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

		rippl_RewardsPage.clickHamburgerIcon();
		rippl_RewardsPage.clickProgramDrpdwn();
		rippl_RewardsPage.clickPoints();
		rippl_RewardsPage.clickAddWaysToEarn();
		rippl_RewardsPage.clickBuildFromScratch();

	}

	@When("fills up the build from scratch form with appropriate data {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void fills_up_the_build_from_scratch_form_with_appropriate_data(String challenge_name,
			String short_description, String action_description, String startdate, String enddate, String filterByTags,
			String tracking_instruction, String reward_points, String water_saved, String plastic_saved,
			String Trees_planted, String optional_email_settings, String content, String correlated_task) {

		buildFromScratchPage.randomChallengeName(challenge_name);
		buildFromScratchPage.enterShortDescription(short_description);
		buildFromScratchPage.enterActionDescription(action_description);
		buildFromScratchPage.enterStartDate(startdate);
		buildFromScratchPage.enterEndDate(enddate);
		buildFromScratchPage.selectFltrByCusTag(filterByTags);
		buildFromScratchPage.enterTrackingInstruction(tracking_instruction);
		buildFromScratchPage.uploadBannerImage();
		buildFromScratchPage.enterRewardPoint(reward_points);
		buildFromScratchPage.enterImpactOne(water_saved);
		buildFromScratchPage.enterImpactTwo(plastic_saved);
		buildFromScratchPage.enterImpactThree(Trees_planted);
		buildFromScratchPage.enterOptionalEmailSettings(optional_email_settings);
		buildFromScratchPage.enterContent(content);
		buildFromScratchPage.enterCorelatedTask(correlated_task);

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

	@Then("verify the created {string} is visible on user dash widget under Actions for Base_Tier customers {string}")
	public void verify_the_created_is_visible_on_user_dash_widget_under_actions_for_base_tier_customers(
			String challenge_name, String filterByTags) {
		ripplUserDashboardPage.launchRipplRewardsUserDashboard();
		ripplUserDashboardPage.loginToRipplRewardsUserDashboard();
		ripplUserDashboardPage.getChallengeNameFromWidgetDash(challenge_name);
		ripplUserDashboardPage.getTagNameFromWidgetDash(filterByTags);

	}

	@Then("verify user can view the challenge {string} in widget dash only if the challenege status <challenge_status> is set as active")
	public void verify_user_can_view_the_challenge_in_widget_dash_only_if_the_challenege_status_challenge_status_is_set_as_active(
			String challenge_name) {
		ripplUserDashboardPage.getChallengeNameFromWidgetDash(challenge_name);

	}

	@Then("verify user is assigned and able to view base tier {string} by default in widget dash")
	public void verify_user_is_assigned_and_able_to_view_base_tier_by_default_in_widget_dash(String filterByTags) {
		ripplUserDashboardPage.getTagNameFromWidgetDash(filterByTags);
	}

	@Then("verify same {string} is visible on user dash widget under Actions just below the {string}")
	public void verify_same_is_visible_on_user_dash_widget_under_actions_just_below_the(String challenge_name,
			String short_description) {
		ripplUserDashboardPage.validateShortDescription(challenge_name, short_description);
	}

	@Then("verify same {string} is visible under details when user selects the {string}")
	public void verify_same_is_visible_under_details_when_user_selects_the(String challenge_name,
			String action_description) {
		ripplUserDashboardPage.validateActionDescription(challenge_name, action_description);
	}

	@Then("verify user can view same {string} in widget dash for the challenge {string} set during challenge creation")
	public void verify_user_can_view_same_in_widget_dash_for_the_challenge_set_during_challenge_creation(
			String challenge_name, String tracking_instruction) {
		ripplUserDashboardPage.validateTrackingInstructions(challenge_name, tracking_instruction);
	}

	@Then("verify user is able to complete the {string} only once")
	public void verify_user_is_able_to_complete_the_only_once(String string) {

	}

	@Then("verify users account is credited with the same {string} on completing the {string} which was configured")
	public void verify_users_account_is_credited_with_the_same_on_completing_the_which_was_configured(String string,
			String string2) {

	}

	@Then("verify on approving the completed action, a {string} configured in the challenge is created in the Tasks")
	public void verify_on_approving_the_completed_action_a_configured_in_the_challenge_is_created_in_the_tasks(
			String string) {

	}

	@Then("verify imapct reward point {string} should only be credited to the users account if the action is approved")
	public void verify_imapct_reward_point_should_only_be_credited_to_the_users_account_if_the_action_is_approved(
			String string) {

	}

	@Then("verify on completing an action {string} a confirmation email should be sent to the registered users email address")
	public void verify_on_completing_an_action_a_confirmation_email_should_be_sent_to_the_registered_users_email_address(
			String string) {

	}

	@Then("verify user can not view the challenge {string} in widget dash if the challenege status <challenge_status> is set as Inactive")
	public void verify_user_can_not_view_the_challenge_in_widget_dash_if_the_challenege_status_challenge_status_is_set_as_inactive(
			String string) {

	}

	@Then("verify user can not view the challenge {string} in widget dash after the challenge is expired {string}")
	public void verify_user_can_not_view_the_challenge_in_widget_dash_after_the_challenge_is_expired(String string,
			String string2) {

	}

}
