package ru.kirillch.streams;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import ru.kirillch.streams.beans.Person;
import ru.kirillch.streams.services.DataService;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamsTest {

    @Test
    public void checkGettingJsonData() throws Exception {
        ImmutableList<Person> people = DataService.getPeople();
        people.forEach(System.out::println);

        assertThat(people).hasSize(1000);
    }
}
