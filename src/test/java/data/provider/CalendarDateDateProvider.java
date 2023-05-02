package data.provider;

import org.testng.annotations.DataProvider;

public class CalendarDateDateProvider {
    @DataProvider(name = "validPredefinedDate")
    public Object[][] calendarDateDataProvider() {
        CalendarDate predefinedDate1 = new CalendarDate("9", "2024", "10/17/2024");
        CalendarDate predefinedDate2 = new CalendarDate("3", "2045","04/17/2045");
        CalendarDate predefinedDate3 = new CalendarDate("5", "2033","06/17/2033");
        CalendarDate predefinedDate4 = new CalendarDate("11", "2025", "12/17/2025");
        CalendarDate predefinedDate5 = new CalendarDate("6", "2042", "07/17/2042");
        CalendarDate predefinedDate6 = new CalendarDate("8", "2050", "09/17/2050");
        CalendarDate predefinedDate7 = new CalendarDate("0", "2069", "01/17/2069");

        return new Object[][]{
                {predefinedDate1},
                {predefinedDate2},
                {predefinedDate3},
                {predefinedDate4},
                {predefinedDate5},
                {predefinedDate6},
                {predefinedDate7}

        };


    }
}
