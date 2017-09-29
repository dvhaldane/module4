import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by HaldaneDavidV on 9/24/2017.
 */
public class CommonElements
{
    int comparisons;
    int arrayLength;
    int totalMembers;
    boolean debug = false;

    CommonElements()
    {
        comparisons = 0;
    }

    public Comparable[] findCommonElements(Comparable[][] collections)
    {
        //queryCollection = commonElementsList.toArray(new Comparable[commonElementsList.size()]);

        ArrayList<Comparable[]> nonNullArrays = new ArrayList<>();

        // Remove Nulls
        for (int i = 0; i < collections.length; i++)
        {
            if (collections[i].length != 0)
            {
                nonNullArrays.add(collections[i]);
            }
        }

        Comparable[][] tempCollections = nonNullArrays.toArray(new Comparable[nonNullArrays.size()][nonNullArrays.size()]);

        //handle all nulls
        if (tempCollections.length < 2)
        {
            Comparable[] errorArray = {"ERROR","NOT","ENOUGH","ARRAYS","OR","MEMBERS","FOR","COMPARISON"};

            return errorArray;
        }

        Comparable[] temp;

        for (int i = 0; i < tempCollections.length; i++)
        {
            tempCollections[i] = mergeSort(tempCollections[i]);

            //Add up total members for debug
            totalMembers+=tempCollections[i].length;

            //Find largest array for query array and place at 0 position
            if (tempCollections[i].length < tempCollections[0].length)
            {
                temp = tempCollections[0];
                tempCollections[0] = tempCollections[i];
                tempCollections[i] = temp;
            }
        }

        //Compress Duplicates
        ArrayList<Comparable> compressedArray = new ArrayList<>();
        for (int i = 0; i < tempCollections.length; i++)
        {
            Comparable[] currArray = tempCollections[i];
            int currCount = 1;

            for (int j = 0; j < tempCollections[i].length; j++)
            {
                if (currArray.length > 1)
                {
                    if (j < currArray.length - 1)
                    {
                        if (currArray[j].compareTo(currArray[j + 1]) == 0)
                        {
                            currCount++;
                        } else
                        {
                            compressedArray.add(currArray[j]);
                            compressedArray.add(currCount);
                            currCount = 1;
                        }
                    }
                    else
                    {
                        if (currArray[j].compareTo(currArray[j - 1]) == 0)
                        {
                            compressedArray.add(currArray[j]);
                            compressedArray.add(currCount);
                            currCount = 1;
                        }
                        else
                        {
                            compressedArray.add(currArray[j]);
                            compressedArray.add(currCount);
                            currCount = 1;
                        }
                    }
                } else
                {
                    compressedArray.add(currArray[0]);
                    compressedArray.add(currCount);
                    currCount = 1;
                }
            }

            tempCollections[i] = compressedArray.toArray(new Comparable[compressedArray.size()]);
            compressedArray.clear();
        }

        //Compare
        ArrayList<Comparable> commonElementsList = new ArrayList<>();
        int currentArrayIndex = 1;
        Comparable[] queryCollection = tempCollections[0];
        Comparable[] currentCompare = tempCollections[currentArrayIndex];
        int j = 0;
        int k = 0;

        while (currentArrayIndex < tempCollections.length)
        {
            comparisons++;

            int compareValue = queryCollection[j].compareTo(currentCompare[k]);
            if (debug)
            {
                System.out.println("j " + j + " k " + k);
                System.out.println("QueryColl Len " + queryCollection.length + "CurrentCompare Len " + currentCompare.length);
                System.out.println("Compare Val = " + compareValue);
                System.out.println("Query Val = " + queryCollection[j] + "Compare Val = " + currentCompare[k]);
            }
            if (compareValue == 0)
            {
                if (j < queryCollection.length - 1 && k < currentCompare.length - 1)
                {
                    commonElementsList.add(queryCollection[j]);
                    commonElementsList.add(Math.abs((int)queryCollection[j + 1] - (int)queryCollection[k + 1]));
                }

                if (k == currentCompare.length - 2)
                {
                    j+=2;
                }
                else
                {
                    j+=2;
                    k+=2;
                }

            }
            else if (compareValue < 0 && j < queryCollection.length - 2) //If query is behind the current compare and not at end or at end
            {
                j+=2;
            }
            else if (compareValue > 0 && k < currentCompare.length - 2) //If query is ahead of comparison and comparison is not at end or at end
            {
                k+=2;
            }
            if (j == queryCollection.length || j == queryCollection.length - 2 && compareValue < 0 || k == currentCompare.length - 2 && compareValue > 0 || k == currentCompare.length && j == queryCollection.length)
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

        arrayLength = queryCollection.length;
        return processArrayListDuplicates(commonElementsList);

    }

    public Comparable[] processArrayListDuplicates(ArrayList<Comparable> arrayList)
    {
        int count = 1;
        ArrayList<Comparable> returnList = new ArrayList<>();

        for (Comparable c : arrayList)
        {
            if (count % 2 == 1)
            {
                returnList.add(c);
            }
            else
            {
                int duplicateCount = (Integer) c;

                if (duplicateCount > 1)
                {
                    for (int i = 0; i < duplicateCount; i++)
                    {
                        returnList.add(returnList.get(returnList.size() - 1));
                    }
                }
            }
        }

        return returnList.toArray(new Comparable[returnList.size()]);
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
        Arrays.sort(collections);
        return collections;
    }

    public int getComparisons()
    {
        return this.comparisons;
    }
}
