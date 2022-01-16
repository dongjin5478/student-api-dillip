package com.student.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.request.WeightSlipRequest;
import com.student.service.ReportServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import net.sf.jasperreports.engine.JRException;

@RestController
@CrossOrigin
public class ReportController {
	
	@Autowired
	private ReportServiceImpl service;
	
	@Operation(summary = "Download Weight Slip in PDF")
	@PostMapping(path = "/weightslip")
	public ResponseEntity<byte[]> generateReport(@RequestBody WeightSlipRequest weightSlipRequest) throws FileNotFoundException, JRException
	{
		return service.exportReport(weightSlipRequest);
	}
}
