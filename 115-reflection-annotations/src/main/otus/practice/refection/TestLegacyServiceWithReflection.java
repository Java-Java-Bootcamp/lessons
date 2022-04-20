package main.otus.practice.refection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestLegacyServiceWithReflection {

    @Test
    public void readPrivateFieldValue() {
        TemperatureService service = new TemperatureService();
        service.init();

        try {
            Field field = service.getClass().getDeclaredField("temperature");
            field.setAccessible(true);
            Integer temperature = (Integer) field.get(service);
            System.out.println("private field value is: " + temperature);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {

        }
    }

    @Test
    public void writePrivateField() {
        TemperatureService service = new TemperatureService();
        service.init();

        try {
            Field field = service.getClass().getDeclaredField("temperature");
            field.setAccessible(true);
            field.set(service, 33);

            Integer temperature = (Integer) field.get(service);
            System.out.println("private field value is: " + temperature);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("exception: " + e.getMessage());
        }
    }

    @Test
    public void callMethod() {
        try {
            TemperatureService serviceToBeTested = new TemperatureService();
            Method privateField = serviceToBeTested.getClass().getDeclaredMethod("convertToFahrenheit", int.class);
            privateField.setAccessible(true);

            assertEquals(42, privateField.invoke(serviceToBeTested, 10));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {

        }
    }

    @Test
    public void initiatingServiceAndSetValue() {
        try {
            Class<TemperatureService> serviceToBeTestedClass = TemperatureService.class;
            Constructor<TemperatureService> constructor = serviceToBeTestedClass.getConstructor();

            TemperatureService serviceToBeTested = constructor.newInstance();

            Field field = serviceToBeTested.getClass().getDeclaredField("temperature");
            field.setAccessible(true);
            field.set(serviceToBeTested, 10);
            assertEquals("temperature in fahrenheit is: " + 42, serviceToBeTested.getTemperatureInformationInFahrenheit());

        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException ignored) {

        }
    }


}
