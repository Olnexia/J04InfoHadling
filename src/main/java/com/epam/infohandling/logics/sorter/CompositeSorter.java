package com.epam.infohandling.logics.sorter;

import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Composite;
import java.util.Collections;
import java.util.List;

//TODO Write integrated test
//TODO Think about sorting

public class CompositeSorter {

    public Composite sort(Composite text,SortingType sortingType) {
        switch (sortingType){
            case PARAGRAPHS_BY_WORDS_AMOUNT:
                List<Component> paragraphs = text.getChildren();
                Collections.sort(paragraphs,new ComponentAmountComparator());
                return new Composite(paragraphs);
                break;
            case WORDS_BY_LENGTH:
//                paragraphs.stream().flatMap(p->p.getChildren().stream().sorted(new WordLengthComparator())).collect(Composite:)

                break;
            case LEXEMES_BY_CHARACTER_OCCUR_DESC:
                break;
        }
//        List<Component> components = composite.getChildren();
//        Collections.sort(components,comparator);
    }
}
