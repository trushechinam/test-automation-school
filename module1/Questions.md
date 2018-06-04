* What will be returned (method return type) by each of the following methods:
```
    private WebElement getInput() {
        return driver.findElement(By.tagName("input"));
    }

 e-mais search field
    private String getInput() {
        return "<input></input>";
    }
    
     //input block

    private List<WebElement> getInputList() {
        return driver.findElements(By.tagName("input"));
    }
     //input field

    private List<String> getInputList() {
        List<String> list = new ArrayList<>();
        list.add("<input></input>");
        list.add("<input></input>");
        return list;
    }
   // 2 input blocks
```

* Will this snippet code will be executed if element is not found on the page? If not, then why?
    ```
    driver.findElement(By.id("some_id").isDisplayed())
    
    //no, as expectation is that element will be displayed
    ```
* Why there is no `isPresent()` method for WebElement interface?
- there is isExists method , isPresent it is more in the moment of time, the different answers are possible during the test execusion
* Which interface is responsible for controling the browser and finding DOM elements?
- driver for every web browser, for example Firefox, Chrome...
* Which interface is intended for interacting with DOM elements?
---
* Name all the WebElement locating mechanisms?
by id, name, xpath, cssSelector, className
* What `driver.findElement(...)` method returns?
- 1 element
* What is the argument to `driver.findElement(...)` method?
- location of the element
* Which class defines different locating mechanisms?
- by
* What is the difference between element is displayed and element is present?
 - displayed - visiable, present - can be hidden
* How to retrieve multiple elements at once? What would be variable type for referencing such Java object?
- List<WebElement> images = driver.findElements
* How to bypass _NoSuchElementException_ if there is no gurantee that element will be found on the page?
- in the metod declaration
* Which browser management strategy is better to use? Why?
--
* What will happen if you will try to locate following element? (TIP - `display:none` sets element to be not rendered)
What will happen if isDisplayed will be invoked on this element?
- you wll not be able to make eny actions with them
```
  <div id='elementId' style='display:none'>
    ...
  </div>
```  