package com.epam.infohandling;


import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> components = new ArrayList<Component>();

    public void addComponent(Component component) {
        components.add(component);
    }

    public List<Component> getChildren() {
        return components;
    }
}
