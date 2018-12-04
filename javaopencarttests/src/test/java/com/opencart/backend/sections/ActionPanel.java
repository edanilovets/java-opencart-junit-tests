package com.opencart.backend.sections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(css = "#content > div.page-header > div > div")
public class ActionPanel extends HtmlElement {

    @FindBy(css = "a[data-original-title=\"Add New\"]")
    private WebElement addNewButton;

    @FindBy(css = "button[data-original-title=\"Save\"]")
    private WebElement saveButton;

    @FindBy(css = "a[data-original-title=\"Cancel\"]")
    private WebElement cancelButton;

    @FindBy(css = "button[data-original-title=\"Delete\"]")
    private WebElement deleteButton;

    public void save(){
        saveButton.click();
    }
    public void add(){
        addNewButton.click();
    }
    public void cancel() {
        cancelButton.click();
    }
    public void delete(){
        deleteButton.click();
    }
}
