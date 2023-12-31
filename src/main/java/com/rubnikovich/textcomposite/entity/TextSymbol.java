package com.rubnikovich.textcomposite.entity;

import java.util.ArrayList;
import java.util.List;

public class TextSymbol implements TextComponent {
    private TextType type;
    private Character symbol;

    public TextSymbol(Character symbol) {
        this.symbol = symbol;
        this.type = setType();
    }

    @Override
    public String collect() {
        return symbol.toString();
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException("can't add anything into the symbol");
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException("can't remove anything from the symbol");
    }

    @Override
    public int count() {
        return 1;
    }

    @Override
    public List<TextComponent> getTextComponent() {
        return new ArrayList<>();
    }

    @Override
    public TextType getType() {
        return type;
    }

    @Override
    public String toString() {
        return symbol.toString();
    }

    private TextType setType() {
        type = TextType.PUNCTUATION;
        if (Character.isLetter(symbol)) { //NullPointerException
            this.type = TextType.LETTER;
        }
        return type;
    }
}
