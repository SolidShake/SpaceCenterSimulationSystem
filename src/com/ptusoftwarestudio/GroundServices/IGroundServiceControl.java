package com.ptusoftwarestudio.GroundServices;

public interface IGroundServiceControl {
    // Запускает все службы системы
    void startSystem();
    // Полностью отключает систему
    void shutdownSystem();
    // Выводит состояние всех показатлей системы
    void showAllTelemetry();
    // Тушит пожар в месте базирования системы
    void killFire();
    // Возвращает вольтаж, необходимый для питания системы
    double getSystemVoltage();
    // Проверяет, работает ли ВСЯ система корректно
    boolean isSystemGo();
    // Проверяет, есть ли пожар в месте базирования системы
    boolean isFireHere();
}