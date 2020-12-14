package com.progon.prowind.infrastructure.log;

import java.util.List;

public interface ILogContext {
    List<Log> GetLogs();
    void AddLog(Log Log);
}
