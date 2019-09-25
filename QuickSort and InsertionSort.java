//incomplete as of 03/07/2019 to be finished at a later date


import java.util.Random;
import java.util.ArrayList;

public class Project_1 {
private int[] arr;
private static ArrayList<Long> InsertionSort = new ArrayList<Long>();
private static ArrayList<Long> MergeSort = new ArrayList<Long>();
private static ArrayList<Long> QuickSort = new ArrayList<Long>();
private static ArrayList<Long> QuickSort2 = new ArrayList<Long>();
private static ArrayList<Long> QuickSort3 = new ArrayList<Long>();

public Project_1(int[] arrInput) {
    arr = copyArray(arrInput); 
}

public static int[] InsertionSort(int low, int[] arr) {
  int key;
  int j;          
    //key starts as the second element in the array
    //j starts as the first element in the array
    for(int i = low; i < arr.length; ++i) {
      key = arr[i];
      j = i - 1;
    
      //if the value before the key is greater than the key, 
      //then they will switch and the elements prior will be checked as well.
      while(j >= low && arr[j] > key){
        arr[j + 1] = arr[j];
        j--;
      }
      
      arr[j+1] = key;
    }
  return arr;
}

private static int[] copyArray(int[] array) {
   int[] arr2 = new int[array.length];
   for(int i = 0; i < array.length; i++) {
     arr2[i] = array[i];
   }
   return arr2;
}

public static int[] mergeSort(int[]arr, int n) {
  if(n > 1) {
    
    //cuts the array in half
    final int firHalf = n/2;
    
    //establishes the remaining array elements beyond the half
    int secHalf = n - firHalf;
    
    //makes array for left half of the array
    int[] left = new int[firHalf];
    
    //makes array for the right half of the array
    int[] right = new int[secHalf];
    
    //copies the first half of the original array into the left array
    for(int i = 0 ; i < firHalf; i++) {
      left[i] = arr[i];
    }
    
    //copes the second half of the original array into the right array
    for(int i = firHalf; i < n; i++) {
        right[i - firHalf] = arr[i];
    }
    
    //recursive calls to sort arrays
    mergeSort(left, firHalf);
    mergeSort(right, secHalf);
    merge(firHalf, secHalf, left, right, arr);
    }
  
  return arr;
}

public static void merge( int firHalf, int secHalf, int[] left, int[] right, int[] arr) {
  
  //indices
  int i = 0;
  int j = 0;
  int k = 0;
  
  //compare the two array elements and sort them into the original array 
  while(i < firHalf && j < secHalf) {
 
    if(left[i] < right[j]) {
      arr[k] = left[i];
      i++;
    }
    
    else {
      arr[k] = right[j];
      j++;
    }
    
    k++;
  }
  
  if(i < firHalf) {
    while((k < (firHalf + secHalf)) && i < firHalf) {
      arr[k] = left[i];
      k++;
      i++;
    }
  }
  
  else {
    while((k < (firHalf + secHalf)) && j < ((firHalf + secHalf)-1)) {
      arr[k] = right[j];
      k++;
      j++;
    }
   }
 }

public static void quickSort(int low, int high, int[] array) {
  if(high > low) {
    int pivot = partition(low, high, array);
    quickSort(low, (pivot), array);
    quickSort((pivot + 1), (high), array); //for sorted, requires high - 1
    return;
  }
  return;
}

public static void quickSort2(int low, int high, int[] array) {
  if((high - low) <= 16) {
    InsertionSort(low, array);
    return;
  }
  
  else {
    if(high > low) {
      int pivot = partition(low, high, array);
      quickSort2(low, (pivot), array);
      quickSort2((pivot + 1), high , array); //sorted arrays require high - 1
      return;
    }
  }
  return;
}

public static int randomNum(int low, int high) {
  Random rand = new Random();
  int num = rand.nextInt((high - low)) + low;
  return num;
}


public static void quickSort3(int low, int high, int[] array) {
  if(high > low) {
   
    if(array.length > 16) {
      int newNum = randomNum(low, high);
      int temp = array[low];
      array[low] = array[newNum];
      array[newNum] = temp;
    }
    int pivot = partition(low, high, array);
    quickSort3(low, pivot, array);
    quickSort3(pivot + 1, high, array);
  }
}

public static int partition(int low, int high, int[] array) {
  int j = low;
  for(int i = low + 1; i < high ; i++) {
    if(array[i] < array[low]) {
      j++;
      int temp = array[j];
      array[j] = array[i];
      array[i] = temp;
    }
  }
  int temp = array[j];
  array[j] = array[low];
  array[low] = temp; 
  return j;
}


public static int[] makeRanArray(int length) {
  int[] arr = new int[length];
  Random r = new Random();
  for(int i = 0; i < length; i++) {
    arr[i] = r.nextInt(65536);
  }
  return arr;
}

public static int[] makeSortedArray(int length) {
  int[] arr = new int[length];
  for(int i = 0; i < length; i++) {
    arr[i] = i;
  }
  return arr;
}

public static String printArr(int[] arr) {
  String s = " ";
  for(int i = 0; i < arr.length; i++) {
    s += arr[i] + " ";
  }
  return s;
}

public static String toString(int[] array) {

  int[]arr2 = copyArray(array);
  
  int[]arr3 = copyArray(array);
  
  int[]arr4 = copyArray(array);
  
  int[]arr5 = copyArray(array);
  
  int[]arr6 = copyArray(array);
  long time = 0;
  
  long startTime = System.nanoTime();
  int[] A = InsertionSort(0, arr2);
  long endTime = System.nanoTime();
  time = endTime - startTime;
  InsertionSort.add(time);
  System.out.println("InsertionSort took " + (endTime - startTime) + " nanoseconds.");
  System.out.println("Is this array sorted?" + isSorted(A));
  
  startTime = System.nanoTime();
  int[] B = mergeSort(arr3, arr3.length);
  endTime = System.nanoTime();
  time = endTime - startTime;
  MergeSort.add(time);
  System.out.println("MergeSort took " + (endTime - startTime) + " nanoseconds.");
  System.out.println("Is this array sorted?" + isSorted(B));
  
  Project_1 C = new Project_1(arr4);
  startTime = System.nanoTime();
  quickSort(0, arr4.length, arr4);
  endTime = System.nanoTime();
  time = endTime - startTime;
  QuickSort.add(time);
  System.out.println("QuickSort took " + (endTime - startTime) + " nanoseconds.");
  System.out.println("Is this array sorted?" + isSorted(arr4));
  
  Project_1 D = new Project_1(arr5);
  startTime = System.nanoTime();
  quickSort2(0, arr5.length, arr5);
  endTime = System.nanoTime();
  time = endTime - startTime;
  QuickSort2.add(time);
  System.out.println("QuickSort2 took " + (endTime - startTime) + " nanoseconds.");
  System.out.println("Is this array sorted?" + isSorted(arr5));
  
  Project_1 E = new Project_1(arr6);
  startTime = System.nanoTime();
  quickSort3(0, arr6.length, arr6);
  endTime = System.nanoTime();
  time = endTime - startTime;
  QuickSort3.add(time);
  System.out.println("QuickSort3 took " + (endTime - startTime) + " nanoseconds.");
  System.out.println("Is this array sorted?" + isSorted(arr6));
  
  return "This is the original array [" + printArr(array)   + "].\n" + 
         
         "After InsertionSort:       [" + printArr(A)     + "].\n" +
         "After MergeSort:           [" + printArr(B)     + "].\n" +
         "After QuickSort:           [" + printArr(arr4) + "].\n" +
         "After QuickSort2:          [" + printArr(arr5) + "].\n" +
         "After QuickSort3:          [" + printArr(arr6) + "].\n\n" 
        ;
}

public static void toString2(int[] arr) {
  int[]arr2 = new int[arr.length];
  arr2 = copyArray(arr);

  int[]arr3 = new int[arr.length];
  arr3 = copyArray(arr);

  int[]arr4 = new int[arr.length];
  arr4 = copyArray(arr);

  int[]arr5 = new int[arr.length];
  arr5 = copyArray(arr);

  int[]arr6 = new int[arr.length];
  arr6 = copyArray(arr);
  
  long time = 0;
  System.out.println("\nArray Length n = " + arr5.length + ":");
  
  long startTime = System.nanoTime();
  int[] A = InsertionSort(0, arr2);
  long endTime = System.nanoTime();
  time = endTime - startTime;
  InsertionSort.add(time);
  System.out.println("InsertionSort took " + (endTime - startTime) + " nanoseconds.");
  System.out.println("Is this array sorted?" + isSorted(A));
  
  startTime = System.nanoTime();
  int[] B = mergeSort(arr3, arr3.length);
  endTime = System.nanoTime();
  time = endTime - startTime;
  MergeSort.add(time);
  System.out.println("MergeSort took " + (endTime - startTime) + " nanoseconds.");
  System.out.println("Is this array sorted?" + isSorted(B));
  
  startTime = System.nanoTime();
  quickSort(0, arr4.length, arr4);
  endTime = System.nanoTime();
  time = endTime - startTime;
  QuickSort.add(time);
  System.out.println("QuickSort took " + (endTime - startTime) + " nanoseconds.");
  System.out.println("Is this array sorted?" + isSorted(arr4));
  
  startTime = System.nanoTime();
  quickSort2(0, arr5.length, arr5);
  endTime = System.nanoTime();
  time = endTime - startTime;
  QuickSort2.add(time);
  System.out.println("QuickSort2 took " + (endTime - startTime) + " nanoseconds.");
  System.out.println("Is this array sorted?" + isSorted(arr5));

  startTime = System.nanoTime();
  quickSort3(0, arr6.length, arr6);
  endTime = System.nanoTime();
  time = endTime - startTime;
  QuickSort3.add(time);
  System.out.println("QuickSort3 took " + (endTime - startTime) + " nanoseconds.");
  System.out.println("Is this array sorted?" + isSorted(arr6));
}

public static boolean isSorted(int[] arr) {
  for(int i = 1; i<arr.length; i++) {
    if(arr[i-1] > arr[i])
    {
      return false;
    }
    
  }
  return true;
}

public static long calculateAverage(ArrayList<Long> values) {
long sum = 0;
  if(!values.isEmpty()) {
    for (Long mark : values) {
        sum += mark;
    }
  return sum / values.size();
  }
  return sum;
}

public static void main(String[] args) {
  for(int i = 0; i < 11; i++) {
     System.out.print("");
  }
  
  //manually change the exponent
  int[] A = makeRanArray((int)Math.pow(2, 1));
  int[] B = makeRanArray((int) Math.pow(2, 2));
  int[] C = makeRanArray((int)Math.pow(2, 3));
  int[] D = makeRanArray((int) Math.pow(2, 4));
  int[] E = makeRanArray((int)Math.pow(2, 5));
  int[] F = makeRanArray((int) Math.pow(2, 6));
  int[] G = makeRanArray((int)Math.pow(2, 7));
  int[] H = makeRanArray((int) Math.pow(2, 8));
  int[] I = makeRanArray((int)Math.pow(2, 9));
  int[] J = makeRanArray((int) Math.pow(2, 10));
  int[] K = makeRanArray((int)Math.pow(2, 11));
  int[] L = makeRanArray((int) Math.pow(2, 12));
  int[] M = makeRanArray((int)Math.pow(2, 13));
  int[] N = makeRanArray((int) Math.pow(2, 14));
  int[] O = makeRanArray((int)Math.pow(2, 15));
  int[] P = makeRanArray((int) Math.pow(2, 16));
  
  //The print out for unsortedArray
  //you can do printString to see the print out of the array
  System.out.println(toString(A));
  System.out.println(toString(B));
  System.out.println(toString(C));
  System.out.println(toString(D));
  System.out.println(toString(E));
  toString2(F);
  toString2(G);
  toString2(H);
  toString2(I);
  toString2(J);
  toString2(K);
  toString2(L);
  toString2(M);
  toString2(N);
  toString2(O);
  //toString2(P); //is being wanky last minute
  
  System.out.println( "InsertionSort takes an average of " + calculateAverage(InsertionSort) + " nanoseconds.");
  System.out.println( "MergeSort takes an average of " + calculateAverage(MergeSort) + " nanoseconds.");
  System.out.println( "QuickSort takes an average of " + calculateAverage(QuickSort) + " nanoseconds.");
  System.out.println( "QuickSort2 takes an average of " + calculateAverage(QuickSort2) + " nanoseconds.");
  System.out.println( "QuickSort3 takes an average of " + calculateAverage(QuickSort3) + " nanoseconds.");

  
  
}

}
