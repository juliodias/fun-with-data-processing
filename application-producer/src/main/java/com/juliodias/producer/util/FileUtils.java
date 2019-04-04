package com.juliodias.producer.util;

import com.google.gson.Gson;
import com.juliodias.producer.model.City;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

@Component
public class FileUtils {

    @Value("classpath:cities.json")
    private Resource resource;

    public Stream<City> getCities() throws Exception {
        InputStream  inputStream = resource.getInputStream();

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        return convertCitiesFrom(bufferedReader);
    }

    private static Stream<City> convertCitiesFrom(BufferedReader bufferedReader) {
        City[] cities = new Gson().fromJson(bufferedReader, City[].class);
        return Arrays.stream(cities);
    }
}
