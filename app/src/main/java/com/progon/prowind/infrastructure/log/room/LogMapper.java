package com.progon.prowind.infrastructure.log.room;

import com.progon.prowind.infrastructure.conversion.IDataConverter;
import com.progon.prowind.infrastructure.log.Log;

public class LogMapper {
    private IDataConverter dataConverter;
    public LogMapper(IDataConverter DataConverter){
        this.dataConverter = DataConverter;
    }
    public LOG Map(Log Log){
        LOG mappedLog = new LOG();
        mappedLog.TYPE = Log.Type.GetValue();
        mappedLog.DATETIME = dataConverter.DateToMilliseconds(Log.DateTime);
        mappedLog.MESSAGE = Log.Message;
        return mappedLog;
    }
}
