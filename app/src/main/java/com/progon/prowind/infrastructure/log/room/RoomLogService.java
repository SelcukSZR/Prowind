package com.progon.prowind.infrastructure.log.room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.progon.prowind.infrastructure.conversion.IDataConverter;
import com.progon.prowind.infrastructure.log.ILogService;
import com.progon.prowind.infrastructure.log.Log;

public class RoomLogService implements ILogService {
    private LogDatabase logDatabase;
    private LogMapper logMapper;

    public RoomLogService(Context AppContext, IDataConverter DataConverter){
        this.logDatabase = Room.databaseBuilder(AppContext,
                LogDatabase.class, "Log").build();
        this.logMapper = new LogMapper(DataConverter);
    }

    @Override
    public void WriteLog(Log Log) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                logDatabase.LogRepository().Insert(logMapper.Map(Log));
            }
        });
    }
}
