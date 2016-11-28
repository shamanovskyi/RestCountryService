package ua.artcode.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.artcode.service_country.*;

import java.util.List;
import java.util.Map;


@RestController()
@RequestMapping("/country")
public class CountryController {

    private CountriesPort port;

    public CountryController() {
        port = new CountriesPortService().getCountriesPortSoap11();
    }

    @RequestMapping("/get")
    public Country getCountry(@RequestParam(value = "name")String name){
        GetCountryRequest request = new GetCountryRequest();
        request.setName(name);
        return port.getCountry(request).getCountry();
    }

    @RequestMapping("/add")
    public boolean addCountry(@RequestParam Map<String, String> params){
        String name = params.get("name");
        String capital = params.get("capital");
        double population = Double.valueOf(params.get("population"));
        double area = Double.valueOf(params.get("area"));

        Country country = new Country();
        country.setPopulation(population);
        country.setArea(area);
        country.setName(name);
        country.setCapital(capital);

        AddCountryRequest request = new AddCountryRequest();
        request.setCountry(country);
        return port.addCountry(request).isBoolean();
    }

    @RequestMapping("/list")
    public List<Country> getAllCountries(){
        GetAllCountriesRequest request = new GetAllCountriesRequest();
        GetAllCountriesResponse response = port.getAllCountries(request);
        List<Country> countries = response.getCountries();
        return countries;
    }

}
