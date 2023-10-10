package com.codegym.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {


        game = new Hippodrome(new ArrayList<Horse>());

        Horse horse1 = new Horse("horse1", 3, 0);
        Horse horse2 = new Horse("horse2", 3, 0);
        Horse horse3 = new Horse("horse3", 3, 0);

        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        try {
            game.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        game.printWinner();

    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++){
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void move(){

        for (Horse values: horses){
            values.move();
        }

    }

    public void print(){

        for (Horse values: horses){
            values.print();
        }

        for (int i = 0; i < 10; i++){
            System.out.println();
        }
        
    }

    public Horse getWinner(){

        int dist1 = (int) horses.get(0).distance;
        int dist2 = (int) horses.get(1).distance;
        int dist3 = (int) horses.get(2).distance;

        if (dist1 >= dist2 && dist1 >= dist3) return horses.get(0);
        else if (dist2 >= dist1 && dist2 >= dist3) return horses.get(1);
        else return horses.get(2);

    }

    public void printWinner(){
        System.out.println("The winner is " + getWinner().name + "!");
    }

}
