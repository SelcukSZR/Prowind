package com.progon.prowind.infrastructure.log.file;

import com.progon.prowind.infrastructure.log.ILogService;
import com.progon.prowind.infrastructure.log.Log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileLogService implements ILogService {
    private String fileName;

    public FileLogService(String FileName){
        this.fileName = FileName;
    }

    @Override
    public void WriteLog(Log Log) {
        try(FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter))
        {
            printWriter.println(Log.toString());
        } catch (Exception E) {

        }
    }
}
