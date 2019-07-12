package com.rickandmorty.info.converter;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ConvertImgToInputStream {

    public static byte[] imgToIS(String urlString) throws IOException{
        InputStream is = new URL(urlString).openStream();

        return IOUtils.toByteArray(is);
    }
}