package com.kpi.it01.team1.models;

import com.kpi.it01.team1.Constants;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class UserRequest {
    private final HttpServletRequest request;
    private ArrayList<Integer> prevValues;
    private ArrayList<Integer> currentValues;
    private TableData tableData;
    private boolean isFirstVisit;

    public UserRequest(HttpServletRequest request) {
        this.request = request;
        this.prevValues = Constants.DEFAULT_VALUES;
        this.currentValues = new ArrayList<>();
        this.isFirstVisit = true;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public ArrayList<Integer> getPrevValues() {
        return prevValues;
    }

    public void setPrevValues(ArrayList<Integer> prevValues) {
        this.prevValues = prevValues;
    }

    public ArrayList<Integer> getCurrentValues() {
        return currentValues;
    }

    public void setCurrentValues(ArrayList<Integer> currentValues) {
        this.currentValues = currentValues;
    }

    public TableData getTableData() {
        return tableData;
    }

    public void setTableData(TableData tableData) {
        this.tableData = tableData;
    }

    public boolean isFirstVisit() {
        return isFirstVisit;
    }

    public void setFirstVisit(boolean firstVisit) {
        isFirstVisit = firstVisit;
    }
}
