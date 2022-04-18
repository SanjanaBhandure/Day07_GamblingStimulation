package com.Bridgelabz.Day07_GamblingStimulator;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import java.util.Random;

public class GamblingStimulation {
    static Logger logger = Logger.getLogger(GamblingStimulatorUC5.class);
    /*Static Variables created*/
    public static final int STAKE_PER_DAY = 100;            //Stake per Day
    public static final int BET_PER_GAME = 1;               //Bet per game
    public static final int WIN = 1;
    public static int stake = 0;                            //Initial gambler bets with 1
    static int daysWonCount = 0;
    static int daysLostCount = 0;

    /*
     * winCheck function will check if gambler wins or loss
     */

    public static void winCheck() {
        Random random = new Random();
        int betReturns = random.nextInt(2);
        if (betReturns == WIN) {
            // incrementing
            stake++;
        } else {
            // decrementing
            stake--;
        }
    }

    /*
     * As a Calculative Gambler if won or lost 50% of the stake, would resign for
     * the day
     */

    public static void resignDayCheck() {
        int totalStake = 0;
        stake = 0;
        while (stake != 50 && stake != -50) {
            winCheck();
        }
        totalStake = stake + STAKE_PER_DAY;
        logger.info("Total stake for resign for a day is: " +totalStake);
    }

    /*
     * After 20 days of playing every day would like to know the total amount won or
     * lost.
     */

    public static void monthlyWinOrLossCheck() {
        int day, totalStake = 0;
        for (day = 1; day <= 20; day++) {
            logger.info("Day: " +day);
            resignDayCheck();
            if (stake == 50) {
                daysWonCount++;
                totalStake = totalStake + stake;
            } else if (stake == -50) {
                daysLostCount++;
                totalStake = totalStake + stake;
            }
        }
        if (totalStake < 0) {
            logger.info("After playing for 20 days Gambler lost total amount: $" +totalStake);
        } else {
            logger.info("After playing for 20 days Gambler won total amount: $" +totalStake);
        }
        logger.info(daysWonCount+ " Days won for a month \n" +daysLostCount+ " Days lost for a month");
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("Welcome to Gambling Simulation");
        monthlyWinOrLossCheck();
    }
}
