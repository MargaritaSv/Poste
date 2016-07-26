package poste;

/**
 * Created by Magi on 26.7.2016 г..
 */
public abstract class Person {
    private String name;
    private String secondName;

    public Person(String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
    }


    protected void setName(String name) {
        if (name == null || name.trim().length() <= 1) {
            throw new IllegalArgumentException("The name must be at least with two letters");
        }
        this.name = name;
    }

    protected void setSecondName(String secondName) {
        if (name == null || name.trim().length() <= 1) {
            throw new IllegalArgumentException("The second name must be at least with two letters");
        }
        this.secondName = secondName;
    }
}
