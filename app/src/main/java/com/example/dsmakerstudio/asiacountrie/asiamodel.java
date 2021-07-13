package com.example.dsmakerstudio.asiacountrie;

import java.util.ArrayList;
import java.util.List;

public class asiamodel {
    String name, capital, flag, region, subRegion, population, borders;
    List<String> ls;

    public asiamodel(String name, String capital, String flag, String region, String subRegion, String population, String borders, List<String> ls) {
        this.name = name;
        this.capital = capital;
        this.flag = flag;
        this.region = region;
        this.subRegion = subRegion;
        this.population = population;
        this.borders = borders;
        this.ls = ls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubRegion() {
        return subRegion;
    }

    public void setSubRegion(String subRegion) {
        this.subRegion = subRegion;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getBorders() {
        return borders;
    }

    public void setBorders(String borders) {
        this.borders = borders;
    }

    public List<String> getLs() {
        return ls;
    }

    public void setLs(List<String> ls) {
        this.ls = ls;
    }
}