package project.helpers;

/*
** Created by NiGhTFoX on 24.11.2017.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LocationParser {
    private String location;
    private String controller;
    private String action;
    private Map<String, String> params;

    public LocationParser(final String location){
        this.location = location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getLocation(){
        return this.location;
    }

    public void parse() throws Exception{
        // controller/action?name=value...
        String regExp = "^(\\w+)\\/(\\w+)[\\?]{0,}(.*)";

        Pattern p = Pattern.compile(regExp);
        Matcher matcher = p.matcher(this.location);

        if(!matcher.matches()){
            throw new Exception("Wrong location path!");
        }else {
            this.controller = matcher.group(1);
            this.action = matcher.group(2);
            this.params = parse(matcher.group(3));
        }
    }

    private Map<String, String> parse(String query){
        Map<String, String > paramsMap = new HashMap<>();
        // name=value
        String regExp = "(\\w+)\\=(\\w+)";

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(query);

        while(matcher.find()){
            paramsMap.put(matcher.group(1), matcher.group(2));
        }

        return paramsMap;
    }

    public String getControllerName(){
        if(this.location == null || this.location.isEmpty()){
            return null;
        }
        return this.controller;
    }

    public String getActionName(){
        if(this.action == null || this.action.isEmpty()){
            return null;
        }

        return this.action;
    }

    public Map<String, String> getParams(){
        if(this.params == null || this.params.isEmpty()){
            return null;
        }
        return this.params;
    }
}
