package ex46;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static ex46.app.*;

class appTest {

    @Test
    void test() {
        List<String> lines = new ArrayList<>();
        lines.add("badger"); lines.add("badger"); lines.add("badger");
        lines.add("snake"); lines.add("mushroom"); lines.add("mushroom");
        lines.add("badger"); lines.add("badger"); lines.add("badger");
        HashMap<String, Integer> hMap = assignHashMap(lines);

        assertEquals(6, hMap.get("badger"));
        assertEquals(2, hMap.get("mushroom"));
        assertEquals(1, hMap.get("snake"));
    }
}