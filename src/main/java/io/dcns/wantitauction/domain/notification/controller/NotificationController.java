package io.dcns.wantitauction.domain.notification.controller;

import io.dcns.wantitauction.domain.notification.service.NotificationService;
import io.dcns.wantitauction.global.impl.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/new")
    public void saveNotification(
        @RequestBody String token,
        @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        notificationService.saveNotification(token, userDetails);
    }
}
