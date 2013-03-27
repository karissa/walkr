package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrefrencesPanel extends JPanel {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCfall;
	private JTextField txtCityName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PrefrencesPanel dialog = new PrefrencesPanel();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PrefrencesPanel() {
		setBounds(100, 100, 548, 222);
		setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JCheckBox chckbxEnable = new JCheckBox("Disabled");
			chckbxEnable.setToolTipText("A tracker represents the location of the current photo. It is a small icon that is displayed on the map.");
			chckbxEnable.setBounds(26, 66, 124, 23);
			contentPanel.add(chckbxEnable);
		}
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Reddit Alien", "Camera", "Flag", "Red Dot"}));
		comboBox.setName("");
		comboBox.setToolTipText("Pick a skin");
		comboBox.setBounds(27, 128, 139, 27);
		contentPanel.add(comboBox);
		{
			JLabel lblPhotoTracker = new JLabel("Photo Tracker:");
			lblPhotoTracker.setBounds(16, 47, 124, 16);
			contentPanel.add(lblPhotoTracker);
		}
		{
			JLabel lblSkin = new JLabel("Skin:");
			lblSkin.setLabelFor(comboBox);
			lblSkin.setBounds(17, 104, 56, 16);
			contentPanel.add(lblSkin);
		}
		{
			JLabel lblMapLookAnd = new JLabel("Look and Feel:");
			lblMapLookAnd.setBounds(6, 19, 149, 16);
			contentPanel.add(lblMapLookAnd);
		}
		{
			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Default", "Black", "Red", "Blue"}));
			comboBox_1.setBounds(209, 65, 128, 27);
			contentPanel.add(comboBox_1);
		}
		{
			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Satellite", "Roadmap", "Hybrid", ""}));
			comboBox_1.setBounds(209, 128, 128, 27);
			contentPanel.add(comboBox_1);
		}
		
		JLabel lblProgramColor = new JLabel("Color:");
		lblProgramColor.setBounds(185, 47, 61, 16);
		contentPanel.add(lblProgramColor);
		
		JLabel lblMapType = new JLabel("Map Type:");
		lblMapType.setBounds(187, 104, 87, 16);
		contentPanel.add(lblMapType);
		
		txtCfall = new JTextField();
		txtCfall.setText("c343_fall2010");
		txtCfall.setBounds(384, 45, 134, 28);
		contentPanel.add(txtCfall);
		txtCfall.setColumns(10);
		
		JLabel lblSearchTags = new JLabel("Search Tag:");
		lblSearchTags.setBounds(357, 19, 105, 16);
		contentPanel.add(lblSearchTags);
		
		JLabel lblMapCenter = new JLabel("Map Center:");
		lblMapCenter.setBounds(357, 89, 105, 16);
		contentPanel.add(lblMapCenter);
		
		txtCityName = new JTextField();
		txtCityName.setColumns(10);
		txtCityName.setBounds(384, 115, 134, 28);
		contentPanel.add(txtCityName);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				okButton.setMnemonic(KeyEvent.VK_ENTER);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
