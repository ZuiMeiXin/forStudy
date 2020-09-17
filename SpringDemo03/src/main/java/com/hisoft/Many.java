package com.hisoft;

import lombok.Data;

import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.List;
@Data
public class Many {
    private String name;
    private String[] arrays;
    private List list;
    private Map map;
    private Set set;
    private String nullValue;
    private Properties properties;
    private Person person;
    private String[][] strings;
}
