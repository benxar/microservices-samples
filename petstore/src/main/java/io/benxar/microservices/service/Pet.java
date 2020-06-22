package io.benxar.microservices.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "tag"
})
public class Pet {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("tag")
    private String tag;

    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

	public Pet(long id, String name, String tag) {
		this.id = id;
		this.name = name;
		this.tag = tag;
	}
}
