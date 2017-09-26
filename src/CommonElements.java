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

        Comparable[] temp;

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
            
            //Find largest array for query array and place at 0 position
            if (tempCollections[i].length > tempCollections[0].length)
            {
                temp = tempCollections[0];
                tempCollections[0] = tempCollections[i];
                tempCollections[i] = temp;
            }
            
        }


        //Compare
        int currentArrayIndex = 1;
        Comparable[] queryCollection = tempCollections[0];
        Comparable[] currentCompare = tempCollections[currentArrayIndex];
        int j = 0;
        int k = 0;

        while (currentArrayIndex < tempCollections.length && k != currentCompare.length)
        {
            comparisons++;
            int compareValue = queryCollection[j].compareTo(tempCollections[k]);
            if (compareValue == 0)
            {
                commonElementsList.add(queryCollection[j]);
                j++;
                k++;
            }
            else if (compareValue == -1 && j != queryCollection.length)
            {
                j++;
            }
            else if (k != tempCollections.length)
            {
                k++;
            }
            
            if (j == queryCollection.length && compareValue == -1 || k == tempCollections[i].length - 1 && j == queryCollection.length - 1)
            {
                queryCollection = commonElementsList.toArray(new Comparable[commonElementsList.size()]);
                j = 0;
                k = 0;
                currentArrayIndex++;
            }
        }

        return queryCollection;

    }

    public Comparable[] insertionSort(Comparable[] collections)
    {
        for (int i = 1; i < collections.length; i++)
        {
            Comparable firstUnsorted = collections[i];
            int index = i - 1;
            
            while (index >= 0 && firstUnsorted.compareTo(collections[index]) < 0)
            {
                collections[index + 1] = collections[index];
                index--;
            }
            collections[index + 1] = firstUnsorted;
        }
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
