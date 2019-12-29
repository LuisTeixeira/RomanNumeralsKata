package com.lteixeira.kataromannumerals;

import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {

    @Test
    public void invalidNumbers() {
        testFailure(0, "Not possible to convert 0", "Test 0");
        testFailure(-1, "Not possible to convert -1", "Test -1");
        testFailure(4000, "Not possible to convert 4000", "Test 4000");
    }

    @Test
    public void units() {
        testConversion(1, "I", "Test 1 - I");
        testConversion(10, "X", "Test 10 - X");
        testConversion(100, "C", "Test 100 - C");
        testConversion(1000, "M", "Test 1000 - M");
    }

    @Test
    public void halfUnits() {
        testConversion(5, "V", "Test 5 - V");
        testConversion(50, "L", "Test 50 - L");
        testConversion(500, "D", "Test 500 - D");
    }

    @Test
    public void upToThreeUnits() {
        testConversion(2, "II", "Test 2 - II");
        testConversion(3, "III", "Test 3 - III");
        testConversion(20, "XX", "Test 20 - XX");
        testConversion(30, "XXX", "Test 30 - XXX");
        testConversion(200, "CC", "Test 200 - CC");
        testConversion(300, "CCC", "Test 300 - CCC");
        testConversion(2000, "MM", "Test 2000 - MM");
        testConversion(3000, "MMM", "Test 3000 - MMM");
    }

    @Test
    public void oneLessThanUnitOrHalfUnit() {
        testConversion(4, "IV", "Test 4 - IV");
        testConversion(9, "IX", "Test 9 - IX");
        testConversion(40, "XL", "Test 40 - XL");
        testConversion(90, "XC", "Test 90 - XC");
        testConversion(400, "CD", "Test 400 - CD");
        testConversion(900, "CM", "Test 900 - CM");
    }

    @Test
    public void composedNumber() {
        testConversion(7, "VII", "Test 7 - VII");
        testConversion(44, "XLIV", "Test 44 - XLIV");
        testConversion(88, "LXXXVIII", "Test 88 - LXXXVIII");
        testConversion(99, "XCIX", "Test 99 - XCIX");
        testConversion(444, "CDXLIV", "Test 444 - CDXLIV");
        testConversion(786, "DCCLXXXVI", "Test 786 - DCCLXXXVI");
        testConversion(867, "DCCCLXVII", "Test 867 - DCCCLXVII");
        testConversion(999, "CMXCIX", "Test 999 - CMXCIX");
        testConversion(2786, "MMDCCLXXXVI", "Test 2786 - MMDCCLXXXVI");
    }



    private void testConversion(int number, String expected, String description) {
        // Setup
        Converter converter = new Converter();
        // Perform
        String result = converter.toRomanNumeral(number);
        // Assert
        Assert.assertEquals(description, expected, result);
    }


    private void testFailure(int number, String expected, String description) {
        // Setup
        Converter converter = new Converter();

        // Perform
        try {
            converter.toRomanNumeral(number);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(description, expected, e.getMessage());
        } catch (Exception e) {
            Assert.fail("Wrong exception thrown");
        }
    }

}
