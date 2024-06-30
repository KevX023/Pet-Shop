package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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

    public void printOldestPet() {
        // Find the oldest dog
        Dogs oldestDog = repository.getDogs().stream()
                .max((d1, d2) -> Integer.compare(d1.getMonths(), d2.getMonths()))
                .orElse(null);

        // Find the oldest cat
        Cats oldestCat = repository.getCats().stream()
                .max((c1, c2) -> Integer.compare(c1.getMonths(), c2.getMonths()))
                .orElse(null);

        // Print the oldest pet
        if (oldestDog != null && oldestCat != null) {
            if (oldestDog.getMonths() >= oldestCat.getMonths()) {
                System.out.println("Oldest pet: Dog, Name: " + oldestDog.getName() + ", Age: " + oldestDog.getMonths());
            } else {
                System.out.println("Oldest pet: Cat, Name: " + oldestCat.getName() + ", Age: " + oldestCat.getMonths());
            }
        } else if (oldestDog != null) {
            System.out.println("Oldest pet: Dog, Name: " + oldestDog.getName() + ", Age: " + oldestDog.getMonths());
        } else if (oldestCat != null) {
            System.out.println("Oldest pet: Cat, Name: " + oldestCat.getName() + ", Age: " + oldestCat.getMonths());
        } else {
            System.out.println("No pets found in the shop.");
        }
    }

    public void findLeastCommonColorAmongDogs() {
        // Collect the colors of all dogs and count their occurrences
        Map<String, Long> colorCounts = repository.getDogs().stream()
                .collect(Collectors.toMap(
                        Dogs::getColor,
                        c -> 1L,
                        Long::sum
                ));

        // Find the color with the smallest count
        Entry<String, Long> leastCommonColor = colorCounts.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElse(null);

        if (leastCommonColor != null) {
            System.out.println("The color that is least predominant among the dogs is: " + leastCommonColor.getKey());
        } else {
            System.out.println("No dogs found in the shop.");
        }
    }

        public void printPetsOrderedByCountry() {
        // Combine the dogs and cats into a single list
        List<Object> allPets = new ArrayList<>();
        allPets.addAll(repository.getDogs());
        allPets.addAll(repository.getCats());

        // Sort the list by country of origin
        allPets.sort(Comparator.comparing(p -> {
            if (p instanceof Dogs) {
                return ((Dogs) p).getCountry();
            } else if (p instanceof Cats) {
                return ((Cats) p).getCountry();
            } else {
                return "";
            }
        }));

        // Print the sorted pets
        for (Object pet : allPets) {
            if (pet instanceof Dogs) {
                Dogs dog = (Dogs) pet;

            } else if (pet instanceof Cats) {
                Cats cat = (Cats) pet;
            }
        }
    }
}


