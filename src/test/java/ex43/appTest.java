package ex43;

import static ex43.app.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class appTest {

    @Test
    void createWebsiteTest() {
        createWebsite("awecomeco", "Max Power", 1, 1);
    }
}