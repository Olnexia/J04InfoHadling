package com.epam.infohandling.logics.sorter.comparator;

import com.epam.infohandling.entity.Lexeme;
import java.util.Comparator;

public class DescendingCharacterOccurrencesComparator implements Comparator<Lexeme> {
    private char character;

    public DescendingCharacterOccurrencesComparator(char character){
        this.character = character;
    }

    @Override
    public int compare(Lexeme firstLexeme, Lexeme secondLexeme) {
        String firstLexemeValue = firstLexeme.getValue();
        String secondLexemeValue = secondLexeme.getValue();
        long firstOccurrencesAmount = firstLexemeValue.chars().filter(c -> c == character).count();
        long secondOccurrencesAmount = secondLexemeValue.chars().filter(c -> c == character).count();
        if(firstOccurrencesAmount<secondOccurrencesAmount){
            return 1;
        }else if(firstOccurrencesAmount>secondOccurrencesAmount){
            return -1;
        }else{
            return 0;
        }
    }
}
