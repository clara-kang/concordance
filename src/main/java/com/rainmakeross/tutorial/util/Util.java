package com.rainmakeross.tutorial.util;

import com.rainmakeross.tutorial.model.AnalysisOutput;

import java.util.*;

/**
 * Utility methods and core processing algorithm
 */
public class Util {

    /**
     * Removes all non-Alpha numberic chars except dot
     * @param str String to be processed
     * @return Alpha numberic with dots
     */
    public static String removeNonAlpha(String str) {
       return str.replaceAll("[^A-Za-z0-9. ]", "");
    }

    /**
     * Populates a sorted Map with word info
     * @param strArray Pre-processed String Array for counting
     * @return Sorted Map with Analysis Output
     */
    public static TreeMap<String, AnalysisOutput> populateWordSet(String[] strArray) {
        TreeMap<String, AnalysisOutput> returnMap = new TreeMap<>();
        int sentenceCount = 1;
        for(String str: strArray) {
            if(str.endsWith(".") && !str.substring(0, str.length()-1).contains(".")) {
                String wordExceptDot = str.substring(0, str.length()-1);
                AnalysisOutput analysisOutput = returnMap.get(wordExceptDot);
                if(analysisOutput != null){
                    returnMap.put(wordExceptDot, new AnalysisOutput(analysisOutput, sentenceCount));
                } else {
                    returnMap.put(wordExceptDot, new AnalysisOutput(sentenceCount));
                }
                sentenceCount++;
            } else {
                AnalysisOutput analysisOutput = returnMap.get(str);
                if(analysisOutput != null){
                    returnMap.put(str, new AnalysisOutput(analysisOutput, sentenceCount));
                } else {
                    returnMap.put(str, new AnalysisOutput(sentenceCount));
                }
            }
        }
        return returnMap;
    }

    /**
     * Sanitizes String by making it all lower case and splits into an array of strings
     * @param stringArg String to be sanitized and split
     * @return Word Array
     */
    public static String[] sanitizeArray(String stringArg) {
        return stringArg.toLowerCase().split(" ");
    }

}
