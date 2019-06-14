package io.github.leobugoni.fipe.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Controller
public class FipeController {

    @RequestMapping(value = "/fipe/consultar/", method = RequestMethod.POST, produces = "application/json")
    public String consultar(@RequestBody String parametros) {
        try {
            HttpPost request = new HttpPost("http://veiculos.fipe.org.br/api/veiculos/"+parametros);
            request.addHeader("Host", request.getURI().getHost());
            request.addHeader("Referer", "http://www.fipe.org.br/pt-br/home");
            final HttpResponse response = HttpClientBuilder.create().build().execute(request);
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            final StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            final String result = new ObjectMapper().readTree(stringBuilder.toString()).toString();
            System.err.println(result);
            return result;
        } catch (final Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
