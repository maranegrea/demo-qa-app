package org.fasttrackit;

import static com.codeborne.selenide.Selenide.open;

public class Page {
    public void openDemoQaApp() {
        String demoQaUrl = "https://demoqa.com/";
        System.out.println("Opening: " + demoQaUrl);
        open(demoQaUrl);
    }

   // public void refreshPage() {
      //  Selenide.refresh();

    // }
}
