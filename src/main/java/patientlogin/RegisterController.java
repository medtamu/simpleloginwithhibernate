package patientlogin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import patientlogin.services.ipatientservice;

@Controller
public class RegisterController {
        
         @Autowired
	
	private ipatientservice patientService;


	@RequestMapping("register")
	public String toregister(Model model) {
		
model.addAttribute("patient", new Patient());
		
		return "register";
		
	}
	
	@RequestMapping("registering")
	public ModelAndView registerPatient(@ModelAttribute("patient") @Valid Patient patient,BindingResult result, ModelMap modelMap) 
	{

		ModelAndView view = new ModelAndView("register");
  
   
 
    if(!result.hasFieldErrors()){
     
    	if(!patientService.registerPatient(patient)) 
      
          {

    result.addError(new ObjectError("*", "Errors have been found"));
    
   
    
          }
    	
    
      else {

       view.setViewName("welcome");
       view.addObject("name",patient.getUsername());
      
  
          }
    
    }     


	
		



	
    System.out.println(view.getViewName());
	return view;
}
}
