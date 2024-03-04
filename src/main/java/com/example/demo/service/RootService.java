package com.example.demo.service;

import com.example.demo.model.Root;
import com.example.demo.model.SalesAndTrafficByAsin;
import com.example.demo.repository.RootRepository;
import com.example.demo.model.SalesAndTrafficByDate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RootService {

    @Autowired
    private RootRepository repository;

    @Cacheable("specification")
    public List<Root> getAllRoots() {
        return repository.findAll();
    }

    public List<SalesAndTrafficByDate> getAllSalesAndTrafficsByDate(int rootId) {
        return repository.findAll().get(rootId).salesAndTrafficByDate;
    }

    public List<SalesAndTrafficByAsin> getAllSalesAndTrafficByAsin(int rootId) {
        return repository.findAll().get(rootId).salesAndTrafficByAsin;
    }

    public List<SalesAndTrafficByDate> getSalesAndTrafficsByPeriod(int rootId, String startDay, String endDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate;
        Date toDate;
        try {
            fromDate = dateFormat.parse(startDay);
            toDate = dateFormat.parse(endDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return repository.findAll().get(rootId).salesAndTrafficByDate
                .stream()
                .filter(data -> {
                    try {
                        return dateFormat.parse(data.date).compareTo(fromDate) >= 0 &&
                                dateFormat.parse(data.date).compareTo(toDate) <= 0;
                    } catch (ParseException e) {
                        throw new RuntimeException("Can't parse date. ", e);
                    }
                })
                .collect(Collectors.toList());
    }

   public Optional<SalesAndTrafficByAsin> getSalesAndTrafficByAsin(int rootId, String parentAsin) {
        return repository.findAll()
                .get(rootId).salesAndTrafficByAsin
                .stream().filter(asin -> asin.parentAsin.equals(parentAsin))
                .findFirst();
   }
}
