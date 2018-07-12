package com.ptusoftwarestudio.GroundServices;

public final class GroundServiceSystemMessage {
    public static final String ERROR_POWER_ALREADY_ON = "Ошибка: Питание уже включено. Действие отменено";
    public static final String ERROR_POWER_ALREADY_OFF = "Ошибка: Питание уже отключено. Действие отменено";
    public static final String ERROR_POWER_OFF = "Ошибка: Питание отключено. Действие невозможно";
    public static final String ERROR_SYSTEM_ALREADY_ON = "Ошибка: Система контроля уже включена. Действие отменено";
    public static final String ERROR_SYSTEM_ALREADY_OFF = "Ошибка: Система контроля уже отключена. Действие отменено";
    public static final String ERROR_SYSTEM_OFF = "Ошибка: Система контроля отключена. Действие невозможно";
    public static final String ERROR_GENERATOR_ALREADY_ON = "Ошибка: Генератор %d уже запущен. Действие отменено";
    public static final String ERROR_GENERATOR_ALREADY_OFF = "Ошибка: Генератор %d уже тключен. Действие отменено";
    public static final String ERROR_BACKUP_GENERATOR_ALREADY_ON = "Ошибка: Резервный генератор %d уже запущен. Действие отменено";
    public static final String ERROR_BACKUP_GENERATOR_ALREADY_OFF = "Ошибка: Резервный генератор %d уже тключен. Действие отменено";
    public static final String ERROR_GENERATOR_IS_OFF = "Ошибка: Генератор %d отключен. Действие невозможно";
    public static final String ERROR_BACKUP_GENERATOR_IS_OFF = "Ошибка: Резервный генератор %d отключен. Действие невозможно";
    public static final String ERROR_ELECTRICAL_SUBSTATION_IS_OFF = "Ошибка: Подстанция %d отключена. Действие невозможно";
    public static final String ERROR_NOT_ENOUGH_POWER = "Ошибка: Недостаточно энергии чтобы подключить все системы к питанию";

    public static final String ERROR_SENSOR_NOT_WORKING = "Ошибка: сенсор системы работает некорректно";
    public static final String ERROR_WATER_LEVEL_IS_LOW = "Ошибка: уровень воды ниже минимально допустимого";


    public static final String ACTION_POWER_SET_ON = "Питание включено";
    public static final String ACTION_POWER_SET_OFF = "Питание отключено";
    public static final String ACTION_SYSTEM_SET_ON = "Система контроля включена";
    public static final String ACTION_SYSTEM_SET_OFF = "Система контроля отключена";
    public static final String ACTION_GENERATOR_SET_ON = "Генератор %d был запущен";
    public static final String ACTION_GENERATOR_SET_OFF = "Генератор %d был отключен";
    public static final String ACTION_BACKUP_GENERATOR_SET_ON = "Резервный генератор %d был запущен";
    public static final String ACTION_BACKUP_GENERATOR_SET_OFF = "Резервынй генератор %d был отключен";
    public static final String ACTION_SHOW_GENERATOR_VOLTAGE = "Напряжение генератора %d: %d";
    public static final String ACTION_SHOW_BACKUP_GENERATOR_VOLTAGE = "Напряжение резервного генератора %d: %d";
    public static final String ACTION_ELECTRICAL_SUBSTATION_POWER_SET_ON = "Подстанция %d включена";
    public static final String ACTION_ELECTRICAL_SUBSTATION_POWER_SET_OFF = "Подстанция %d отключена";
    public static final String ACTION_SHOW_ELECTRICAL_SUBSTATION_VOLTAGE = "Напряжение подстанции %d: %d";
    public static final String ACTION_SUCCESSFULLY_CONNECTED_TO_POWER = "Напряжение подстанции %d: %d";
    public static final String ACTION_SYSTEM_TURNED_ON = "Система включена";
    public static final String ACTION_SYSTEM_TURNED_OFF = "Система отключена";

    public static final String ACTION_SENSOR_SYSTEM_WORKING = "Система сенсоров работает исправно";
    public static final String ACTION_ALL_SYSTEM_WORKING = "Все системы фунцуионируют нормально";
}
