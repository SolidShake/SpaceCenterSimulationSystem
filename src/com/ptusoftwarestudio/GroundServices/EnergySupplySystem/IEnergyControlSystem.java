package com.ptusoftwarestudio.GroundServices.EnergySupplySystem;

public interface IEnergyControlSystem {
    void turnPowerOn();
    void turnPowerOff();
    boolean isPowerOn();

    void turnControlSystemOn();
    void turnControlSystemOff();
    boolean isControlSystemOn();

    void setGeneratorsPowerOn();
    void setGeneratorsPowerOff();

    void setGeneratorPowerOn(int generatorNumber);
    void setGeneratorPowerOff(int generatorNumber);

    void setBackupGeneratorsPowerOn();
    void setBackupGeneratorsPowerOff();

    void setBackupGeneratorPowerOn(int backupGeneratorNumber);
    void setBackupGeneratorPowerOff(int backupGeneratorNumber);

    void showAllGeneratorsVoltage();
    int getGeneratorVoltage(int generatorNumber);
    int getBackupGeneratorVoltage(int backupGeneratorNumber);
    int getGeneratorsCount();
    int getBackupGeneratorsCount();

    void setElectricalSubstationsPowerOn();
    void setElectricalSubstationsPowerOff();

    void setElectricalSubstationPowerOn(int generatorNumber);
    void setElectricalSubstationPowerOff(int generatorNumber);

    void showAllElectricalSubstationsVoltage();
    int getElectricalSubstationVoltage(int generatorNumber);
    int getElectricalSubstationsCount();

    int checkSubstationsEnergy();
    boolean connectToEnergy(double[] members);
    void adaptiveEnergyControlSystem(int substationNumber);
}
