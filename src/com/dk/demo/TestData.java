package com.dk.demo;

public class TestData {
    private int avatarId;
    private String content;

    public TestData(int avatarId, String content) {
        this.avatarId = avatarId;
        this.content = content;
    }

    public int getAvatar() {
        return avatarId;
    }

    public String getContent() {
        return content;
    }
}
