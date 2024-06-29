import domain.Pets.Breed;
import domain.Pets.Cats;
import domain.Pets.Dogs;
import domain.Pets.Gender;
import repository.ShopRepositoryimport;

public class Main {

    public static void main(String[] args) {
        
        ShopRepositoryimport repository = new ShopRepositoryimport();

        Cats Lole = new Cats(10, "Kelvin", "Negro", "Japon", "Rojos", Gender.Macho, true);
        Cats Albert = new Cats(30, "Albert", "Negro", "Japon", "Rojos", Gender.Macho, true);
        Dogs Aeogon = new Dogs(40, "Aegon", "Blanco", "Poniente", Breed.Bulldog);
        Dogs Valeryum = new Dogs(12, "Valerium", "Rojo", "Valiria", Breed.Dalmata);
        Dogs Tyriom = new Dogs(5, "Tyriom", "Verde", "AHi", Breed.chowchow);

        System.out.println(Lole.price());
        System.out.println(Albert.price());
        System.out.println(Aeogon.price());
        System.out.println(Valeryum.price());
        System.out.println(Tyriom.price());

        repository.addCat(Albert);
        repository.addCat(Lole);
        repository.addDog(Aeogon);
        repository.addDog(Valeryum);
        repository.addDog(Tyriom);

        System.out.println("Dogs:");
        for (Dogs dog : repository.getDogs()) {
            System.out.println("- Name: " + dog.getName() + ", Age: " + dog.getMonths() + ", Breed: " + dog.getBreed() + "Price: " + dog.price());
        }

        // Print the cats
        System.out.println("\nCats:");
        for (Cats cat : repository.getCats()) {
            System.out.println("- Name: " + cat.getName() + ", Age: " + cat.getMonths() + ", Breed: " + cat.isPedigri() + "Price: " + cat.price());
        }

        
    }

    
}