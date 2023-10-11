package classTests.junitIntro;

import org.junit.Assert;
import org.junit.Test;

public class AssertIntro {
    @Test
    public void lion(){
        Assert.assertTrue("Lion".contains("o"));
    }
    @Test
    public void compare(){
        Assert.assertFalse(34<9);
    }
    @Test
    public void compareBoolean(){
        Assert.assertEquals(true,true&false);
    }
    @Test
    public void compareSentence(){
        Assert.assertEquals("Chicago","Chicago");
    }




}
