package ru.kirillch.streams.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import ru.kirillch.streams.beans.Person;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DataService {

    public static ImmutableList<Person> getPeople() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream = Resources.getResource("people.json").openStream();
        List<Person> people = objectMapper.readValue(inputStream, new TypeReference<List<Person>>() {
        });

        return ImmutableList.copyOf(people);

    }
}
