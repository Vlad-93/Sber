package com.company;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public boolean marry(Person person) {
        if (this.man == person.man || this.spouse == person)
            return false;

        this.divorce();
        person.divorce();

        this.spouse = person;
        person.spouse = this;

        return true;
    }

    public boolean divorce() {
        if (this.spouse == null)
            return false;

        this.spouse.spouse = null;
        this.spouse = null;

        return true;
    }

    public String getName() {
        return name;
    }

    public Person getSpouse() {
        return spouse;
    }
}
