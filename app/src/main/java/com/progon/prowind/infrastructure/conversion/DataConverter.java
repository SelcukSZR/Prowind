package com.progon.prowind.infrastructure.conversion;

import java.util.Date;

public class DataConverter implements IDataConverter {
    @Override
    public long DateToMilliseconds(Date Date) {
        return Date.getTime();
    }

    @Override
    public Date MillisecondsToDate(long Milliseconds) {
        return new Date(Milliseconds);
    }
}
