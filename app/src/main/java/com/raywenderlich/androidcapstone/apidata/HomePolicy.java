
package com.raywenderlich.androidcapstone.apidata;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class HomePolicy {

    @SerializedName("homePolicyId")
    @Expose
    public Integer homePolicyId;
    @SerializedName("homePolicyPremium")
    @Expose
    public Float homePolicyPremium;
    @SerializedName("homePolicyStartDate")
    @Expose
    public String homePolicyStartDate;
    @SerializedName("homePolicyEndDate")
    @Expose
    public String homePolicyEndDate;

}
