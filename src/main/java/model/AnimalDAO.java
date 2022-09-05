package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalDAO {
    private final List<Animal> animals = new ArrayList<Animal>();
    private int animal_id = 1;
 
    public List<Animal> create(String name, String birthday, int gender, int specie_id, int customer_id) {
        Animal animal = new Animal(animal_id, name, birthday, gender, specie_id, customer_id);
        this.animals.add(animal);
        animal_id++;
        return this.animals;
    }

    public List<Animal> retrieveAll() {
        return this.animals;
    }

    public List<Animal> retrieveByID(int id) {
        return (List<Animal>) this.animals.stream().filter(animal -> animal.getId() == id).collect(Collectors.toList());
    }

    public List<Animal> retrieveByClientID(int id) {
        return (List<Animal>) this.animals.stream().filter(animal -> animal.getCustomerId() == id).collect(Collectors.toList());
    }

    public int update(int id, String name, String birthday, int gender, int specie_id, int client_id) {
        int index = 0;

        for (Animal animal:this.animals) {
            if (animal.getId() == id) {
                Animal animal_update = this.animals.get(index);
                animal_update.setName(name);
                animal_update.setBirthday(birthday);
                animal_update.setGender(gender);
                break;
            }
            index++;
        }

        return 1;
    }

    public int delete(int id) {
        int index = 0;

        for (Animal animal:this.animals) {
            if (animal.getId() == id) {
                this.animals.remove(index);
                break;
            }
            index++;
        }

        return 1;
    }
}