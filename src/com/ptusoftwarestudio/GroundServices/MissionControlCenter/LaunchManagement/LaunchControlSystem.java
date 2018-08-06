package com.ptusoftwarestudio.GroundServices.MissionControlCenter.LaunchManagement;

import com.ptusoftwarestudio.GroundServices.EnergySupplySystem.EnergyControlSystem;
import com.ptusoftwarestudio.GroundServices.GroundServiceSystemMessage;

public class LaunchControlSystem {
    public static void main(String[] args) {
        EnergyControlSystem energyControlSystem = new EnergyControlSystem();

        energyControlSystem.startSystem();
        energyControlSystem.showAllTelemetry();
        if(energyControlSystem.isSystemGo()) {
            logMaker(GroundServiceSystemMessage.MESSAGE_ENERGYCONTROLSYSTEM_GO);
        } else {
            logMaker(GroundServiceSystemMessage.MESSAGE_ENERGYCONTROLSYSTEM_STOP);
            logMaker(GroundServiceSystemMessage.MESSAGE_LAUNCH_CANCELED);
        }
    }

    private static void logMaker(String message) {
        System.out.println("ЦУП: " + message);
    }
}