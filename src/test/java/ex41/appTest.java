package ex41;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import static ex41.app.outputTable;


class appTest {

    @Test
    void inputTest() {
        ArrayList<String> testArray = new ArrayList<>();
        testArray.add("String 2");
        testArray.add("String 3");
        testArray.add("String 1");
        testArray.add("String 6");

        outputTable(testArray);

        File testExistence = new File("output/ex41_output.txt");
        assertTrue(testExistence.exists()); //This test will overwrite the output file, but tests that it executes and creates a file.
    }
}