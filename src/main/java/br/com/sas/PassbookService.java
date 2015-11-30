package br.com.sas;

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
    private static String appleWWDRCA = "passbook/AppleWWDRCA.cer"; // this is apple's developer relation cert
    private static String privateKeyPath = "passbook/privateKey.p12"; // the private key you exported from keychain
    private static String privateKeyPassword = ""; // the password you used to export
    private static String templateSaude = "templateSaude.raw"; // the password you used to export

    public static ByteArrayInputStream geraPassbookSaude() throws Exception{
        return geraPassbook(templateSaude, Util.returnTemplateJsonSaude());
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
