import org.junit.Test;
import java.util.Arrays;
import java.util.Random;

//Test cases for performance comparison against JV
public class test2 extends CommonElements
{
    @Test
    public void test1()
    {
        Comparable[][] testArray = {{"banana", "apple", "pear", "banana", "pomegranate", "pineapple", "cherry", "jujube", "cherry", "orange"}, {"quince", "raspberry", "banana", "lemon", "apple", "banana", "cherry", "blueberry", "jujube", "mango"}, {"plum", "pomegranate", "lime", "banana", "jujube", "blueberry", "apple", "cherry", "grape", "banana"}};
        System.out.println("Result: " + Arrays.toString(findCommonElements(testArray)));
        System.out.println("Total Members " + totalMembers);
        System.out.println("Comparisons: " + getComparisons());
        System.out.println("Matches " + arrayLength);
    }

    @Test
    public void test2()
    {
        Integer[] intList1 = new Integer[100000];
        Integer[] intList2 = new Integer[100000];
        Integer[] intList3 = new Integer[100000];
        Integer[] intList4 = new Integer[100000];
        Integer[] intList5 = new Integer[100000];
        Integer[] intList6 = new Integer[100];

        Random random = new Random();


        for (int i = 0; i < 100000; i++)
        {
            intList1[i] = random.nextInt(10);
            intList2[i] = random.nextInt(10);
            intList3[i] = random.nextInt(10);
            intList4[i] = random.nextInt(10);
            intList5[i] = random.nextInt(10);
        }

        for (int i = 0; i < 100; i++)
        {
            intList6[i] = random.nextInt(100);
        }

        Comparable[][] testArray2 = {intList1, intList2, intList3, intList4, intList5};

        Arrays.toString(findCommonElements(testArray2));
        System.out.println("Total Members " + totalMembers);
        System.out.println("Comparisons: " + getComparisons());
        System.out.println("Matches " + arrayLength);

    }

    @Test
    public void test3()
    {
        Integer[] intList1 = new Integer[100000];
        Integer[] intList2 = new Integer[100000];
        Integer[] intList3 = new Integer[100000];
        Integer[] intList4 = new Integer[100000];
        Integer[] intList5 = new Integer[100000];
        Integer[] intList6 = new Integer[100000];

        Random random = new Random();


        for (int i = 0; i < 100000; i++) {
            intList1[i] = random.nextInt(10);
            intList2[i] = random.nextInt(10);
            intList3[i] = random.nextInt(10);
            intList4[i] = random.nextInt(10);
            intList5[i] = random.nextInt(10);
            intList6[i] = random.nextInt(10);
        }

        Comparable[][] testArray3 = {intList1, intList2, intList3, intList4, intList6};
        Arrays.toString(findCommonElements(testArray3));
        System.out.println("Total Members " + totalMembers);
        System.out.println("Comparisons: " + getComparisons());
        System.out.println("Matches " + arrayLength);
    }


    @Test
    public void test4()
    {
        Integer[] intList1 = new Integer[100000];
        Integer[] intList2 = new Integer[100000];
        Integer[] intList3 = new Integer[100000];
        Integer[] intList4 = new Integer[100000];
        Integer[] intList5 = new Integer[100000];
        Integer[] intList6 = new Integer[100000];
        Integer[] intList7 = new Integer[100000];
        Integer[] intList8 = new Integer[100000];
        Integer[] intList9 = new Integer[100000];
        Integer[] intList10 = new Integer[100000];

        Random random = new Random();


        for (int i = 0; i < 100000; i++) {
            intList1[i] = random.nextInt(100000);
            intList2[i] = random.nextInt(100000);
            intList3[i] = random.nextInt(100000);
            intList4[i] = random.nextInt(100000);
            intList5[i] = random.nextInt(100000);
            intList6[i] = random.nextInt(100000);
            intList7[i] = random.nextInt(100000);
            intList8[i] = random.nextInt(100000);
            intList9[i] = random.nextInt(100000);
            intList10[i] = random.nextInt(100000);
        }

        Comparable[][] testArray3 = {intList1, intList2, intList3, intList4, intList5, intList6, intList7, intList8, intList9, intList10};
        Arrays.toString(findCommonElements(testArray3));
        System.out.println("Total Members " + totalMembers);
        System.out.println("Comparisons: " + getComparisons());
        System.out.println("Matches " + arrayLength);
    }


}
