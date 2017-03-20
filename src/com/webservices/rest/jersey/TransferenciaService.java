package com.webservices.rest.jersey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransferenciaService {
	
	TransferenciaDao transferenciaDao;
	
	public TransferenciaService() {
		transferenciaDao = TransferenciaDao.instance;
	}

	public void createTransferencia(Transferencia transferencia) {
		transferenciaDao.getTransferencias().put(transferencia.getId(), transferencia);
	}

	public Transferencia getTransferencia(String id) {
		return transferenciaDao.getTransferencias().get(id);
	}

	public Map<String, Transferencia> getTransferencias() {
		return transferenciaDao.getTransferencias();
	}

	public List<Transferencia> getTransferenciasAsList() {
		List<Transferencia> transferenciaList = new ArrayList<Transferencia>();
		transferenciaList.addAll(transferenciaDao.getTransferencias().values());
		return transferenciaList;
	}

	public int getTransferenciasCount() {
		return transferenciaDao.getTransferencias().size();
	}

	public void deleteTransferencia(String id) {
		transferenciaDao.getTransferencias().remove(id);
	}

}
