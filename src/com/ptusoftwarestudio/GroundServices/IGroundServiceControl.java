package com.ptusoftwarestudio.GroundServices;

public interface IGroundServiceControl {
    void startSystem();
    void shutdownSystem();
    void showAllTelemetry();
    void killFire();
    double getSystemVoltage();
    boolean isSystemGo();
    boolean isFireHere();
}