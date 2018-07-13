package com.hazloakki.ofertas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hazloakki.ofertas.api.OfertasException;
import com.hazloakki.ofertas.entity.OfertasEntity;
import com.hazloakki.ofertas.modelo.OfertasDto;
import com.hazloakki.ofertasrepository.OfertasRepository;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
@Service
public class OfertasServiceImpl implements OfertasService {

	@Autowired
	private OfertasRepository cuentaRepository;

	@Transactional
	@Override
	public OfertasEntity guardarCuenta(OfertasDto cuentaDto) {
		OfertasEntity cuentaEntity = OfertasEntity.from(cuentaDto);
		return cuentaRepository.save(cuentaEntity);
	}

	@Override
	public OfertasEntity obtenerCuenta(String idCuenta) {
		return cuentaRepository.findById(idCuenta)
				.orElseThrow(() -> OfertasException.from("No se encontro la cuenta :" + idCuenta, idCuenta));
	}

	@Transactional
	@Override
	public OfertasEntity modificarCuenta(String idCuenta, OfertasDto cuentaDto) {

		OfertasEntity cuentaOptional = cuentaRepository.findById(idCuenta)
				.orElseThrow(() -> OfertasException.from("No se encontro la cuenta: " + idCuenta, idCuenta));

		cuentaOptional = OfertasEntity.from(cuentaDto);
		cuentaOptional.setId(idCuenta);

		return cuentaRepository.save(cuentaOptional);

	}

	@Override
	public void borrarCuenta(String idCuenta) {

		OfertasEntity cuentaOptional = cuentaRepository.findById(idCuenta)
				.orElseThrow(() -> OfertasException.from("No se encontro la cuenta: " + idCuenta, idCuenta));

		cuentaRepository.delete(cuentaOptional);
	}

	@Override
	public OfertasEntity validaCuenta(String email, String password) {

		return cuentaRepository.findByEmailAndPasswordAndEstatus(email, password,Boolean.TRUE)
				.orElseThrow(() -> OfertasException.from("No se encontro la cuenta, es necesario registrarse!", email));

	}

}
