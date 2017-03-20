package com.webservices.rest.jersey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CuentaService {
	
	CuentaDao cuentaDao;
	
	public CuentaService() {
		cuentaDao = CuentaDao.instance;
	}

	public void createCuenta(Cuenta cuenta) {
		cuentaDao.getCuentas().put(cuenta.getId(), cuenta);
	}

	public Cuenta getCuenta(String id) {
		return cuentaDao.getCuentas().get(id);
	}

	public Map<String, Cuenta> getCuentas() {
		return cuentaDao.getCuentas();
	}

	public List<Cuenta> getCuentaAsList() {
		List<Cuenta> cuentaList = new ArrayList<Cuenta>();
		cuentaList.addAll(cuentaDao.getCuentas().values());
		return cuentaList;
	}

	public int getCuentasCount() {
		return cuentaDao.getCuentas().size();
	}

	public void deleteCuenta(String id) {
		cuentaDao.getCuentas().remove(id);
	}

}
