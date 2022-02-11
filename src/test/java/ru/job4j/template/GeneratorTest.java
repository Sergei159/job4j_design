package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
/**
 * Класс - имитация работы интерфейса Generator.
 * Генератор получает шаблон вида.
 * "I am a ${name}, Who are ${subject}? "
 * Слова записанные в фигурных скобках ${..} - это ключи,
 * которые нужно заменить.
 */

@Ignore
public class GeneratorTest {


    @Test
    public void whenRightKeys() {
        Generator generator = new GeneratorDemo();
        String input = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Sergei");
        map.put("subject", "you");
        String result =  generator.produce(input, map);
        assertThat(input, is(result));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenWrongKeys()   {
        Generator generator = new GeneratorDemo();
        String input = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Sergei");
        map.put("surname", "you");
        String result =  generator.produce(input, map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenExtraKeys()   {
        Generator generator = new GeneratorDemo();
        String input = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Sergei");
        map.put("surname", "you");
        map.put("subject", "you");
        String result =  generator.produce(input, map);
    }

}