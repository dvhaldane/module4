/**
 * Created by HaldaneDavidV on 9/24/2017.
 */
public class CommonElements
{
    int comparisons;

    CommonElements()
    {
        comparisons = 0;
    }

    public Comparable[] findCommonElements(Comparable[][] collections)
    {
        //Placeholder to declare return value
        Comparable[] commonElements = {};

        //Tempcomparable to store sorted arrays
        Comparable[][] tempComparable = {};

        //Iterate through array of arrays to sort
        for (int i = 0; i < collections.length; i++)
        {
            if (collections[i].length >= 10)
            {
                tempComparable[i] = quickSortRemoveDuplicates(collections[i]);
            }
            else
            {
                tempComparable[i] = insertionSortRemoveDuplicates(collections[i]);
            }
        }

        //Compare


        return commonElements;

    }

    public Comparable[] insertionSortRemoveDuplicates(Comparable[] collections)
    {
        return collections;
    }

    public Comparable[] quickSortRemoveDuplicates(Comparable[] collections)
    {
        return collections;
    }

    public int getComparisons()
    {
        return this.comparisons;
    }
}
