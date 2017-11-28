package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    private int numberOfVictoriesHuman = 0;
    private int numberOfVictoriesComputer = 0;
    public void rps(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name?");
        String name = sc.next();
        System.out.println("How many games takes to win:");
        int i = sc.nextInt();
        Logic logic = new Logic();
        i = logic.checkNumberOfGames(i);


        for (int j = 0 ; j < i ; j++){
            if (logic.play()){
                numberOfVictoriesHuman++;
            }else {
                numberOfVictoriesComputer++;
            }
        }
        assessTheScore();
    }

    public void assessTheScore() {
        System.out.println("Human won: " + numberOfVictoriesHuman + " times. " + "Computer: " + numberOfVictoriesComputer);
    }
}
