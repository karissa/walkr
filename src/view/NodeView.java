package view;

import java.awt.Graphics;
import java.awt.Image;

import graph.Node;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class NodeView extends JLabel {

	private static final long serialVersionUID = 6702342379913627617L;
	Node node;
	
	public NodeView(Node n, String skin) {
		setToolTipText(n.getName());
		setBorder(null);
		setIconTextGap(0);
		setText(null);
		Image icon = n.getImage(skin);
		setIcon(new ImageIcon(icon));
		setSize(icon.getWidth(null),
				icon.getHeight(null));
	}
	
    protected void paintComponent(Graphics g) {
        super.invalidate();
    	super.paintComponent(g);
    }
}
