package com.opencart.backend.sections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Action Panel")
@FindBy(css = "#content > div.page-header > div > div")
public class ActionPanel extends HtmlElement {

    @Name("Add New")
    @FindBy(css = "a[data-original-title=\"Add New\"]")
    private WebElement addNewButton;

    @Name("Save")
    @FindBy(css = "button[data-original-title=\"Save\"]")
    private WebElement saveButton;

    public void save(){
        saveButton.click();
    }

    public void add(){
        addNewButton.click();
    }

}
