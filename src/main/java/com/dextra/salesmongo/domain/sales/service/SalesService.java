package com.dextra.salesmongo.domain.sales.service;

import com.dextra.salesmongo.domain.sales.dto.SalesDTO;
import com.dextra.salesmongo.domain.sales.mapper.SalesDTOToSalesMapper;
import com.dextra.salesmongo.domain.sales.model.Sales;
import com.dextra.salesmongo.domain.sales.repository.SalesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService {

    private SalesRepository salesRepository;

    private SalesDTOToSalesMapper salesDTOToSalesMapper;

    @Autowired
    public SalesService(SalesRepository salesRepository, SalesDTOToSalesMapper salesDTOToSalesMapper) {
        this.salesRepository = salesRepository;
        this.salesDTOToSalesMapper = salesDTOToSalesMapper;
    }

    public List<Sales> getAllSales() {
        return this.salesRepository.findAll();
    }


    public void saveSales(final SalesDTO salesDTO) {
        Sales sales = salesDTOToSalesMapper.map(salesDTO);
        this.salesRepository.save(sales);
    }

    public Optional<Sales> getSalesById(final String id) {
        return this.salesRepository.findById(new ObjectId(id));
    }

    public void deleteSalesById(final String id) {
        this.salesRepository.deleteById(new ObjectId(id));
    }
}
