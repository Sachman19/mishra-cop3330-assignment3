package ex43;

import static ex43.app.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

class appTest {

    @Test
    void createWebsiteTest() {
        createWebsite("awecomeco", "Max Power", 1, 1);

        File existenceTest = new File("src/main/java/ex43/website/awecomeco");
        assertTrue(existenceTest.exists());

        //Not only should this file exist, but the actual file itself should also include newline characters.
    }
}