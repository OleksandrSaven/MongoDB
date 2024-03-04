package com.example.demo.model;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ReportSpecification {
    public String reportType;
    public ReportOptions reportOptions;
    public String dataStartTime;
    public String dataEndTime;
    public List<String> marketplaceIds;
}
