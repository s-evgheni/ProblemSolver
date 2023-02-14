package com.testdome.classes;


/**
 Given the time in numerals we may convert it into words, as shown below:

 5:00 -> five o’ clock
 5:01 -> one minute past five
 5:10 -> ten minutes past five
 5.15 -> quarter past five
 5:30 -> half past five
 5:40 -> twenty minutes to six
 5:45 -> quarter to six
 5:47 -> thirteen minutes to six
 5:28 -> twenty eight minutes past five

 At minutes = 0, use o' clock.
 For 1<= minutes <= 30, use past,
 and for 30 < minutes use to.
 Note the space between the apostrophe and clock in o' clock
 Write a program in Java which prints the time in words for the input given in the format described.

 Function Description
 Complete the timeInWords function.
 timeInWords has the following parameter(s):
 * int h: the hour of the day
 * int m: the minutes after the hour
 Returns
 * string: a time string as described

 Input Format
 The first line contains h, the hours portion The second line contains m, the minutes portion

 Constraints
 1 <= h <= 12
 0 <= m < 60


 Sample input: h = 3, m = 0
 Sample output: There o’ clock

 Sample input h = 7, m = 15
 Sample output: Quarter past seven

 Sample input: h = 5, m = 47
 Sample output: Thirteen minutes to six
 */
public class TimeInWords {

    public static String timeInWords(int h, int m) {
        String[] numbers = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine"};
        String hourString = numbers[h];
        String minuteString = "";
        if (m == 0) {
            return hourString + " o' clock";
        } else if (m == 30) {
            return "half past " + hourString;
        } else if (m == 15) {
            return "quarter past " + hourString;
        } else if(m == 45) {
            return "quarter to " + (h == 12 ? numbers[1] : numbers[h + 1]);
        } else if (m < 21) {
            minuteString = numbers[m];
            return minuteString + " minute" + (m != 1 ? "s" : "") + " past " + hourString;
        } else if (m < 30) {
            minuteString = "twenty " + numbers[m - 20];
            return minuteString + " minutes past " + hourString;
        } else if (m == 59) {
            return "one minute to " + (h == 12 ? numbers[1] : numbers[h + 1]);
        } else if (m > 30 && m < 40) {
            minuteString = numbers[60 - m];
            return minuteString + " minutes to " + (h == 12 ? numbers[1] : numbers[h + 1]);
        } else {
            minuteString = numbers[60 - m];
            return minuteString + " minute" + (m != 1 ? "s" : "") + " to " + (h == 12 ? numbers[1] : numbers[h + 1]);
        }
    }
}
