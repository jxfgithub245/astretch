package learn.springboot.downloaduploadfile.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class TestFileUpload {
    @RequestMapping("/uploadFile")
    public String uploadFile(){
        return "uploadFile";
    }

    @RequestMapping("/upload")
    public String upload(
        HttpServletRequest request,
        @RequestParam("description") String description,
        @RequestParam("myfile")MultipartFile myfile) throws IOException {
            System.out.println("文件描述"+description);
            if(!myfile.isEmpty()){
                String path = request.getServletContext().getRealPath("/uploadFiles/");
                System.out.println("uploadFilesjxf"+path);
                String fileName = myfile.getOriginalFilename();
                File filePath = new File(path+ File.separator+fileName);
                if(!filePath.getParentFile().exists()){
                    filePath.getParentFile().mkdirs();
                }
                myfile.transferTo(filePath);
            }
            return "forward:/showDownLoad";
    }


    @RequestMapping("/showDownLoad")
    public String showDownLoad(HttpServletRequest request, Model model){
        String path = request.getServletContext().getRealPath("/uploadFiles/");
        System.out.println("==========showDownLoad=========="+path);
        File fileDir = new File(path);
        File filesList[]=fileDir.listFiles();
        model.addAttribute("filesList",filesList);
        System.out.println("==========model============"+model+filesList);
        return "showFile";
    }


    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("filename") String filename,
                                           @RequestHeader("User-Agent") String userAgent) throws IOException {
        String path = request.getServletContext().getRealPath("/uploadFiles/");
        File downFile = new File(path+File.separator+filename);
        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
        builder.contentLength(downFile.length());
        builder.contentType(MediaType.APPLICATION_OCTET_STREAM);
        System.out.println("=========filename=========="+filename);
        filename = URLEncoder.encode(filename,"UTF-8");
        System.out.println("=========filename=========="+filename);
        if(userAgent.indexOf("MSIE")>0){
            builder.header("Content-Disposition","attachment;filename="+filename);
        }else{
            builder.header("Content-Disposition","attachment;filename *= UTF-8"+filename);
        }
        System.out.println("==============downFile============"+downFile);
        return builder.body(FileUtils.readFileToByteArray(downFile));
    }}
