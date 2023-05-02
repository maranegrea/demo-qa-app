package data.provider;

public class CalendarDate {
    private String month;
    private String year;
    private String expectedResults;

    public CalendarDate(String month, String year, String expectedResult) {

        this.month = month;
        this.year = year;
        this.expectedResults = expectedResult;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getExpectedResults() {
        return expectedResults;
    }

    ;

    @Override
    public String toString() {
        return year;
    }

}
