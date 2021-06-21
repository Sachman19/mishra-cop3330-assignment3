package ex45;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static ex45.app.*;

class appTest {

    @Test
    void appTester() {
        List<String> lines = new ArrayList<String>();
        lines.add("String1");
        lines.add("String2");
        lines.add("String3");

        String[] lineArr = fixNewLine(lines);

        writeOutput("testFile", lineArr);

        File existenceTest = new File("output/testFile.txt");
        assertTrue(existenceTest.exists());
    }
}