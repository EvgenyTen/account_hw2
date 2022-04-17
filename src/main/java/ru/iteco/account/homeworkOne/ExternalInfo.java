package ru.iteco.account.homeworkOne;

import lombok.Getter;

@Getter
public class ExternalInfo {
    private Integer id;
    private String info;

    public ExternalInfo(Integer id, String info) {
        this.id = id;
        this.info = info;
    }

    @Override
    public String toString() {
        return "ExternalInfo{" +
                "id=" + id +
                ", info='" + info + '\'' +
                '}';
    }
}
