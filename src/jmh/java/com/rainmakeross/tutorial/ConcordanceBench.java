package com.rainmakeross.tutorial;


import com.rainmakeross.tutorial.util.Util;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.State;

public class ConcordanceBench {

    @Benchmark
    public void testMethod() {
        String trialStr = "Given an arbitrary text document written in English, write a program that will generate a " +
                "concordance, i.e. an alphabetical list of all word occurrences, labeled with word frequencies. " +
                "Bonus: label each word with the sentence numbers in which each occurrence appeared.";

        String[] wordArr = Util.sanitizeArray(Util.removeNonAlpha(trialStr));
        Util.populateWordList(wordArr);
    }

    @Benchmark
    public void testMethodDoubleSize() {
        String trialStr = "Given an arbitrary text document written in English, write a program that will generate a " +
                "concordance, i.e. an alphabetical list of all word occurrences, labeled with word frequencies. " +
                "Bonus: label each word with the sentence numbers in which each occurrence appeared.";

        String[] wordArrDouble = Util.sanitizeArray(Util.removeNonAlpha(trialStr+ " "+ trialStr));
        Util.populateWordList(wordArrDouble);
    }
}
