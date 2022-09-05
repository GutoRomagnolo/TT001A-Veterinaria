package model;

public class Animal {
    private final int id;
    private String birthday;
    private String name;
    private int gender;
    private int specie_id;
    private int customer_id;

    public Animal(int id, String birthday, String name, int gender, int specie_id, int customer_id) {
        this.id = id;
        this.birthday = birthday;
        this.name = name;
        this.gender = gender;
    }

    public int getSpecieId() {
        return specie_id;
    }
    
    public int getCustomerId() {
        return customer_id;
    }
        
    public int getId() {
        return id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
