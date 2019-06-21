package ru.kirillch.jsonpojo;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import ru.kirillch.jsonpojo.beans.Person;
import ru.kirillch.jsonpojo.services.DataService;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPojoTest {

    @Test
    public void checkGettingJsonData() throws Exception {
        ImmutableList<Person> people = DataService.getPeople();
        people.forEach(System.out::println);

        assertThat(people).hasSize(1000);
    }
}
