package repository;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import domain.Pets.Breed;
import domain.Pets.Cats;
import domain.Pets.Dogs;
import domain.Pets.Gender;

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
    
    

    public static void saveDog(ArrayList<Dogs> dogs){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("dog.txt", false));
            for(Dogs d: dogs){
                writer.write(d.toString());
                writer.newLine();
            }
            writer.close();
        }catch(IOException e){
            System.out.println("Error al guardar el archivo" + e.getMessage());
        }
    }

    public static void saveCat(ArrayList<Cats> cats){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("cat.txt", false));
            for(Cats c: cats){
                writer.write(c.toString());
                writer.newLine();
            }
            writer.close();
        }catch(IOException e){
            System.out.println("Error al guardar el archivo" + e.getMessage());
        }
    }

public static void readDog(ArrayList<Dogs> dogs) {
    try {
        BufferedReader reader = new BufferedReader(new FileReader("dog.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] datos = line.split(",");
            int months = Integer.parseInt(datos[0]);
            String name = datos[1];
            String color = datos[2];
            String country = datos[3];
            Breed breed = Breed.valueOf(datos[4]); // assuming Breed is an enum
            Dogs d = new Dogs(months, name, color, country, breed);
            dogs.add(d);
        }
        reader.close();
    } catch (IOException e) {
        System.out.println("Error al cargar el archivo" + e.getMessage());
    }
}

public static void readCat(ArrayList<Cats> cats) {
    try {
        BufferedReader reader = new BufferedReader(new FileReader("cat.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] datos = line.split(",");
            int months = Integer.parseInt(datos[0]);
            String name = datos[1];
            String color = datos[2];
            String country = datos[3];
            String eyecolor = datos[4];
            Gender gender = Gender.valueOf(datos[5]); // assuming Gender is an enum
            boolean pedigri = Boolean.parseBoolean(datos[6]);
            Cats c = new Cats(months, name, color, country, eyecolor, gender, pedigri);
            cats.add(c);
        }
        reader.close();
    } catch (IOException e) {
        System.out.println("Error al cargar el archivo" + e.getMessage());
    }
}

    public void callSaveDog(){
        saveDog(listdDogs);
    }

    public void callSaveCat(){
        saveCat(listCats);
    }

    public void callReadCat(){
        readCat(listCats);
    }

    public void callReadDog(){
        readDog(listdDogs);
    }
}
