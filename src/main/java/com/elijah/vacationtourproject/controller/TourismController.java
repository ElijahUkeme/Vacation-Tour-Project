package com.elijah.vacationtourproject.controller;

import com.elijah.vacationtourproject.response.ApiResponse;
import com.elijah.vacationtourproject.dto.TourismInfoDto;
import com.elijah.vacationtourproject.model.image.ImageModel;
import com.elijah.vacationtourproject.model.tourist.TouristInfo;
import com.elijah.vacationtourproject.service.image.ImageService;
import com.elijah.vacationtourproject.service.tourist.TourismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
public class TourismController {

    private ImageService imageService;

    @Autowired
    private TourismService tourismService;

    public TourismController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/touristCenter/add")
    public ResponseEntity<ApiResponse> uploadUserInfo(@RequestParam("file") MultipartFile file, @RequestPart("touristCenter") TourismInfoDto tourismInfoDto) throws Exception {
        ImageModel imageModel = imageService.saveTouristImage(file);
        String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(imageModel.getId())
                .toUriString();
        tourismService.addATouristCenter(tourismInfoDto,downloadUrl);

        return  new ResponseEntity<>(new ApiResponse(true,"Tourist Center Added Successfully"), HttpStatus.CREATED);
    }
    @GetMapping("/download/{imageId}")
    public ResponseEntity<Resource> downloadImage(@PathVariable("imageId") String imageId) throws Exception {
        ImageModel imageModel = imageService.getImage(imageId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(imageModel.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"imageModel; filename=\""+imageModel.getFileName()
                        +"\"")
                .body(new ByteArrayResource(imageModel.getData()));

    }
    @GetMapping("/tourist/getAll")
    public ResponseEntity<List<TouristInfo>> allTouristCenter(){
        return new ResponseEntity<>(tourismService.getAllTouristCenter(),HttpStatus.OK);
    }
}
