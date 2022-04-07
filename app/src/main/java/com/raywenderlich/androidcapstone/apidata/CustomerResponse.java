
package com.raywenderlich.androidcapstone.apidata;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class CustomerResponse {

    @SerializedName("firstName")
    @Expose
    public String firstName;
    @SerializedName("lastName")
    @Expose
    public String lastName;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("dateOfBirth")
    @Expose
    public String dateOfBirth;
    @SerializedName("password")
    @Expose
    public String password;
    @SerializedName("homes")
    @Expose
    public List<Home> homes = null;
    @SerializedName("autos")
    @Expose
    public List<Auto> autos = null;
    @SerializedName("id")
    @Expose
    public Integer id;

}
