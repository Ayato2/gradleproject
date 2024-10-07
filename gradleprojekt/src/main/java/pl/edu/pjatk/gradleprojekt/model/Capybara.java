package pl.edu.pjatk.gradleprojekt.model;

public class Capybara {
    private String name;
    private String color;

    public Capybara(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
