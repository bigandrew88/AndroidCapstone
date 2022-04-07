
package com.raywenderlich.androidcapstone.apidata;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class HomeQuote {

    @SerializedName("homeQuoteId")
    @Expose
    public Integer homeQuoteId;
    @SerializedName("homeQuotePremium")
    @Expose
    public Float homeQuotePremium;
    @SerializedName("homeQuoteStartDate")
    @Expose
    public String homeQuoteStartDate;
    @SerializedName("homeQuoteEndDate")
    @Expose
    public String homeQuoteEndDate;

}
