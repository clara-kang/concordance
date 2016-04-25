package com.rainmakeross.tutorial.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilTest {
    String trialStr = "Apple is a great company!!!.";
    String noNonAlphaTrialStr = "Apple is a great company.";
    String trialStr2 = "Given an arbitrary text document written in English, write a program that will generate a " +
            "concordance, i.e. an alphabetical list of all word occurrences, labeled with word frequencies. " +
            "Bonus: label each word with the sentence numbers in which each occurrence appeared.";

    String resultStr = "{a=2:[1, 1], " +
            "all=1:[1], alphabetical=1:[1], an=2:[1, 1], appeared=1:[2], arbitrary=1:[1], bonus=1:[2], concordance=1:[1], document=1:[1], each=2:[2, 2], " +
            "english=1:[1], frequencies=1:[1], generate=1:[1], given=1:[1], i.e.=1:[1], in=2:[1, 2], label=1:[2], labeled=1:[1], list=1:[1], numbers=1:[2], " +
            "occurrence=1:[2], occurrences=1:[1], of=1:[1], program=1:[1], sentence=1:[2], text=1:[1], that=1:[1], the=1:[2], which=1:[2], will=1:[1], " +
            "with=2:[1, 2], word=3:[1, 1, 2], write=1:[1], written=1:[1]}";

    @Test
    public void fullRun() throws Exception {
        String[] wordArr2 = Util.sanitizeArray(Util.removeNonAlpha(trialStr2));
        assertEquals(Util.populateWordSet(wordArr2).toString(), resultStr);
    }

    @Test
    public void removeNonAlpha() throws Exception {
        assertEquals(Util.removeNonAlpha(trialStr), noNonAlphaTrialStr);
    }

    @Test
    public void populateWordList() throws Exception {
        String[] wordArr = Util.sanitizeArray(Util.removeNonAlpha(trialStr));
        assertEquals(wordArr.length, 5);
        assertEquals(Util.populateWordSet(wordArr).firstKey(), "a");

        String[] wordArr2 = Util.sanitizeArray(Util.removeNonAlpha(trialStr2));
        assertEquals(wordArr2.length, 41);
        assertEquals(Util.populateWordSet(wordArr2).lastKey(), "written");
    }

}