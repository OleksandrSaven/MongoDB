package com.example.demo.controller;

import com.example.demo.model.Root;
import com.example.demo.model.SalesAndTrafficByAsin;
import com.example.demo.model.SalesAndTrafficByDate;
import com.example.demo.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/root")
public class SpecificationController {
    @Autowired
    RootService rootService;

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/")
    public List<Root> getAllSpecification() {
        return rootService.getAllRoots();
    }

    @GetMapping("/{rootId}/allSalesAndTrafficByDate")
    public List<SalesAndTrafficByDate> getAllSalesByDate(@PathVariable Integer rootId) {
        return rootService.getAllSalesAndTrafficsByDate(rootId);
    }

    @GetMapping("/{rootId}/allSalesAndTrafficByAsin")
    public List<SalesAndTrafficByAsin> getAllSalesByAsin(@PathVariable Integer rootId) {
        return rootService.getAllSalesAndTrafficByAsin(rootId);
    }

    @GetMapping("/{rootId}/allSalesAndTrafficByPeriod")
    public List<SalesAndTrafficByDate> getAllSalesByPeriod(@PathVariable Integer rootId,
                                                           @RequestParam String startDate, @RequestParam String endDate){
        return rootService.getSalesAndTrafficsByPeriod(rootId, startDate, endDate);
    }

    @GetMapping("/{rootId}/salesAndTraficsByAsin")
    public Optional<SalesAndTrafficByAsin> getSalesByAsin(@PathVariable Integer rootId,
                                                          @RequestParam String parentAsin) {
        return rootService.getSalesAndTrafficByAsin(rootId, parentAsin);
    }
}


