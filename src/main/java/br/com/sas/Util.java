package br.com.sas;

/**
 * Created by thales on 11/30/15.
 */
public class Util {

    public static String returnTemplateJsonSaude(){
        StringBuffer a = new StringBuffer();

        a.append("{");
        a.append("  \"formatVersion\" : 1,");
        a.append("  \"passTypeIdentifier\" : \"pass.ciandt.prototype.sas\",");
        a.append("  \"serialNumber\" : \"8j23fm3\",");
        a.append("  \"teamIdentifier\" : \"DC7P966WU6\",");
        a.append("  \"barcode\" : {");
        a.append("    \"message\" : \"0254 2145 21445 2145\",");
        a.append("    \"format\" : \"PKBarcodeFormatPDF417\",");
        a.append("    \"messageEncoding\" : \"iso-8859-1\"");
        a.append("  },");
        a.append("  \"organizationName\" : \"Toy Town\",");
        a.append("  \"description\" : \"Toy Town Membership\",");
        a.append("  \"logoText\" : \"\",");
        a.append("  \"foregroundColor\" : \"rgb(244, 121, 43)\",");
        a.append("  \"backgroundColor\" : \"rgb(255, 255, 255)\",");
        a.append("  \"generic\" : {");
        a.append("    \"primaryFields\" : [");
        a.append("      {");
        a.append("        \"key\" : \"member\",");
        a.append("        \"value\" : \"Alex de Franca\"");
        a.append("      },");
        a.append("      {");
        a.append("        \"key\" : \"birth\",");
        a.append("        \"label\" : \"birth\",");
        a.append("        \"value\" : \"29/06/1972\"");
        a.append("      }");
        a.append("    ],");
        a.append("    \"secondaryFields\" : [");
        a.append("      {");
        a.append("        \"key\" : \"subtitle\",");
        a.append("        \"label\" : \"CODIGO DE IDENTIFICACAO\",");
        a.append("        \"value\" : \"0254 2145 21445 2145\"");
        a.append("      }");
        a.append("    ],");
        a.append("    \"auxiliaryFields\" : [");
        a.append("      {");
        a.append("        \"key\" : \"level\",");
        a.append("        \"label\" : \"PLANO\",");
        a.append("        \"value\" : \"Especial\"");
        a.append("      },");
        a.append("      {");
        a.append("        \"key\" : \"favorite\",");
        a.append("        \"label\" : \"ACOMODACAO\",");
        a.append("        \"value\" : \"Apartamento\"");
        a.append("      },");
        a.append("      {");
        a.append("        \"key\" : \"favorite2\",");
        a.append("        \"label\" : \"PRODUTO\",");
        a.append("        \"value\" : \"598\"");
        a.append("      }");
        a.append("    ],");
        a.append("");
        a.append("    \"backFields\" : [");
        a.append("      {");
        a.append("        \"label\" : \"Cobertura\",");
        a.append("        \"key\" : \"cobertura\",");
        a.append("        \"value\" : \"Ambulatorial + Hospitalar + Obstetricia\"");
        a.append("      },");
        a.append("");
        a.append("      {");
        a.append("        \"label\" : \"Empresa\",");
        a.append("        \"key\" : \"empresa\",");
        a.append("        \"value\" : \"00379 Sul America Companhia de seguro Saude\"");
        a.append("      },");
        a.append("");
        a.append("      {");
        a.append("        \"label\" : \"ANS\",");
        a.append("        \"key\" : \"ANS\",");
        a.append("        \"value\" : 416428");
        a.append("      },");
        a.append("      ");
        a.append("      {");
        a.append("        \"label\" : \"Nascimento\",");
        a.append("        \"key\" : \"timeFull\",");
        a.append("        \"value\" : \"29/06/1972\"");
        a.append("      }");
        a.append("    ]");
        a.append("  }");
        a.append("}");

        return a.toString();
    }
}
