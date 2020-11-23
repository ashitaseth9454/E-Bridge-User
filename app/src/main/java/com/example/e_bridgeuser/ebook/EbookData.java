package com.example.e_bridgeuser.ebook;

public class EbookData {
    String pdfTitle, pdfUrl;

    public EbookData() {
    }

    public EbookData(String name, String pdfUrl) {
        this.pdfTitle = name;
        this.pdfUrl = pdfUrl;
    }

    public String getPdfTitle() {
        return pdfTitle;
    }

    public void setPdfTitle(String name) {
        this.pdfTitle = name;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
