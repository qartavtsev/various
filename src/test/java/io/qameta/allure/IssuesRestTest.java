package io.qameta.allure;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Owner("npolly")
@Feature("Issues")

public class IssuesRestTest {

    private static final String OWNER = "allure-framework";
    private static final String REPO = "allure2";

    private final RestSteps steps = new RestSteps();

    @TM4J("AE-T1")
    @Story("Create new issue")
    @Layer("api")
    @Tags({@Tag("api")})
    @DisplayName("[16] Create issue via api")
    @ParameterizedTest(name = " (parameterized)")
    @ValueSource(strings = {"First Note", "Second Note"})
    public void shouldCreateUserNote(@Param(value = "Title") String title) {
        steps.createIssueWithTitle(OWNER, REPO, title);
        steps.shouldSeeIssueWithTitle(OWNER, REPO, title);
    }

    @TM4J("AE-T2")
    @Story("Close existing issue")
    @Tags({@Tag("web")})
    @DisplayName("[17] Close issue via api")
    @ParameterizedTest(name = " (parameterized)")
    @ValueSource(strings = {"First Note", "Second Note"})
    public void shouldDeleteUserNote(@Param(value = "Title") String title) {
        steps.createIssueWithTitle(OWNER, REPO, title);
        steps.closeIssueWithTitle(OWNER, REPO, title);
    }
}
