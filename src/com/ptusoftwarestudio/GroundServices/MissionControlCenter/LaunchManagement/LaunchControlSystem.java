package com.ptusoftwarestudio.GroundServices.MissionControlCenter.LaunchManagement;

import com.ptusoftwarestudio.GroundServices.EnergySupplySystem.EnergyControlSystem;

public class LaunchControlSystem {
    public static void main(String[] args) {
        EnergyControlSystem energyControlSystem = new EnergyControlSystem();

        energyControlSystem.startSystem();
        energyControlSystem.showAllTelemetry();
    }
}