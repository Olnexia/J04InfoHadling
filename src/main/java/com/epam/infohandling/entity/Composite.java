package com.epam.infohandling.entity;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> components = new ArrayList <>();

    public Composite(){
    }

    public Composite(List<Component> components){
        this.components = components;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public List<Component> getChildren() {
        return components;
    }
}
