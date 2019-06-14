package io.github.leobugoni.fipe.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Controller
public class FipeController {

    @PostMapping(value = "/fipe/consultar/")
    public String consultar(@RequestBody String parametros) {
        try {
            HttpPost request = new HttpPost("http://veiculos.fipe.org.br/api/veiculos/"+parametros);
            request.addHeader("Content-Type", "application/json; charset=utf-8");
            request.addHeader("Host", request.getURI().getHost());
            request.addHeader("Referer", "http://www.fipe.org.br/pt-br/home");

            HttpResponse response = HttpClientBuilder.create().build().execute(request);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            return new ObjectMapper().readTree(result.toString()).toString();
        } catch (final Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
