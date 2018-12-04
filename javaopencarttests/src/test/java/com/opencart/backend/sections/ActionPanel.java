package com.opencart.backend.sections;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Action Panel")
public class ActionPanel extends HtmlElement {

    @Name("Add New")
    @FindBy(css = "a[data-original-title=\"Add New\"]")
    private Button addNewButton;

    @Name("Save")
    @FindBy(css = "a[data-original-title=\"Save\"]")
    private Button saveButton;

    public void save(){
        saveButton.click();
    }

    public void add(){
        addNewButton.click();
    }

}
