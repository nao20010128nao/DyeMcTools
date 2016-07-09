package net.lesmi;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Axe {
	public static void main(String[] args) throws IOException {
		BufferedImage bi = ImageIO.read(Axe.class.getResourceAsStream("/net/lesmi/iron_axe.png"));
		int w = bi.getWidth();
		int h = bi.getHeight();
		int[] basePixels = bi.getRGB(0, 0, w, h, null, 0, w);
		if (args.length == 1)
			processForColor(w, h, basePixels, Integer.valueOf(args[0]));
		else
			main2(w, h, basePixels);
	}

	public static void processForColor(int w, int h, int[] basePixels, int mask) {
		int[] px = Arrays.copyOf(basePixels, basePixels.length);
		Pickaxe.process2(px, 9, 1, w, mask);
		Pickaxe.process2(px, 10, 1, w, mask);

		Pickaxe.process2(px, 8, 2, w, mask);
		Pickaxe.process2(px, 9, 2, w, mask);
		Pickaxe.process2(px, 10, 2, w, mask);
		Pickaxe.process2(px, 11, 2, w, mask);

		Pickaxe.process2(px, 7, 3, w, mask);
		Pickaxe.process2(px, 8, 3, w, mask);
		Pickaxe.process2(px, 9, 3, w, mask);
		Pickaxe.process2(px, 10, 3, w, mask);
		Pickaxe.process2(px, 11, 3, w, mask);

		Pickaxe.process2(px, 6, 4, w, mask);
		Pickaxe.process2(px, 7, 4, w, mask);
		Pickaxe.process2(px, 8, 4, w, mask);
		Pickaxe.process2(px, 9, 4, w, mask);
		Pickaxe.process2(px, 10, 4, w, mask);

		Pickaxe.process2(px, 6, 5, w, mask);
		Pickaxe.process2(px, 7, 5, w, mask);
		Pickaxe.process2(px, 8, 5, w, mask);
		Pickaxe.process2(px, 9, 5, w, mask);
		Pickaxe.process2(px, 10, 5, w, mask);
		Pickaxe.process2(px, 11, 5, w, mask);

		Pickaxe.process2(px, 7, 6, w, mask);
		Pickaxe.process2(px, 8, 6, w, mask);

		Pickaxe.process2(px, 10, 6, w, mask);
		Pickaxe.process2(px, 11, 6, w, mask);
		Pickaxe.process2(px, 12, 6, w, mask);
		Pickaxe.process2(px, 13, 6, w, mask);

		Pickaxe.process2(px, 11, 7, w, mask);
		Pickaxe.process2(px, 12, 7, w, mask);
		Pickaxe.process2(px, 13, 7, w, mask);

		Pickaxe.process2(px, 11, 8, w, mask);
		Pickaxe.process2(px, 12, 8, w, mask);

		BufferedImage result = new BufferedImage(w, h, BufferedImage.TYPE_4BYTE_ABGR);
		result.setRGB(0, 0, w, h, px, 0, w);
		try {
			ImageIO.write(result, "png",
					new File("axe_color_" + Integer.toHexString(mask).substring(1) + ".png"));
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public static void main2(int w, int h, int[] basePixels) {
		Arrays.asList(0xf1A237E, 0xf303F9F, 0xf9FA8DA, 0xf1565C0, 0xf0277BD, 0xf2E7D32, 0xf76FF03, 0xfEF6C00).stream()
				.forEach(mask -> processForColor(w, h, basePixels, mask));
	}
}
