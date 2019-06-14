package io.github.leobugoni.fipe;

import io.github.leobugoni.ControllerIntegration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
public class FipeControllerIntegrationTest extends ControllerIntegration {

    private static final String ano = "2016-1";
    private static final String codMarca = "20";
    private static final String codModelo = "6095";
    private static final String anoModelo = "2016";
    private static final String codTipoVeiculo = "1";
    private static final String codReferencia = "238";
    private static final String tipoVeiculo = "carro";
    private static final String codigoTipoCombustivel = "1";
    private static final String tipoConsulta = "tradicional";

    @Test
    public void testConsultarValorComTodosParametros() throws Exception {
        final String contentBody = "ConsultarValorComTodosParametros?"
                                 + "codigoTipoVeiculo="+codTipoVeiculo+""
                                 + "&codigoTabelaReferencia="+codReferencia+""
                                 + "&codigoMarca="+codMarca+""
                                 + "&codigoModelo="+codModelo+""
                                 + "&ano="+ano+""
                                 + "&anoModelo="+anoModelo+""
                                 + "&codigoTipoCombustivel="+codigoTipoCombustivel+""
                                 + "&tipoVeiculo="+tipoVeiculo+""
                                 + "&tipoConsulta="+tipoConsulta+"";

        final MvcResult result = getMockMvc()
                                .perform(post("/fipe/consultar/")
                                .contentType(APPLICATION_JSON)
                                .content(contentBody))
                                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testConsultarModelosAtravesDoAno() throws Exception {
        final String contentBody = "ConsultarAnoModelo?"
                                 + "codigoTipoVeiculo="+codTipoVeiculo+""
                                 + "&codigoTabelaReferencia="+codReferencia+""
                                 + "&codigoMarca="+codMarca+""
                                 + "&codigoModelo="+codModelo+""
                                 + "&ano="+ano+""
                                 + "&anoModelo="+anoModelo+""
                                 + "&codigoTipoCombustivel="+codigoTipoCombustivel+"";

        final MvcResult result = getMockMvc()
                                .perform(post("/fipe/consultar/")
                                .contentType(APPLICATION_JSON)
                                .content(contentBody))
                                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testConsultarAnoModelos() throws Exception {
        final String contentBody = "ConsultarAnoModelo?"
                                 + "codigoTipoVeiculo="+codTipoVeiculo+""
                                 + "&codigoTabelaReferencia="+codReferencia+""
                                 + "&codigoMarca="+codMarca+""
                                 + "&codigoModelo="+codModelo+"";

        final MvcResult result = getMockMvc()
                                .perform(post("/fipe/consultar/")
                                .contentType(APPLICATION_JSON)
                                .content(contentBody))
                                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testConsultarModelos() throws Exception {
        final String contentBody = "ConsultarModelos?"
                                 + "codigoTipoVeiculo="+codTipoVeiculo+""
                                 + "&codigoTabelaReferencia="+codReferencia+""
                                 + "&codigoMarca="+codMarca+"";

        final MvcResult result = getMockMvc()
                                .perform(post("/fipe/consultar/")
                                .contentType(APPLICATION_JSON)
                                .content(contentBody))
                                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testConsultarMarcas() throws Exception {
        final String contentBody = "ConsultarMarcas?"
                                 + "codigoTabelaReferencia="+codReferencia+""
                                 + "&codigoTipoVeiculo="+codTipoVeiculo+"";

        final MvcResult result = getMockMvc()
                                .perform(post("/fipe/consultar/")
                                .contentType(APPLICATION_JSON)
                                .content(contentBody))
                                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testConsultarTabelaDeReferencia() throws Exception {
        final String contentBody = "ConsultarTabelaDeReferencia";

        final MvcResult result = getMockMvc()
                                .perform(post("/fipe/consultar/")
                                .contentType(APPLICATION_JSON)
                                .content(contentBody))
                                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }
}