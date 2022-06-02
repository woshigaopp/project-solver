package com.dabao.data;

public enum ProjectStatus {
    draft("草稿", 0),
    cancel("作废", -1),
    push("推进", 1),
    verify("签约", 2),
    destroy("核销", 3);
    private String name;
    private int code;

    ProjectStatus(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
