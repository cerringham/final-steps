package it.proactivity.finalsteps.builder;


import it.proactivity.finalsteps.model.City;

public class CityBuilder {
    private final Long id;

    private String cityName;

    private Integer cityPinCode;

    private CityBuilder(Long id) {
        this.id = id;
    }

    public static CityBuilder newBuilder(Long id) {
        return new CityBuilder(id);
    }

    public CityBuilder cityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public CityBuilder cityPinCode(Integer cityPinCode) {
        this.cityPinCode = cityPinCode;
        return this;
    }

    public City build() {
        return new City(id, cityName, cityPinCode);
    }
}
