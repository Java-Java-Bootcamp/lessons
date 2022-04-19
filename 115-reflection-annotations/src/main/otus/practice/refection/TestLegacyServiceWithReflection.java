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
    public void readingPrivateField() {
        TemperatureService serviceToBeTested = new TemperatureService();
        serviceToBeTested.init();
        try {
            Field field = serviceToBeTested.getClass().getDeclaredField("privateField");
            field.setAccessible(true);
            String privateFieldValue = (String) field.get(serviceToBeTested);

            System.out.println("value inside: " + privateFieldValue);
            assertNotNull(privateFieldValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
        }
    }

    @Test
    public void writePrivateField() {
        TemperatureService serviceToBeTested = new TemperatureService();
        serviceToBeTested.init();
        try {
            Field field = serviceToBeTested.getClass().getDeclaredField("privateField");
            field.setAccessible(true);
            field.set(serviceToBeTested, "new value");
            String privateFieldValue = (String) field.get(serviceToBeTested);

            System.out.println("value inside: " + privateFieldValue);

            assertEquals("new value", privateFieldValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {

        }
    }
//
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
