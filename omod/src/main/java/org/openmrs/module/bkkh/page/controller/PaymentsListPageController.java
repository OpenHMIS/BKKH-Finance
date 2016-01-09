package org.openmrs.module.bkkh.page.controller;

import org.openmrs.Patient;
import org.openmrs.module.bkkh.Charges;
import org.openmrs.module.bkkh.api.ChargesService;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class PaymentsListPageController {
	public void get(
			@RequestParam("chargesId") long chargesId,
			@RequestParam("patientId") Patient patient,
			@SpringBean("chargesService") ChargesService chargesService,
			PageModel model) {
		model.addAttribute("patient", patient);
		Charges charges = chargesService.getCharges(chargesId);
		//charges.getPayments();
		model.addAttribute("charges", charges);
	}
}
