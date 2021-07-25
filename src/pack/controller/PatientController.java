package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.dao.AppointmentDAO;
import pack.dao.DoctorDAO;
import pack.dao.PatientDAO;
import pack.dao.docAvailDAO;
import pack.entity.Appointment;
import pack.entity.Doctor;
import pack.entity.Patient;
import pack.entity.docAvail;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientDAO pt;
	@Autowired
	private DoctorDAO doctorDAO;
	@Autowired
	private AppointmentDAO appoint;

	@RequestMapping("showFormForAdd")
	public String showPatForm(Model theModel)
	{
		Patient patient = new Patient();
		theModel.addAttribute("patient",patient);
		return "pat-form";
	}
	@GetMapping("showPatient")
	public String showPat(@RequestParam("id") int id,Model theModel)
	{
		Patient p = pt.getOnePatient(id);
		theModel.addAttribute("patList",p);
		return "showPatient";
	}
	
	@RequestMapping("processPatForm")
	public String processPatForm(@ModelAttribute("patient") Patient thePatient,@RequestParam("age") int age)
	{
		thePatient.setAge(age);
		pt.savePatient(thePatient);
		return "pat-home";
	}
	
		@RequestMapping("/showPat")
	public String showPatient(@RequestParam("patId") int id, Model theModel)
	{
		Patient p = pt.getOnePatient(id);
		Appointment a = new Appointment();
		theModel.addAttribute("appointment",a);
		theModel.addAttribute("patient",p);
		return "showFormAppo";
	}
	@RequestMapping("/showFormForAppC")
	public String getId(Model theModel)
	{
		return "getPatId";
	}
}
