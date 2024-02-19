package com.practice.java.lld;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> snakes = new HashMap<>();
        Map<Integer, Integer> ladders = new HashMap<>();
        Integer numOfSnakes = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < numOfSnakes; i++) {
            String[] snakeInput = scanner.nextLine().split(" ");
            snakes.put(Integer.valueOf(snakeInput[0]), Integer.valueOf(snakeInput[1]));
        }
        Integer numOfLadders = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < numOfLadders; i++) {
            String[] ladderInput = scanner.nextLine().split(" ");
            snakes.put(Integer.valueOf(ladderInput[0]), Integer.valueOf(ladderInput[1]));
        }
        Integer noOfPlayers = Integer.valueOf(scanner.nextLine());
        String playerOne = scanner.nextLine();
        String playerTwo = scanner.nextLine();
        scanner.close();
        Integer playerOnePosition = 0;
        Integer playerTwoPosition = 0;
        int chance = 1;
        Random random = new Random();
        while (playerOnePosition <= 100 && playerTwoPosition <= 100) {
            int diceRoll = random.nextInt(6) + 1;
            int updatedPosition = playAMove(diceRoll, ladders, snakes, chance == 1 ? playerOnePosition : playerTwoPosition, chance == 1 ? playerOne : playerTwo);
            if(chance == 1) {
                playerOnePosition = updatedPosition > 100 ? playerOnePosition : updatedPosition;
            } else {
                playerTwoPosition = updatedPosition > 100 ? playerTwoPosition : updatedPosition;
            }
            if (updatedPosition == 100) {
                System.out.println(chance == 1 ? playerOne : playerTwo + " wins the game");
                break;
            }
            chance = chance * -1;
        }
    }

    private static Integer playAMove(int diceRoll, Map<Integer, Integer> ladders, Map<Integer, Integer> snakes,
            Integer playerPosition, String player ) {
        int initPosition = playerPosition;
        playerPosition += diceRoll;
        if (snakes.containsKey(playerPosition)) {
            playerPosition = snakes.get(playerPosition);
        } else if (ladders.containsKey(playerPosition)) {
            playerPosition = ladders.get(playerPosition);
        }
        System.out.println(player + " rolled a " + diceRoll + " and moved from " + initPosition + " to " + playerPosition);
        return playerPosition;
    }

}
