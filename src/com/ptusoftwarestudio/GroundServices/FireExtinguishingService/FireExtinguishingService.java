package com.ptusoftwarestudio.GroundServices.FireExtinguishingService;

import com.ptusoftwarestudio.GroundServices.IGroundServiceControl;
import java.util.Random;

public class FireExtinguishingService implements IGroundServiceControl {

    private static final short MIN_TEMP_WATER = 5;
    private static final short MAX_TEMP_WATER = 90;
    private static final short CRITICAL_LEVEL_OF_WATER = 20;
    private static final short INDICATORS_COUNT = 100;

    private static final String ERROR_POWER_ALREADY_ON = "Ошибка: Питание уже включено. Действие отменено.";
    private static final String ERROR_POWER_ALREADY_OFF = "Ошибка: Питание уже отключено. Действие отменено";

    private static final String ACTION_POWER_SET_ON = "Питание включено";
    private static final String ACTION_POWER_SET_OFF = "Питание отключено";

    private int[] indicatorsVoltage = new int[INDICATORS_COUNT];

    private Random random = new Random();

    private static boolean power = false;

    private static void logMaker(String errorMessage) {
        System.out.println("Система пожаротушения: " + errorMessage);
    }

    private static void turnPowerOn() {
        if(!power) {
            power = true;
            logMaker(ACTION_POWER_SET_ON);
        } else {
            logMaker(ERROR_POWER_ALREADY_ON);
        }
    };

    private static void turnPowerOff() {
        if(power) {
            //
        } else {
            logMaker(ERROR_POWER_ALREADY_OFF);
        }

    };

    private static boolean isPowerOn() {
       return false;
    };

    private static void checkAllSensorInArea(int numberOfArea) {

    };

    private static double checkTemperatureInArea(int numberOfArea) {
        return 0;
    };

    private static void checkAllFireExtinguishingSystem() {

    };

    //In Percent
    private static double checkWaterLevelInTank() {
        return 0;
    };

    //In Degrees Celsius
    private static double checkWaterTempInTank() {
        return 0;
    }

    //In Cubic Meters
    private static double checkWaterConsumption() {
        return 0;
    }


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
        return 0;
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
