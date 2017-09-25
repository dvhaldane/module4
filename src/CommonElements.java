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
        Comparable[] queryCollection = tempCollections[0];
        int j = 0;
        int k = 0;
        
        for (int i = 1; i < tempCollections[i].length; i++)
        {
            comparisons++;
            switch(queryCollection[j].compareTo(tempCollections[k]))
            {
                case 0:
                    commonElementsList.add(queryCollection[j]);
                    j++;
                    k++;
                case -1:
                    j++;
                case 1:
                    k++;
            }
            
            if (i == tempCollections[i].length)
            {
                queryCollection = commonElementsList.toArray(new Comparable[commonElementsList.size()]);
            }
        }

        return queryCollection;

    }

    public Comparable[] insertionSort(Comparable[] collections)
    {
        for (int i = 1; i < objArray.length; i++)
        {
            Comparable firstUnsorted = objArray[i];
            int index = i - 1;
            
            while (index >= 0 && firstUnsorted.compareTo(objArray[index]) < 0)
            {
                objArray[index + 1] = objArray[index];
                index--;
            }
            objArray[index + 1] = firstUnsorted;
        }
        return objArray;
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
