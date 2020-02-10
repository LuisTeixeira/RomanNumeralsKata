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
        RomanNumeralWriter romanNumeralWriter = new RomanNumeralWriter();
        return romanNumeralWriter.writeRomanNumeral(number);
    }

}
