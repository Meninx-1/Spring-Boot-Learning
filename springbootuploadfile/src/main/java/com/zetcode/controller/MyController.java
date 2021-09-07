package com.zetcode.controller;

import com.zetcode.exception.StorageException;
import com.zetcode.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MyController {

    @Autowired
    private StorageService storageService;
/*
 * There are three encoding HTML form types for a POST request:

1.application/x-www-form-urlencoded
2.multipart/form-data
3.text/plain

The application/x-www-form-urlencoded is the default encoding, where the values are encoded in key-value
 tuples separated by &. The = character is used between the key and the value. Non-alphanumeric 
 characters are percent encoded. This encoding type is not suitable for binary files.

The multipart/form-data is used for non-acsii data and binary files. The input element's type attribute is set to file.

The text/plain is used for debugging.
 */
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST,
            consumes = {"multipart/form-data"})
    public String upload(@RequestParam MultipartFile file) {

        storageService.uploadFile(file);

        return "redirect:/success.html";
    }

    @ExceptionHandler(StorageException.class)
    public String handleStorageFileNotFound(StorageException e) {

        return "redirect:/failure.html";
    }
}