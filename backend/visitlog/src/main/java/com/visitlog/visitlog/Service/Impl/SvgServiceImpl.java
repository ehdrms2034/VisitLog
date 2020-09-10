package com.visitlog.visitlog.Service.Impl;

import com.visitlog.visitlog.Model.Badge;
import com.visitlog.visitlog.Model.RequestBadge;
import com.visitlog.visitlog.Repository.SvgRepository;
import com.visitlog.visitlog.Service.SvgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SvgServiceImpl implements SvgService {

    @Autowired
    SvgRepository svgRepository;

    @Override
    public ResponseEntity<?> makeSVGImageFromData(long badgeId) {

        long total = 0;
        long today = 0;
        Optional<Badge> badge = svgRepository.findById(badgeId);
        if (badge.isPresent()) {
            plusCount(badge.get());
            total = badge.get().getCount();
            today = badge.get().getCount();
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
        Badge badge = Badge.builder()
                .count(0)
                .url(requestBadge.getUrl())
                .build();
        svgRepository.save(badge);
    }

    @Override
    @Transactional
    public void plusCount(Badge badge) {
        badge.setCount(badge.getCount() + 1);
        svgRepository.save(badge);
    }


}
