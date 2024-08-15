-- database: ../Database/CMEcuafauna.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| max_inmc@outlook.com           mxavc   |
|----------------------------------------|
Autor : mxavc 
Fecha : 15.agosto.2k24
Script: Insertando datos
*/

INSERT INTO CMCatalogoTipo
 ( Nombre                  ,Descripcion )  VALUES
 ('HormigaTipo'            ,'Obrera, reina y soldado')
,('Sexo'                   ,'Macho, hembra, asexual')
,('AlimentoTipo'           ,'Ingesta Nativa, GenoAlimento')              
,('Pais'                   ,'Pais, region, provincia');

UPDATE CMCatalogoTipo
SET Nombre = upper(Nombre), Descripcion = UPPER(Descripcion)
WHERE IdCMCatalogoTipo IN (1,2,3,4);

INSERT INTO CMCatalogo
 (IdCMCatalogoTipo     ,Nombre           ,Descripcion) VALUES 
 (1                   ,'Obrera'          ,'Trabajos de la colonia') --1
,(1                   ,'Reina'           ,'Solo para reproduccion') --2
,(1                   ,'Soldado'         ,'Defiende la colonia')    --3

,(2                   ,'Macho'           ,'Se puede reproducir')    --4
,(2                   ,'Hembra'          ,'Tiene crias')            --5
,(2                   ,'Asexual'         ,'No se reproduce')        --6

,(3                   ,'Ingesta Nativa'  ,'Comida Natural')         --7
,(3                   ,'GenoAlimento'    ,'Alimentos Modificados')  --8

,(4                   ,'Ecuador'          ,'Pais');                 --9


UPDATE CMCatalogo
SET Nombre = upper(Nombre), Descripcion = UPPER(Descripcion)
WHERE IdCMCatalogo BETWEEN 1 AND 9;

INSERT INTO CMCatalogoRegion
(IdCMCatalogo     , Nombre          , Descripcion) VALUES
 (9               ,'Costa'          ,'Ambiente humedo')
,(9               ,'Sierra'         ,'Ambiente frio')
,(9               ,'Amazonia'       ,'Ambiente calido')
,(9               ,'Insular'        ,'Ambiente tropical');

UPDATE CMCatalogoRegion
SET Nombre = upper(Nombre), Descripcion = UPPER(Descripcion)
WHERE IdCMCatalogoRegion BETWEEN 1 AND 4;

INSERT INTO CMCatalogoProvincia
(IdCMCatalogoRegion     , Nombre                , Descripcion) VALUES
 (  1                   ,'Esmeraldas'           ,'Provincia de la Costa')  -- 1
,(  1                   ,'Manabi'               ,'Provincia de la Costa')  -- 2
,(  1                   ,'Guayas'               ,'Provincia de la Costa')  -- 3
,(  1                   ,'Santa Elena'          ,'Provincia de la Costa')  -- 4
,(  1                   ,'Los Rios'             ,'Provincia de la Costa')  -- 5
,(  1                   ,'El Oro'               ,'Provincia de la Costa')  -- 6

,(  2                   ,'Carchi'               ,'Provincia de la Sierra')   -- 7
,(  2                   ,'Imbabura'             ,'Provincia de la Sierra')   -- 8
,(  2                   ,'Santo Domingo'        ,'Provincia de la Sierra')   -- 9
,(  2                   ,'Pichincha'            ,'Provincia de la Sierra')   -- 10
,(  2                   ,'Cotopaxi'             ,'Provincia de la Sierra')   -- 11
,(  2                   ,'Tunguragua'           ,'Provincia de la Sierra')   -- 12
,(  2                   ,'Bolivar'              ,'Provincia de la Sierra')   -- 13
,(  2                   ,'Chimborazo'           ,'Provincia de la Sierra')   -- 14
,(  2                   ,'Cañar'                ,'Provincia de la Sierra')   -- 15
,(  2                   ,'Azuay'                ,'Provincia de la Sierra')   -- 16
,(  2                   ,'Loja'                 ,'Provincia de la Sierra')   -- 17

,(  3                   ,'Orellana'             ,'Provincia del Oriente')       -- 18
,(  3                   ,'Pastaza'              ,'Provincia del Oriente')       -- 19
,(  3                   ,'Napo'                 ,'Provincia del Oriente')       -- 20
,(  3                   ,'Sucumbios'            ,'Provincia del Oriente')       -- 21
,(  3                   ,'Morona Santiago'      ,'Provincia del Oriente')       -- 22
,(  3                   ,'Zamora Chinchipe'     ,'Provincia del Oriente')       -- 23

,(  4                   ,'Galapagos'       ,'Provincia Insular');      --24

UPDATE CMCatalogoProvincia
SET Nombre = upper(Nombre), Descripcion = UPPER(Descripcion)
WHERE IdCMCatalogoProvincia BETWEEN 1 AND 24;

INSERT INTO CMCatalogoAlimento
 (IdCMCatalogo        ,Nombre             ,Descripcion) VALUES
 (7                   ,'Carnivoro'        , 'Alimento de origen animal')
,(7                   ,'Herviboro'        , 'Alimento Modificado')
,(7                   ,'Omnivoro'         ,'Carnes y plantas')
,(7                   ,'Insectivoro'      ,'Solo insectos')

,(8                   ,'X'                ,'Genoalimento')
,(8                   ,'XY'               ,'Genoalimento')
,(8                   ,'XX'               ,'Genoalimento');

UPDATE CMCatalogoAlimento
SET Nombre = upper(Nombre), Descripcion = UPPER(Descripcion)
WHERE IdCMCatalogoAlimento IN (1,2,3,4,5,6,7);


INSERT INTO CMHormiga
 (IdCMHormigaTipo    ,IdCMSexo   ,IdCMCatalogoProvincia  ,IdCMCatalogoModificado  ,IdCMCatalogoNativo) VALUES
 (1                   ,4           ,2                     ,5                       ,4)
,(2                   ,5           ,7                     ,6                       ,3)       
,(3                   ,6           ,18                     ,7                       ,2);       
