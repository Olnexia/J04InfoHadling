package com.epam.infohandling.logics.sorter;

import java.util.Comparator;
import java.util.List;
import com.epam.infohandling.entity.Composite;
import com.epam.infohandling.entity.Component;

public class ParagraphSorter implements ComponentSorter {
    private Comparator<Component> paragraphComparator;

    public ParagraphSorter(Comparator<Component> paragraphComparator){
        this.paragraphComparator = paragraphComparator;
    }

    @Override
    public Component sort(Component text) {
        List<Component> paragraphs = text.getChildren();
        paragraphs.sort(paragraphComparator);
        return new Composite(paragraphs);
    }
}
