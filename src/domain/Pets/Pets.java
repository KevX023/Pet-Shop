package domain.Pets;

public class Pets {
    protected int months;
    protected String name;
    protected String color;
    protected String country;
    public Pets(int months, String name, String color, String country) {
        this.months = months;
        this.name = name;
        this.color = color;
        this.country = country;
    }
    public int getMonths() {
        return months;
    }
    public void setMonths(int months) {
        this.months = months;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    @Override
    public String toString() {
        return "Pets [months=" + months + ", name=" + name + ", color=" + color + ", country=" + country + "]";
    }

    


}
