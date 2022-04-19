package main.otus.practice.annotations.dependencyinjection;

public class ServiceWithInjection {

    @Inject
    private Service myService;

    public String callService() {
        return myService.callMe();
    }

}
