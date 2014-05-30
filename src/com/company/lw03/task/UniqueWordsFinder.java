package com.company.lw03.task;

import com.company.lw03.text.PartOfText;
import com.company.lw03.text.Text;
import com.company.lw03.text.sentence.PartOfSentence;
import com.company.lw03.text.sentence.Sentence;
import com.company.lw03.text.sentence.Word;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vova
 * Date: 29.05.14
 * To change this template use File | Settings | File Templates.
 */

public class UniqueWordsFinder implements Task {
    @Override
    public void execute(Text text) {
        List<Sentence> sentences = extractSentences(text);

        System.out.println();
        System.out.println("[FIRST TASK] Find all unique words in the first sentence");
        System.out.println();

        Iterator<Sentence> iterator = sentences.iterator();
        List<Word> potencialWords = extractWord(iterator.next());
        while (iterator.hasNext()) {
            List<Word> deletedWord = extractWord(iterator.next());
            potencialWords.removeAll(deletedWord);
        }
        for (Word word : potencialWords) {
            System.out.println(word);
        }
        System.out.println("********************************************************");
    }

    private List<Sentence> extractSentences(Text text) {
        List<PartOfText> partOfTexts = new ArrayList<PartOfText>(text.getPartsOfText());
        List<Sentence> sentences = new ArrayList<Sentence>();
        for (PartOfText part : partOfTexts) {
            if (part instanceof Sentence) {
                sentences.add((Sentence)part);
            }
        }
        return sentences;
    }

    private List<Word> extractWord(Sentence sentence) {
        List<PartOfSentence> partOfSentences = new ArrayList<PartOfSentence>(sentence.getPartsOfSentence());
        List<Word> words = new ArrayList<Word>();
        for (PartOfSentence part : partOfSentences) {
            if (part instanceof Word) {
                words.add((Word)part);
            }
        }
        return words;
    }
}
