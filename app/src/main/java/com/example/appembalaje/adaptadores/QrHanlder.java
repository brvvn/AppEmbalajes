package com.example.appembalaje.adaptadores;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QrHanlder {

    public void ReadCode(Activity activity,int tipoLector){
        String codigo = (tipoLector==1) ? IntentIntegrator.QR_CODE:IntentIntegrator.EAN_13;
        Boolean beep= (tipoLector==1) ? Boolean.FALSE:Boolean.TRUE;
        IntentIntegrator integrador = new IntentIntegrator(activity);
        integrador.setDesiredBarcodeFormats(codigo);
        integrador.setCameraId(0);
        integrador.setBeepEnabled(beep);
        integrador.setBarcodeImageEnabled(true);
        integrador.setOrientationLocked(true);
        integrador.initiateScan();
    }

    public Object GenerateQrCode(String data){
        QRCodeWriter writer = new QRCodeWriter();
        try {
            BitMatrix bitmatrix = writer.encode(data,BarcodeFormat.QR_CODE,400,400);
            BarcodeEncoder encoder = new BarcodeEncoder();
            Bitmap bmp =encoder.createBitmap(bitmatrix);
            return bmp;
        }catch (WriterException e){
            return e.toString();
        }


    }

}
