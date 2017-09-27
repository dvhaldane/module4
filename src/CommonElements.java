import java.util.ArrayList;
import java.util.Arrays;

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
            if (collections[i].length >= 20)
            {
                tempCollections[i] = mergeSort(collections[i]);
            }
            else
            {
                tempCollections[i] = insertionSort(collections[i]);
            }
            
            //Find largest array for query array and place at 0 position
            if (tempCollections[i].length < tempCollections[0].length)
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

        while (currentArrayIndex < tempCollections.length)
        {
            comparisons++;
            int compareValue = queryCollection[j].compareTo(currentCompare[k]);
            if (compareValue == 0)
            {
                if (j < queryCollection.length && k < currentCompare.length)
                {
                    commonElementsList.add(queryCollection[j]);
                }

                j++;
                k++;

            }
            else if (compareValue < 0 && j < queryCollection.length - 1) //If query is behind the current compare and not at end or at end
            {
                j++;
            }
            else if (compareValue > 0 && k < currentCompare.length - 1) //If query is ahead of comparison and comparison is not at end or at end
            {
                k++;
            }
                //Query collection index
            if (j == queryCollection.length || j == queryCollection.length - 1 && compareValue < 0 || k == currentCompare.length && j == queryCollection.length)
            {
                queryCollection = commonElementsList.toArray(new Comparable[commonElementsList.size()]);
                commonElementsList.clear();
                j = 0;
                k = 0;
                currentArrayIndex++;
                if (currentArrayIndex < tempCollections.length)
                {
                    currentCompare = tempCollections[currentArrayIndex];
                }
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

    public Comparable[] mergeSort(Comparable[] collections)
    {
        return collections;
    }

    public int getComparisons()
    {
        return this.comparisons;
    }
}
