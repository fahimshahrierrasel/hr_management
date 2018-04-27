package com.treebricks.hrmanagement.models;

public class ApplicationItem {
    private String applicantName;
    private String leaveType;
    private int totalLeave;

    public ApplicationItem(String applicantName, String leaveType, int totalLeave) {
        this.applicantName = applicantName;
        this.leaveType = leaveType;
        this.totalLeave = totalLeave;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public int getTotalLeave() {
        return totalLeave;
    }

    public void setTotalLeave(int totalLeave) {
        this.totalLeave = totalLeave;
    }
}
