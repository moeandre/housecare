-- MySQL Workbench Synchronization
-- Generated: 2020-04-15 21:55
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: AndréMauricio

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

ALTER TABLE `housecare`.`cliente` 
DROP FOREIGN KEY `fk_cliente_empresa1`;

ALTER TABLE `housecare`.`familiar` 
DROP FOREIGN KEY `fk_familiar_empresa1`;

ALTER TABLE `housecare`.`funcionario` 
DROP FOREIGN KEY `fk_empresa_has_usuario_empresa1`,
DROP FOREIGN KEY `fk_empresa_has_usuario_usuario1`;

ALTER TABLE `housecare`.`configuracao` 
DROP FOREIGN KEY `fk_configuracao_empresa1`;

ALTER TABLE `housecare`.`quarto` 
DROP FOREIGN KEY `fk_quarto_empresa1`;

ALTER TABLE `housecare`.`leito` 
DROP FOREIGN KEY `fk_leito_quarto1`;

ALTER TABLE `housecare`.`lotacao` 
DROP FOREIGN KEY `fk_leito_has_cliente_cliente1`;

ALTER TABLE `housecare`.`anotacao` 
DROP FOREIGN KEY `fk_anotacao_cliente1`,
DROP FOREIGN KEY `fk_anotacao_usuario1`;

ALTER TABLE `housecare`.`inventario` 
DROP FOREIGN KEY `fk_inventario_cliente1`;

ALTER TABLE `housecare`.`servico` 
DROP FOREIGN KEY `fk_servico_cliente1`;

ALTER TABLE `housecare`.`caixa` 
DROP FOREIGN KEY `fk_caixa_cliente1`;

ALTER TABLE `housecare`.`lancamento` 
DROP FOREIGN KEY `fk_lancamento_cliente1`,
DROP FOREIGN KEY `fk_lancamento_cobranca1`;

ALTER TABLE `housecare`.`papel_empresa` 
DROP FOREIGN KEY `fk_papel_has_empresa_empresa1`;

ALTER TABLE `housecare`.`papel_empresa_usuario` 
DROP FOREIGN KEY `fk_papel_empresa_has_usuario_papel_empresa1`,
DROP FOREIGN KEY `fk_papel_empresa_has_usuario_usuario1`;

ALTER TABLE `housecare`.`atributo_usuario` 
DROP FOREIGN KEY `fk_atributo_usuario_papel_empresa_usuario1`;

ALTER TABLE `housecare`.`sessao` 
DROP FOREIGN KEY `fk_sessao_usuario1`;

ALTER TABLE `housecare`.`parentesco` 
DROP FOREIGN KEY `fk_familiar_has_cliente_cliente1`;

ALTER TABLE `housecare`.`atributo_familiar` 
DROP FOREIGN KEY `fk_atributo_familiar_familiar1`;

ALTER TABLE `housecare`.`atributo_cliente` 
DROP FOREIGN KEY `fk_atributo_cliente_cliente1`;

ALTER TABLE `housecare`.`inventario` 
CHANGE COLUMN `cobranca` `cobranca` TINYINT(1) NOT NULL COMMENT 'Indicador de cobrança\nT = Gera \'lancamento\'' ;

ALTER TABLE `housecare`.`lancamento` 
DROP COLUMN `id_fatura`,
ADD COLUMN `id_fatura` INT(11) NULL DEFAULT NULL AFTER `id_empresa`,
ADD INDEX `fk_lancamento_fatura1_idx` (`id_fatura` ASC) VISIBLE,
DROP INDEX `fk_lancamento_cobranca1_idx` ;

ALTER TABLE `housecare`.`lancamento` 
ADD COLUMN `quantidade` INT(11) NOT NULL DEFAULT 1 AFTER `nome`;
;

DROP TABLE IF EXISTS `housecare`.`fatura` ;

CREATE TABLE IF NOT EXISTS `housecare`.`fatura` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` INT(11) NOT NULL,
  `id_empresa` INT(11) NOT NULL,
  `id_familiar` INT(11) NULL DEFAULT NULL,
  `valor` DECIMAL(15,2) NOT NULL,
  `data` DATETIME NOT NULL,
  `vencimento` DATETIME NOT NULL,
  `pagamento` DATETIME NULL DEFAULT NULL,
  `tipo` VARCHAR(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_fatura_cliente1_idx` (`id_cliente` ASC, `id_empresa` ASC) VISIBLE,
  INDEX `fk_fatura_familiar1_idx` (`id_familiar` ASC) VISIBLE,
  CONSTRAINT `fk_fatura_cliente1`
    FOREIGN KEY (`id_cliente` , `id_empresa`)
    REFERENCES `housecare`.`cliente` (`id` , `id_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fatura_familiar1`
    FOREIGN KEY (`id_familiar`)
    REFERENCES `housecare`.`familiar` (`id_familiar`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

ALTER TABLE `housecare`.`cliente` 
ADD CONSTRAINT `fk_cliente_empresa1`
  FOREIGN KEY (`id_empresa`)
  REFERENCES `housecare`.`empresa` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `housecare`.`familiar` 
DROP FOREIGN KEY `fk_familiar_familiar1`;

ALTER TABLE `housecare`.`familiar` ADD CONSTRAINT `fk_familiar_familiar1`
  FOREIGN KEY (`id_contato`)
  REFERENCES `housecare`.`familiar` (`id_familiar`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_familiar_empresa1`
  FOREIGN KEY (`id_empresa`)
  REFERENCES `housecare`.`empresa` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `housecare`.`funcionario` 
ADD CONSTRAINT `fk_empresa_has_usuario_empresa1`
  FOREIGN KEY (`id_empresa`)
  REFERENCES `housecare`.`empresa` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_empresa_has_usuario_usuario1`
  FOREIGN KEY (`id_usuario`)
  REFERENCES `housecare`.`usuario` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `housecare`.`configuracao` 
ADD CONSTRAINT `fk_configuracao_empresa1`
  FOREIGN KEY (`id_empresa`)
  REFERENCES `housecare`.`empresa` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `housecare`.`quarto` 
ADD CONSTRAINT `fk_quarto_empresa1`
  FOREIGN KEY (`id_empresa`)
  REFERENCES `housecare`.`empresa` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `housecare`.`leito` 
ADD CONSTRAINT `fk_leito_quarto1`
  FOREIGN KEY (`id_quarto`)
  REFERENCES `housecare`.`quarto` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `housecare`.`lotacao` 
DROP FOREIGN KEY `fk_leito_has_cliente_leito1`;

ALTER TABLE `housecare`.`lotacao` ADD CONSTRAINT `fk_leito_has_cliente_leito1`
  FOREIGN KEY (`id_leito` , `id_quarto`)
  REFERENCES `housecare`.`leito` (`id` , `id_quarto`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_leito_has_cliente_cliente1`
  FOREIGN KEY (`id_cliente` , `id_empresa`)
  REFERENCES `housecare`.`cliente` (`id` , `id_empresa`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `housecare`.`anotacao` 
ADD CONSTRAINT `fk_anotacao_cliente1`
  FOREIGN KEY (`id_cliente` , `id_empresa`)
  REFERENCES `housecare`.`cliente` (`id` , `id_empresa`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_anotacao_usuario1`
  FOREIGN KEY (`id_usuario`)
  REFERENCES `housecare`.`usuario` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `housecare`.`inventario` 
ADD CONSTRAINT `fk_inventario_cliente1`
  FOREIGN KEY (`id_cliente` , `id_empresa`)
  REFERENCES `housecare`.`cliente` (`id` , `id_empresa`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `housecare`.`servico` 
ADD CONSTRAINT `fk_servico_cliente1`
  FOREIGN KEY (`id_cliente` , `id_empresa`)
  REFERENCES `housecare`.`cliente` (`id` , `id_empresa`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `housecare`.`caixa` 
ADD CONSTRAINT `fk_caixa_cliente1`
  FOREIGN KEY (`id_cliente` , `id_empresa`)
  REFERENCES `housecare`.`cliente` (`id` , `id_empresa`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `housecare`.`lancamento` 
ADD CONSTRAINT `fk_lancamento_cliente1`
  FOREIGN KEY (`id_cliente` , `id_empresa`)
  REFERENCES `housecare`.`cliente` (`id` , `id_empresa`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_lancamento_fatura1`
  FOREIGN KEY (`id_fatura`)
  REFERENCES `housecare`.`fatura` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `housecare`.`papel_empresa` 
DROP FOREIGN KEY `fk_papel_has_empresa_papel1`;

ALTER TABLE `housecare`.`papel_empresa` ADD CONSTRAINT `fk_papel_has_empresa_papel1`
  FOREIGN KEY (`id_papel`)
  REFERENCES `housecare`.`papel` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_papel_has_empresa_empresa1`
  FOREIGN KEY (`id_empresa`)
  REFERENCES `housecare`.`empresa` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `housecare`.`papel_empresa_usuario` 
ADD CONSTRAINT `fk_papel_empresa_has_usuario_papel_empresa1`
  FOREIGN KEY (`id_papel` , `id_empresa`)
  REFERENCES `housecare`.`papel_empresa` (`id_papel` , `id_empresa`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_papel_empresa_has_usuario_usuario1`
  FOREIGN KEY (`id_usuario`)
  REFERENCES `housecare`.`usuario` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `housecare`.`atributo_usuario` 
ADD CONSTRAINT `fk_atributo_usuario_papel_empresa_usuario1`
  FOREIGN KEY (`id_papel` , `id_empresa` , `id_usuario`)
  REFERENCES `housecare`.`papel_empresa_usuario` (`id_papel` , `id_empresa` , `id_usuario`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `housecare`.`sessao` 
ADD CONSTRAINT `fk_sessao_usuario1`
  FOREIGN KEY (`id_usuario`)
  REFERENCES `housecare`.`usuario` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `housecare`.`parentesco` 
DROP FOREIGN KEY `fk_familiar_has_cliente_familiar1`;

ALTER TABLE `housecare`.`parentesco` ADD CONSTRAINT `fk_familiar_has_cliente_familiar1`
  FOREIGN KEY (`id_familiar`)
  REFERENCES `housecare`.`familiar` (`id_familiar`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_familiar_has_cliente_cliente1`
  FOREIGN KEY (`id_cliente` , `id_empresa`)
  REFERENCES `housecare`.`cliente` (`id` , `id_empresa`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `housecare`.`atributo_familiar` 
ADD CONSTRAINT `fk_atributo_familiar_familiar1`
  FOREIGN KEY (`id_familiar`)
  REFERENCES `housecare`.`familiar` (`id_familiar`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `housecare`.`atributo_cliente` 
ADD CONSTRAINT `fk_atributo_cliente_cliente1`
  FOREIGN KEY (`id_cliente` , `id_empresa`)
  REFERENCES `housecare`.`cliente` (`id` , `id_empresa`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
