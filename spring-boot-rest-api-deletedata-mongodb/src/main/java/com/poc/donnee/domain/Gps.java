package com.poc.donnee.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.HashIndexed;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Sharded;
import org.springframework.data.mongodb.core.mapping.ShardingStrategy;

@Document
@Sharded(shardKey = { "pfVehicleId" }, shardingStrategy = ShardingStrategy.HASH)
@CompoundIndexes({ @CompoundIndex(name = "pfVehicleId_dateTime_index", def = "{ 'pfVehicleId': 1, 'dateTime': -1 }") })
public class Gps {
	@Id
	private String id;
	private String externalId;
	private String name;
	@HashIndexed
	private String pfVehicleId;
	private String type;
	private Object value;
	private String canBusType;
	private Double latitude;
	private Double longitude;
	@HashIndexed
	@Indexed(name = "dateTime_index", direction = IndexDirection.DESCENDING)
	private String dateTime;
	private String providerType;
	private String metaDataProvider;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPfVehicleId() {
		return pfVehicleId;
	}

	public void setPfVehicleId(String pfVehicleId) {
		this.pfVehicleId = pfVehicleId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getProviderType() {
		return providerType;
	}

	public void setProviderType(String providerType) {
		this.providerType = providerType;
	}

	public String getMetaDataProvider() {
		return metaDataProvider;
	}

	public void setMetaDataProvider(String metaDataProvider) {
		this.metaDataProvider = metaDataProvider;
	}

	public String getCanBusType() {
		return canBusType;
	}

	public void setCanBusType(String canBusType) {
		this.canBusType = canBusType;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
