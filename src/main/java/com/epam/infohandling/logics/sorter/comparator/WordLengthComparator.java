package com.epam.infohandling.logics.sorter.comparator;

import com.epam.infohandling.entity.Lexeme;
import java.util.Comparator;

public class WordLengthComparator implements Comparator<Lexeme> {
    @Override
    public int compare(Lexeme firstWord, Lexeme secondWord) {
        String firstContent = firstWord.getValue();
        String secondContent = secondWord.getValue();
        return Integer.compare(firstContent.length(),secondContent.length());
    }
}
