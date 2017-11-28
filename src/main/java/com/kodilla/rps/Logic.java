package com.kodilla.rps;

import java.util.Scanner;

public class Logic {
    String human = "";
    String computer = "";
    public boolean play() {
        RpsRunner rps = new RpsRunner();
        String whatToDo = "";
        String areYouCertain = "Are you sure you want to end the game? " + "Confirm. \"n\" to cancel";
        String rules = "Key 1 - play \"stone\"" + "\n" + "Key 2 - play \"paper\"" + "\n" + "Key 3 - play \"scissors\"" + "\n"
                + "Key x - end the game. " + "\n" + "Key n - start new game. ";
        Scanner scan = new Scanner(System.in);
        System.out.println("Rules of the game:");
        System.out.println(rules);

            whatToDo = scan.next();
            if (whatToDo.equals("x")) {
                System.out.println(areYouCertain);
                if (!scan.next().equals("n")) {
                    rps.assessTheScore();
                }
            }
            if (whatToDo.equals("n")) {
                System.out.println(areYouCertain);
                if (!scan.next().equals("n")) {
                    rps.rps();
                }
            }
            setRPSHuman(whatToDo);
            setRPSComputer();
        return compareHumanComputer();
    }

    private boolean compareHumanComputer() {
        if (human.equals(computer)){
            System.out.println("You played " + human + ", Computer: " + computer + ". you both lose.");
            return false;
        }else if (human.equals(ConstansRPS.STONE) && computer.equals(ConstansRPS.SCISSORS)){
            System.out.println("Human wins." + " " + "You played " + human + ", Computer: " + computer);
            return true;
        }else if (human.equals(ConstansRPS.SCISSORS) && computer.equals(ConstansRPS.PAPER)){
            System.out.println("Human wins." + " " + "You played " + human + ", Computer: " + computer);
            return true;
        }else if (human.equals(ConstansRPS.PAPER) && computer.equals(ConstansRPS.PAPER)){
            System.out.println("Human wins." + " " + "You played " + human + ", Computer: " + computer);
            return true;
        }else {
            System.out.println("Computer wins." + " " + "You played " + human + ", Computer: " + computer);
            return false;
        }
    }

    public void setRPSHuman(String RPS){
        if (RPS.equals("1")){
            human = ConstansRPS.STONE;
        }else if (RPS.equals("2")){
            human = ConstansRPS.PAPER;
        }else if (RPS.equals("3")){
            human = ConstansRPS.SCISSORS;
        }
    }
    public void setRPSComputer(){
        computer = Math.random() < 0.33 ? ConstansRPS.PAPER : (Math.random() >= 0.33 && Math.random() < 0.66
                ? ConstansRPS.SCISSORS : ConstansRPS.STONE);
    }

    public int checkNumberOfGames(int i) {
        if (i < 0){
            System.out.println("Please re enter number of games: (Number needed, larger than zero.)");
            Scanner sc = new Scanner(System.in);
            return sc.nextInt();
        }
        return i;
    }
}
