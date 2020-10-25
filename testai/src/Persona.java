import java.io.Serializable;

/**
 * @uthor Ami Mince
 */

public class Persona implements Serializable {
    private int id;
    private String name;

    public Persona(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return id + ":" + name;
    }
}
