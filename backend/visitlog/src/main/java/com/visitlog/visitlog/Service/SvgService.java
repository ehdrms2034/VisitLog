package com.visitlog.visitlog.Service;

import com.visitlog.visitlog.Model.Badge;
import com.visitlog.visitlog.Model.RequestBadge;
import org.springframework.http.ResponseEntity;

public interface SvgService {

    public ResponseEntity<?> makeSVGImageFromData(long badgeId);

    public void makeCount(RequestBadge requestBadge);

    public void plusCount(Badge badge);
}
