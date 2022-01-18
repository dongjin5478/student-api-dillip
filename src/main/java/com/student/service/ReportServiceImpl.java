package com.student.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.student.request.WeightSlipRequest;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportServiceImpl {
	public ResponseEntity<byte[]> exportReport(WeightSlipRequest weightSlipRequest)
			throws JRException, IOException {
		
		List<WeightSlipRequest> list = new ArrayList<>();
		list.add(new WeightSlipRequest());
		
		String netWeight = String.valueOf(Integer.parseInt(weightSlipRequest.getGrossWeight())
				- Integer.parseInt(weightSlipRequest.getTareWeight()));
		
		ClassPathResource classPathResource = new ClassPathResource("WeightSlip.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(classPathResource.getInputStream());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("address", weightSlipRequest.getAddress());
		parameters.put("vehicleNumber", weightSlipRequest.getVehicleNumber());
		parameters.put("grossWeight", weightSlipRequest.getGrossWeight());
		parameters.put("tareWeight", weightSlipRequest.getTareWeight());
		parameters.put("netWeight", netWeight);
		parameters.put("grossWeightDate", formattedDate(weightSlipRequest.getGrossWeightDate()));
		parameters.put("tareWeightDate", formattedDate(weightSlipRequest.getTareWeightDate()));
		parameters.put("grossWeightTime", formattedTime(weightSlipRequest.getGrossWeightDate()));
		parameters.put("tareWeightTime", formattedTime(weightSlipRequest.getTareWeightDate()));
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);
		
		HttpHeaders headers = new HttpHeaders();
		Date date = new Date();
		headers.set(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=Weight Slip_" + String.valueOf(date)+".pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}
	public String formattedDate(LocalDateTime date)
	{
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(myFormatObj);
	}
	public String formattedTime(LocalDateTime date)
	{
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("hh : mm : ss  a");
		return date.format(myFormatObj).toUpperCase();
	}
}
