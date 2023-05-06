package com.goit.todolist.testmvc.uploadfile;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {
    public long getFileSize(MultipartFile file){
        return file.getSize();
    }

    public String getContent(MultipartFile file) throws IOException {
        final byte[] bytes = file.getBytes();
        return new String(bytes);
    }
}
