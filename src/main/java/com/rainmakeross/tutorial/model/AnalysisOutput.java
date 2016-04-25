package com.rainmakeross.tutorial.model;

import java.util.ArrayList;
import java.util.List;

public class AnalysisOutput {
    private Integer occurenceCount;
    private List<Integer> sentences = new ArrayList<>();

    public AnalysisOutput(Integer sentenceNbr) {
        occurenceCount = 1;
        sentences.add(sentenceNbr);
    }

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
