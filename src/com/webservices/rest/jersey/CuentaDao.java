package com.webservices.rest.jersey;

import java.util.HashMap;
import java.util.Map;

public enum CuentaDao {
	instance;

	private Map<String, Cuenta> cuentas = new HashMap<String, Cuenta>();
	
	private CuentaDao(){
		
		// pumping-in some default data
				Cuenta cuenta = new Cuenta("1001", "joaquin", "11111111");
				cuentas.put("1", cuenta);

				cuenta = new Cuenta("1002", "luis", "22222222");
				cuentas.put("2", cuenta);

				cuenta = new Cuenta("1003", "daniel", "33333333");
				cuentas.put("3", cuenta);
				
				cuenta = new Cuenta("1004", "jorge", "44444444");
				cuentas.put("4", cuenta);	
	}
	
	public Map<String, Cuenta> getCuentas() {
		return cuentas;
	}

}
