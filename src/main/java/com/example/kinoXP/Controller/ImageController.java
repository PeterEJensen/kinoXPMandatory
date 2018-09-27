package com.example.kinoXP.Controller;

import com.example.kinoXP.Domain.Image;
import com.example.kinoXP.Service.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.awt.print.Pageable;
import java.io.IOException;
import java.net.URI;

@Controller
public class ImageController {


    private static final String BASE_PATH = "/images";
    private static final String FILENAME = "{filename: .+}";

    private final ImageServiceImpl imageService;

    @Autowired
    public ImageController(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }

    @RequestMapping(value = "/image")
    public String index(Model model, org.springframework.data.domain.Pageable pageable){
        final Page<Image> page = imageService.findPage(pageable);
        model.addAttribute("page", page);
        return "image";
    }

    @RequestMapping(method = RequestMethod.GET, value = BASE_PATH + "/" + FILENAME + "/raw")
    @ResponseBody
    public ResponseEntity<?> oneRawImage(@PathVariable String filename){

        try {
            org.springframework.core.io.Resource file = imageService.findOneImage(filename);
            return ResponseEntity.ok()
                    .contentLength((file).contentLength())
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new InputStreamResource((file).getInputStream()));
        } catch (IOException e){
            return ResponseEntity.badRequest()
                    .body("Couldn't find" + filename + " =>" +  e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = BASE_PATH)
    public String createFile(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes){

        try {
            imageService.createImage(file);
            redirectAttributes.addFlashAttribute("flash.message", "Successfully uploaded" + file.getOriginalFilename());
        }catch (IOException e){
            redirectAttributes.addFlashAttribute("flash.message", "Failed to upload" + file.getOriginalFilename() + " => " + e.getMessage());
        }
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = BASE_PATH + "/" + FILENAME)
    @ResponseBody
    public ResponseEntity<?> deleteFile(@PathVariable String filename){

        try{
            imageService.deleteImage(filename);
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Successfully deleted" + filename);
        } catch (IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete" + filename + " => " + e.getMessage());
        }
    }
}
