package pack.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pack.dao.AppointmentDAO;
import pack.entity.Appointment;


@Controller
@RequestMapping("/hosp")
public class HomeController 
{
	@Autowired
	private AppointmentDAO appoint;
	@RequestMapping("/home")
	public String showHome()
	{
		return "home";
	}
	@RequestMapping("/showDoctorHomePage")
	public String showDoc()
	{
		return "doc-home";
	}
	
	@RequestMapping("/showPatientHomePage")
	public String showPat()
	{
		return "pat-home";
	}
	
	@RequestMapping("/showAppoHomePage")
	public String showAppo(Model theModel)
	{
		List<Appointment> li = appoint.getAppointment();
		theModel.addAttribute("appointment",li);
		System.out.println(li.size());
		return "appo-home";
	}
}

