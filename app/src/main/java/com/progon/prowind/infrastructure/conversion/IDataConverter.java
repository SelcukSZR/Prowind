package com.progon.prowind.infrastructure.conversion;

import java.util.Date;

public interface IDataConverter {
    long DateToMilliseconds(Date Date);
    Date MillisecondsToDate(long Milliseconds);
}
