package com.progon.prowind.infrastructure.log.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ILOGRepository {
    @Query("SELECT * FROM LOG")
    LOG[] GetAll();

    @Insert
    void Insert(LOG Log);

    @Update
    void Update(LOG Log);

    @Delete
    void Delete(LOG Log);
}
