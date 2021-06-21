package ex42;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class appTest {

    @Test
    void empValTest() {
        empInfo testing = new empInfo();
        testing.parseInfo("lName,fName,salary");

        //Tests that values are assigned as intended
        assertEquals("lName", testing.returnLName());
        assertEquals("fName", testing.returnFName());
        assertEquals("salary", testing.returnSalary());
    }
}