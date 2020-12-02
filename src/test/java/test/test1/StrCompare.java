package test.test1;

import org.junit.Test;

public class StrCompare {

    @Test
    public void test2() {
        String str1 = "1";
        String str2 = "2";

        System.out.println(str1.compareTo(str2));
    }

    @Test
    public void test1() {
//        String str1 = "2019/02/05";
        String str1 = "2020/02/01";
        String str2 = "2020/02/01";

        System.out.println(str1.compareTo(str2));
    }

}
