package com.uiui881.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    PARENTS("ROLE_PARENTS", "보호자"),
    CHILD("ROLE_CHILD", "아이"),
    PG_MANAGER("ROLE_PG_MANAGER","놀이터 관리자"),
    SERVICE_MANAGER("ROLE_SERVICE_MANAGER", "서비스 관리자");

    private final String key;
    private final String title;
}
