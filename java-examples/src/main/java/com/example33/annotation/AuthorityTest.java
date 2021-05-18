package com.example33.annotation;

@Authority
public class AuthorityTest {
    @Authority(Authority.AuthorityType.SUPERADMIN)
    private static void doSuperAdmin() {
    }
    @Authority(Authority.AuthorityType.ADMIN)
    private static void doAdmin() {
    }
}
