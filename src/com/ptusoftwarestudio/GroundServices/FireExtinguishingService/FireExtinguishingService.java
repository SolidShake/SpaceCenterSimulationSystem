package com.ptusoftwarestudio.GroundServices.FireExtinguishingService;

import com.ptusoftwarestudio.GroundServices.IGroundServiceControl;
import com.ptusoftwarestudio.GroundServices.GroundServiceSystemMessage;
import java.util.Random;

public class FireExtinguishingService implements IGroundServiceControl {

    private static final short MIN_TEMP_WATER = 5;
    private static final short MAX_TEMP_WATER = 90;
    private static final short CRITICAL_LEVEL_OF_WATER = 20;
    private static final short INDICATORS_COUNT = 20;

    private static int[] indicatorsVoltage = new int[INDICATORS_COUNT];

    private static Random random = new Random();

    private static boolean power = false;

    private static void logMaker(String errorMessage) {
        System.out.println("Система пожаротушения: " + errorMessage);
    }

    private static void turnPowerOn() {
        if(!power) {
            for(short i = 0; i < INDICATORS_COUNT; i ++) {
                //8-10 volt
                indicatorsVoltage[i] = 8 + random.nextInt(2);
            }
            power = true;
            logMaker(GroundServiceSystemMessage.ACTION_POWER_SET_ON);
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_ALREADY_ON);
        }
    };

    private static void turnPowerOff() {
        if(power) {
            for(short i = 0; i < INDICATORS_COUNT; i ++) {
                indicatorsVoltage[i] = 0;
            }
            power = false;
            logMaker(GroundServiceSystemMessage.ACTION_POWER_SET_OFF);
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_ALREADY_OFF);
        }
    };

    private static boolean isPowerOn() {
       return power;
    };

    private static boolean checkAllSensor() {
        for(int voltage : indicatorsVoltage) {
            if(voltage <= 8 && voltage >= 10) {
                logMaker(GroundServiceSystemMessage.ERROR_SENSOR_NOT_WORKING);

                return false;
            } else {
                logMaker(GroundServiceSystemMessage.ACTION_SENSOR_SYSTEM_WORKING);
            }
        }

        return true;
    };

    //In Percent
    private static double checkWaterLevelInTank() {
        //0-100%
        double waterLevel = random.nextInt(100);

        return waterLevel;
    }

    private static void checkAllFireExtinguishingSystem() {
        boolean sensorStatus = checkAllSensor();
        boolean waterStatus = (checkWaterLevelInTank() > CRITICAL_LEVEL_OF_WATER);

        if(sensorStatus && waterStatus) {
            logMaker(GroundServiceSystemMessage.ACTION_ALL_SYSTEM_WORKING);
        } else {
            if (!sensorStatus) {
                logMaker(GroundServiceSystemMessage.ERROR_SENSOR_NOT_WORKING);
            }
            if (!waterStatus) {
                logMaker(GroundServiceSystemMessage.ERROR_WATEL_LEVEL_IS_LOW);
            }
        }

    };

    private static double checkTemperature() {
        //20-100 C
        int tempetature = 20 + random.nextInt(80);

        return tempetature;
    };


    @Override
    public void startSystem() {

    };

    @Override
    public void shutdownSystem() {

    };

    @Override
    public void showAllTelemetry() {

    };

    @Override
    public void killFire() {

    }

    @Override
    public double getSystemVoltage() {
        double SystemVoltage = 0.0;

        for(int voltage : indicatorsVoltage) {
            SystemVoltage += voltage;
        }

        return SystemVoltage;
    };

    @Override
    public boolean isSystemGo() {
        return false;
    }

    @Override
    public boolean isFireHere() {
        return random.nextInt(10) == 9;
    }

    ;


}
