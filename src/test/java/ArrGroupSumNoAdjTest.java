import com.skanda.java_practice.ArrGroupSumNoAdj;
import org.junit.Assert;
import org.junit.Test;

public class ArrGroupSumNoAdjTest {
    @Test
    public final void test1() {
        Assert.assertEquals(true,ArrGroupSumNoAdj.groupNoAdj(0, new int[]{2, 5, 10, 4}, 12));
    }
}

/*
groupNoAdj(0, [2, 5, 10, 4], 12) → true	true	OK
groupNoAdj(0, [2, 5, 10, 4], 14) → false	false	OK
groupNoAdj(0, [2, 5, 10, 4], 7) → false	false	OK
groupNoAdj(0, [2, 5, 10, 4, 2], 7) → true	true	OK
groupNoAdj(0, [2, 5, 10, 4], 9) → true	true	OK
groupNoAdj(0, [10, 2, 2, 3, 3], 15) → true	true	OK
groupNoAdj(0, [10, 2, 2, 3, 3], 7) → false	false	OK
groupNoAdj(0, [], 0) → true	true	OK
groupNoAdj(0, [1], 1) → true	true	OK
groupNoAdj(0, [9], 1) → false	false	OK
groupNoAdj(0, [9], 0) → true	true	OK
groupNoAdj(0, [5, 10, 4, 1], 11) → true	true	OK
 */
