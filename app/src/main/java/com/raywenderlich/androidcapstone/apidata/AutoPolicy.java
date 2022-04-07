
package com.raywenderlich.androidcapstone.apidata;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class AutoPolicy {

    @SerializedName("autoPolicyId")
    @Expose
    public Integer autoPolicyId;
    @SerializedName("autoPolicyPremium")
    @Expose
    public Float autoPolicyPremium;
    @SerializedName("autoPolicyStartDate")
    @Expose
    public String autoPolicyStartDate;
    @SerializedName("autoPolicyEndDate")
    @Expose
    public String autoPolicyEndDate;

}
