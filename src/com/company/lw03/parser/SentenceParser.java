package com.company.lw03.parser;

import com.company.lw03.text.sentence.Code;
import com.company.lw03.text.sentence.PartOfSentence;
import com.company.lw03.text.sentence.Punctuation;
import com.company.lw03.text.sentence.Word;

import java.util.Collection;
import java.util.ResourceBundle;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vova on 5/30/14.
 */
public class SentenceParser {

    private ResourceBundle regexp;
    private String codeRegEx;
    private String wordRegEx;
    private String text;

    public SentenceParser(String resourcePath, String codeRegEx, String wordRegEx){
        regexp = ResourceBundle.getBundle(resourcePath);
    }

    public Collection<PartOfSentence> parseSentence(String sentence) {

        sentence = sentence.replaceAll("\r", "\n");

        Collection<PartOfSentence> parts = new TreeSet<PartOfSentence>();

        Pattern codePattern = Pattern.compile(regexp.getString(codeRegEx));
        Matcher codeMatcher = codePattern.matcher(sentence);
        while (codeMatcher.find()) {
            if (codeMatcher.group(1) != null) {
                Code code = new Code(codeMatcher.start(1), codeMatcher.group(1));
                parts.add(code);
            }
        }

        Pattern wordPattern = Pattern.compile(regexp.getString(wordRegEx));
        Matcher wordMatcher = wordPattern.matcher(sentence);
        while (wordMatcher.find()) {
            if (wordMatcher.group(1) != null) {
                Word word = new Word(wordMatcher.start(1), wordMatcher.group(1));
                parts.add(word);
            }
            if (wordMatcher.group(2) != null) {
                Punctuation punctuation = new Punctuation(wordMatcher.start(2), wordMatcher.group(2));
                parts.add(punctuation);
            }
        }

        return parts;
    }
}
