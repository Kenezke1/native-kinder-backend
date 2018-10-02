package com.codecool.kinder.model.Dto;

public class StatusDto {
    private Boolean doNotify = false;
    private Boolean sendSuperNotification = false;

    public StatusDto(Boolean doNotify, Boolean sendSuperNotification) {
        this.doNotify = doNotify;
        this.sendSuperNotification = sendSuperNotification;
    }

    public StatusDto(){}

    public Boolean getDoNotify() {
        return doNotify;
    }

    public void setDoNotify(Boolean doNotify) {
        this.doNotify = doNotify;
    }

    public Boolean getSendSuperNotification() {
        return sendSuperNotification;
    }

    public void setSendSuperNotification(Boolean sendSuperNotification) {
        this.sendSuperNotification = sendSuperNotification;
    }
}
