import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by HaldaneDavidV on 9/24/2017.
 */
public class test extends CommonElements
{
    @Test
    public void test1()
    {
        Comparable[] query_Collection = {1,2,3,4,5,5,5};
        Comparable[] current_Collection = {1,2,3,3,4,5,5,5};
        Comparable[][] arrays = {query_Collection, current_Collection};
        System.out.println(Arrays.toString(findCommonElements(arrays)));

    }

    @Test
    public void test2()
    {
        Comparable[] query_Collection = {4,3,1,2,5,7,1,9,8};
        Comparable[] current_Collection1 = {1,2,3,4};
        Comparable[] current_Collection2 = {1,2};
        Comparable[][] arrays = {query_Collection, current_Collection1, current_Collection2};
        System.out.println(Arrays.toString(findCommonElements(arrays)));
        System.out.println("Comparisons " + getComparisons());
    }

    @Test
    public void test3()
    {
        Comparable[] coll_1 = {"banana", "apple", "pear", "banana", "pomegranate", "pineapple", "cherry", "jujube", "cherry", "orange"};
        Comparable[] coll_2 = {"quince", "raspberry", "banana", "lemon", "apple", "banana", "cherry", "blueberry", "jujube", "mango"};
        Comparable[] coll_3 = {"plum", "pomegranate", "lime", "banana", "jujube", "blueberry", "apple", "cherry", "grape", "banana"};
        Comparable[][] arrays = {coll_1, coll_2, coll_3};
        System.out.println(Arrays.toString(findCommonElements(arrays)));
        System.out.println("Comparisons " + getComparisons());
    }

    @Test
    public void test4()
    {
        Comparable[] coll_1 = {"banana", "apple", "pear", "banana", "pomegranate", "pineapple", "cherry", "jujube", "cherry", "orange"};
        Comparable[] coll_2 = {"banana", "apple", "pear", "banana", "pomegranate", "pineapple", "cherry", "jujube", "cherry", "orange"};
        Comparable[] coll_3 = {"banana", "apple", "pear", "banana", "pomegranate", "pineapple", "cherry", "jujube", "cherry", "orange"};
        Comparable[][] arrays = {coll_1, coll_2, coll_3};
        System.out.println(Arrays.toString(findCommonElements(arrays)));
        System.out.println("Comparisons " + getComparisons());
    }

    @Test
    public void test5()
    {
        Comparable[] query_Collection = {1,2,2,4,5};
        Comparable[] current_Collection1 = {1,2};
        Comparable[][] arrays = {query_Collection, current_Collection1};
        System.out.println(Arrays.toString(findCommonElements(arrays)));
        System.out.println("Comparisons " + getComparisons());
    }

    @Test
    public void test6()
    {
        Random random = new Random();

        Integer[] intlist1 = new Integer[100000];
        Integer[] intlist2 = new Integer[100000];
        Integer[] intlist3 = new Integer[100000];
        Integer[] intlist4 = new Integer[100000];
        Integer[] intlist5 = new Integer[100000];
        Integer[] intlist6 = new Integer[100000];

        for (int i = 0; i < 100000; i++)
        {
            intlist1[i] = random.nextInt(100);
            intlist2[i] = random.nextInt(100);
            intlist3[i] = random.nextInt(100);
            intlist4[i] = random.nextInt(100);
            intlist5[i] = random.nextInt(100);
            intlist6[i] = random.nextInt(100);
        }

        Comparable[][] arrays = {intlist1, intlist2, intlist3, intlist4, intlist5, intlist6};
        System.out.println(Arrays.toString(findCommonElements(arrays)));
        System.out.println("Comparisons " + getComparisons());

    }

    @Test
    public void test7()
    {
        Comparable[] query_Collection = {1,2,3,4,5};
        Comparable[] current_Collection = {1,2,3,4,5};
        Comparable[] current_Collection2 = {1,2,3,4,5};
        Comparable[] current_Collection3 = {1,2,3,4,5};
        Comparable[][] arrays = {query_Collection, current_Collection, current_Collection2, current_Collection3};
        System.out.println(Arrays.toString(findCommonElements(arrays)));
    }
}
