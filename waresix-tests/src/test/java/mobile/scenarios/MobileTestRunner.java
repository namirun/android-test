package mobile.scenarios;

import com.intuit.karate.Results;
import com.intuit.karate.core.Scenario;
import com.intuit.karate.core.ScenarioResult;
import org.junit.jupiter.api.Test;
import utils.BaseRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MobileTestRunner extends BaseRunner {
    String[] FEATURE_TEST_PATH = {
            "classpath:mobile"
    };
    private static final String REPORT_DIR = "mobile-test";
    private String ignoredTags[] = new String[]{"~@ignore"};

    @Test
    void Runner() {
        Results results = karateRunner(FEATURE_TEST_PATH, ignoredTags, REPORT_DIR).parallel(1);
        List<ScenarioResult> failed = results.getScenarioResults().filter(sr -> sr.isFailed()).collect(Collectors.toList());

        if (failed.isEmpty()) {
            KARATE_LOGGER.info("No failed case found");
        } else {
            KARATE_LOGGER.info(String.format("Found %d failed case(s)", failed.size()));
            for (ScenarioResult f : failed) {
                Scenario retryScenario = f.getScenario();
                try {
                    for (int i = 0; i < MAX_RETRY; i++) {
                        KARATE_LOGGER.info(String.format("Retry Attempt: %d - %s", i, retryScenario.getName()));
                        ScenarioResult retryResult = results.getSuite().retryScenario(retryScenario);
                        if (!retryResult.isFailed()) {
                            assertFalse(retryResult.isFailed());
                            results = results.getSuite().updateResults(retryResult);
                            break;
                        }
                    }
                } catch (NullPointerException e) {
                    System.err.println("No more testcases found");
                }
                finally {
                    /**
                     * Remove this remark to generate html cucumber-report
                     */
                    // generateReport(results.getReportDir());
                    assertEquals(0, results.getFailCount(), results.getErrorMessages());
                }
            }
        }
    }
}
