package com.progon.prowind.infrastructure.log.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LOG {
    @PrimaryKey(autoGenerate = true)
    public long ID;
    public int TYPE;
    public long DATETIME;
    public String MESSAGE;
}
