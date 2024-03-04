package com.example.demo.model;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@RequiredArgsConstructor
@Document(collection = "spesification")
public class Root {
    public ReportSpecification reportSpecification;
    public List<SalesAndTrafficByDate> salesAndTrafficByDate;
    public List<SalesAndTrafficByAsin> salesAndTrafficByAsin;
}
