package com.lena;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 20.09.14.
 */
public class Test1 {

    private Parse sut;

    @Before
    public void init() {
        sut = new Parse();
    }

    @Test
    public void test1() {
        String val = "(if (zero? x) max (/ 1 x))";
        assertTrue(sut.checkString(val));
    }

    @Test
    public void test2() {
        String val = "I told him (that it's not (yet) done).\\n(But he wasn't listening)";
        assertTrue(sut.checkString(val));
    }

    @Test
    public void test3() {
        String val = ":-)";
        assertFalse(sut.checkString(val));
    }

    @Test
    public void test4() {
        String val = "(wer)sx)er(rf)";
        assertFalse(sut.checkString(val));
    }

    class Parse {

        int count;

        public boolean checkString(String str) {
            for(char c: str.toCharArray()) {
                if ('(' == c)
                    count++;
                else if (')' == c && count > 0)
                    count--;
                else if (')' == c && count <= 0)
                    return false;
            }
            return count==0;
        }
    }
}
