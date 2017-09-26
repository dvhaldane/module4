import org.junit.Test;

import java.util.Arrays;

/**
 * Created by HaldaneDavidV on 9/24/2017.
 */
public class test extends CommonElements
{
    @Test
    public void test1()
    {
        Comparable[] query_Collection = {1,2,3,4};
        Comparable[] current_Collection = {1,2,3,4};
        Comparable[][] arrays = {query_Collection, current_Collection};
        Arrays.toString(findCommonElements(arrays));

    }

    @Test
    public void test2()
    {
        Comparable[] query_Collection = {4,3,1,2,5,7,1,9,8};
        Comparable[] current_Collection = {1,2,3,4};
        System.out.println(Arrays.toString(insertionSort(query_Collection)));

    }
}
