package patientlogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import patientlogin.services.ipatientservice;




@Controller
public class LoginController {
	
	@Autowired
	
	private ipatientservice patientService;
 
	@RequestMapping("login")
	public String toLogin(Model model) {
		
		model.addAttribute("patient", new Patient());
		
		return "login";
	}
 
	@RequestMapping("loginin")
	public ModelAndView toLogin(@ModelAttribute("patient") @Valid Patient patient,BindingResult result, ModelMap modelMap) throws Exception {
		ModelAndView view = new ModelAndView("login");
		
		//	Patient patientx = new Patient();
			
		
			if(!result.hasFieldErrors()){
			if(!patientService.authenticatePatient(patient)) {
				
				result.addError(new ObjectError("*", "Errors have been found"));
		
				
			} 
			
			else {
				view.setViewName("welcome");
				view.addObject("name",patient.getUsername());
				System.out.println(patient.getUsername());
			}
			}
		//}
			
		return view;
	}
}
