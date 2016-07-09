package net.lesmi;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main extends JFrame {
	public Main() throws HeadlessException {
		// TODO 自動生成されたコンストラクター・スタブ
		super("DyeMcTools - Dye tools on Minecraft you like.");
		setVisible(true);
		setSize(300, 200);
		BoxLayout bl = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
		setLayout(bl);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				System.out.println("Closing application...");
				System.exit(0);
			}
		});

		add(new JLabel("Select a tool you want to dye"));

		{
			JButton button = new JButton("Axe");
			button.addActionListener(a -> {
				JDialog dialog = new JDialog(this);
				dialog.setSize(500, 200);
				AtomicReference<Color> color = new AtomicReference<>(Color.BLACK);
				JTextField path = new JTextField(new File("axe_colored.png").getAbsolutePath());
				JButton selectColor = new JButton("Select");
				colorButton(selectColor, color.get());
				selectColor.addActionListener(b -> {
					color.set(JColorChooser.showDialog(dialog.getContentPane(), "Choose Color", color.get()));
					colorButton(selectColor, color.get());
				});
				JButton execute = new JButton("Execute");
				execute.addActionListener(b -> {
					try {
						Axe.main(new String[] { Integer.toString(color.get().getRGB()), path.getText() });
						execute.setText("Done");
					} catch (Throwable e) {
						execute.setText("Failed");
					}
				});
				JComponent[][] components = { { new JLabel("Destination:"), path },
						{ new JLabel("Color:"), selectColor }, { null, execute } };
				GroupLayoutUtil glu = new GroupLayoutUtil();
				glu.setComponents(components);
				glu.setGroupLayoutTo(dialog.getContentPane());
				dialog.setVisible(true);

			});
			add(button);
		}
		{
			JButton button = new JButton("Hoe");
			button.addActionListener(a -> {
				JDialog dialog = new JDialog(this);
				dialog.setSize(500, 200);
				AtomicReference<Color> color = new AtomicReference<>(Color.BLACK);
				JTextField path = new JTextField(new File("hoe_colored.png").getAbsolutePath());
				JButton selectColor = new JButton("Select");
				colorButton(selectColor, color.get());
				selectColor.addActionListener(b -> {
					color.set(JColorChooser.showDialog(dialog.getContentPane(), "Choose Color", color.get()));
					colorButton(selectColor, color.get());
				});
				JButton execute = new JButton("Execute");
				execute.addActionListener(b -> {
					try {
						Hoe.main(new String[] { Integer.toString(color.get().getRGB()), path.getText() });
						execute.setText("Done");
					} catch (Throwable e) {
						execute.setText("Failed");
					}
				});
				JComponent[][] components = { { new JLabel("Destination:"), path },
						{ new JLabel("Color:"), selectColor }, { null, execute } };
				GroupLayoutUtil glu = new GroupLayoutUtil();
				glu.setComponents(components);
				glu.setGroupLayoutTo(dialog.getContentPane());
				dialog.setVisible(true);

			});
			add(button);
		}
		{
			JButton button = new JButton("Pickaxe");
			button.addActionListener(a -> {
				JDialog dialog = new JDialog(this);
				dialog.setSize(500, 200);
				AtomicReference<Color> color = new AtomicReference<>(Color.BLACK);
				JTextField path = new JTextField(new File("pickaxe_colored.png").getAbsolutePath());
				JButton selectColor = new JButton("Select");
				colorButton(selectColor, color.get());
				selectColor.addActionListener(b -> {
					color.set(JColorChooser.showDialog(dialog.getContentPane(), "Choose Color", color.get()));
					colorButton(selectColor, color.get());
				});
				JButton execute = new JButton("Execute");
				execute.addActionListener(b -> {
					try {
						Pickaxe.main(new String[] { Integer.toString(color.get().getRGB()), path.getText() });
						execute.setText("Done");
					} catch (Throwable e) {
						execute.setText("Failed");
					}
				});
				JComponent[][] components = { { new JLabel("Destination:"), path },
						{ new JLabel("Color:"), selectColor }, { null, execute } };
				GroupLayoutUtil glu = new GroupLayoutUtil();
				glu.setComponents(components);
				glu.setGroupLayoutTo(dialog.getContentPane());
				dialog.setVisible(true);

			});
			add(button);
		}
		{
			JButton button = new JButton("Shovel");
			button.addActionListener(a -> {
				JDialog dialog = new JDialog(this);
				dialog.setSize(500, 200);
				AtomicReference<Color> color = new AtomicReference<>(Color.BLACK);
				JTextField path = new JTextField(new File("shovel_colored.png").getAbsolutePath());
				JButton selectColor = new JButton("Select");
				colorButton(selectColor, color.get());
				selectColor.addActionListener(b -> {
					color.set(JColorChooser.showDialog(dialog.getContentPane(), "Choose Color", color.get()));
					colorButton(selectColor, color.get());
				});
				JButton execute = new JButton("Execute");
				execute.addActionListener(b -> {
					try {
						Shovel.main(new String[] { Integer.toString(color.get().getRGB()), path.getText() });
						execute.setText("Done");
					} catch (Throwable e) {
						execute.setText("Failed");
					}
				});
				JComponent[][] components = { { new JLabel("Destination:"), path },
						{ new JLabel("Color:"), selectColor }, { null, execute } };
				GroupLayoutUtil glu = new GroupLayoutUtil();
				glu.setComponents(components);
				glu.setGroupLayoutTo(dialog.getContentPane());
				dialog.setVisible(true);

			});
			add(button);
		}
		{
			JButton button = new JButton("Sword");
			button.addActionListener(a -> {
				JDialog dialog = new JDialog(this);
				dialog.setSize(500, 200);
				AtomicReference<Color> color = new AtomicReference<>(Color.BLACK);
				JTextField path = new JTextField(new File("sword_colored.png").getAbsolutePath());
				JButton selectColor = new JButton("Select");
				colorButton(selectColor, color.get());
				selectColor.addActionListener(b -> {
					color.set(JColorChooser.showDialog(dialog.getContentPane(), "Choose Color", color.get()));
					colorButton(selectColor, color.get());
				});
				JButton execute = new JButton("Execute");
				execute.addActionListener(b -> {
					try {
						Sword.main(new String[] { Integer.toString(color.get().getRGB()), path.getText() });
						execute.setText("Done");
					} catch (Throwable e) {
						execute.setText("Failed");
					}
				});
				JComponent[][] components = { { new JLabel("Destination:"), path },
						{ new JLabel("Color:"), selectColor }, { null, execute } };
				GroupLayoutUtil glu = new GroupLayoutUtil();
				glu.setComponents(components);
				glu.setGroupLayoutTo(dialog.getContentPane());
				dialog.setVisible(true);

			});
			add(button);
		}
	}

	public static void colorButton(JButton btn, Color color) {
		float[] hsv = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
		btn.setBackground(color);
		btn.setForeground(hsv[2] > 0.3 ? Color.BLACK : Color.WHITE);
	}

	public static void main(String... args) {
		new Main();
	}
}
