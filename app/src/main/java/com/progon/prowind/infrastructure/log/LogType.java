package com.progon.prowind.infrastructure.log;

public enum LogType {
    Info(0),
    Warning(1),
    Error(2);

    private final int Value;
    LogType(int Value){
        this.Value = Value;
    }
    public int GetValue() {
        return this.Value;
    }
}