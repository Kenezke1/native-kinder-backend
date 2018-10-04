package com.codecool.kinder.model.Dto;

public class StatusDto {
    private Boolean doNotify = false;
    private Boolean sendSuperNotification = false;

    public StatusDto(Builder builder) {
        setDoNotify(builder.doNotify);
        setSendSuperNotification(builder.sendSuperNotification);
    }

    public StatusDto(){}

    public Builder builder(){
        return new Builder();
    }

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

    public final static class Builder{
        private Boolean doNotify = false;
        private Boolean sendSuperNotification = false;


        public Builder(){}

        public Builder doNotify(Boolean doNotify){
            this.doNotify = doNotify;
            return this;
        }

        public Builder sendSuperNotification(Boolean sendSuperNotification){
            this.sendSuperNotification = sendSuperNotification;
            return this;

        }
        public StatusDto build(){
           return new StatusDto(this);
        }
    }
}
