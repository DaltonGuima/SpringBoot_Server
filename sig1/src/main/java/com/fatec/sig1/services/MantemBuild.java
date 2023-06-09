package com.fatec.sig1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.sig1.model.Build.Build;
import com.fatec.sig1.model.Repositorys.MantemBuildRepository;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;

@Service
public class MantemBuild {

    Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    MantemBuildRepository repository;

    public List<Build> consultaTodos() {
        logger.info(">>>>>> servico consultaTodos chamado");
        return repository.findAll();
    }

    public void delete(Long id) {
        logger.info(">>>>>> servico delete por id chamado");
        repository.deleteById(id);
    }

    public Optional<Build> consultaPorId(Long id) {
        logger.info(">>>>>> servico consultaPorId chamado");
        return repository.findById(id);
    }

    public Optional<Build> consultaPorNome(String Nome) {
        logger.info(">>>>>> servico consultaPorNome chamado");
        return repository.findByNome(Nome);
    }

    public Optional<Build> save(Build build) {
        logger.info(">>>>>> servico save chamado ");
        Build.setDataCadastro(new DateTime());
        return Optional.ofNullable(repository.save(build));
    }

    public Optional<Build> atualiza(Long id, Build build) {
        logger.info(">>>>>> 1.servico atualiza informações de cliente chamado");
        Build buildModificado = new Build(build.getOrcamento(), build.getDescricao(), build.getNome());
        buildModificado.setId(id);
        buildModificado.obtemDataAtual(new DateTime());
        logger.info(buildModificado.getId());
        return Optional.ofNullable(repository.save(buildModificado));
    }
}