import java.util.Arrays;

/**
 * Created by HaldaneDavidV on 10/1/2017.
 */
public class TestHarness
{
    public static void main(String[] args)
    {
        CommonElements elements = new CommonElements();
        Comparable[] coll_1 = {"banana", "apple", "pear", "banana", "pomegranate", "pineapple", "cherry", "jujube", "cherry", "orange"};
        Comparable[] coll_2 = {"quince", "raspberry", "banana", "lemon", "apple", "banana", "cherry", "blueberry", "jujube", "mango"};
        Comparable[] coll_3 = {"plum", "pomegranate", "lime", "banana", "jujube", "blueberry", "apple", "cherry", "grape", "banana"};
        Comparable[][] arrays = {coll_1, coll_2, coll_3};
        System.out.println(Arrays.toString(elements.findCommonElements(arrays)));
        System.out.println("Total Members " + elements.totalMembers);
        System.out.println("Comparisons " + elements.getComparisons());

        Comparable[] coll_4 = {"Baltimore Ravens",
                "Seattle Seahawks",
                "Indianapolis Colts",
                "Houston Texans",
                "Tennessee Titans",
                "Jacksonville Jaguars",
                "Arizona Cardinals",
                "New England Patriots",
                "Baltimore Ravens",
                "Cincinnati Bengals",
                "bye week",
                "Kansas City Chiefs",
                "Cincinnati Bengals",
                "Cleveland Browns",
                "San Francisco 49ers",
                "St. Louis Rams",
                "Cleveland Browns"};
        Comparable[] coll_5 = {"Pittsburgh Steelers",
                "Tennessee Titans",
                "St. Louis Rams",
                "New York Jets",
                "bye week",
                "Houston Texans",
                "Jacksonville Jaguars",
                "Arizona Cardinals",
                "Pittsburgh Steelers",
                "Seattle Seahawks",
                "Cincinnati Bengals",
                "San Francisco 49ers",
                "Cleveland Browns",
                "Indianapolis Colts",
                "San Diego Chargers",
                "Cleveland Browns",
                "Cincinnati Bengals"};
        Comparable[][] arrays2 = {coll_4, coll_5};
        System.out.println(Arrays.toString(elements.findCommonElements(arrays2)));
        System.out.println("Total Members " + elements.totalMembers);
        System.out.println("Comparisons " + elements.getComparisons());
    }
}
