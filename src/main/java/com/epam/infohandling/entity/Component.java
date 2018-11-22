package com.epam.infohandling.entity;

import java.util.List;

public interface Component {
    void addComponent( Component component);
    List<Component> getChildren();
}
