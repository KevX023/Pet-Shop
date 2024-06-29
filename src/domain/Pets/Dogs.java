package domain.Pets;

public class Dogs extends Pets {
    private Breed breed;

    public Dogs(int months, String name, String color, String country, Breed breed) {
        super(months, name, color, country);
        this.breed = breed;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    


}
