package net.lesmi;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Pickaxe {
	public static void main(String[] args) throws IOException {
		BufferedImage bi = ImageIO.read(Pickaxe.class.getResourceAsStream("/net/lesmi/iron_pickaxe.png"));
		int w = bi.getWidth();
		int h = bi.getHeight();
		int[] basePixels = bi.getRGB(0, 0, w, h, null, 0, w);
		if (args.length >= 1)
			processForColor(w, h, basePixels, Integer.valueOf(args[0]), args.length == 2 ? new File(args[1]) : null);
		else
			main2(w, h, basePixels);
	}

	public static void processForColor(int w, int h, int[] basePixels, int mask, File file) {
		if (file == null)
			file = new File("pickaxe_color_" + Integer.toHexString(mask).substring(1) + ".png");
		int[] px = Arrays.copyOf(basePixels, basePixels.length);
		process2(px, 6, 2, w, mask);
		process2(px, 7, 2, w, mask);
		process2(px, 8, 2, w, mask);
		process2(px, 9, 2, w, mask);
		process2(px, 10, 2, w, mask);

		process2(px, 5, 3, w, mask);
		process2(px, 6, 3, w, mask);
		process2(px, 7, 3, w, mask);
		process2(px, 8, 3, w, mask);
		process2(px, 9, 3, w, mask);
		process2(px, 10, 3, w, mask);
		process2(px, 11, 3, w, mask);

		process2(px, 6, 4, w, mask);
		process2(px, 7, 4, w, mask);
		process2(px, 8, 4, w, mask);
		process2(px, 9, 4, w, mask);
		process2(px, 10, 4, w, mask);
		process2(px, 11, 4, w, mask);

		process2(px, 11, 5, w, mask);
		process2(px, 12, 5, w, mask);
		process2(px, 13, 5, w, mask);

		process2(px, 12, 6, w, mask);
		process2(px, 13, 6, w, mask);
		process2(px, 14, 6, w, mask);

		process2(px, 12, 7, w, mask);
		process2(px, 13, 7, w, mask);
		process2(px, 14, 7, w, mask);

		process2(px, 12, 8, w, mask);
		process2(px, 13, 8, w, mask);
		process2(px, 14, 8, w, mask);

		process2(px, 12, 9, w, mask);
		process2(px, 13, 9, w, mask);
		process2(px, 14, 9, w, mask);

		process2(px, 12, 10, w, mask);
		process2(px, 13, 10, w, mask);
		process2(px, 14, 10, w, mask);

		process2(px, 13, 11, w, mask);

		BufferedImage result = new BufferedImage(w, h, BufferedImage.TYPE_4BYTE_ABGR);
		result.setRGB(0, 0, w, h, px, 0, w);
		try {
			ImageIO.write(result, "png", file);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public static void main2(int w, int h, int[] basePixels) {
		Arrays.asList(0xf1A237E, 0xf303F9F, 0xf9FA8DA, 0xf1565C0, 0xf0277BD, 0xf2E7D32, 0xf76FF03, 0xfEF6C00).stream()
				.forEach(mask -> processForColor(w, h, basePixels, mask, null));
	}

	public static void process2(int[] px, int x, int y, int w, int mask/* RRGGBB */) {
		int imageColor = px[y * w + x];// AARRGGBB
		// System.out.println(Integer.toHexString(imageColor));
		int imageR = imageColor >> 0 & 0xff;
		int imageG = imageColor >> 8 & 0xff;
		int imageB = imageColor >> 16 & 0xff;

		int maskR = (mask & 0xff0000) >> 16;
		int maskG = (mask & 0xff00) >> 8;
		int maskB = mask & 0xff;

		imageR = new BigDecimal(imageR)
				.multiply(new BigDecimal(maskR).divide(new BigDecimal(255), 100, RoundingMode.FLOOR)).intValue();
		imageG = new BigDecimal(imageG)
				.multiply(new BigDecimal(maskG).divide(new BigDecimal(255), 100, RoundingMode.FLOOR)).intValue();
		imageB = new BigDecimal(imageB)
				.multiply(new BigDecimal(maskB).divide(new BigDecimal(255), 100, RoundingMode.FLOOR)).intValue();

		px[y * w + x] = 0;
		px[y * w + x] |= imageColor & 0xff000000;
		px[y * w + x] |= (imageR & 0xff) << 16;
		px[y * w + x] |= (imageG & 0xff) << 8;
		px[y * w + x] |= (imageB & 0xff) << 0;
		// System.out.println(Integer.toHexString(px[y * w + x]));
	}
}
