package ru.netology.geo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class TestGeoService {
    private static long suiteStartTime;
    private long testStartTime;

    @BeforeAll
    public static void initSuite() {
        System.out.println("Running All Tests GeoService");
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
        System.out.println("\n" + "Test GeoService complete in time: " + (System.nanoTime() - testStartTime));
    }

    @ParameterizedTest
    @ValueSource(strings = {"172.0.32.11", "172.16.0.1", "172.16.0.18"})
    void testLocationByIpRussia(String argument) {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(argument))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        Assertions.assertTrue(geoService.byIp(argument).getCountry().equals(Country.RUSSIA));
    }

    @ParameterizedTest
    @ValueSource(strings = {"96.44.183.149", "96.69.96.69", "96.0.0.1"})
    void testLocationByIpUsa(String argument) {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(argument))
                .thenReturn(new Location("New York", Country.USA, null, 0));

        Assertions.assertTrue(geoService.byIp(argument).getCountry().equals(Country.USA));
    }
}