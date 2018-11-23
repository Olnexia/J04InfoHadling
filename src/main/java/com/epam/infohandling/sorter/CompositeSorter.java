package com.epam.infohandling.sorter;

import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Composite;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//TODO Write integrated test
//TODO Think about sorting

public class CompositeSorter {

    public void sort(Composite composite, Comparator comparator) {
        List<Component> components = composite.getChildren();
        Collections.sort(components,comparator);
    }
}
