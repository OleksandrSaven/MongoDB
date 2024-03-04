package com.example.demo.model;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@RequiredArgsConstructor
public class SalesAndTrafficByDate {

    public String date;
    public SalesByDate salesByDate;
    public TrafficByDate trafficByDate;
}
