package com.generalassembly.ngram;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Set;

public class NGramTextGenerator {
    /*
     * An ngram is a series of n contiguous words in a body of text.
     * For example, the above sentence contains the following 2grams: "an ngram", "ngram is", "is a", "a series", "series of", etc
     *
     * The map below uses an ngram (represented by a LinkedList of NGRAM_LENGTH) as the key,
     * and an ArrayList of all words trailing that ngram as the value.
     */
    private HashMap<LinkedList<String>, ArrayList<String>> ngrams;
    private LinkedList<String> currentNGram;
    private final Random random;

    private final int NGRAM_LENGTH = 2;
    private final int OUTPUT_WORD_COUNT = 300;

    public NGramTextGenerator() {
        this.ngrams = new HashMap<LinkedList<String>, ArrayList<String>>();
        this.currentNGram = null;
        this.random = new Random();
    }

    /**
     * Add a word to the data source we'll generate random text from.
     */
    public void addWord(String word) {
        // Have we started processing ngrams yet? If not, create a new currently processed ngram
        if (currentNGram == null) {
            currentNGram = new LinkedList<String>();
        }

        currentNGram.addLast(word);

        if (currentNGram.size() == NGRAM_LENGTH + 1) {
            // We have a new ngram + trailing word to add!
            // Separate out the n+1gram into an ngram and a trailing word, make a copy of it,
            // then add to our data store.
            LinkedList<String> ngram = new LinkedList<String>(currentNGram);
            String lastWord = ngram.removeLast();

            ArrayList<String> trailingWords = this.ngrams.get(ngram);
            if (trailingWords == null) {
                trailingWords = new ArrayList<String>();
            }

            trailingWords.add(lastWord);
            this.ngrams.put(ngram, trailingWords);

            // Remove the first thing from the currently processed n+1gram and keep on chugging.
            currentNGram.removeFirst();
        }
    }

    /**
     * Returns similar looking, but random text of length OUTPUT_WORD_LENGTH given the words added using addWord()
     * @return A string of length OUTPUT_WORD_LENGTH,
     */
    public String randomText() {
        // Start with random seed text
        LinkedList<String> words = this.randomNGram();
        StringWriter stringWriter = new StringWriter(this.OUTPUT_WORD_COUNT);
        stringWriter.append(ngramStringRepresentation(words));
        LinkedList<String> newWords = new LinkedList<String>();
        //int i = words.size();

        for (int i = 0; i < OUTPUT_WORD_COUNT; i++) {
            // Homework TODO: Given the generated map of ngrams and tailing words, generate random-seeming text!
            // * It should be OUTPUT_WORD_COUNT long
            // * If words is an ngram that exist in the map, get its associated ArrayList<String> and use random.nextInt
            //   to get a random value from it. After that, append that value
            // * If you come across an ngram that doesn't exist in the map, call randomNGram to get a random one
            // * To do all this, you should not need to make changes outside of this method.

            //RKM: if words is an ngram that exists in the map
            if (ngrams.containsKey(words)){
                //Get its associated ArrayList<String>
                ArrayList<String> list = ngrams.get(words);
                //And use random.nextInt to get a random value from its
                int newIndex = random.nextInt(list.size());

                String newWord = list.get(newIndex);
                //Append the value
                newWords.addLast(newWord);
            }

            //if words is an ngram that doesn't exist in the map
            words = this.randomNGram();

            //
            // Bonus opportunities (that will require changes to be made outside of this method):
            // * Instead of starting your text with a random ngram, instead start with the first ngram in the sample text you were given.
            // * Make output word length, ngram length user-settable parameters
        }
        stringWriter.append(ngramStringRepresentation(newWords));

        return stringWriter.toString();
    }

    private String ngramStringRepresentation(LinkedList<String> ngram) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : ngram) {
            stringBuilder.append(s + " ");
        }
        return stringBuilder.toString();
    }

    private LinkedList<String> randomNGram() {
        LinkedList<String> randomNGram = null;

        Set<LinkedList<String>> keySet = this.ngrams.keySet();
        List<LinkedList<String>> keys = new ArrayList<LinkedList<String>>(keySet);
        randomNGram = keys.get( random.nextInt(keys.size()) );

        return randomNGram;
    }
}
