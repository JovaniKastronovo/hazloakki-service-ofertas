package com.hazloakki.ofertas.service;

import com.hazloakki.ofertas.entity.OfertasEntity;
import com.hazloakki.ofertas.modelo.OfertasDto;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
public interface OfertasService {

	OfertasEntity guardarCuenta(OfertasDto cuentaDto);

	OfertasEntity obtenerCuenta(String idCuenta);

	OfertasEntity modificarCuenta(String idCuenta, OfertasDto cuentaDto);

	void borrarCuenta(String idCuenta);

	OfertasEntity validaCuenta(String email, String password);
}
