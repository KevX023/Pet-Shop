import domain.Pets.Breed;
import domain.Pets.Cats;
import domain.Pets.Dogs;
import domain.Pets.Gender;
import repository.ShopRepository;
import service.ShopService;

public class Main {

    public static void main(String[] args) {
        
        ShopRepository repository = new ShopRepository();
        ShopService shopService = new ShopService(repository);

        Cats Lole = new Cats(10, "Kelvin", "Negro", "Japon", "Rojos", Gender.Macho, true);
        Cats Albert = new Cats(30, "Albert", "Negro", "Japon", "Rojos", Gender.Macho, true);
        Dogs Aeogon = new Dogs(40, "Aegon", "Blanco", "Poniente", Breed.Bulldog);
        Dogs Valeryum = new Dogs(12, "Valerium", "Rojo", "Valiria", Breed.Dalmata);
        Dogs Tyriom = new Dogs(5, "Tyriom", "Rojo", "AHi", Breed.chowchow);

        repository.addCat(Albert);
        repository.addCat(Lole);
        repository.addDog(Aeogon);
        repository.addDog(Valeryum);
        repository.addDog(Tyriom);


        shopService.printPetByName("Lole");
        shopService.printOldestPet();
        shopService.findLeastCommonColorAmongDogs();
        shopService.printPetsOrderedByCountry();
    }

    
}