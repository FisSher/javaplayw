package org.example;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestHooks {



    // Shared between all tests in the class.
    Playwright playwright;
    Browser browser;

    // New instance for each test method.
    BrowserContext context;
    Page page;

    /*
    Non headless configuration goes in launch.
    You can algo slow mo the execution by adding the setSlowMo (Just if you want to see what is it doing in millisecs)
    new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50)
    */

    @BeforeAll
    void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    void closeBrowser() {
        playwright.close();
    }


    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }
}
