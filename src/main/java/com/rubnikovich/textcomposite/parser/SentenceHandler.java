package com.rubnikovich.textcomposite.parser;

import com.rubnikovich.textcomposite.entity.TextComponent;
import com.rubnikovich.textcomposite.entity.TextComposite;
import com.rubnikovich.textcomposite.entity.TextType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceHandler extends AbstractHandler {
    private static final String REGEX = " {1,4}.+?\\."; //fixme
    private AbstractHandler successor = new LexemeHandler();

    @Override
    public TextComponent handleRequest(String text) {
        TextComponent paragraph = new TextComposite(TextType.PARAGRAPH);
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            paragraph.addComponent(successor.handleRequest(matcher.group()));
        }
        return paragraph;
    }
}