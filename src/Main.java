import domain.Pets.Breed;
import domain.Pets.Cats;
import domain.Pets.Dogs;
import domain.Pets.Gender;

public class Main {

    public static void main(String[] args) {
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
    }
}