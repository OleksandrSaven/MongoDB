package com.example.demo.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SalesByAsin {
    public int unitsOrdered;
    public int unitsOrderedB2B;
    public OrderedProductSales orderedProductSales;
    public OrderedProductSalesB2B orderedProductSalesB2B;
    public int totalOrderItems;
    public int totalOrderItemsB2B;
}
