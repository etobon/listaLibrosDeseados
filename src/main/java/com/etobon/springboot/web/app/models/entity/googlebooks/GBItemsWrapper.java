package com.etobon.springboot.web.app.models.entity.googlebooks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GBItemsWrapper {

	private String id;
	private GBVolumeInfoWrapper volumeInfo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public GBVolumeInfoWrapper getVolumeInfo() {
		return volumeInfo;
	}

	public void setVolumeInfo(GBVolumeInfoWrapper volumeInfo) {
		this.volumeInfo = volumeInfo;
	}

}
