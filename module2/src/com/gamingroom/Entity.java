package com.gamingroom;

public class Entity {

    private long id;

    private String name;

    //we keep the default constructor private so no empty Entities can be created
    private Entity(){}

    //we use this constructor inside our subclasses so we can pass data to the superclass
    //if we don't do this, then we would not be able to use the
    //id and name variables since the subclasses do not have access to them
    public Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    //getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //we have this toString method that we can tack onto the different subclasses
    //doing it this way allows us to print out which class is using the method
    //inside each class while having the data portion here in the superclass
    @Override
    public String toString() {
        return " [id=" + id + ", name=" + name + "]";
    }
}
