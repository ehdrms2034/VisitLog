package com.visitlog.visitlog.Controller;

import com.visitlog.visitlog.Model.CustomResponse;
import com.visitlog.visitlog.Model.RequestBadge;
import com.visitlog.visitlog.Service.SvgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SvgController {

    @Autowired
    private SvgService svgService;

    @RequestMapping(value = "/badge/{badgeId}", method = RequestMethod.GET)
    public ResponseEntity<?> getBadge(@PathVariable long badgeId, HttpServletRequest request,@RequestHeader HttpHeaders header){
//        System.out.println("header");
        return svgService.makeSVGImageFromData(request,badgeId);
    }

    @RequestMapping(value = "/badge",method = RequestMethod.POST)
    public CustomResponse makeBadge(@RequestBody RequestBadge requestBadge){
        System.out.println("header2");
        svgService.makeCount(requestBadge);
        return new CustomResponse("Success","성공적으로 카운트가 생성됐습니다.",null);
    }

}
