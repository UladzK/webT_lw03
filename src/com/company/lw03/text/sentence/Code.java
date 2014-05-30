package com.company.lw03.text.sentence;

/**
 * Created with IntelliJ IDEA.
 * User: Vova
 * Date: 29.05.14
 * To change this template use File | Settings | File Templates.
 */

public class Code extends PartOfSentence {

    private String code;

    public Code(int position, String code) {
        super.setPosition(position);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String word) {
        this.code = word;
    }

    @Override
    public String toString() {
        return code;
    }
}