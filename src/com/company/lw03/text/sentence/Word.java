package com.company.lw03.text.sentence;

/**
 * Created with IntelliJ IDEA.
 * User: Vova
 * Date: 29.05.14
 * To change this template use File | Settings | File Templates.
 */
public class Word extends PartOfSentence {

    private String word;

    public Word(int position, String word) {
        super.setPosition(position);
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (word == null ? 0 : word.hashCode())*100;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        Word o = (Word) obj;
        return (word == null ? o.word == null : word.equals(o.word));
    }
}