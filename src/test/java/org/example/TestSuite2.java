package org.example;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestSuite2 extends TestHooks {

    @Test
    void shouldReturnInnerHTMLTest() {
        page.setContent("<div>Esto es nuevo contenido</div>");
        assertEquals("Esto es nuevo contenido", page.innerHTML("css=div"));
    }

    @Test
    void shouldClickButtonTest() {
        Page popup = page.waitForPopup(() -> {
            page.evaluate("window.open('about:blank');");
        });
        assertEquals("about:blank", popup.url());

    }
}
