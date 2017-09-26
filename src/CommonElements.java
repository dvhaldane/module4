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

        while (currentArrayIndex < tempCollections.length)
        {
            comparisons++;
            int compareValue = queryCollection[j].compareTo(currentCompare[k]);
            if (compareValue == 0)
            {
                //System.out.println("Added " + queryCollection[j]);
                commonElementsList.add(queryCollection[j]);
                j++; //Increment query collection
                k++; //Increment current comparison collection
            }
            else if (compareValue == -1 && j < queryCollection.length - 1)
            {
                j++;
            }
            else if (k < currentCompare.length - 1)
            {
                k++;
            }
            
            if (j == currentCompare.length && compareValue != -1 || k == queryCollection.length && compareValue != 1 || k == currentCompare.length && j == queryCollection.length)
            {
                queryCollection = commonElementsList.toArray(new Comparable[commonElementsList.size()]);
                commonElementsList.clear();
                j = 0;
                k = 0;
                currentArrayIndex++;
                if (currentArrayIndex < tempCollections.length)
                {
                    currentCompare = tempCollections[currentArrayIndex];
                    //System.out.println("currentCompare is " + Arrays.toString(currentCompare));
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

    public Comparable[] quickSort(Comparable[] collections)
    {
        return collections;
    }

    public int getComparisons()
    {
        return this.comparisons;
    }
}
