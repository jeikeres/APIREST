package com.webservices.rest.jersey;

import java.util.HashMap;
import java.util.Map;

public enum TransferenciaDao {
	instance;

	private Map<String, Transferencia> transferencias = new HashMap<String, Transferencia>();
	
	private TransferenciaDao(){
		// pumping-in some default data
		Transferencia transferencia = new Transferencia("36.49468464", "45");
		transferencias.put("1", transferencia);
	}
	
	public Map<String, Transferencia> getTransferencias() {
		return transferencias;
	}

}
