import java.util.ArrayList;

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
        ArrayList<Comparable> commonElementsList = new ArrayList<>();

        //Tempcomparable to store sorted arrays
        Comparable[][] tempCollections = collections;

        ArrayList<Integer> collectionLengths = new ArrayList<Integer>();

        //Iterate through array of arrays to sort
        for (int i = 0; i < collections.length; i++)
        {
            if (collections[i].length >= 10)
            {
                tempCollections[i] = quickSort(collections[i]);
            }
            else
            {
                tempCollections[i] = insertionSort(collections[i]);
            }
        }

        //Find largest array for query array
        Comparable[] temp;

        for (int i = 1; i < tempCollections.length; i++)
        {
            if (tempCollections[i].length > tempCollections[0].length)
            {
                temp = tempCollections[0];
                tempCollections[0] = tempCollections[i];
                tempCollections[i] = temp;
            }
        }

        //Compare
        Comparable[] queryCollection = tempCollections[0];

        for (int i = 1; i < tempCollections[i].length; i++)
        {
            comparisons++;
            if (queryCollection[i].compareTo(tempCollections[i]) == 0)
            {
                commonElementsList.add(queryCollection[i]);
            }
        }

        Comparable[] commonElements = commonElementsList.toArray(new Comparable[commonElementsList.size()]);

        return commonElements;

    }

    public Comparable[] insertionSort(Comparable[] collections)
    {
        return collections;
    }

    public Comparable[] quickSort(Comparable[] collections)
    {
        return collections;
    }

    public int getComparisons()
    {
        return this.comparisons;
    }
}
