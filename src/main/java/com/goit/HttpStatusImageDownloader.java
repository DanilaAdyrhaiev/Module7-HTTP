package com.goit;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    void downloadStatusImage(int code){
        String url = new HttpStatusChecker().getStatusImage(code);
        try(BufferedInputStream in = new BufferedInputStream(new URL(url).openStream())){
            Path path = Paths.get(code + ".jpg");
            FileOutputStream out = new FileOutputStream(path.toFile());
            byte data[] = new byte[1024];
            int bytesReader;
            while((bytesReader = in.read(data, 0, 1024)) != 1){
                out.write(data, 0, bytesReader);
            }
            System.out.println("Photo has been download to: " + path.toAbsolutePath());
        }catch(Exception e){

        }

    }
}
