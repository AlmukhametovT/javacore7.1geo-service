package ru.netology.i18n;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import ru.netology.entity.Country;

public class TestLocalizationService {
    private static long suiteStartTime;
    private long testStartTime;

    @BeforeAll
    public static void initSuite() {
        System.out.println("Running All Tests LocalizationService");
        suiteStartTime = System.nanoTime();
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("All Tests completed in time: " + (System.nanoTime() - suiteStartTime));
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Starting new test");
        testStartTime = System.nanoTime();
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("\n" + "Test LocalizationService complete in time: " + (System.nanoTime() - testStartTime));
    }

    @org.junit.jupiter.api.Test
    void testLocalizationServiceRus() {
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        String message = localizationService.locale(Country.RUSSIA);
        String expected = "Добро пожаловать";
        Assertions.assertEquals(message, expected);
    }

    @org.junit.jupiter.api.Test
    void testLocalizationService() {
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Mockito.any()))
                .thenReturn("Welcome");

        String message = localizationService.locale(Country.BRAZIL);
        String expected = "Welcome";
        Assertions.assertEquals(message, expected);
    }
}