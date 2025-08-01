/*
 * The MIT License
 *
 * Copyright (c) 2009-2025 PrimeTek Informatics
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.primefaces.integrationtests.accordionpanel;

import org.primefaces.selenium.AbstractPrimePage;
import org.primefaces.selenium.AbstractPrimePageTest;
import org.primefaces.selenium.component.AccordionPanel;
import org.primefaces.selenium.component.SelectBooleanCheckbox;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccordionPanel004Test extends AbstractPrimePageTest {
    @Test
    public void test(Page page) {
        // Arrange
        AccordionPanel accordionPanel = page.accordionPanel;
        SelectBooleanCheckbox toggle = page.toggle;

        // Act
        toggle.click();

        // Assert
        assertEquals(2, accordionPanel.getSelectedTabs().size());
        assertEquals("tab2", accordionPanel.getSelectedTabs().get(0).getTitle());
        assertEquals("tab3", accordionPanel.getSelectedTabs().get(1).getTitle());
    }

    public static class Page extends AbstractPrimePage {
        @FindBy(id = "form:toggle")
        SelectBooleanCheckbox toggle;

        @FindBy(id = "form:accordionpanel")
        AccordionPanel accordionPanel;

        @Override
        public String getLocation() {
            return "accordionpanel/accordionPanel004.xhtml";
        }
    }
}
