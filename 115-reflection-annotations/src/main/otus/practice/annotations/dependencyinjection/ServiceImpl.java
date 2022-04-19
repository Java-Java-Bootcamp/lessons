package main.otus.practice.annotations.dependencyinjection;

public class ServiceImpl implements Service{
    @Override
    public String callMe() {
        return "data from my service";
    }
}
