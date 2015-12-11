package br.com.sas;

import br.com.sas.model.Saude;

/**
 * Created by thales on 11/30/15.
 */
public class Util {

    public static String returnTemplateJsonSaude(Saude saude){
        StringBuffer a = new StringBuffer();

        a.append("{");
        a.append("  \"formatVersion\" : 1,");
        a.append("  \"passTypeIdentifier\" : \"pass.ciandt.prototype.sas\",");
        a.append("  \"serialNumber\" : \" ").append(saude.getCarterinha()).append("\",");
        a.append("  \"teamIdentifier\" : \"DC7P966WU6\",");
        a.append("  \"barcode\" : {");
        a.append("    \"message\" : \"").append(saude.getCarterinha()).append("\",");
        a.append("    \"format\" : \"PKBarcodeFormatPDF417\",");
        a.append("    \"messageEncoding\" : \"iso-8859-1\"");
        a.append("  },");
        a.append("  \"organizationName\" : \"Sulamerica saúde\",");
        a.append("  \"description\" : \"Sulamerica segurado\",");
        a.append("  \"logoText\" : \"\",");
        a.append("  \"foregroundColor\" : \"rgb(244, 121, 43)\",");
        a.append("  \"backgroundColor\" : \"rgb(255, 255, 255)\",");
        a.append("  \"generic\" : {");
        a.append("    \"primaryFields\" : [");
        a.append("      {");
        a.append("        \"key\" : \"member\",");
        a.append("        \"value\" : \"").append(saude.getNome()).append("\"");
        a.append("      },");
        a.append("      {");
        a.append("        \"key\" : \"birth\",");
        a.append("        \"label\" : \"birth\",");
        a.append("        \"value\" : \"").append(saude.getNascimento()).append("\"");
        a.append("      }");
        a.append("    ],");
        a.append("    \"secondaryFields\" : [");
        a.append("      {");
        a.append("        \"key\" : \"subtitle\",");
        a.append("        \"label\" : \"CODIGO DE IDENTIFICACAO\",");
        a.append("        \"value\" : \"").append(saude.getCarterinha()).append("\"");
        a.append("      }");
        a.append("    ],");
        a.append("    \"auxiliaryFields\" : [");
        a.append("      {");
        a.append("        \"key\" : \"level\",");
        a.append("        \"label\" : \"PLANO\",");
        a.append("        \"value\" : \"").append(saude.getPlano()).append("\"");
        a.append("      },");
        a.append("      {");
        a.append("        \"key\" : \"favorite\",");
        a.append("        \"label\" : \"ACOMODACAO\",");
        a.append("        \"value\" : \"").append(saude.getAcomodacao()).append("\"");
        a.append("      },");
        a.append("      {");
        a.append("        \"key\" : \"favorite2\",");
        a.append("        \"label\" : \"PRODUTO\",");
        a.append("        \"value\" : \"").append(saude.getProduto()).append("\"");
        a.append("      }");
        a.append("    ],");
        a.append("");
        a.append("    \"backFields\" : [");
        a.append("      {");
        a.append("        \"label\" : \"Cobertura\",");
        a.append("        \"key\" : \"cobertura\",");
        a.append("        \"value\" : \"").append(saude.getCobertura()).append("\"");
        a.append("      },");
        a.append("");
        a.append("      {");
        a.append("        \"label\" : \"Empresa\",");
        a.append("        \"key\" : \"empresa\",");
        a.append("        \"value\" : \"").append(saude.getEmpresa()).append("\"");
        a.append("      },");
        a.append("");
        a.append("      {");
        a.append("        \"label\" : \"ANS\",");
        a.append("        \"key\" : \"ANS\",");
        a.append("        \"value\" : ").append(saude.getAns()).append("");
        a.append("      },");
        a.append("      ");
        a.append("      {");
        a.append("        \"label\" : \"Nascimento\",");
        a.append("        \"key\" : \"timeFull\",");
        a.append("        \"value\" : \"").append(saude.getNascimento()).append("\"");
        a.append("      }");
        a.append("    ]");
        a.append("  }");
        a.append("}");

        return a.toString();
    }

    public static String returnTemplateJsonCardSaude(Saude saude){
        StringBuffer a = new StringBuffer();

        a.append("{");
        a.append("  \"formatVersion\" : 1,");
        a.append("  \"passTypeIdentifier\" : \"pass.ciandt.prototype.sas\",");
        a.append("  \"serialNumber\" : \"").append(saude.getCarterinha()).append("\",");
        a.append("  \"teamIdentifier\" : \"DC7P966WU6\",");
        a.append("  \"barcode\" : {");
        a.append("    \"message\" : \"").append(saude.getCarterinha()).append("\",");
        a.append("    \"format\" : \"PKBarcodeFormatPDF417\",");
        a.append("    \"messageEncoding\" : \"iso-8859-1\"");
        a.append("  },");
        a.append("  \"organizationName\" : \"Sulamerica saúde\",");
        a.append("  \"description\" : \"Sulamerica segurado\",");
        a.append("  \"foregroundColor\" : \"rgb(255, 255, 255)\",");
        a.append("  \"backgroundColor\" : \"rgb(27, 54, 93)\",");
        a.append("  \"storeCard\" : {");

        a.append("  \"headerFields\" : [");
        a.append("  {");
        a.append("      \"key\" : \"balances\",");
        a.append("      \"label\" : \"\",");
        a.append("      \"value\" : \"Passbook SulAmerica\",");
        a.append("  }");
        a.append("  ],");

        a.append("    \"primaryFields\" : [");
        a.append("      {");
        a.append("        \"key\" : \"balance\",");
        a.append("        \"label\" : \"\",");
        a.append("        \"value\" : \"").append(saude.getCarterinha()).append("\",");
        a.append("      }");
        a.append("    ],");
        a.append("    \"auxiliaryFields\" : [");
        a.append("      {");
        a.append("        \"key\" : \"deal\",");
        a.append("        \"label\" : \"SEGURADO\",");
        a.append("        \"value\" : \"").append(saude.getNome()).append("\"");
        a.append("      },");
        a.append("      {");
        a.append("        \"key\" : \"level\",");
        a.append("        \"label\" : \"PLANO\",");
        a.append("        \"value\" : \"").append(saude.getPlano()).append("\"");
        a.append("      }");
        a.append("    ],");

        a.append("    \"backFields\" : [");
        a.append("      {");
        a.append("        \"key\" : \"favorite\",");
        a.append("        \"label\" : \"ACOMODACAO\",");
        a.append("        \"value\" : \"").append(saude.getAcomodacao()).append("\"");
        a.append("      },");
        a.append("      {");
        a.append("        \"key\" : \"favorite2\",");
        a.append("        \"label\" : \"PRODUTO\",");
        a.append("        \"value\" : \"").append(saude.getProduto()).append("\"");
        a.append("      },");
        a.append("      {");
        a.append("        \"label\" : \"COBERTURA\",");
        a.append("        \"key\" : \"cobertura\",");
        a.append("        \"value\" : \"").append(saude.getCobertura()).append("\"");
        a.append("      },");

        a.append("      {");
        a.append("        \"label\" : \"EMPRESA\",");
        a.append("        \"key\" : \"empresa\",");
        a.append("        \"value\" : \"").append(saude.getEmpresa()).append("\"");
        a.append("      },");

        a.append("      {");
        a.append("        \"label\" : \"ANS\",");
        a.append("        \"key\" : \"ANS\",");
        a.append("        \"value\" : ").append(saude.getAns()).append(",");
        a.append("      },");

        a.append("      {");
        a.append("        \"label\" : \"NASCIMENTO\",");
        a.append("        \"key\" : \"timeFull\",");
        a.append("        \"value\" : \"").append(saude.getNascimento()).append("\"");
        a.append("      }");
        a.append("    ]");
        a.append("  }");
        a.append("}");

        return a.toString();
    }

}
