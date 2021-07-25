package pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.dao.AppointmentDAO;
import pack.dao.DoctorDAO;
import pack.dao.docAvailDAO;
import pack.entity.Appointment;
import pack.entity.Doctor;
import pack.entity.docAvail;

@Controller
@RequestMapping("appointment")
public class AppointmentController {
	@Autowired
	private docAvailDAO docAvaildao;
	@Autowired
	private AppointmentDAO appoint;
	@Autowired
	private DoctorDAO doctorDAO;
	@RequestMapping(value="formSub", params="mark")
	public String markAsComplete(@RequestParam("completed") String[] li)
	{
		List<Integer> li2 = new ArrayList<Integer>();
		for(int i=0;i<li.length;i++)
		{
			li2.add(Integer.parseInt(li[i]));
		}
		appoint.markAsCompleted(li2);
		return "home";
	}
	
	@RequestMapping("autoschedule")
	public String autoShedule()
	{
		appoint.autoschedule();
		return "appo-home";
	}
	@RequestMapping(value="submitSlot")
	public String submitSlot(@RequestParam("appointment")String id,@RequestParam("appoId") String appoId,Model theModel)
	{
		int iD=Integer.parseInt(id);
		int appoID=Integer.parseInt(appoId);
		Appointment appointment = appoint.getOneAppointment(iD);
		docAvail da = docAvaildao.getDocAvail(appoID);
		int t=da.getSlot();
		da.setSlot(t-1);
		appointment.setDocId(da.getDoctor().getId());
		appointment.setAppDay(da.getDays());
		appoint.saveAppointment(appointment);
		docAvaildao.saveDocAvail(da);
		return "pat-home";
	}
	@RequestMapping("processUpdate")
	public String processFormUpdate(@RequestParam("appId") int id,@ModelAttribute("appointment") Appointment a,Model theModel)
	{
		Appointment ap = appoint.getOneAppointment(id);
		ap.setSpeciality(a.getSpeciality());
		ap.setSeverity(a.getSeverity());
		appoint.saveAppointment(ap);
		Doctor d = doctorDAO.getOneDoctor(ap.getDocId());
		List<docAvail> li = d.getAvail();
		for(int i=0;i<li.size();i++)
		{
			if(li.get(i).getDays().equals(ap.getAppDay()))
			{
				int t = li.get(i).getSlot();
				li.get(i).setSlot(t+1);
				break;
			}
		}
		doctorDAO.saveDoctor(d);
		List<Doctor> availDocs = doctorDAO.getDoctorBySpeciality(a.getSpeciality());
		theModel.addAttribute("app",ap);
		theModel.addAttribute("li",availDocs);
		return "schedApp";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showForUpdate(@RequestParam("appId") int id,Model theModel)
	{
		Appointment a = appoint.getOneAppointment(id);
		theModel.addAttribute("appointment",a);
		return "updateAppointment";
	}
	@RequestMapping("deleteAppointment")
	@Transactional
	public String deleteAppointment(@RequestParam("appId") int theId,Model theModel)
	{
		appoint.deleteAppointment(theId);
		return "redirect:/hosp/showAppoHomePage";
	}

	@RequestMapping(value="processPatFormA",params="submit")
	public String submitAppo(@RequestParam("hospId") int id,@RequestParam("speciality") String spc,
			@RequestParam("severity") int sev,Model theModel)
	{
		Appointment a = new Appointment(id,spc,sev,1);
		appoint.saveAppointment(a);
		return "pat-home";
	}
	

	
	@RequestMapping(value="processPatFormA",params="book")
	public String showBookSlot(@RequestParam("hospId") int id,@RequestParam("speciality") String spc,
			@RequestParam("severity") int sev,Model theModel)
	{
		Appointment a = new Appointment(id,spc,sev,1);
		appoint.saveAppointment(a);
		List<Doctor> availDocs = doctorDAO.getDoctorBySpeciality(spc);
		theModel.addAttribute("app",a);
		theModel.addAttribute("li",availDocs);
		return "schedApp";
	}
	


}
