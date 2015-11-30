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

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PassbookServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    resp.setContentType("application/vnd.apple.pkpass");
    ServletOutputStream out=resp.getOutputStream();
    ByteArrayInputStream inputStream;

    try {
      inputStream = PassbookService.geraPassbookSaude();

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
