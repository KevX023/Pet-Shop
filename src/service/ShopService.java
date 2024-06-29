package service;

import domain.Pets.Cats;
import domain.Pets.Dogs;
import repository.ShopRepository;

public class ShopService {
    private ShopRepository repository;

    public ShopService(ShopRepository repository) {
        this.repository = repository;
    }

    public void printDogs() {
        // Print the dogs
        System.out.println("Dogs:");
        for (Dogs dog : repository.getDogs()) {
            System.out.println("- Name: " + dog.getName() + ", Age: " + dog.getMonths() + ", Breed: " + dog.getBreed() + ", Price: $" + dog.price());
        }
    }
    public void printCats(){   // Print the cats
        System.out.println("\nCats:");
        for (Cats cat : repository.getCats()) {
            System.out.println("- Name: " + cat.getName() + ", Age: " + cat.getMonths() + ", Pedrigi: " + cat.isPedigri() + ", Price: $" + cat.price());
        }
    }

    public void printPetByName(String petName) {
        // Search for the dog with the given name
        Dogs dog = repository.getDogs().stream()
                .filter(d -> d.getName().equalsIgnoreCase(petName))
                .findFirst()
                .orElse(null);

        if (dog != null) {
            System.out.println("Perro: Nombre: " + dog.getName() + ", Meses: " + dog.getMonths() + ", Raza : " + dog.getBreed() + ", Price: $" + dog.price());
            return;
        }
    
        // Search for the cat with the given name
        Cats cat = repository.getCats().stream()
                .filter(c -> c.getName().equalsIgnoreCase(petName))
                .findFirst()
                .orElse(null);

        if (cat != null) {
            System.out.println("Cat: Name: " + cat.getName() + ", Age: " + cat.getMonths() + ", Pedrigi: " + cat.isPedigri() + ", Price: $" + cat.price());
            return;
        } else {
            System.out.println("Mascota no encontrada: " + petName);
        }
    }
}
