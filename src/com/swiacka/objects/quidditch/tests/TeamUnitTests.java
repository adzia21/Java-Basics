package com.company.objects.quidditch.tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class TeamUnitTests {


    @Test
    public void hasNullTest() {
        String[] chasers = new String[]{null, "Ginny", "Katie"};
        Assertions.assertTrue(Arrays.asList(chasers).contains(null));
    }

    @Test
    public void nasNull() {
        String[] chasers = {"    ", "Ginny", "Katie"};
        Assertions.assertTrue(Arrays.stream(chasers).anyMatch(String::isBlank));
    }



}
