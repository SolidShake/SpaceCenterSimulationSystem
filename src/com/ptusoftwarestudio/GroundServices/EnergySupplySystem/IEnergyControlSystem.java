package com.ptusoftwarestudio.GroundServices.EnergySupplySystem;

public interface IEnergyControlSystem {

    void turnPowerOn();
    void turnPowerOff();
    boolean isPowerOn();

    void turnSystemOn();
    void turnSystemOff();
    boolean isSystemOn();

    void setTransformer0PowerOn();
    void setTransformer1PowerOn();
    void setTransformer2PowerOn();
    void setTransformer3PowerOn();
    void setTransformer4PowerOn();
    void setTransformer5PowerOn();
    void setTransformer6PowerOn();
    void setTransformer7PowerOn();
    void setTransformer8PowerOn();

    void setTransformer0PowerOff();
    void setTransformer1PowerOff();
    void setTransformer2PowerOff();
    void setTransformer3PowerOff();
    void setTransformer4PowerOff();
    void setTransformer5PowerOff();
    void setTransformer6PowerOff();
    void setTransformer7PowerOff();
    void setTransformer8PowerOff();

    boolean isTransformer0Connected();
    boolean isTransformer1Connected();
    boolean isTransformer2Connected();
    boolean isTransformer3Connected();
    boolean isTransformer4Connected();
    boolean isTransformer5Connected();
    boolean isTransformer6Connected();
    boolean isTransformer7Connected();
    boolean isTransformer8Connected();

    String getTransformer0Condition();
    String getTransformer1Condition();
    String getTransformer2Condition();
    String getTransformer3Condition();
    String getTransformer4Condition();
    String getTransformer5Condition();
    String getTransformer6Condition();
    String getTransformer7Condition();
    String getTransformer8Condition();

    void setElectricalSubstation0PowerOn();
    void setElectricalSubstation1PowerOn();
    void setElectricalSubstation2PowerOn();

    void setElectricalSubstation0PowerOff();
    void setElectricalSubstation1PowerOff();
    void setElectricalSubstation2PowerOff();

    boolean isElectricalSubstation0Connected();
    boolean isElectricalSubstation1Connected();
    boolean isElectricalSubstation2Connected();

    String getElectricalSubstation0Condition();
    String getElectricalSubstation1Condition();
    String getElectricalSubstation2Condition();

    String errorSystemPowerOff();
    String errorSystemOff();

    String errorTransformer0Off();
    String errorTransformer1Off();
    String errorTransformer2Off();
    String errorTransformer3Off();
    String errorTransformer4Off();
    String errorTransformer5Off();
    String errorTransformer6Off();
    String errorTransformer7Off();
    String errorTransformer8Off();

    String errorElectricalSubstation0Off();
    String errorElectricalSubstation1Off();
    String errorElectricalSubstation2Off();

    String errorElectricalSubstation0LowEnergy();
    String errorElectricalSubstation1LowEnergy();
    String errorElectricalSubstation2LowEnergy();
}
