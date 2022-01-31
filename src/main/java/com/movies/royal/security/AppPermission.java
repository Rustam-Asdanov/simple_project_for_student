package com.movies.royal.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AppPermission {
    DATA_READ("can read any data"),
    DATA_WRITE("can edit any data");

    private final String permissionInfo;
}
