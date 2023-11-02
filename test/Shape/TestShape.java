package Shape;

import java.util.ArrayList;

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


import java.util.concurrent.TimeUnit;

public class TestShape {

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS,  threadMode=Timeout.ThreadMode.SEPARATE_THREAD)    
    public void test_Empty() {
    	assertTrue(true);
    }
    
    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS,  threadMode=Timeout.ThreadMode.SEPARATE_THREAD)    
    public void test_Area() 
    {
      ArrayList<Shape> shapeList = new ArrayList<Shape>(5);
      shapeList.add(new Square(2));
      shapeList.add(new Square(4));
      double sum = Application.sumArea(shapeList);
      assertEquals(sum, 2.0*2.0+4.0*4.0); // warning float conversions
    }
    
//        Shape test[] = new Shape[5];
//        shapeList.toArray(test);
//        System.out.println("Num greater : " + countAreaGreaterThan(test, 2.0));

}
