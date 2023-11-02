package container;

/*
//import org.testng.annotations.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
*/
// JUNIT 5
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Timeout.ThreadMode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestShape {

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS,  threadMode=Timeout.ThreadMode.SEPARATE_THREAD)    
    public void test_Empty() {
    	assertTrue(true);
        assertEquals(0, 0);
    }
    
}
