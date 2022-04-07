
package com.raywenderlich.androidcapstone.apidata;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Home {

    @SerializedName("homeId")
    @Expose
    public Integer homeId;
    @SerializedName("heatingType")
    @Expose
    public String heatingType;
    @SerializedName("location")
    @Expose
    public String location;
    @SerializedName("value")
    @Expose
    public Integer value;
    @SerializedName("streetNumber")
    @Expose
    public Integer streetNumber;
    @SerializedName("streetName")
    @Expose
    public String streetName;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("postalcode")
    @Expose
    public String postalcode;
    @SerializedName("dateBuilt")
    @Expose
    public String dateBuilt;
    @SerializedName("homeQuotes")
    @Expose
    public List<HomeQuote> homeQuotes = null;
    @SerializedName("homePolicy")
    @Expose
    public HomePolicy homePolicy;

}
