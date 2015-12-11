package br.com.sas;

import br.com.sas.model.Saude;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.brendamour.jpasskit.signing.PKInMemorySigningUtil;
import de.brendamour.jpasskit.signing.PKPassTemplateFolder;
import de.brendamour.jpasskit.signing.PKSigningInformation;
import de.brendamour.jpasskit.signing.PKSigningInformationUtil;

import java.io.ByteArrayInputStream;

/**
 * Created by thales on 11/30/15.
 */
public class PassbookService {
    private static String appleWWDRCA = "passbook/AppleWWDRCA.cer";
    private static String privateKeyPath = "passbook/privateKey.p12";
    private static String templateSaude = "templateSaude.raw";
    private static String templateCardSaude = "templateSaude.raw";

    public static ByteArrayInputStream geraPassbookSaude(Saude saude) throws Exception{
        return geraPassbook(templateSaude, Util.returnTemplateJsonSaude(saude));
    }

    public static ByteArrayInputStream geraPassbookCardSaude(Saude saude) throws Exception{
        return geraPassbook(templateCardSaude, Util.returnTemplateJsonCardSaude(saude));
    }

    public static ByteArrayInputStream geraPassbook(String template, String templateJson) throws Exception {
        PKSigningInformation pkSigningInformation = new PKSigningInformationUtil().loadSigningInformationFromPKCS12AndIntermediateCertificate(
                privateKeyPath, privateKeyPassword, appleWWDRCA);

        PKInMemorySigningUtil pkInMemorySigningUtil = new PKInMemorySigningUtil(new ObjectMapper());

        PKPassTemplateFolder pkPassTemplateFolder = new PKPassTemplateFolder(template);
        byte[] signedAndZippedPkPassArchive = pkInMemorySigningUtil.createSignedAndZippedPkPassArchive(templateJson, pkPassTemplateFolder,
                pkSigningInformation);
        return new ByteArrayInputStream(signedAndZippedPkPassArchive);
    }
}
