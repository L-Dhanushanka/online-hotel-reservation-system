package com.xadmin.payment.model;

public class Pay {  private int ID;
					private String Name;
					private String Tel_No;
					private String Payment_Method;
					private String Package;
					private String Date;
					private String Paid_amount;
					
					
					
					
					public Pay(int iD, String name, String tel_No, String payment_Method, String package1, String date,
							String paid_amount) {
						super();
						ID = iD;
						Name = name;
						Tel_No = tel_No;
						Payment_Method = payment_Method;
						Package = package1;
						Date = date;
						Paid_amount = paid_amount;
						
					}
					
					public Pay(String name, String tel_No, String payment_Method, String package1, String date,
							String paid_amount) {
						super();
						Name = name;
						Tel_No = tel_No;
						Payment_Method = payment_Method;
						Package = package1;
						Date = date;
						Paid_amount = paid_amount;
					}
					
					
					public int getID() {
						return ID;
					}
					public void setID(int iD) {
						ID = iD;
					}
					public String getName() {
						return Name;
					}
					public void setName(String name) {
						Name = name;
					}
					public String getTel_No() {
						return Tel_No;
					}
					public void setTel_No(String tel_No) {
						Tel_No = tel_No;
					}
					public String getPayment_Method() {
						return Payment_Method;
					}
					public void setPayment_Method(String payment_Method) {
						Payment_Method = payment_Method;
					}
					public String getPackage() {
						return Package;
					}
					public void setPackage(String package1) {
						Package = package1;
					}
					public String getDate() {
						return Date;
					}
					public void setDate(String date) {
						Date = date;
					}
					public String getPaid_amount() {
						return Paid_amount;
					}
					public void setPaid_amount(String paid_amount) {
						Paid_amount = paid_amount;
					}

					
}
