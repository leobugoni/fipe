# Fipe API
Web service para consultar tabela [Fipe](https://veiculos.fipe.org.br/)

### Consultando fipe pelo [Postman](https://www.getpostman.com/)

#### 1- Subindo a aplicação

`mvn spring-boot:run`

#### 2- Criando Requisição

* No Postman altere o metodo para `POST`
* Preencha a URL `http://localhost:8080/fipe/consultar`
* Na aba `Body` selecione o tipo `raw` e adicione os parametros da consulta
`ConsultarValorComTodosParametros?codigoTabelaReferencia=243&codigoTipoVeiculo=1&codigoMarca=20&codigoModelo=6095&ano=2016-1&anoModelo=2016&codigoTipoCombustivel=1&tipoVeiculo=carro&tipoConsulta=tradicional`

##### O resultado deve ser o seguinte:
```json
{
    "Valor": "R$ 3.088.677,00",
    "Marca": "Ferrari",
    "Modelo": "FF F1 6.3 V12 660cv",
    "AnoModelo": 2016,
    "Combustivel": "Gasolina",
    "CodigoFipe": "031032-8",
    "MesReferencia": "junho de 2019 ",
    "Autenticacao": "p0gqvpd15wcz9",
    "TipoVeiculo": 1,
    "SiglaCombustivel": "G",
    "DataConsulta": "sexta-feira, 14 de junho de 2019 12:00"
}
```

### Lista de parametros para consultas

* Meses de referência `ConsultarTabelaDeReferencia`
* Marcas `ConsultarMarcas?codigoTabelaReferencia=243&codigoTipoVeiculo=1`
* Modelos `ConsultarModelos?codigoTabelaReferencia=243&codigoTipoVeiculo=1&codigoMarca=59`
* Anos `ConsultarAnoModelo?codigoTabelaReferencia=243&codigoTipoVeiculo=1&codigoMarca=59&codigoModelo=6809`

#### Ps. Ano 32000 é referente a veículo zero km

***
### _Aplicação para fins educacionais, não utilize comercialmente!_
