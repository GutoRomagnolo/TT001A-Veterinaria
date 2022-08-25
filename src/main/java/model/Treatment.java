package model;

public class Treatment {
    private final int id;
    private String name;
    private String history;
    private String document_number;
    private String initial_date;
    private String final_date;
    private int animal_id;


    public Treatment(int id, String name, String history, String document_number, String initial_date, String final_date, int animal_id) {
        this.id = id;
        this.name = name;
        this.history = history;
        this.document_number = document_number;
        this.initial_date = initial_date;
        this.final_date = final_date;
        this.animal_id = animal_id;
    }
    
    public int getId() {
        return id;
    }

    public int getAnimal_id() {
        return animal_id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    public String getInitial_date() {
        return initial_date;
    }

    public void setInitial_date(String initial_date) {
        this.initial_date = initial_date;
    }

    public String getFinal_date() {
        return final_date;
    }

    public void setFinal_date(String final_date) {
        this.final_date = final_date;
    }
}
