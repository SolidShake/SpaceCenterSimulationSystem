package com.ptusoftwarestudio.GroundServices.EnergySupplySystem;

import com.ptusoftwarestudio.GroundServices.IGroundServiceControl;

import javax.sound.midi.MidiChannel;
import java.util.Random;

public class EnergyControlSystem implements IGroundServiceControl, IEnergyControlSystem {

    private static final short MAX_GENERATOR_VOLTAGE = 380;
    private static final short MIN_GENERATOR_VOLTAGE = 80;
    private static final byte GENERATORS_COUNT = 9;
    private static final byte BACKUP_GENERATORS_COUNT = 3;
    private static final byte ELECTRICAL_SUBSTATION_COUNT = 3;

    private static final String ERROR_POWER_ALREADY_ON = "Ошибка: Питание уже включено. Действие отменено";
    private static final String ERROR_POWER_ALREADY_OFF = "Ошибка: Питание уже отключено. Действие отменено";
    private static final String ERROR_POWER_OFF = "Ошибка: Питание отключено. Действие невозможно";
    private static final String ERROR_SYSTEM_ALREADY_ON = "Ошибка: Система контроля уже включена. Действие отменено";
    private static final String ERROR_SYSTEM_ALREADY_OFF = "Ошибка: Система контроля уже отключена. Действие отменено";
    private static final String ERROR_SYSTEM_OFF = "Ошибка: Система контроля отключено. Действие невозможно";
    private static final String ERROR_GENERATOR_ALREADY_ON = "Ошибка: Генератор %d уже запущен. Действие отменено";

    private static final String ACTION_POWER_SET_ON = "Питание включено";
    private static final String ACTION_POWER_SET_OFF = "Питание отключено";
    private static final String ACTION_SYSTEM_SET_ON = "Система контроля включена";
    private static final String ACTION_SYSTEM_SET_OFF = "Система контроля отключена";
    private static final String ACTION_GENERATOR_SET_ON = "Генератор %d был запущен";

    private Random random = new Random();

    private boolean power = false;
    private boolean system = false;

    private int[] generatorsVoltage = new int[GENERATORS_COUNT];
    private int[] backupGeneratorsVoltage = new int[BACKUP_GENERATORS_COUNT];
    private int[] electricalSubstationsVoltage = new int[ELECTRICAL_SUBSTATION_COUNT];

    private void logMaker(String errorMessage) {
        System.out.println("Система энергоснабжения: " + errorMessage);
    }

    @Override public void turnPowerOn() {
        if(!power) {
            power = true;
            logMaker(ACTION_POWER_SET_ON);
        }
        else {
           logMaker(ERROR_POWER_ALREADY_ON);
        }
    }

    @Override public void turnPowerOff() {
        if(power) {
            for(byte i = 0; i < ELECTRICAL_SUBSTATION_COUNT; i++) {
                electricalSubstationsVoltage[i] = 0;
            }
            for(byte i = 0; i < BACKUP_GENERATORS_COUNT; i++) {
                backupGeneratorsVoltage[i] = 0;
            }
            for(byte i = 0; i < GENERATORS_COUNT; i++) {
                generatorsVoltage[i] = 0;
            }
            system = false;
            power = false;
            logMaker(ACTION_POWER_SET_OFF);
        }
        else {
            logMaker(ERROR_POWER_ALREADY_OFF);
        }
    }

    @Override public boolean isPowerOn() {
        return power;
    }

    @Override public void turnControlSystemOn() {
        if(power) {
            if(!system) {
                system = true;
                logMaker(ACTION_SYSTEM_SET_ON);
            }
            else {
                logMaker(ERROR_SYSTEM_ALREADY_ON);
            }
        }
        else {
            logMaker(ERROR_POWER_OFF);
        }
    }

    @Override public void turnControlSystemOff() {
        if(power) {
            if(system) {
                system = false;
                logMaker(ACTION_SYSTEM_SET_OFF);
            }
            else {
                logMaker(ERROR_SYSTEM_ALREADY_OFF);
            }
        }
        else {
            logMaker(ERROR_POWER_OFF);
        }
    }

    @Override public boolean isControlSystemOn() {
        return system;
    }

    @Override public void setGeneratorsPowerOn() {
        if(power) {
            if(system) {
                for(byte i = 0; i < GENERATORS_COUNT; i++) {
                    if(generatorsVoltage[i] <= 0) {
                        generatorsVoltage[i] = MIN_GENERATOR_VOLTAGE + random.nextInt(MAX_GENERATOR_VOLTAGE -
                                MIN_GENERATOR_VOLTAGE);
                        logMaker(String.format(ACTION_GENERATOR_SET_ON, i));
                    }
                    else {
                        logMaker(String.format(ERROR_GENERATOR_ALREADY_ON, i));
                    }
                }
            }
            else {
                logMaker(ERROR_SYSTEM_OFF);
            }
        }
        else {
            logMaker(ERROR_POWER_OFF);
        }
    }

    @Override
    public void setGeneratorsPowerOff() {

    }

    @Override
    public void setGeneratorPowerOn(int generatorNumber) {

    }

    @Override
    public void setGeneratorPowerOff(int generatorNumber) {

    }

    @Override
    public void setBackupGeneratorsPowerOn() {

    }

    @Override
    public void setBackupGeneratorsPowerOff() {

    }

    @Override
    public void setBackupGeneratorPowerOn(int backupGeneratorNumber) {

    }

    @Override
    public void setBackupGeneratorPowerOff(int backupGeneratorNumber) {

    }

    @Override
    public void showAllGeneratorsVoltage() {

    }

    @Override
    public int getGeneratorVoltage(int generatorNumber) {
        return 0;
    }

    @Override
    public int getBackupGeneratorVoltage(int backupGeneratorNumber) {
        return 0;
    }

    @Override
    public int getGeneratorsCount() {
        return 0;
    }

    @Override
    public int getBackupGeneratorsCount() {
        return 0;
    }

    @Override
    public void setElectricalSubstationsPowerOn() {

    }

    @Override
    public void setElectricalSubstationsPowerOff() {

    }

    @Override
    public void setElectricalSubstationPowerOn(int generatorNumber) {

    }

    @Override
    public void setElectricalSubstationPowerOff(int generatorNumber) {

    }

    @Override
    public void showAllElectricalSubstationsVoltage() {

    }

    @Override
    public int getElectricalSubstationVoltage(int generatorNumber) {
        return 0;
    }

    @Override
    public int getElectricalSubstationsCount() {
        return 0;
    }

    @Override
    public int checkSubstationsEnergy() {
        return 0;
    }

    @Override
    public boolean connectToEnergy(double[] members) {
        return false;
    }

    @Override
    public void adaptiveEnergyControlSystem(int substationNumber) {

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
    public double getSystemVoltage() {
        return 0;
    }

    @Override
    public boolean isSystemOk() {
        return false;
    }
}
