package com.testdome.classes;

import java.util.Arrays;

/**
 Implement function countNumbers that accepts a sorted array of unique integers and, efficiently with respect to time used,
 counts the number of array elements that are less than the parameter lessThan.

  For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4) should return 2 because there are two array elements less than 4.
 */

// The best way to solve this problem is to use binary search
//Binary search is a fast algorithm for searching in a sorted array S of keys.
//To search for key q, we compare q to the middle key S[n/2]. If q appears before S[n/2], it must reside in the top half of our set; if not, it must reside in the bottom half of our set.
//By recursively repeating this process on the correct half, we find the key in a total of logN comparisons, a big win over the n/2 we expect with sequential search.
public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedArray[mid] < lessThan) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("There are " + left + " numbers in the array: " + Arrays.toString(sortedArray) + " that are less then: " + lessThan);
        return left;
    }
}
