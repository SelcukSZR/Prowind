package com.progon.prowind.infrastructure.log.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {LOG.class}, version = 1)
public abstract class LogDatabase extends RoomDatabase {
    public abstract ILOGRepository LogRepository();
}
