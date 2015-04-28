-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2015-04-28 01:40:49.73




-- tables
-- Table Categoria
CREATE TABLE Categoria (
    Id int    NOT NULL  AUTO_INCREMENT,
    Designacao varchar(100)    NOT NULL ,
    CONSTRAINT Categoria_pk PRIMARY KEY (Id)
);

-- Table Configuracao
CREATE TABLE Configuracao (
    Id int    NOT NULL  AUTO_INCREMENT,
    NomePosto varchar(200)    NOT NULL ,
    NFolgasSemanais int    NOT NULL ,
    NDiasFeriasAnuais int    NOT NULL ,
    CONSTRAINT Configuracao_pk PRIMARY KEY (Id)
);

-- Table Gratificado
CREATE TABLE Gratificado (
    Id int    NOT NULL  AUTO_INCREMENT,
    HoraInicio time    NOT NULL ,
    HoraFim time    NOT NULL ,
    Observacao varchar(300)    NULL ,
    Local varchar(150)    NULL ,
    TipoGratificado_Id int    NOT NULL ,
    Viatura_Id int    NOT NULL ,
    FRadio varchar(15)    NULL ,
    DataInicio date    NOT NULL ,
    DataFim date    NOT NULL ,
    CONSTRAINT Gratificado_pk PRIMARY KEY (Id)
);

-- Table GratificadoPessoa
CREATE TABLE GratificadoPessoa (
    Id int    NOT NULL  AUTO_INCREMENT,
    Gratificado_Id int    NOT NULL ,
    Pessoa_Id int    NOT NULL ,
    Status int    NOT NULL ,
    Erro varchar(100)    NULL ,
    Data date    NOT NULL ,
    CONSTRAINT GratificadoPessoa_pk PRIMARY KEY (Id)
);

-- Table HabilitaServico
CREATE TABLE HabilitaServico (
    Id int    NOT NULL ,
    Pessoa_Id int    NOT NULL ,
    TipoServico_Id int    NOT NULL ,
    CONSTRAINT HabilitaServico_pk PRIMARY KEY (Id)
);

-- Table Pessoa
CREATE TABLE Pessoa (
    Id int    NOT NULL  AUTO_INCREMENT,
    PNome varchar(30)    NOT NULL ,
    UNome varchar(30)    NOT NULL ,
    Apelido varchar(30)    NOT NULL ,
    Telemovel varchar(15)    NULL ,
    Telefone varchar(15)    NULL ,
    CP varchar(30)    NULL ,
    Rua varchar(200)    NULL ,
    Porta int    NULL ,
    Cidade varchar(30)    NULL ,
    NumeroGNR varchar(20)    NOT NULL ,
    NumeroPosto varchar(20)    NOT NULL ,
    Ativo bool    NOT NULL ,
    DataIngresso date    NOT NULL ,
    Categoria_Id int    NOT NULL ,
    CONSTRAINT Pessoa_pk PRIMARY KEY (Id)
);

-- Table Servico
CREATE TABLE Servico (
    Id int    NOT NULL  AUTO_INCREMENT,
    HoraInicio time    NOT NULL ,
    HoraFim time    NOT NULL ,
    Data date    NOT NULL ,
    Observacao varchar(300)    NULL ,
    Numero int    NOT NULL ,
    Composicao varchar(500)    NULL ,
    Titulo varchar(100)    NULL ,
    Itenerario varchar(200)    NULL ,
    Viatura_Id int    NOT NULL ,
    TipoServico_Id int    NOT NULL ,
    FRadio varchar(15)    NULL ,
    DataInicio date    NOT NULL ,
    DataFim date    NOT NULL ,
    CONSTRAINT Servico_pk PRIMARY KEY (Id)
);

-- Table ServicoPessoa
CREATE TABLE ServicoPessoa (
    Id int    NOT NULL  AUTO_INCREMENT,
    Servico_Id int    NOT NULL ,
    Pessoa_Id int    NOT NULL ,
    Status int    NOT NULL ,
    Erro varchar(100)    NULL ,
    Data date    NOT NULL ,
    CONSTRAINT ServicoPessoa_pk PRIMARY KEY (Id)
);

-- Table TipoGratificado
CREATE TABLE TipoGratificado (
    Id int    NOT NULL  AUTO_INCREMENT,
    Nome varchar(100)    NOT NULL ,
    Prefixo varchar(10)    NOT NULL ,
    CONSTRAINT TipoGratificado_pk PRIMARY KEY (Id)
);

-- Table TipoServico
CREATE TABLE TipoServico (
    Id int    NOT NULL  AUTO_INCREMENT,
    Nome varchar(50)    NOT NULL ,
    Prefixo varchar(10)    NOT NULL ,
    HoraInicio int    NOT NULL ,
    HoraFim int    NOT NULL ,
    ServicoMinimo bool    NOT NULL ,
    CONSTRAINT TipoServico_pk PRIMARY KEY (Id)
);

-- Table Viatura
CREATE TABLE Viatura (
    Id int    NOT NULL  AUTO_INCREMENT,
    Descricao varchar(100)    NULL ,
    Matricula varchar(100)    NOT NULL ,
    CONSTRAINT Viatura_pk PRIMARY KEY (Id)
);





-- foreign keys
-- Reference:  GratificadoPessoa_Gratificado (table: GratificadoPessoa)


ALTER TABLE GratificadoPessoa ADD CONSTRAINT GratificadoPessoa_Gratificado FOREIGN KEY GratificadoPessoa_Gratificado (Gratificado_Id)
    REFERENCES Gratificado (Id);
-- Reference:  GratificadoPessoa_Pessoa (table: GratificadoPessoa)


ALTER TABLE GratificadoPessoa ADD CONSTRAINT GratificadoPessoa_Pessoa FOREIGN KEY GratificadoPessoa_Pessoa (Pessoa_Id)
    REFERENCES Pessoa (Id);
-- Reference:  Gratificado_TipoGratificado (table: Gratificado)


ALTER TABLE Gratificado ADD CONSTRAINT Gratificado_TipoGratificado FOREIGN KEY Gratificado_TipoGratificado (TipoGratificado_Id)
    REFERENCES TipoGratificado (Id);
-- Reference:  Gratificado_Viatura (table: Gratificado)


ALTER TABLE Gratificado ADD CONSTRAINT Gratificado_Viatura FOREIGN KEY Gratificado_Viatura (Viatura_Id)
    REFERENCES Viatura (Id);
-- Reference:  HabilitaServico_Pessoa (table: HabilitaServico)


ALTER TABLE HabilitaServico ADD CONSTRAINT HabilitaServico_Pessoa FOREIGN KEY HabilitaServico_Pessoa (Pessoa_Id)
    REFERENCES Pessoa (Id);
-- Reference:  HabilitaServico_TipoServico (table: HabilitaServico)


ALTER TABLE HabilitaServico ADD CONSTRAINT HabilitaServico_TipoServico FOREIGN KEY HabilitaServico_TipoServico (TipoServico_Id)
    REFERENCES TipoServico (Id);
-- Reference:  Pessoa_Categoria (table: Pessoa)


ALTER TABLE Pessoa ADD CONSTRAINT Pessoa_Categoria FOREIGN KEY Pessoa_Categoria (Categoria_Id)
    REFERENCES Categoria (Id);
-- Reference:  ServicoPessoa_Pessoa (table: ServicoPessoa)


ALTER TABLE ServicoPessoa ADD CONSTRAINT ServicoPessoa_Pessoa FOREIGN KEY ServicoPessoa_Pessoa (Pessoa_Id)
    REFERENCES Pessoa (Id);
-- Reference:  ServicoPessoa_Servico (table: ServicoPessoa)


ALTER TABLE ServicoPessoa ADD CONSTRAINT ServicoPessoa_Servico FOREIGN KEY ServicoPessoa_Servico (Servico_Id)
    REFERENCES Servico (Id);
-- Reference:  Servico_TipoServico (table: Servico)


ALTER TABLE Servico ADD CONSTRAINT Servico_TipoServico FOREIGN KEY Servico_TipoServico (TipoServico_Id)
    REFERENCES TipoServico (Id);
-- Reference:  Servico_Viatura (table: Servico)


ALTER TABLE Servico ADD CONSTRAINT Servico_Viatura FOREIGN KEY Servico_Viatura (Viatura_Id)
    REFERENCES Viatura (Id);



-- End of file.

