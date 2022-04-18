package com.Bridgelabz.Day07_GamblingStimulator;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import java.util.Random;

public class GamblingStimulation {
    static Logger logger = Logger.getLogger(GamblingStimulation.class);
    /*
     * Static Variables STAKE_PER_DAY and BET_PER_GAME created
     */
    public static final int STAKE_PER_DAY = 100;             // Stake per day
    public static final int BET_PER_GAME = 1;                //Bet per game
    public static final int WIN = 1;
    public static int stake = 0;                             //initial gambler bets with 1

    /*
     * winCheck method will check if gambler wins or loss the game
     */
    public static void winCheck() {
        Random random = new Random();
        int betReturns = random.nextInt(2);
        if (betReturns == WIN) {
            // incrementing
            stake++;
            logger.info("Congratulations you Win!!!");
        } else {
            // decrementing
            stake--;
            logger.info("You loss the Game!!!");
        }
        logger.info("Stake: " + stake);
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("Welcome to Gambling Simulation");
        //Calling winCheck method
        winCheck();
    }
}
