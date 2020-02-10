package com.lteixeira.kataromannumerals;

import org.junit.Assert;
import org.junit.Test;

public class ConverterToDecimalTest {

    @Test
    public void testUnits() {
        testConversion("I", 1, "Test I = 1");
        testConversion("X", 10, "Test X = 10");
        testConversion("C", 100, "Test C = 100");
        testConversion("M", 1000, "Test M = 1000");
    }

    @Test
    public void testHalfUnits() {
        testConversion("V", 5, "Test V = 5");
        testConversion("L", 50, "Test L = 50");
        testConversion("D", 500, "Test D = 500");
    }

    @Test
    public void testUntilMultipleOfThreeUnits() {
        testConversion("II", 2, "Test II = 2");
        testConversion("III", 3, "Test III = 3");
        testConversion("XX", 20, "Test XX = 20");
        testConversion("XXX", 30, "Test XXX = 30");
        testConversion("CC", 200, "Test CC = 200");
        testConversion("CCC", 300, "Test CCC = 300");
        testConversion("MM", 2000, "Test MM = 2000");
        testConversion("MMM", 3000, "Test MMM = 3000");
    }

    @Test
    public void oneLessThanUnitOrHalfUnit() {
        testConversion("IV", 4,  "Test IV - 4");
        testConversion("IX", 9,  "Test IX - 9");
        testConversion("XL", 40, "Test XL - 40");
        testConversion("XC", 90, "Test XC - 90");
        testConversion("CD", 400,"Test CD - 400");
        testConversion("CM", 900,"Test CM - 900");
    }

    @Test
    public void composedNumber() {
        testConversion("VII", 7, "Test 7 - VII");
        testConversion("XLIV", 44,"Test 44 - XLIV");
        testConversion("LXXXVIII", 88,"Test 88 - LXXXVIII");
        testConversion("XCIX", 99, "Test 99 - XCIX");
        testConversion("CDXLIV", 444, "Test 444 - CDXLIV");
        testConversion("DCCLXXXVI", 786, "Test 786 - DCCLXXXVI");
        testConversion("DCCCLXVII", 867, "Test 867 - DCCCLXVII");
        testConversion("CMXCIX", 999, "Test 999 - CMXCIX");
        testConversion("MMDCCLXXXVI", 2786,"Test 2786 - MMDCCLXXXVI");
    }

    private void testConversion(String romanNumeral, Integer expected, String description) {
        Converter converter = new Converter();
        Integer decimal = converter.toDecimal(romanNumeral);
        Assert.assertEquals(description, (long) expected, (long) decimal);
    }

}
