package com.jackyting.code.zxing;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 利用google的zxing库生成二维码
 * 
 * @author jackyting1025
 *
 */
public class CreateQRCode {

	public static void main(String[] args) {

		int width = 300;
		int height = 300;
		String format = "png";
		String content = "www.baizhongyun.cn";

		// 定义二维码的参数
		HashMap hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);

		try {
			BitMatrix matrix = new MultiFormatWriter().encode(content,
					BarcodeFormat.QR_CODE, width, height, hints);
			Path file = new File("/home/jackyting1025/Desktop/code.png")
					.toPath();
			MatrixToImageWriter.writeToPath(matrix, format, file);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
