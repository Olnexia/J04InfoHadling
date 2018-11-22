package com.epam.infohandling.parser;

import com.epam.infohandling.entity.Composite;
import com.epam.infohandling.entity.Lexeme;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends Parser {
    private static final String POLISH_NOTATION_REGEX ="(\\d\\s)((\\d|[-+*/])\\s)+[-+*/]";
    private static final Pattern PRN_PATTERN = Pattern.compile(POLISH_NOTATION_REGEX);
    private static final String WORDS_SEPARATOR = "\\s+";
    private static final String EXPRESSION_PLACEHOLDER = "@expression@";

    public SentenceParser(){
    }

    @Override
    public Composite parse(String sentence) {
        Queue <String> expressions = findExpressions(sentence);
        String sentenceWithPlaceHolders = sentence.replaceAll(POLISH_NOTATION_REGEX, EXPRESSION_PLACEHOLDER);
        String[] words = sentenceWithPlaceHolders.split(WORDS_SEPARATOR);
        Composite sentenceComposite = new Composite();
        for (String word : words) {
            Lexeme lexeme;
            if (word.compareTo(EXPRESSION_PLACEHOLDER) == 0) {
                String expression = expressions.poll();
                lexeme = Lexeme.expression(expression);
            } else {
                lexeme = Lexeme.word(word);
            }
            sentenceComposite.addComponent(lexeme);
        }
        return sentenceComposite;
    }

    private Queue<String> findExpressions (String sentence){
        Queue<String> expressions = new LinkedList <>();
        Matcher matcher = PRN_PATTERN.matcher(sentence);
        while(matcher.find()){
            String expression = matcher.group();
            expressions.add(expression);
        }
        return expressions;
    }


}
