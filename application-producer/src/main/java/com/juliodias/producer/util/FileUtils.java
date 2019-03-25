package com.juliodias.producer.util;

import com.google.gson.Gson;
import com.juliodias.producer.model.City;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileUtils {

    private static final String CITIES_FILE = "classpath:cities.json";

    public static Stream<City> getCities() throws Exception {
        File citiesFile = ResourceUtils.getFile(CITIES_FILE);

        FileReader fileReader = new FileReader(citiesFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        return convertCitiesFrom(bufferedReader);
    }

    private static Stream<City> convertCitiesFrom(BufferedReader bufferedReader) {
        City[] cities = new Gson().fromJson(bufferedReader, City[].class);
        return Arrays.stream(cities);
    }
}
