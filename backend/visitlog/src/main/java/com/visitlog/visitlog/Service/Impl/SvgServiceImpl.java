package com.visitlog.visitlog.Service.Impl;

import com.visitlog.visitlog.Model.Today;
import com.visitlog.visitlog.Model.Total;
import com.visitlog.visitlog.Model.RequestBadge;
import com.visitlog.visitlog.Repository.TodayRepository;
import com.visitlog.visitlog.Repository.TotalRepository;
import com.visitlog.visitlog.Service.SvgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Slf4j
public class SvgServiceImpl implements SvgService {

    @Autowired
    TotalRepository totalRepository;

    @Autowired
    TodayRepository todayRepository;

    @Override
    public ResponseEntity<?> makeSVGImageFromData(HttpServletRequest request, long badgeId) {

        long total = 0;
        long today = 0;
        Optional<Total> badge = totalRepository.findById(badgeId);
        if (badge.isPresent()) {
            Total totalObj = badge.get();
            plusCount(badge.get());
            makeToday(request,totalObj);
            total = badge.get().getCount();
            today = badge.get().getTodayList().size();
        }

        String data = "<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n" +
                "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                "    height=\"20\"\n" +
                "    width=\"100\"\n" +
                ">\n" +
                "    <rect x=\"30\" width=\"10\" height=\"100%\" fill=\"#4aa6c2\"/>\n" +
                "    <rect width=\"40\" height=\"100%\" fill=\"#4aa6c2\"  rx=\"4\" ry=\"4\"/>\n" +
                "    \n" +
                "    <text\n" +
                "    x=\"20\" y=\"13\"\n" +
                "    fill=\"#ffffff\" font-size=\"12\" text-anchor=\"middle\">\n" +
                "        visitor\n" +
                "    </text>\n" +
                "    <rect x=\"40\" width=\"10\" height=\"100%\" fill=\"#b9e059\"/>\n" +
                "    <rect x=\"40\" width=\"60\" height=\"100%\" fill=\"#b9e059\" rx=\"4\" ry=\"4\"/>\n" +
                "\n" +
                "    <text\n" +
                "        x=\"70\" y=\"13\"\n" +
                "        fill=\"#ffffff\" font-size=\"12\" text-anchor=\"middle\">\n" +
                "        " + today + " / " + total + "\n" +
                "    </text>\n" +
                "\n" +
                "</svg>";

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf("image/svg+xml"))
                .body(data);
    }

    @Override
    @Transactional
    public void makeCount(RequestBadge requestBadge) {
        Total total = Total.builder()
                .count(0)
                .url(requestBadge.getUrl())
                .todayList(new ArrayList<>())
                .build();
        totalRepository.save(total);
    }

    @Override
    @Transactional
    public void makeToday(HttpServletRequest request, Total total){
        log.info(request.getLocalName());
        log.info(request.getHeader("User-Agent"));
        Today today = Today.builder()
                .total(total)
                .fromUrl(request.getHeader("Referer"))
                .build();

        todayRepository.save(today);
    }

    @Override
    @Transactional
    public void plusCount(Total total) {
        total.setCount(total.getCount() + 1);
        totalRepository.save(total);
    }


}
