package com.example.mytestapplication;

import java.util.Date;

public class JobEntry {

    private String companyName, jobPosition, location, status, notes;
    private String appliedOn, lastDate;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAppliedOn() {
        return appliedOn;
    }

    public void setAppliedOn(String appliedOn) {
        this.appliedOn = appliedOn;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    @Override
    public String toString() {
        return "com.example.mytestapplication.JobEntry{" +
                "companyName='" + companyName + '\'' +
                ", jobPosition='" + jobPosition + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", notes='" + notes + '\'' +
                ", appliedOn=" + appliedOn +
                ", lastDate=" + lastDate +
                '}';
    }
}
