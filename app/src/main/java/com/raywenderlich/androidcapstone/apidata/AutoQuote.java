
package com.raywenderlich.androidcapstone.apidata;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class AutoQuote {

    @SerializedName("autoQuoteId")
    @Expose
    public Integer autoQuoteId;
    @SerializedName("autoQuotePremium")
    @Expose
    public Float autoQuotePremium;
    @SerializedName("autoQuoteStartDate")
    @Expose
    public String autoQuoteStartDate;
    @SerializedName("autoQuoteEndDate")
    @Expose
    public String autoQuoteEndDate;

}
