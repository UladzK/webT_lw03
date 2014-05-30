package com.company.lw03.parser;

import com.company.lw03.text.PartOfText;
import com.company.lw03.text.SentenceComparator;
import com.company.lw03.text.sentence.*;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Vova
 * Date: 29.05.14
 * To change this template use File | Settings | File Templates.
 */
public class TextParser {

    private static final String RESOURCE_PATH = "resources.regexp";
    private static final String CODE_REGEX = "codeRegEx";
    private static final String WORD_REGEX = "wordRegEx";
    private static final String TEXT_REGEX = "textRegEx";

    private static ResourceBundle regexp = ResourceBundle.getBundle(RESOURCE_PATH);

    private TextParser() {}

    public static Collection<PartOfText> parseText(File f) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(f.getAbsolutePath()));
        Charset encoding = Charset.forName("UTF-8");

        String readText = encoding.decode(ByteBuffer.wrap(encoded)).toString();
        return parseText(readText);
    }

    public static Collection<PartOfText> parseText(String text) {

        Collection<PartOfText> partsOfText = new TreeSet<PartOfText>(new SentenceComparator());

        Pattern pattern = Pattern.compile(regexp.getString(TEXT_REGEX));
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String match = matcher.group();
            SentenceParser sp = new SentenceParser(RESOURCE_PATH, CODE_REGEX, WORD_REGEX);
            Sentence sentence = new Sentence(matcher.start(), sp.parseSentence(match));
            partsOfText.add(sentence);
        }

        return partsOfText;
    }
}