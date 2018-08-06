package com.ptusoftwarestudio.GroundServices.FireExtinguishingService;

import com.ptusoftwarestudio.GroundServices.IGroundServiceControl;
import com.ptusoftwarestudio.GroundServices.GroundServiceSystemMessage;
import java.util.Random;

public class FireExtinguishingService implements IGroundServiceControl {

    private static final short CRITICAL_LEVEL_OF_WATER = 20;
    private static final short INDICATORS_COUNT = 20;

    private static int[] indicatorsVoltage = new int[INDICATORS_COUNT];

    private static Random random = new Random();

    private static boolean power = false;
    private static boolean system = false;
    //private static boolean systemGo = false;

    private static void logMaker(String errorMessage) {
        System.out.println("Система пожаротушения: " + errorMessage);
    }

    private static void turnPowerOn() {
        if(!power) {
            power = true;
            logMaker(GroundServiceSystemMessage.ACTION_POWER_SET_ON);
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_ALREADY_ON);
        }
    }

    private static void turnPowerOff() {
        if(power) {
            turnFireExtinguishingSystemOff();

            power = false;
            system = false;
            logMaker(GroundServiceSystemMessage.ACTION_POWER_SET_OFF);
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_ALREADY_OFF);
        }
    }

    private static boolean isPowerOn() {
       return power;
    };

    private static void turnFireExtinguishingSystemOn() {
        if(power) {
            if(!system) {
                system = true;
                logMaker(GroundServiceSystemMessage.ACTION_FIRE_EXTINGUISHING_SYSTEM_ON);
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_FIRE_EXTINGUISHING_SYSTEM_ALREADY_ON);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_ALREADY_OFF);
        }
    }

    private static void turnFireExtinguishingSystemOff() {
        if(power) {
            if(system) {
                system = false;
                logMaker(GroundServiceSystemMessage.ACTION_FIRE_EXTINGUISHING_SYSTEM_OFF);
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_FIRE_EXTINGUISHING_SYSTEM_ALREADY_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_ALREADY_OFF);
        }
    }

    private static void setIndicatorsTurnOn() {
        if(power) {
            if (system) {
                for (short i = 0; i < INDICATORS_COUNT; i++) {
                    int chanceOfBraking = random.nextInt(100);
                    if (chanceOfBraking > 95) {
                        indicatorsVoltage[i] = 0;
                    } else {
                        //8-10 volt
                        indicatorsVoltage[i] = 8 + random.nextInt(2);
                    }
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_FIRE_EXTINGUISHING_SYSTEM_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
        }
    }

    private static void setIndicatorsTurnOff() {
        if(power) {
            if (system) {
                for(short i = 0; i < INDICATORS_COUNT; i++) {
                    indicatorsVoltage[i] = 0;
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_FIRE_EXTINGUISHING_SYSTEM_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
        }
    }

    private static boolean checkAllSensor() {
        for(int voltage : indicatorsVoltage) {
            if(voltage <= 8 && voltage >= 10) {
                logMaker(GroundServiceSystemMessage.ERROR_SENSOR_NOT_WORKING);

                return false;
            }
        }

        logMaker(GroundServiceSystemMessage.ACTION_SENSOR_SYSTEM_WORKING);

        return true;
    }

    //In Percent
    private static double checkWaterLevelInTank() {
        //0-100%
        double waterLevel = random.nextInt(100);

        return waterLevel;
    }

    private static boolean checkAllFireExtinguishingSystem() {
        boolean sensorStatus = checkAllSensor();
        boolean waterStatus = (checkWaterLevelInTank() > CRITICAL_LEVEL_OF_WATER);

        if(sensorStatus && waterStatus) {
            logMaker(GroundServiceSystemMessage.ACTION_ALL_SYSTEM_WORKING);
        } else {
            if (!sensorStatus) {
                logMaker(GroundServiceSystemMessage.ERROR_SENSOR_NOT_WORKING);
            }
            if (!waterStatus) {
                logMaker(GroundServiceSystemMessage.ERROR_WATER_LEVEL_IS_LOW);
            }

            return false;
        }

        return true;
    }

    private static double checkTemperature() {
        //20-100 C
        int tempetature = 20 + random.nextInt(80);

        return tempetature;
    }

    public static boolean fireExtinguishing() {
        if(checkAllFireExtinguishingSystem()) {
            logMaker(GroundServiceSystemMessage.ACTION_FIRE_EXTINGUISHED);

            return true;
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_FIRE_NOT_EXTINGUISHED);

            return false;
        }
    }


    @Override
    public void startSystem() {
        turnPowerOn();
        turnFireExtinguishingSystemOn();
        setIndicatorsTurnOn();
        logMaker(GroundServiceSystemMessage.ACTION_SYSTEM_TURNED_ON);
    }

    @Override
    public void shutdownSystem() {
        turnPowerOff();
        turnFireExtinguishingSystemOff();
        setIndicatorsTurnOff();
        logMaker(GroundServiceSystemMessage.ACTION_SYSTEM_TURNED_OFF);
    }

    @Override
    public void showAllTelemetry() {
        if(power) {
            getSystemVoltage();
            checkTemperature();
            checkWaterLevelInTank();
            checkAllSensor();
        } else {
            logMaker(GroundServiceSystemMessage.ACTION_POWER_SET_OFF);
        }
    }

    @Override
    public void killFire() {
        fireExtinguishing();
    }

    @Override
    public double getSystemVoltage() {
        double SystemVoltage = 0.0;

        for(int voltage : indicatorsVoltage) {
            SystemVoltage += voltage;
        }

        return SystemVoltage;
    }

    @Override
    public boolean isSystemGo() {
        return false;
    }

    @Override
    public boolean isFireHere() {
        return random.nextInt(10) == 9;
    }
}
