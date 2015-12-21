/**
 * Copyright 2014-2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//[START all]
package br.com.sas;

import br.com.sas.model.Saude;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PassbookServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("application/vnd.apple.pkpass");
    resp.setHeader("Content-Disposition","attachment; filename=\"saude.pkpass\"");
    ServletOutputStream out=resp.getOutputStream();
    ByteArrayInputStream inputStream;

    try {

      Saude saude = new Saude();
      saude.setNome("Paulo da Silva");
      saude.setCarterinha("1254 2568 5412 5412");
      saude.setPlano("Especial");
      saude.setAcomodacao("Apartamento");
      saude.setProduto("598");
      saude.setCobertura("Ambulatorial + Hospitalar + Obstreticia");
      saude.setEmpresa("00379 Sul America Companinha de Seguro Saúde");
      saude.setAns("416428");
      saude.setNascimento("29/06/1972");

      inputStream = PassbookService.geraPassbookSaude(saude);

      if(inputStream != null){
        int value;
        while ((value=inputStream.read()) != -1) {
          out.write(value);
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
      resp.setContentType("text/plain");
      out.print("erro:" + e.getMessage());
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("application/vnd.apple.pkpass; filename=\"saude.pkpass\"");
    resp.setHeader("Content-Disposition","attachment; filename=\"saude.pkpass\"");
    ServletOutputStream out=resp.getOutputStream();
    ByteArrayInputStream inputStream;

    try {

      Saude saude = new Saude();

      saude.setNome(req.getParameter("nome"));
      saude.setCarterinha(req.getParameter("carterinha"));
      saude.setPlano(req.getParameter("plano"));
      saude.setAcomodacao(req.getParameter("acomodacao"));
      saude.setProduto(req.getParameter("produto"));
      saude.setCobertura(req.getParameter("cobertura"));
      saude.setEmpresa(req.getParameter("empresa"));
      saude.setAns(req.getParameter("ans"));
      saude.setNascimento(req.getParameter("nascimento"));

      inputStream = PassbookService.geraPassbookSaude(saude);

      if(inputStream != null){
        int value;
        while ((value=inputStream.read()) != -1) {
          out.write(value);
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
      resp.setContentType("text/plain");
      out.print("erro:" + e.getMessage());
    }
  }
}
