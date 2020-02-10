package com.dextra.salesmongo.application;

import com.dextra.salesmongo.domain.sales.model.Item;
import com.dextra.salesmongo.domain.sales.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/items" , produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "items", description = "Sales API")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find items", notes = "Find items by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Items found"),
            @ApiResponse(code = 404, message = "Items not found")
    })
    public Item findById(@PathVariable("id") final String id) throws Exception {
        return this.itemService.findById(id).orElseThrow(Exception::new);
    }

    @GetMapping
    @ApiOperation(value = "Find all items", notes = "Find all the items")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Items found"),
            @ApiResponse(code = 404, message = "Items not found")
    })
    public List<Item> findAll() {
        return this.itemService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Remove items", notes = "Remove items by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Items removed successfully"),
            @ApiResponse(code = 404, message = "Items not found")
    })
    public void deleteById(@PathVariable("id") final String id) {
        this.itemService.deleteById(id);
    }

    @PostMapping
    @ApiOperation(value = "Create items", notes = "It permits to create")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Items created successfully"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    public void save(@RequestBody final Item item) {
        this.itemService.save(item);
    }
}
