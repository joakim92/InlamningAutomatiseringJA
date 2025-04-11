package stepDefinitions;

import io.cucumber.java.After;
import java.util.concurrent.TimeUnit;

public class ScenarioDelay {

    @After
    public void waitForNextScenario() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

