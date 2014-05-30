package com.company.lw03.text;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vova
 * Date: 29.05.14
 * To change this template use File | Settings | File Templates.
 */
public class Text {

    private Collection<PartOfText> partsOfText = new TreeSet<PartOfText>(new SentenceComparator());

    public Text(Collection<PartOfText> partsOfText) {
        this.partsOfText = partsOfText;
    }

    public void printText() {
        for (PartOfText part : partsOfText) {
            System.out.print(part);
        }
        System.out.println();
    }

    public Collection<PartOfText> getPartsOfText() {
        return partsOfText;
    }

    public void setPartsOfText(Collection<PartOfText> partsOfText) {
        this.partsOfText = partsOfText;
    }


}