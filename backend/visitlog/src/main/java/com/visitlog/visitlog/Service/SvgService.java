package com.visitlog.visitlog.Service;

import com.visitlog.visitlog.Model.Total;
import com.visitlog.visitlog.Model.RequestBadge;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

public interface SvgService {


    public ResponseEntity<?> makeSVGImageFromData(HttpServletRequest request, long badgeId);

    public void makeCount(RequestBadge requestBadge);

    @Transactional
    public void makeToday(HttpServletRequest request, Total total);

    public void plusCount(Total total);
}
