package com.kodilla.rps;

import java.util.Scanner;

public class Logic {
    String human = "";
    String computer = "";
    public boolean play() {
        boolean stateOfTheGame = true;
        RpsRunner rps = new RpsRunner();
        String whatToDo = "";
        String areYouCertain = "Are you sure you want to end the game? " + "Confirm. \"n\" to cancel";
        Scanner scan = new Scanner(System.in);
        System.out.println("Rules of the game:");
        whatToDo = askRPS();
            if (whatToDo.equals("x")) {
                System.out.println(areYouCertain);
                if (!scan.next().equals("n")) {
                    rps.assessTheScore();
                    rps.rps();
                }
                whatToDo = askRPS();
            }
            if (whatToDo.equals("n")) {
                System.out.println(areYouCertain);
                if (!scan.next().equals("n")) {
                    rps.rps();
                }
                whatToDo = askRPS();
            }
            setRPSHuman(whatToDo);
            setRPSComputer();
        stateOfTheGame = compareHumanComputer();
        return stateOfTheGame;
    }

    private String askRPS() {
        Scanner sc = new Scanner(System.in);
        System.out.println(ConstansRPS.RULES);
        String RPSxn = sc.next();
        if (RPSxn.equals("1") || RPSxn.equals("2") || RPSxn.equals("3") || RPSxn.equals("x") || RPSxn.equals("n")){
            return RPSxn;
        }
        System.out.println("Please, pay attention, Your choice is limited to 1, 2 ,3 , n ,x .");
        askRPS();
        return RPSxn;
    }

    private boolean compareHumanComputer() {
        if (human.equals(computer)){
            System.out.println("You played " + human + ", Computer: " + computer + ". you both lose.");
            return false;
        }else if (human.equals(ConstansRPS.STONE) && computer.equals(ConstansRPS.SCISSORS)){
            humanWinsPrint();
            return true;
        }else if (human.equals(ConstansRPS.SCISSORS) && computer.equals(ConstansRPS.PAPER)){
            humanWinsPrint();
            return true;
        }else if (human.equals(ConstansRPS.PAPER) && computer.equals(ConstansRPS.PAPER)){
            humanWinsPrint();
            return true;
        }else {
            System.out.println("Computer wins." + " " + "You played " + human + ", Computer: " + computer);
            return false;
        }
    }

    private void humanWinsPrint() {
        System.out.println("Human wins." + " " + "You played " + human + ", Computer: " + computer);
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
