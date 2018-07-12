package com.ptusoftwarestudio.GroundServices.EnergySupplySystem;

import com.ptusoftwarestudio.GroundServices.IGroundServiceControl;
import com.ptusoftwarestudio.GroundServices.GroundServiceSystemMessage;

import java.util.Random;

public final class EnergyControlSystem implements IGroundServiceControl {

    private static final short MAX_GENERATOR_VOLTAGE = 380;
    private static final short MIN_GENERATOR_VOLTAGE = 200;
    private static final byte GENERATORS_COUNT = 9;
    private static final byte BACKUP_GENERATORS_COUNT = 3;
    private static final byte ELECTRICAL_SUBSTATION_COUNT = 3;
    private static Random random = new Random();
    private static boolean power = false;
    private static boolean system = false;
    private static boolean systemGo = false;

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
                        logMaker(String.format(GroundServiceSystemMessage.ACTION_GENERATOR_SET_ON, i));
                    } else {
                        logMaker(String.format(GroundServiceSystemMessage.ERROR_GENERATOR_ALREADY_ON, i));
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
        if (power) {
            if (system) {
                for (byte i = 0; i < GENERATORS_COUNT; i++) {
                    if (generatorsVoltage[i] != 0) {
                        generatorsVoltage[i] = 0;
                        logMaker(String.format(GroundServiceSystemMessage.ACTION_GENERATOR_SET_OFF, i));
                    } else {
                        logMaker(String.format(GroundServiceSystemMessage.ERROR_GENERATOR_ALREADY_OFF, i));
                    }
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
        }
    }

    private static void setGeneratorPowerOn(int generatorNumber) {
        if (power) {
            if (system) {
                if (generatorsVoltage[generatorNumber] <= 0) {
                    generatorsVoltage[generatorNumber] = MIN_GENERATOR_VOLTAGE + random.nextInt(MAX_GENERATOR_VOLTAGE -
                            MIN_GENERATOR_VOLTAGE);
                    logMaker(String.format(GroundServiceSystemMessage.ACTION_GENERATOR_SET_ON, generatorNumber));
                } else {
                    logMaker(String.format(GroundServiceSystemMessage.ERROR_GENERATOR_ALREADY_ON, generatorNumber));
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
        }
    }

    private static void setGeneratorPowerOff(int generatorNumber) {
        if (power) {
            if (system) {
                if (generatorsVoltage[generatorNumber] != 0) {
                    generatorsVoltage[generatorNumber] = 0;
                    logMaker(String.format(GroundServiceSystemMessage.ACTION_GENERATOR_SET_OFF, generatorNumber));
                } else {
                    logMaker(String.format(GroundServiceSystemMessage.ERROR_GENERATOR_ALREADY_OFF, generatorNumber));
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
        }
    }

    private static void setBackupGeneratorsPowerOn() {
        if (power) {
            if (system) {
                for (byte i = 0; i < BACKUP_GENERATORS_COUNT; i++) {
                    if (backupGeneratorsVoltage[i] <= 0) {
                        backupGeneratorsVoltage[i] = MIN_GENERATOR_VOLTAGE + random.nextInt(MAX_GENERATOR_VOLTAGE -
                                MIN_GENERATOR_VOLTAGE);
                        logMaker(String.format(GroundServiceSystemMessage.ACTION_BACKUP_GENERATOR_SET_ON, i));
                    } else {
                        logMaker(String.format(GroundServiceSystemMessage.ERROR_BACKUP_GENERATOR_ALREADY_ON, i));
                    }
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
        }
    }

    private static void setBackupGeneratorsPowerOff() {
        if (power) {
            if (system) {
                for (byte i = 0; i < BACKUP_GENERATORS_COUNT; i++) {
                    if (backupGeneratorsVoltage[i] != 0) {
                        backupGeneratorsVoltage[i] = 0;
                        logMaker(String.format(GroundServiceSystemMessage.ACTION_BACKUP_GENERATOR_SET_OFF, i));
                    } else {
                        logMaker(String.format(GroundServiceSystemMessage.ERROR_BACKUP_GENERATOR_ALREADY_OFF, i));
                    }
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
        }
    }

    private static void setBackupGeneratorPowerOn(int backupGeneratorNumber) {
        if (power) {
            if (system) {
                if (generatorsVoltage[backupGeneratorNumber] <= 0) {
                    generatorsVoltage[backupGeneratorNumber] = MIN_GENERATOR_VOLTAGE + random.nextInt(MAX_GENERATOR_VOLTAGE -
                            MIN_GENERATOR_VOLTAGE);
                    logMaker(String.format(GroundServiceSystemMessage.ACTION_BACKUP_GENERATOR_SET_ON, backupGeneratorNumber));
                } else {
                    logMaker(String.format(GroundServiceSystemMessage.ERROR_BACKUP_GENERATOR_ALREADY_ON, backupGeneratorNumber));
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
        }
    }

    private static void setBackupGeneratorPowerOff(int backupGeneratorNumber) {
        if (power) {
            if (system) {
                if (generatorsVoltage[backupGeneratorNumber] != 0) {
                    generatorsVoltage[backupGeneratorNumber] = 0;
                    logMaker(String.format(GroundServiceSystemMessage.ACTION_BACKUP_GENERATOR_SET_OFF, backupGeneratorNumber));
                } else {
                    logMaker(String.format(GroundServiceSystemMessage.ERROR_BACKUP_GENERATOR_ALREADY_OFF, backupGeneratorNumber));
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
        }
    }

    private static void showAllGeneratorsVoltage() {
        if (power) {
            if (system) {
                for (int i = 0; i < GENERATORS_COUNT; i++) {
                    if (generatorsVoltage[i] > 0) {
                        logMaker(String.format(GroundServiceSystemMessage.ACTION_SHOW_GENERATOR_VOLTAGE, i,
                                generatorsVoltage[i]));
                    } else {
                        logMaker(String.format(GroundServiceSystemMessage.ERROR_GENERATOR_IS_OFF, i));
                    }
                }
                for (int i = 0; i < BACKUP_GENERATORS_COUNT; i++) {
                    if (backupGeneratorsVoltage[i] > 0) {
                        logMaker(String.format(GroundServiceSystemMessage.ACTION_SHOW_BACKUP_GENERATOR_VOLTAGE, i,
                                backupGeneratorsVoltage[i]));
                    } else {
                        logMaker(String.format(GroundServiceSystemMessage.ERROR_BACKUP_GENERATOR_IS_OFF, i));
                    }
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
        }
    }

    private static int getGeneratorVoltage(int generatorNumber) {
        if (power) {
            if (system) {
                if (generatorsVoltage[generatorNumber] > 0) {
                    return generatorsVoltage[generatorNumber];
                } else {
                    logMaker(String.format(GroundServiceSystemMessage.ERROR_GENERATOR_IS_OFF, generatorNumber));
                    return 0;
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
                return 0;
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
            return 0;
        }
    }

    private static int getBackupGeneratorVoltage(int backupGeneratorNumber) {
        if (power) {
            if (system) {
                if (generatorsVoltage[backupGeneratorNumber] > 0) {
                    return generatorsVoltage[backupGeneratorNumber];
                } else {
                    logMaker(String.format(GroundServiceSystemMessage.ERROR_BACKUP_GENERATOR_IS_OFF, backupGeneratorNumber));
                    return 0;
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
                return 0;
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
            return 0;
        }
    }

    private static void setElectricalSubstationsPowerOn() {
        if (power) {
            if (system) {
               for (int i = 0; i < ELECTRICAL_SUBSTATION_COUNT; i++) {
                   setElectricalSubstationPowerOff(i);
                   setElectricalSubstationPowerOn(i);
                   logMaker(String.format(GroundServiceSystemMessage.ACTION_ELECTRICAL_SUBSTATION_POWER_SET_ON, i));
               }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
        }
    }

    private static void setElectricalSubstationsPowerOff() {
        if (power) {
            if (system) {
                for (int i = 0; i < ELECTRICAL_SUBSTATION_COUNT; i++) {
                    setElectricalSubstationPowerOff(i);
                    logMaker(String.format(GroundServiceSystemMessage.ACTION_ELECTRICAL_SUBSTATION_POWER_SET_OFF, i));
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
        }
    }

    private static void setElectricalSubstationPowerOn(int electricalSubstationNumber) {
        if (power) {
            if (system) {
                switch (electricalSubstationNumber) {
                    case 0:
                        electricalSubstationsVoltage[electricalSubstationNumber] =
                                generatorsVoltage[0] + generatorsVoltage[1] + generatorsVoltage[2];
                        break;
                    case 1:
                        electricalSubstationsVoltage[electricalSubstationNumber] =
                                generatorsVoltage[3] + generatorsVoltage[4] + generatorsVoltage[5];
                        break;
                    case 2:
                        electricalSubstationsVoltage[electricalSubstationNumber] =
                                generatorsVoltage[6] + generatorsVoltage[7] + generatorsVoltage[8];
                        break;
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
        }
    }

    private static void setElectricalSubstationPowerOff(int electricalSubstationNumber) {
        if (power) {
            if (system) {
                switch (electricalSubstationNumber) {
                    case 0:
                        electricalSubstationsVoltage[electricalSubstationNumber] = 0;
                        break;
                    case 1:
                        electricalSubstationsVoltage[electricalSubstationNumber] = 0;
                        break;
                    case 2:
                        electricalSubstationsVoltage[electricalSubstationNumber] = 0;
                        break;
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
        }
    }

    private static void showAllElectricalSubstationsVoltage() {
        if (power) {
            if (system) {
                for (int i = 0; i < ELECTRICAL_SUBSTATION_COUNT; i++) {
                    logMaker(String.format(GroundServiceSystemMessage.ACTION_SHOW_ELECTRICAL_SUBSTATION_VOLTAGE,
                            i, electricalSubstationsVoltage[i]));
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
        }
    }

    private static int getElectricalSubstationVoltage(int electricalSubstationNumber) {
        if (power) {
            if (system) {
                if (electricalSubstationsVoltage[electricalSubstationNumber] > 0) {
                    return electricalSubstationsVoltage[electricalSubstationNumber];
                } else {
                    logMaker(String.format(GroundServiceSystemMessage.ERROR_ELECTRICAL_SUBSTATION_IS_OFF,
                            electricalSubstationNumber));
                    return 0;
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
                return 0;
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
            return 0;
        }
    }

    private static int getElectricalSubstationsCount() {
        return ELECTRICAL_SUBSTATION_COUNT;
    }

    private static int getCurrentSubstationsVoltage() {
        if (power) {
            if (system) {
                int currentSubstationVoltage = 0;

                for (int substationVoltage: electricalSubstationsVoltage) {
                    currentSubstationVoltage += substationVoltage;
                }
                return  currentSubstationVoltage;
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
                return 0;
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
            return 0;
        }
    }

    public static boolean connectToEnergy(short[] members) {
        if (power) {
            if (system) {
                int currentMembersVoltage = 0;

                for (short member: members) {
                    currentMembersVoltage += member;
                }
                if (currentMembersVoltage < getCurrentSubstationsVoltage()) {
                    systemGo = true;
                    return true;
                } else {
                    return adaptiveEnergyControlSystem(members);
                }
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
                systemGo = false;
                return false;
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
            systemGo = false;
            return false;
        }
    }

    private static boolean adaptiveEnergyControlSystem(short[] members) {
        if (power) {
            if (system) {
                int currentMembersVoltage = 0;
                int currentSubstationsVoltage = getCurrentSubstationsVoltage();

                for (short member: members) {
                    currentMembersVoltage += member;
                }
                for (int i = 0; i < BACKUP_GENERATORS_COUNT; i++) {
                    setBackupGeneratorPowerOn(i);
                    currentSubstationsVoltage += getBackupGeneratorVoltage(i);
                    if (currentMembersVoltage < currentSubstationsVoltage) {
                        logMaker(GroundServiceSystemMessage.ACTION_SUCCESSFULLY_CONNECTED_TO_POWER);
                        systemGo = true;
                        return true;
                    }
                }
                logMaker(GroundServiceSystemMessage.ERROR_NOT_ENOUGH_POWER);
                systemGo = false;
                return false;
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
                systemGo = false;
                return false;
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
            systemGo = false;
            return false;
        }
    }

    @Override
    public void startSystem() {
        turnPowerOn();
        turnControlSystemOn();
        setGeneratorsPowerOn();
        setElectricalSubstationsPowerOn();
        logMaker(GroundServiceSystemMessage.ACTION_SYSTEM_TURNED_ON);
    }

    @Override
    public void shutdownSystem() {
        systemGo = false;
        setElectricalSubstationsPowerOff();
        setBackupGeneratorsPowerOff();
        setGeneratorsPowerOff();
        turnControlSystemOff();
        turnPowerOff();
        logMaker(GroundServiceSystemMessage.ACTION_SYSTEM_TURNED_OFF);
    }

    @Override
    public void showAllTelemetry() {
        if (power) {
            if (system) {
                showAllGeneratorsVoltage();
                showAllElectricalSubstationsVoltage();
            } else {
                logMaker(GroundServiceSystemMessage.ACTION_SYSTEM_SET_OFF);
            }
        } else {
            logMaker(GroundServiceSystemMessage.ACTION_POWER_SET_OFF);
        }
    }

    @Override
    public void killFire() {
        systemGo = false;
        // Код который тушит пожар
    }

    @Override
    public double getSystemVoltage() {
        return 0;
    }

    @Override
    public boolean isSystemGo() {
        if (power) {
            if (system) {
                return systemGo;
            } else {
                logMaker(GroundServiceSystemMessage.ERROR_SYSTEM_OFF);
                return false;
            }
        } else {
            logMaker(GroundServiceSystemMessage.ERROR_POWER_OFF);
            return false;
        }
    }

    @Override
    public boolean isFireHere() {
        return random.nextInt(10) == 9;
    }
}