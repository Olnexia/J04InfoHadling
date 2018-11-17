package com.epam.infohandling;

import java.util.List;

public interface Component {
    void addComponent( Component component);
    List<Component> getChildren();
}
