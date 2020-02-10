package com.dextra.salesmongo.application;

import com.dextra.salesmongo.domain.sales.dto.SalesDTO;
import com.dextra.salesmongo.domain.sales.model.Sales;
import com.dextra.salesmongo.domain.sales.service.SalesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/sales", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "sales", description = "Sales API")
public class SalesController {

    private SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping
    @ApiOperation(value = "Find all sales", notes = "Find all the sales")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sales found"),
            @ApiResponse(code = 404, message = "Sales not found")
    })
    public List<Sales> getAllSales() {
        return this.salesService.getAllSales();
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Find sales", notes = "Find sales by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sales found"),
            @ApiResponse(code = 404, message = "Sales not found")
    })
    public Sales getSalesById(@PathVariable("id") final String id) throws Exception {
        return this.salesService.getSalesById(id).orElseThrow(Exception::new);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Remove sales", notes = "Remove sales by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sales removed successfully"),
            @ApiResponse(code = 404, message = "Sales not found")
    })
    public void deleteSalesById(@PathVariable("id") final String id) {
        this.salesService.deleteSalesById(id);
    }

    @PostMapping
    @ApiOperation(value = "Create sales", notes = "It permits to create")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sales created successfully"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    public void saveSales(@RequestBody final SalesDTO sales) {
        this.salesService.saveSales(sales);
    }
}
