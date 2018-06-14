package com.kirillch.lambdas.services;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kirillch.lambdas.objects.Person;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DataService {

    public static List<Person> getPeople() throws IOException {

        InputStream inputStream = Resources.getResource("people.json").openStream();
        String json = IOUtils.toString(inputStream);

        List<Person> people = new Gson().fromJson(json, new TypeToken<List<Person>>(){}.getType());

        return people;
    }

    public static void printString(){
        System.out.println("Print our string");
    }

    public static int compareId(Person p1, Person p2){
        Integer id = p2.getId();
        return id.compareTo(p1.getId());
    }

    public int instanceMethodCompareId(Person p1, Person p2){
        Integer id = p1.getId();
        return id.compareTo(p2.getId());
    }
}
