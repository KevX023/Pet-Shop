package repository;
import java.util.ArrayList;

import domain.Pets.Cats;
import domain.Pets.Dogs;

public class ShopRepository {
    private ArrayList<Dogs> listdDogs = new ArrayList<>();
    private ArrayList<Cats> listCats = new ArrayList<>();

    public void addDog(Dogs dog) {
        // Validate the dog object
        if (dog == null || dog.getName() == null || dog.getName().isEmpty()) {
            throw new IllegalArgumentException("Por favor introduzca bien los datos del perro");
        }

        // Check for duplicate dogs
        if (listdDogs.stream().anyMatch(Dogs -> Dogs.getName().equals(dog.getName()))) {
            throw new IllegalArgumentException("Ya existe un perro con ese nombre");
        }

        // Add the dog to the list
        listdDogs.add(dog);
    }

    public void addCat(Cats cat) {
        // Validate the cat object
        if (cat == null || cat.getName() == null || cat.getName().isEmpty()) {
            throw new IllegalArgumentException("Por favor introduzca bien los datos del gato");
        }

        // Check for duplicate cats
        if (listCats.stream().anyMatch(c -> c.getName().equals(cat.getName()))) {
            throw new IllegalArgumentException("Ya existe un gato con ese nombre");
        }

        // Add the cat to the list
        listCats.add(cat);
    }

    public ArrayList<Dogs> getDogs() {
        // Return a copy of the dogs list to prevent direct modification
        return new ArrayList<>(listdDogs);
    }

    public ArrayList<Cats> getCats() {
        // Return a copy of the cats list to prevent direct modification
        return new ArrayList<>(listCats);
    }
}
