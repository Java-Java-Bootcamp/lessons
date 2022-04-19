package main.otus.annotations;

public class MyCode {

    @MyDepricated(dateOutdated = "2020-07-06")
    public String veryOldLegacyCode(){
        return "12";
    }

}
