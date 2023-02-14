package com.testdome.classes;

import java.util.Arrays;

/**
 Implement function countNumbers that accepts a sorted array of unique integers and, efficiently with respect to time used,
 counts the number of array elements that are less than the parameter lessThan.

  For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4) should return 2 because there are two array elements less than 4.
 */

// The best way to solve this problem is to use binary search
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
