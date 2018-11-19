package patientlogin.services;

import org.springframework.stereotype.Service;

import patientlogin.Patient;

@Service
public interface ipatientservice {
	public abstract boolean authenticatePatient(Patient patient) throws Exception;
public abstract boolean registerPatient(Patient patient);
}
