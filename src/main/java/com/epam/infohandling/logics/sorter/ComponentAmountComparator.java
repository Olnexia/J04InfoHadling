package com.epam.infohandling.logics.sorter;

import com.epam.infohandling.entity.Component;

import java.util.Comparator;
import java.util.List;

public class ComponentAmountComparator implements Comparator<Component> {

    @Override
    public int compare(Component firstComponent, Component secondComponent) {
        List<Component> firstChildren = firstComponent.getChildren();
        List<Component> secondChildren = secondComponent.getChildren();
        return Integer.compare(firstChildren.size(),secondChildren.size());
    }
}
