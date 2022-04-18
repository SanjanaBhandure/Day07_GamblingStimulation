package com.Bridgelabz.Day07_GamblingStimulator;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class GamblingStimulation {
    static Logger logger = Logger.getLogger(GamblingStimulation.class);
    /*
     * Static Variables STAKE_PER_DAY and BET_PER_GAME created
     */
    static final int STAKE_PER_DAY = 100;       //Stake per day
    static final int BET_PER_GAME = 1;          //Bet per game

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("Welcome to Gambling Stimulation");
    }
}
