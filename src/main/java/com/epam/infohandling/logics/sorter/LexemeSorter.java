package com.epam.infohandling.logics.sorter;

import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Composite;
import java.util.Comparator;
import java.util.List;

public class LexemeSorter implements ComponentSorter{
    private Comparator<Component> lexemeComparator;

    public LexemeSorter(Comparator<Component> lexemeComparator){
        this.lexemeComparator = lexemeComparator;
    }

    @Override
    public Component sort(Component text) {
        List<Component> paragraphs = text.getChildren();
        paragraphs.forEach(p->p.getChildren().forEach(s->s.getChildren().sort(lexemeComparator)));
        return new Composite(paragraphs);
    }
}
