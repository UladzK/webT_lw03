package com.company.lw03.text;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: Vova
 * Date: 29.05.14
 * To change this template use File | Settings | File Templates.
 */

public class SentenceComparator implements Comparator<PartOfText> {

    @Override
    public int compare(PartOfText o1, PartOfText o2) {
        return o1.getPosition() - o2.getPosition();
    }
}