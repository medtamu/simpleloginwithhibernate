package patientlogin.services;








import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import patientlogin.Patient;
import patientlogin.dao.ipatientdao;




public class PatientService implements ipatientservice {

@Autowired
private ipatientdao patientDao;

public boolean authenticatePatient(Patient patient) throws Exception{

	
return patientDao.authenticatePatient(patient);


}


public boolean registerPatient(Patient patient) {

	
return patientDao.registerPatient(patient);

}


}
