package net.lesmi;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Sword {
	public static void main(String[] args) throws IOException {
		BufferedImage bi = ImageIO.read(Sword.class.getResourceAsStream("/net/lesmi/iron_sword.png"));
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
		Pickaxe.process2(px, 13, 0, w, mask);
		Pickaxe.process2(px, 14, 0, w, mask);
		Pickaxe.process2(px, 15, 0, w, mask);

		Pickaxe.process2(px, 12, 1, w, mask);
		Pickaxe.process2(px, 13, 1, w, mask);
		Pickaxe.process2(px, 14, 1, w, mask);
		Pickaxe.process2(px, 15, 1, w, mask);

		Pickaxe.process2(px, 11, 2, w, mask);
		Pickaxe.process2(px, 12, 2, w, mask);
		Pickaxe.process2(px, 13, 2, w, mask);
		Pickaxe.process2(px, 14, 2, w, mask);
		Pickaxe.process2(px, 15, 2, w, mask);

		Pickaxe.process2(px, 10, 3, w, mask);
		Pickaxe.process2(px, 11, 3, w, mask);
		Pickaxe.process2(px, 12, 3, w, mask);
		Pickaxe.process2(px, 13, 3, w, mask);
		Pickaxe.process2(px, 14, 3, w, mask);

		Pickaxe.process2(px, 9, 4, w, mask);
		Pickaxe.process2(px, 10, 4, w, mask);
		Pickaxe.process2(px, 11, 4, w, mask);
		Pickaxe.process2(px, 12, 4, w, mask);
		Pickaxe.process2(px, 13, 4, w, mask);

		Pickaxe.process2(px, 8, 5, w, mask);
		Pickaxe.process2(px, 9, 5, w, mask);
		Pickaxe.process2(px, 10, 5, w, mask);
		Pickaxe.process2(px, 11, 5, w, mask);
		Pickaxe.process2(px, 12, 5, w, mask);

		Pickaxe.process2(px, 7, 6, w, mask);
		Pickaxe.process2(px, 8, 6, w, mask);
		Pickaxe.process2(px, 9, 6, w, mask);
		Pickaxe.process2(px, 10, 6, w, mask);
		Pickaxe.process2(px, 11, 6, w, mask);

		Pickaxe.process2(px, 6, 7, w, mask);
		Pickaxe.process2(px, 7, 7, w, mask);
		Pickaxe.process2(px, 8, 7, w, mask);
		Pickaxe.process2(px, 9, 7, w, mask);
		Pickaxe.process2(px, 10, 7, w, mask);

		Pickaxe.process2(px, 6, 8, w, mask);
		Pickaxe.process2(px, 7, 8, w, mask);
		Pickaxe.process2(px, 8, 8, w, mask);
		Pickaxe.process2(px, 9, 8, w, mask);

		Pickaxe.process2(px, 2, 6, w, mask);
		Pickaxe.process2(px, 3, 6, w, mask);

		Pickaxe.process2(px, 2, 7, w, mask);
		Pickaxe.process2(px, 3, 7, w, mask);
		Pickaxe.process2(px, 4, 7, w, mask);

		Pickaxe.process2(px, 3, 8, w, mask);
		Pickaxe.process2(px, 4, 8, w, mask);
		Pickaxe.process2(px, 5, 8, w, mask);

		Pickaxe.process2(px, 3, 9, w, mask);
		Pickaxe.process2(px, 4, 9, w, mask);
		Pickaxe.process2(px, 5, 9, w, mask);

		Pickaxe.process2(px, 4, 10, w, mask);
		Pickaxe.process2(px, 5, 10, w, mask);
		Pickaxe.process2(px, 6, 10, w, mask);
		Pickaxe.process2(px, 7, 10, w, mask);

		Pickaxe.process2(px, 5, 11, w, mask);
		Pickaxe.process2(px, 6, 11, w, mask);
		Pickaxe.process2(px, 7, 11, w, mask);
		Pickaxe.process2(px, 8, 11, w, mask);

		Pickaxe.process2(px, 6, 12, w, mask);
		Pickaxe.process2(px, 7, 12, w, mask);
		Pickaxe.process2(px, 8, 12, w, mask);
		Pickaxe.process2(px, 9, 12, w, mask);

		Pickaxe.process2(px, 8, 13, w, mask);
		Pickaxe.process2(px, 9, 13, w, mask);

		Pickaxe.process2(px, 0, 13, w, mask);
		Pickaxe.process2(px, 1, 13, w, mask);

		Pickaxe.process2(px, 0, 14, w, mask);
		Pickaxe.process2(px, 1, 14, w, mask);
		Pickaxe.process2(px, 2, 14, w, mask);

		Pickaxe.process2(px, 0, 15, w, mask);
		Pickaxe.process2(px, 1, 15, w, mask);
		Pickaxe.process2(px, 2, 15, w, mask);

		BufferedImage result = new BufferedImage(w, h, BufferedImage.TYPE_4BYTE_ABGR);
		result.setRGB(0, 0, w, h, px, 0, w);
		try {
			ImageIO.write(result, "png",
					new File("sword_color_" + Integer.toHexString(mask).substring(1) + ".png"));
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
