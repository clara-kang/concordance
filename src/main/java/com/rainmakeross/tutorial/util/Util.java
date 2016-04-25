package com.rainmakeross.tutorial.util;

import com.rainmakeross.tutorial.model.AnalysisOutput;

import java.util.*;

public class Util {

    public static String removeNonAlpha(String str) {
       return str.replaceAll("[^A-Za-z0-9. ]", "");
    }

    public static TreeMap<String, AnalysisOutput> populateWordList(String[] strArray) {
        TreeMap<String, AnalysisOutput> returnMap = new TreeMap<>();
        int sentenceCount = 1;
        for(String str: strArray) {
            // Must deal with end of a sentence
            // assumption1: dots are placed at the end of a word with no space in between
            // assumption2: dots contained within words with dot in the end is okay to be treated as a word like i.e.
            // assumption3: i.e. type constructs can not occur at the end of a sentence
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

    public static String[] sanitizeArray(String stringArg) {
        return stringArg.toLowerCase().split(" ");
    }

}
