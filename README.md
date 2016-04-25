# Concordance Tutorial

[![Build Status](https://travis-ci.org/rainmakeross/concordance.svg?branch=master)](https://travis-ci.org/rainmakeross/concordance)

## Introduction
Algorithm is designed to handle word frequencies and produce a sorted word Map with frequencies
and list of sentences encountered. Sorting is done on the key (alphabetical).

TreeMap is utilized for its efficient keySorting capabilities. As it is based on Red-Black Tree structure,
virtually all access and retrieval methods are of order O(log(n)).

## Algorithm PseudoCode
1. Pre-processing: Parse text to ensure non-alphanumeric (except dots) are eliminated and it is convereted
to small letters. TimeComplexity: O(n). SpaceComplexity: O(n)
2. Counting and Sorting: Every key is inserted into a TreeMap with an associated AnalyisObject
keeping track of number of repetitions and sentencesEncountered. TimeComplexity O(2*n*log(n)) ~ O(n*log(n))
SpaceComplexity: O(n) -- memory utilization is linear with words

## Complexity Analysis
* TimeComplexity: O(n) + O(n*log(n)) ~ O(n) when n is very large
* SpaceComplexity: O(n) + O(n) ~ O(n) when n is very large

## Testing
### Unit Tests
Utility methods are tested via JUnit4. In order to run them, please execute "gradle test"

### Performance Tests
Solution is tested via JMH for same string and 2X same string, theoretical complexity
analysis matches practical JMH output, please execute via "gradle jmh".

Futher information can be gleaned via Travis CI file and output as to how to execute
and output.