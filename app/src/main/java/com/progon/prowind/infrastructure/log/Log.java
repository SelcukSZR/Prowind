package com.progon.prowind.infrastructure.log;

import androidx.annotation.NonNull;

import java.util.Date;

public class Log {
    public LogType Type;
    public Date DateTime;
    public String Message;

    public  Log(LogType Type, Date DateTime, String Message){
        this.Type = Type;
        this.DateTime = DateTime;
        this.Message = Message;
    }

    @NonNull
    @Override
    public String toString() {
        return this.DateTime + " - " + this.Type + " - " + this.Message;
    }
}
