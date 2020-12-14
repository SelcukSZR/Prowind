package com.progon.prowind.infrastructure.log.service;

import com.progon.prowind.infrastructure.log.ILogContext;
import com.progon.prowind.infrastructure.log.ILogService;
import com.progon.prowind.infrastructure.log.Log;

public class LogService implements ILogService {
    private ILogContext logContext;

    public LogService(ILogContext LogContext){
        logContext = LogContext;
    }

    @Override
    public void WriteLog(Log Log) {
        logContext.AddLog(Log);
    }
}