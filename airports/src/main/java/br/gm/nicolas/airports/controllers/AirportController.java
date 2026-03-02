/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gm.nicolas.airports.controllers;

import br.gm.nicolas.airports.DTO.AirportMinDTO;
import br.gm.nicolas.airports.DTO.AirportNearMeDTO;
import br.gm.nicolas.airports.entities.Airport;
import br.gm.nicolas.airports.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nckz06_
 */

@RestController
public class AirportController {
    
    @Autowired
    private AirportService airportService;
    
    /**
     * Endpoint /airports/airport
     * Retorna TODOS os aeroportos da base de dados.
     * @return
     */
    @GetMapping("/airport")
    public List<Airport> findAll() {
        List<Airport> result = airportService.findAll();
        return result;
    }
    
    /**
     * Endpoint /airports/city/{cityName}
     * preparado para devolver código de status conforme padronização REST
     * @param cityName
     * @return 
     */
    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName) {
        
        List<Airport> result = airportService.findByCity(cityName);
        
        if (result.isEmpty()) {
            // Lista vazia
            // notFound devolve 404
            return ResponseEntity.notFound().build();
        } else {
            // Possui dados
            // ok devolve 200
            return ResponseEntity.ok(result);
        }
        
    }
    
    /**
     * 
     * @param countryName
     * @return 
     */
    @GetMapping("/country/{countryName}")
    public ResponseEntity<List<AirportMinDTO>> findByCountryIgnoreCase(@PathVariable String countryName) {
        
        List<AirportMinDTO> result = airportService.findByCountry(countryName);
        
        if (result.isEmpty()) {
            // Lista vazia
            // notFound devolve 404
            return ResponseEntity.notFound().build();
        } else {
            // Tem dados
            // ok devolve 200
            return ResponseEntity.ok(result);
        }
        
    }
    
    @GetMapping("/iatacode/{iataCode}")
    public ResponseEntity<Airport> findByIataCodeIgnoreCase(@PathVariable String iataCode) {
        
        Airport result = airportService.findByIataCode(iataCode);
        
        if (result == null) {
            // Ops... Aeroporto vazio...
            // notFound devolve 404
            return ResponseEntity.notFound().build();
        } else {
            // Possui dados...
            // ok devolve 200
            return ResponseEntity.ok(result);
        }
    }

    /**
     * Endpoint /airports/nearme
     * Retorna os aeroportos próximos a coordenada enviada como parâmetro
     * da requisição GET.
     * 
     * @param latitude
     * @param longitude
     * @return 
     */
    @GetMapping("/nearme")
    public ResponseEntity<List<AirportNearMeDTO>> findNearMe(
            @RequestParam double latitude,
            @RequestParam double longitude){
        List<AirportNearMeDTO> result = airportService.findNearMe(latitude, longitude);
        
        if (result.isEmpty()) {
            // Ops... lista vazia...
            // notFound devolve 404
            return ResponseEntity.notFound().build();
        } else {
            // Possui dados...
            // ok devolve 200
            return ResponseEntity.ok(result);
        }
    }
    
}
