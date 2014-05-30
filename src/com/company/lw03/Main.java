package com.company.lw03;

import com.company.lw03.parser.TextParser;
import com.company.lw03.task.SentenceSorter;
import com.company.lw03.task.UniqueWordsFinder;
import com.company.lw03.task.Task;
import com.company.lw03.text.Text;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Vova
 * Date: 29.05.14
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {

        File f = new File("text.txt");

        try {
            Text text = new Text(TextParser.parseText(f));
            text.printText();

            Task sorter = new SentenceSorter();
            sorter.execute(text);

            Task unique = new UniqueWordsFinder();
            unique.execute(text);

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}