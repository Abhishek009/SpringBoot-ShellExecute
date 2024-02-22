package com.api.service;

import com.api.utils.StreamGobbler;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class FileService {

    public Boolean executeShell() throws IOException {

        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

        ProcessBuilder builder = new ProcessBuilder();
        if (isWindows) {
            System.out.println(System.getProperty("user.dir"));
            builder.command("D:\\Google_Drive_Rahul\\java_program\\BigData\\LearningJava\\scripts\\echo.bat");
        } else {
            builder.command("sh", "-c", System.getProperty("user.dir")+ "/script/echo.bat");
        }

        builder.directory(new File(System.getProperty("user.home")));
        Process process = builder.start();

        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(),process.getErrorStream(), System.out::println);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future = executorService.submit(streamGobbler);
        int exitCode = 0;
        try {
            exitCode = process.waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            executorService.shutdown();
        }
        if(exitCode != 0){
            System.out.println("Script execution failed");
            return true;
        }
        else {
            System.out.println(exitCode);
            return false;
        }


    }
}
