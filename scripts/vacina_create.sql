CREATE SCHEMA `vacina` ;
CREATE TABLE `vacina`.`pessoa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `sexo` VARCHAR(1) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `reacao_vacina` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  CREATE TABLE `vacina`.`vacinas` (
  `idvacinas` INT NOT NULL AUTO_INCREMENT,
  `pais_de_origem` VARCHAR(45) NOT NULL,
  `estagio_pesquisa` INT NOT NULL,
  `dt_inicio_pesquisa` DATE NOT NULL,
  `nome_pesquisador` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idvacinas`));
ALTER TABLE `vacina`.`vacinas` 
DROP COLUMN `nome_pesquisador`,
ADD COLUMN `id_pesquisador` INT NULL AFTER `dt_inicio_pesquisa`,
ADD INDEX `id_pesquisador_idx` (`id_pesquisador` ASC) VISIBLE;
;
ALTER TABLE `vacina`.`vacinas` 
ADD CONSTRAINT `id_pesquisador`
  FOREIGN KEY (`id_pesquisador`)
  REFERENCES `vacina`.`pessoa` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;