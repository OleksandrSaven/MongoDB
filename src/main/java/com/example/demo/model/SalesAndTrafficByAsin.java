package com.example.demo.model;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SalesAndTrafficByAsin {
    public String parentAsin;
    public SalesByAsin salesByAsin;
    public TrafficByAsin trafficByAsin;
}
