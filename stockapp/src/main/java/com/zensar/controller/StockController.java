package com.zensar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.Stock;

@RestController
@RequestMapping("/stockapp")
@CrossOrigin("*")
public class StockController {
    static List<Stock> stocks=new ArrayList<Stock>();
    static
    {
        stocks.add(new Stock(1,"zensar","BSE",30));
        stocks.add(new Stock(2,"IBM","NSE",40));
        stocks.add(new Stock(3,"Infosys","BSE",10));
        stocks.add(new Stock(4,"Accenture","NSE",25));
    }
     //delete all from vs code

    @DeleteMapping(value = "/stock")
    public boolean deleteAll(){
        stocks.clear();
        return true;
    }

    //delete by id
    @DeleteMapping(value="/stock/{id}")
    public boolean deleteById(@PathVariable("id") int StockId) {
    	for(Stock stock: stocks) {
    		if(stock.getId()==StockId) {
    			stocks.remove(stock);
                return true;
    		}
    	}
    	return false;
    }
    

    //update stock by id

    @PutMapping(value = "/stock/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Stock updatedStock(@PathVariable("id") int StockId,@RequestBody Stock updatedStock ){
        Stock existingStock= geStockById(StockId);
        existingStock.setName(updatedStock.getName());
        existingStock.setMarket(updatedStock.getMarket());
        existingStock.setPrice(updatedStock.getPrice());
        return existingStock;        
    }

    // create new stock 
    @PostMapping (value = "/stock",  consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Stock createNewStock (@RequestBody Stock stock){
        stock.setId(stocks.size()+1);
        stocks.add(stock);
        return stock;
    }


    //to get all stocks
    @GetMapping(value = "/stock", produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Stock> getAllStocks(){
        return stocks;
    }

    // get stock by id
    @GetMapping(value = "/stock/{id}",produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Stock geStockById(@PathVariable("id") int StockId){
        for( Stock stock: stocks){
            if(stock.getId()==StockId){
                return stock;
            }
        }
        return null;
    }
}
