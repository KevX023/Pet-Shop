import domain.Pets.Cats;
import domain.Pets.Dogs;
import repository.ShopRepository;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ShopRepository shopRepository = new ShopRepository();

        shopRepository.callReadDog();
        shopRepository.callReadCat();

        // Ahora puedes acceder a los datos leídos en los archivos
        ArrayList<Dogs> dogs = shopRepository.getDogs();
        ArrayList<Cats> cats = shopRepository.getCats();

        // Imprimir los datos leídos
        System.out.println("Perros:");
        for (Dogs dog : dogs) {
            System.out.println(dog.toString());
        }

        System.out.println("Gatos:");
        for (Cats cat : cats) {
            System.out.println(cat.toString());
        }
    }
}