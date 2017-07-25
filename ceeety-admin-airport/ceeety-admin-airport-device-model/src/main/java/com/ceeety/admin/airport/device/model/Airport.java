package com.ceeety.admin.airport.device.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ceeety.common.service.Base;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
/**
 * 
 * @author Qiao-Zhang
 */

@XmlType
@XmlRootElement
@DatabaseTable(tableName="cty_airport")
public class Airport extends Base implements Serializable {


	private static final long serialVersionUID = -7071085175266157250L;
	
		@DatabaseField(generatedId = true)
	    private Integer id;
	    @DatabaseField
	    private String city;
	    @DatabaseField
	    private String code_3;
	    @DatabaseField
	    private String code_4;
	    @DatabaseField
	    private String chinese;
	    @DatabaseField
	    private String english;
	    @DatabaseField
	    private String longitude;
	    @DatabaseField
	    private String latitude;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getCode_3() {
			return code_3;
		}
		public void setCode_3(String code_3) {
			this.code_3 = code_3;
		}
		public String getCode_4() {
			return code_4;
		}
		public void setCode_4(String code_4) {
			this.code_4 = code_4;
		}
		public String getChinese() {
			return chinese;
		}
		public void setChinese(String chinese) {
			this.chinese = chinese;
		}
		public String getEnglish() {
			return english;
		}
		public void setEnglish(String english) {
			this.english = english;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}
		public String getLongitude() {
			return longitude;
		}
		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}
		public String getLatitude() {
			return latitude;
		}
		@Override
		public String toString() {
			return "Airport [id=" + id + ", city=" + city + ", code_3=" + code_3 + ", code_4=" + code_4 + ", chinese="
					+ chinese + ", english=" + english + ", longitude=" + longitude + ", latitude=" + latitude + "]";
		}
		
	    
}
