package com.epam.infohandling.logics.sorter;

import com.epam.infohandling.entity.Lexeme;

import java.util.Comparator;

public class CharacterOccurrencesComparator implements Comparator<Lexeme> {
    private char characterToCount;

    public CharacterOccurrencesComparator(char characterToCount){
        this.characterToCount = characterToCount;
    }

    @Override
    public int compare(Lexeme firstLexeme, Lexeme secondLexeme) {
        String firstLexemeValue = firstLexeme.getValue();
        String secondLexemeValue = secondLexeme.getValue();
        long firstOccurrencesAmount = firstLexemeValue.chars().filter(c -> c == characterToCount).count();
        long secondOccurrencesAmount = secondLexemeValue.chars().filter(c -> c == characterToCount).count();
        return Long.compare(firstOccurrencesAmount,secondOccurrencesAmount);
    }
}
