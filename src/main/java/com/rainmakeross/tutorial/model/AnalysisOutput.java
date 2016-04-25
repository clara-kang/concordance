package com.rainmakeross.tutorial.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Analysis Output is analysis representation to be furhter utilized or printed
 */
public class AnalysisOutput {
    private Integer occurenceCount;
    private List<Integer> sentences = new ArrayList<>();

    /**
     * Initial constructor for first encounter of a word
     * @param sentenceNbr Sentence number where word is found
     */
    public AnalysisOutput(Integer sentenceNbr) {
        occurenceCount = 1;
        sentences.add(sentenceNbr);
    }


    /**
     * Constructor for subsequent encounters of a word
     * @param ao Previous encounter's AnalysisOutput for state representation
     * @param sentenceNbr New encounter's sentence location
     */
    public AnalysisOutput(AnalysisOutput ao, Integer sentenceNbr) {
        occurenceCount = ao.occurenceCount + 1;
        sentences = ao.sentences;
        sentences.add(sentenceNbr);
    }

    @Override
    public String toString() {
        return occurenceCount + ":"+ sentences;
    }
}
