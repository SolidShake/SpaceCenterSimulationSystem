package com.ptusoftwarestudio.GroundServices;

public interface IGroundServiceControl {
    void startSystem();
    void shutdownSystem();
    void showAllTelemetry();
    double getSystemVoltage();
    boolean isSystemOk();
}