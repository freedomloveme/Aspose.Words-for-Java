package com.aspose.words.examples.loading_saving;

import com.aspose.words.Document;
import com.aspose.words.MsWordVersion;
import com.aspose.words.OoxmlCompliance;
import com.aspose.words.OoxmlSaveOptions;
import com.aspose.words.SaveFormat;
import com.aspose.words.examples.Utils;

public class WorkingWithOoXML {
	public static void main(String[] args) throws Exception {
        String dataDir = Utils.getDataDir(WorkingWithOoXML.class);

        encryptDocxWithPassword(dataDir);
        setOOXMLCompliance(dataDir);
        updateLastSavedTimeProperty(dataDir);
        keepLegacyControlChars(dataDir);
    }

    public static void encryptDocxWithPassword(String dataDir) throws Exception {
        // ExStart:encryptDocxWithPassword
        Document doc = new Document(dataDir + "Document.doc");
        
        OoxmlSaveOptions ooxmlSaveOptions = new OoxmlSaveOptions();
        ooxmlSaveOptions.setPassword("password");
        
        dataDir = dataDir + "Document.Password_out.docx";
        doc.save(dataDir, ooxmlSaveOptions);
        // ExEnd:encryptDocxWithPassword
        System.out.println("\nDocument saved with Password Encryption.\nFile saved at " + dataDir);
    }

    public static void setOOXMLCompliance(String dataDir) throws Exception {
        // ExStart:setOOXMLCompliance
        Document doc = new Document(dataDir + "Document.doc");
        
        // Set Word2016 version for document
        doc.getCompatibilityOptions().optimizeFor(MsWordVersion.WORD_2016);

        //Set the Strict compliance level. 
        OoxmlSaveOptions ooxmlSaveOptions = new OoxmlSaveOptions();
        ooxmlSaveOptions.setCompliance(OoxmlCompliance.ISO_29500_2008_STRICT);
        ooxmlSaveOptions.setSaveFormat(SaveFormat.DOCX);
        
        dataDir = dataDir + "Document.Iso29500_2008_Strict_out.docx";
        doc.save(dataDir, ooxmlSaveOptions);
        // ExEnd:setOOXMLCompliance
        System.out.println("\nDocument saved with compliance settings.\nFile saved at " + dataDir);
    }

    public static void updateLastSavedTimeProperty(String dataDir) throws Exception {
        //ExStart:updateLastSavedTimeProperty
    	Document doc = new Document(dataDir + "Document.doc");
    	
    	OoxmlSaveOptions ooxmlSaveOptions = new OoxmlSaveOptions();
    	
    	ooxmlSaveOptions.setUpdateLastSavedTimeProperty(true);

    	dataDir = dataDir + "UpdateLastSavedTimeProperty_out.docx";

    	doc.save(dataDir, ooxmlSaveOptions);
        //ExEnd:updateLastSavedTimeProperty
        System.out.println("\nDocument saved with Update Laset Saved Time proprty to true.\nFile saved at " + dataDir);
    }

    public static void keepLegacyControlChars(String dataDir) throws Exception {
        //ExStart:keepLegacyControlChars
    	Document doc = new Document(dataDir + "Document.doc");

    	OoxmlSaveOptions ooxmlSaveOptions = new OoxmlSaveOptions(SaveFormat.FLAT_OPC);
    	ooxmlSaveOptions.setKeepLegacyControlChars(true);

    	dataDir = dataDir + "Document_out.docx";
    	doc.save(dataDir, ooxmlSaveOptions);
        //ExEnd:keepLegacyControlChars
        System.out.println("\nDocument saved with keeping legacy control character.\nFile saved at " + dataDir);
    }
}
