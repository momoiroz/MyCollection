/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycollection;
//STEP 1: Book class
public class Books implements Comparable<Books>{
    private int number; //Key element
    private String name;
    private int year;

    public Books() {
    }

    public Books(int number, String name, int year) {
        this.number = number;
        this.name = name;
        this.year = year;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int compareTo(Books t) {
       return this.getNumber() - t.getNumber();    
    }
            
    @Override
    public String toString() {
        return "Number: " + number + ". Book name=" + name + ". Publish year: " + year;
    }
    
}
