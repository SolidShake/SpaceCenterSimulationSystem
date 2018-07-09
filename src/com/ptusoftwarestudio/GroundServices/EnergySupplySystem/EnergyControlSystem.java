package com.ptusoftwarestudio.GroundServices.EnergySupplySystem;

import com.ptusoftwarestudio.GroundServices.IGroundServiceControl;
import com.ptusoftwarestudio.GroundServices.GroundServiceSystemMessage;

import java.util.Random;

public final class EnergyControlSystem implements IGroundServiceControl {

    private static final short MAX_GENERATOR_VOLTAGE = 380;
    private static final short MIN_GENERATOR_VOLTAGE = 80;
    private static final byte GENERATORS_COUNT = 9;
    private static final byte BACKUP_GENERATORS_COUNT = 3;
    private static final byte ELECTRICAL_SUBSTATION_COUNT = 3;

    private static final String ERROR_GENERATOR_ALREADY_ON = "Ошибка: Генератор %d уже запущен. Действие отменено";

    private static final String ACTION_GENERATOR_SET_ON = "Генератор %d был запущен";

    private static Random random = new Random();

    private static boolean power = false;
    private static boolean system = false;

    private static int[] generatorsVoltage = new int[GENERATORS_COUNT];
    private static int[] backupGeneratorsVoltage = new int[BACKUP_GENERATORS_COUNT];
    private static int[] electricalSubstationsVoltage = new int[ELECTRICAL_SUBSTATION_COUNT];

    private static void logMaker(String errorMessage) {
        System.out.println("Система энергоснабжения: " + errorMessage);
    }

    private static void turnPowerOn() {
        if (!power) {
            power = true;
            logMaker(GroundServiceSystemMessage.ACTION_POWER_SET_ON);
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_ALREADY_ON);
        }
    }

    private static void turnPowerOff() {
        if (power) {
            for (byte i = 0; i < ELECTRICAL_SUBSTATION_COUNT; i++) {
                electricalSubstationsVoltage[i] = 0;
            }
            for (byte i = 0; i < BACKUP_GENERATORS_COUNT; i++) {
                backupGeneratorsVoltage[i] = 0;
            }
            for (byte i = 0; i < GENERATORS_COUNT; i++) {
                generatorsVoltage[i] = 0;
            }
            system = false;
            power = false;
            logMaker(GroundServiceSystemMessage.ACTION_POWER_SET_OFF);
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_ALREADY_OFF);
        }
    }

    private static boolean isPowerOn() {
        return power;
    }

    public static void turnControlSystemOn() {
        if (power) {
            if (!system) {
                system = true;
                logMaker(GroundServiceSystemMessage.ACTION_SYSTEM_SET_ON);
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_ALREADY_ON);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
        }
    }

    private static void turnControlSystemOff() {
        if (power) {
            if (system) {
                system = false;
                logMaker(GroundServiceSystemMessage.ACTION_SYSTEM_SET_OFF);
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_ALREADY_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
        }
    }

    private static boolean isControlSystemOn() {
        return system;
    }

    private static void setGeneratorsPowerOn() {
        if (power) {
            if (system) {
                for (byte i = 0; i < GENERATORS_COUNT; i++) {
                    if (generatorsVoltage[i] <= 0) {
                        generatorsVoltage[i] = MIN_GENERATOR_VOLTAGE + random.nextInt(MAX_GENERATOR_VOLTAGE -
                                MIN_GENERATOR_VOLTAGE);
                        logMaker(String.format(ACTION_GENERATOR_SET_ON, i));
                    } else {
                        logMaker(String.format(ERROR_GENERATOR_ALREADY_ON, i));
                    }
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
        }
    }

    private static void setGeneratorsPowerOff() {

    }

    private static void setGeneratorPowerOn(int generatorNumber) {

    }

    private static void setGeneratorPowerOff(int generatorNumber) {

    }

    private static void setBackupGeneratorsPowerOn() {

    }

    private static void setBackupGeneratorsPowerOff() {

    }

    private static void setBackupGeneratorPowerOn(int backupGeneratorNumber) {

    }

    private static void setBackupGeneratorPowerOff(int backupGeneratorNumber) {

    }

    private static void showAllGeneratorsVoltage() {

    }

    private static int getGeneratorVoltage(int generatorNumber) {
        return 0;
    }

    private static int getBackupGeneratorVoltage(int backupGeneratorNumber) {
        return 0;
    }

    private static int getGeneratorsCount() {
        return 0;
    }

    private static int getBackupGeneratorsCount() {
        return 0;
    }

    private static void setElectricalSubstationsPowerOn() {

    }

    private static void setElectricalSubstationsPowerOff() {

    }

    private static void setElectricalSubstationPowerOn(int generatorNumber) {

    }

    private static void setElectricalSubstationPowerOff(int generatorNumber) {

    }

    private static void showAllElectricalSubstationsVoltage() {

    }

    private static int getElectricalSubstationVoltage(int generatorNumber) {
        return 0;
    }

    private static int getElectricalSubstationsCount() {
        return 0;
    }

    private static int checkSubstationsEnergy() {
        return 0;
    }

    private static boolean connectToEnergy(double[] members) {
        return false;
    }

    private static void adaptiveEnergyControlSystem(int substationNumber) {

    }

    @Override
    public void startSystem() {

    }

    @Override
    public void shutdownSystem() {

    }

    @Override
    public void showAllTelemetry() {

    }

    @Override
    public void killFire() {
        
    }

    @Override
    public double getSystemVoltage() {
        return 0;
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
