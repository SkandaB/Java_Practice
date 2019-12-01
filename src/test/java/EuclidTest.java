import org.junit.Assert;
import org.junit.Test;
import com.skanda.java_practice.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class EuclidTest {
    @Test
    public final void whenBothNumbersareZero () {
        Assert.assertEquals(0, Euclid.gcd(0, 0));
    }

    @Test
    public final void happyPath() {
        Assert.assertEquals(6, Euclid.main(new String[] {"12", "18"}));
    }
}