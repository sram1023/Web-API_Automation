package utils;

import context.TestContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import steps.WaitSteps;

import java.util.Locale;

@Slf4j
public class AssertionText implements Assertion {

    private final String expected;
    private final String itemKey;
    private final TestContext testContext;
    private final WaitSteps page;

    public AssertionText(String expected, String itemKey, WaitSteps page,TestContext testContext) {
        this.expected = expected;
        this.itemKey = itemKey;
        this.testContext = testContext;
        this.page = page;
    }

    @Override
    public void assertAction() {
        String actual = page.waitForElementVisible(itemKey, testContext).getText();
        log.info("Actual:"+actual);
        Assert.assertEquals(actual,expected.toUpperCase(Locale.ROOT));
    }
}
