package com.lteixeira.kataromannumerals;

import java.util.*;

public class Converter {

    public String toRomanNumeral(int number) {
        if (number > 0 && number < 4000) {
            return convertNumberToRomanNumeral(number);
        }
        throw new IllegalArgumentException("Not possible to convert " + number);
    }

    private String convertNumberToRomanNumeral(int number) {
        List<Integer> digits = getDigits(number);
        RomanNumeralWriter romanNumeralWriter = new RomanNumeralWriter();
        return romanNumeralWriter.writeRomanNumeral(digits);
    }


    private List<Integer> getDigits(int number) {
        List<Integer> digitsBuilder = new ArrayList<>();
        while (number > 0) {
            digitsBuilder.add(number % 10);
            number = number / 10;
        }
        return digitsBuilder;
    }

}
