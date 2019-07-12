package com.rickandmorty.info.converter;

public final class ConvertStringToInt {

    public static int srtToInt(String string){
        string = string.replaceAll("\\D+","");
        return Integer.parseInt(string);
    }

    public static Long srtToLong(String string){
        string = string.replaceAll("\\D+","");
        return Long.parseLong(string);
    }
}
