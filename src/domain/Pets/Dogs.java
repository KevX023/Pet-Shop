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

    @Override
    public double price(){
        if (getMonths() <= 24 && getBreed() == Breed.Bulldog) {
            return 1000 / getMonths();            
        } else if (getMonths() <= 24 && getBreed() == Breed.chowchow ) {
            return 1000 / getMonths() + 30;
        } else if (getMonths() <= 24 && getBreed() == Breed.Dalmata) {
            return 1000 / getMonths() + 50;
        } else if (getMonths() > 24 && getBreed() == Breed.chowchow) {
            return 65.00;
        }   else if (getMonths() > 24 && getBreed() == Breed.Dalmata) {
            return 85.00; 
        } else {
            return 35.00;
        }
    }

    @Override
    public String toString() {
        return "Dogs [months=" + months + ", breed=" + breed + ", name=" + name + ", color=" + color + ", country="
                + country + "]";
    }

}
