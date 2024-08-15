-- database: ../Database/CMEcuafauna.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| max_inm@outlook.com           mxavc    |
|----------------------------------------|
Autor : mxavc 
Fecha : 14.agosto.2k24
Script: Creacion de la estructura de datos para EcuaFauna
*/

DROP TABLE IF EXISTS CMHormiga;
DROP TABLE IF EXISTS CMCatalogoProvincia;
DROP TABLE IF EXISTS CMCatalogoRegion;
DROP TABLE IF EXISTS CMCatalogoAlimento;
DROP TABLE IF EXISTS CMCatalogo; 
DROP TABLE IF EXISTS CMCatalogoTipo; 

CREATE TABLE CMCatalogoTipo (
     IdCMCatalogoTipo       INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre                 VARCHAR(40) NOT NULL UNIQUE
    ,Descripcion            VARCHAR(90)  

    ,Estado                 VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion          DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica          DATETIME
); 

CREATE TABLE CMCatalogo (
     IdCMCatalogo               INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdCMCatalogoTipo           INTEGER     NOT NULL REFERENCES CMCatalogoTipo (IdCMCatalogoTipo)
    ,Nombre                     VARCHAR(40) NOT NULL UNIQUE
    ,Descripcion                VARCHAR(90)   
    
    ,Estado                     VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion  DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica  DATETIME
); 

CREATE TABLE CMCatalogoAlimento (
     IdCMCatalogoAlimento           INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdCMCatalogo                   INTEGER     NOT NULL REFERENCES CMCatalogo (IdCMCatalogo)
    ,Nombre                         VARCHAR(30) NOT NULL UNIQUE
    ,Descripcion                    VARCHAR(90)   

    ,Estado                         VARCHAR(1)  NOT NULL DEFAULT('A')    
    ,FechaCreacion                  DATETIME DEFAULT(datetime('now','localtime'))
    ,FechaModifica                  DATETIME
);

CREATE TABLE CMCatalogoRegion (
     IdCMCatalogoRegion           INTEGER primary key autoincrement
    ,IdCMCatalogo                 INTEGER NOT NULL REFERENCES CMCatalogo(IdCMCatalogo)
    ,Nombre                       TEXT NOT NULL UNIQUE
    ,Descripcion                  TEXT
    
    ,FechaCreacion                  DATETIME DEFAULT(datetime('now','localtime'))
    ,FechaModifica                  DATETIME
);
CREATE TABLE CMCatalogoProvincia (
     IdCMCatalogoProvincia           integer primary key autoincrement
    ,IdCMCatalogoRegion              integer NOT NULL REFERENCES CMCatalogoRegion (IdCMCatalogoRegion)
    ,Nombre                          TEXT NOT NULL
    ,Descripcion                     VARCHAR(90)

    ,Estado                         VARCHAR(1)  NOT NULL DEFAULT('A')    
    ,FechaCreacion                  DATETIME DEFAULT(datetime('now','localtime'))
    ,FechaModifica                  DATETIME
);
CREATE TABLE CMHormiga (
     IdCMHormiga                INTEGER primary key autoincrement
    ,IdCMHormigaTipo                INTEGER NOT NULL REFERENCES CMCatalogo(IdCMCatalogo) 
    ,IdCMSexo                   integer NOT NULL REFERENCES CMCatalogo(IdCMCatalogo) 
    ,IdCMCatalogoProvincia              integer NOT NULL REFERENCES CMCatalogoProvincia(IdCMCatalogoProvincia)
    ,IdCMCatalogoModificado     integer NOT NULL REFERENCES CMCatalogoAlimento(IdCMCatalogoAlimento)
    ,IdCMCatalogoNativo         integer NOT NULL REFERENCES CMCatalogoAlimento(IdCMCatalogoAlimento)
    
    ,Estado                     VARCHAR(1)  NOT NULL DEFAULT('A') CHECK (Estado IN ('A','I'))
    ,FechaCreacion              DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica              DATETIME
);

