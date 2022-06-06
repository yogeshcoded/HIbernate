package com.nt.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="STOCK_INFO")
@DynamicUpdate(value =true)
public class Stock {
	@Id
	@GeneratedValue
	private Integer stockId;
	@NonNull
	private String stockName;
	@NonNull
	private Integer price;
	@NonNull
	private String exchange;
	@Version
	private Integer updationCount;
	@CreationTimestamp
	private Timestamp launchTime;
	@UpdateTimestamp
	private Timestamp lastUpdateTime;
}// class
