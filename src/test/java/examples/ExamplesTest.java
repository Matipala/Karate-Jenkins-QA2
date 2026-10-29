package examples;

import io.karatelabs.core.Runner;
import io.karatelabs.core.SuiteResult;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExamplesTest {
    @Test
    void runApiTests() {
        SuiteResult result = Runner.path("classpath:examples")
                .outputHtmlReport(true)
                .outputJunitXml(true)
                .parallel(1);
        assertTrue(result.isPassed(), "Las pruebas Karate fallaron. Revisar target/karate-reports.");
    }
}
