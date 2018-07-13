package com.hazloakki.ofertas.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hazloakki.ofertas.modelo.OfertasDto;
import com.hazloakki.ofertas.service.OfertasService;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
@RestController
@RequestMapping("/api/v1/cuentas")
public class OfertasController {
	@Autowired
	private OfertasService cuentaService;

	@PostMapping
	@ResponseStatus(CREATED)
	public OfertasDto crearCuenta(@Valid @RequestBody OfertasDto cuentaDto) {
		return cuentaService.guardarCuenta(cuentaDto).to();
	}

	@GetMapping("/{id}")
	public OfertasDto readCuenta(@PathVariable("id") String idCuenta) {
		return cuentaService.obtenerCuenta(idCuenta).to();
	}

	@PutMapping("/{id}")
	public OfertasDto updateCuenta(@PathVariable("id") String idCuenta, @Valid @RequestBody OfertasDto cuentaDto) {
		return cuentaService.modificarCuenta(idCuenta, cuentaDto).to();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(OK)
	public void borraCuenta(@PathVariable("id") String idCuenta) {
		cuentaService.borrarCuenta(idCuenta);
	}

	@GetMapping("/{email}/{password}")
	@ResponseStatus(OK)
	public OfertasDto loginCuenta(@PathVariable("email") String email, @PathVariable("password") String password) {
		return cuentaService.validaCuenta(email, password).to();
	}

}
