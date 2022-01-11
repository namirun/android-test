package utils;

import com.intuit.karate.Logger;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BaseRunner {
    protected static final String THREAD_COUNT_PROPERTY_NAME = "test.thread.count";
    protected static final String KARATE_OUTPUT_PATH = "target/surefire-reports/";
    protected static final String REPORT_OUTPUT_DIRECTORY = "target";
    protected static int THREAD_COUNT = 5;
    protected static final int MAX_RETRY = 0;
    protected static final Logger KARATE_LOGGER = new Logger();

    public Runner.Builder karateRunner(String[] testPath, String[] ignoredTags, String reportDirname) {
        return Runner.path(testPath)
                .tags(ignoredTags)
                .outputCucumberJson(true)
                .reportDir(KARATE_OUTPUT_PATH + reportDirname);
    }

    public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "waresix-api-test");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }

}
