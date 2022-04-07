
package com.raywenderlich.androidcapstone.apidata;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Auto {

    @SerializedName("autoId")
    @Expose
    public Integer autoId;
    @SerializedName("make")
    @Expose
    public String make;
    @SerializedName("model")
    @Expose
    public String model;
    @SerializedName("dateMade")
    @Expose
    public String dateMade;
    @SerializedName("autoQuotes")
    @Expose
    public List<AutoQuote> autoQuotes = null;
    @SerializedName("autoPolicy")
    @Expose
    public AutoPolicy autoPolicy;

}
