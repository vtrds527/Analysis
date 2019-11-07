package com.ems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Analysis1Application {
	public static void main(String[] args) {
		SpringApplication.run(Analysis1Application.class, args);
		
		try {
			InputStreamReader isr = new InputStreamReader(
					new FileInputStream("C:\\Users\\08062\\Downloads\\file.csv"));
			BufferedReader reader = new BufferedReader(isr);
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\08062\\Desktop\\export_file.csv"));
			String line = null;
			reader.readLine();
			bw.write("id,meter_id,bday,lday,nday,oday,uday,hday,onoff,bat,door,signal_type,sim,gprs,"
					+ "trn_amt,trn_suc,trn_fail,trn_ontime,boot_time,firm_version,alarm,amount,short_l,"
					+ "p_amount,p_short_l,r_amount,r_short_l,pressure,rec_date_time,rec_hour_time,sensor1_f,"
					+ "sensor1_f_short_l,sensor1_r,sensor1_r_short_l,sensor2_f,sensor2_f_short_l,sensor2_r,"
					+ "sensor2_r_short_l,sensor3_f,sensor3_f_short_l,sensor3_r,sensor3_r_short_l,ai1,ai2,di1,"
					+ "di1_short_l,di2,di2_short_l,ai3,ai4,di3,di3_short_l,di4,di4_short_l,ai5,pressure2,status,"
					+ "version,temperature,humidity,battery,water_meter_id,receive_time,error_code");
			bw.newLine();
			while ((line = reader.readLine()) != null) {
				String item[] = line.split(",| ");
				for (int i = 0; i < item.length; i++) {
					bw.write(item[i]);
					bw.append(",");
				}
				bw.newLine();
			}
			reader.close();
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot found file");
		} catch (IOException e) {
		}
	}
}