package com.goit.todolist.testmvc.uploadfile;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
@RequiredArgsConstructor
@RequestMapping("/file")
@Controller
public class FileController {
    private final FileService fileService;
    @PostMapping("/upload")
    public ModelAndView postReceiveFile(@RequestParam(name = "file") MultipartFile file) throws IOException {

        ModelAndView result = new ModelAndView("upload-file");
        result.addObject("fileSize", fileService.getFileSize(file));
        result.addObject("fileContent", fileService.getContent(file));

        return result;
    }
}
