package com.hazloakki.ofertasrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hazloakki.ofertas.entity.OfertasEntity;

/**
 * @author Jovani Arzate
 * 2018-07-01
 * HazloAkki para Empresas v.1
 *
 */
@Repository
public interface OfertasRepository extends JpaRepository<OfertasEntity, String>{

	Optional<OfertasEntity> findById(String id);
	Optional<OfertasEntity> findByEmailAndPasswordAndEstatus(String email, String password, boolean estatus);
}
