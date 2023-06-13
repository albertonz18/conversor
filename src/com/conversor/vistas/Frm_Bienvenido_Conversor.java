package com.conversor.vistas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;


public class Frm_Bienvenido_Conversor extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPanelConversor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Bienvenido_Conversor frame = new Frm_Bienvenido_Conversor ();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	public Frm_Bienvenido_Conversor () {
		setTitle("Conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 242);
		contentPanelConversor = new JPanel();
		contentPanelConversor.setBackground(Color.WHITE);
		contentPanelConversor.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPanelConversor);
		contentPanelConversor.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Conversor");
		labelTitulo.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(0, 11, 367, 39);
		contentPanelConversor.add(labelTitulo);
		
		JLabel labelCantidadFinal = new JLabel("<html><center>Bienvenido por favor seleccione el tipo de datos que desea convertir.</html>");
		labelCantidadFinal.setToolTipText("\r\n");
		labelCantidadFinal.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		labelCantidadFinal.setBounds(10, 39, 337, 46);
		contentPanelConversor.add(labelCantidadFinal);
		
		JLabel lblPastorAlbertoNuez = new JLabel("Pastor Alberto Nuñez Reynaga - 2023");
		lblPastorAlbertoNuez.setToolTipText("\r\n");
		lblPastorAlbertoNuez.setFont(new Font("Bahnschrift", Font.PLAIN, 10));
		lblPastorAlbertoNuez.setBounds(159, 166, 176, 26);
		contentPanelConversor.add(lblPastorAlbertoNuez);
		
		JLabel labelPie = new JLabel("");
		labelPie.setOpaque(isOpaque());
		labelPie.setBackground(new Color(0, 0, 102));
		labelPie.setBounds(0, 186, 367, 17);
		contentPanelConversor.add(labelPie);
		
		JComboBox<String> boxSeleccionar = new JComboBox<String>();
		boxSeleccionar.setBounds(20, 89, 173, 26);
		contentPanelConversor.add(boxSeleccionar);
		boxSeleccionar.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione una Accion.", "Divisas", "Temperatura"}));
		
		
		
		JButton btnConvertir = new JButton("Acceder");
		btnConvertir.setBounds(203, 89, 123, 26);
		contentPanelConversor.add(btnConvertir);
		
		ActionListener llamarSiguieteVentana = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							if(boxSeleccionar.getSelectedItem()=="Divisas") {
								Frm_Conversor_Moneda.main(null);
								dispose();
							}else if (boxSeleccionar.getSelectedItem()=="Temperatura") {
								Frm_Conversor_Temperatura.main(null);
								dispose();
							}else {
								return;
							}
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		};
		
		btnConvertir.addActionListener(llamarSiguieteVentana);
		
		

		
		JButton btnLinkedin = new JButton("");
		btnLinkedin.setIcon(new ImageIcon(Frm_Bienvenido_Conversor.class.getResource("/com/conversor/imagenes/Linkedin.png")));
		btnLinkedin.setBackground(new Color(255, 255, 255));
		btnLinkedin.setBounds(213, 121, 54, 46);
		contentPanelConversor.add(btnLinkedin);
		
		ActionListener irLinkedin = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent eventoHtml) {
				try {
					if(Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
							if(desktop.isSupported(Desktop.Action.BROWSE)) {
								desktop.browse(new URI("https://www.linkedin.com/in/alberto-nu%C3%B1ez/"));
							}
					}
					
				}catch(Exception errorHtml) {
					errorHtml.printStackTrace();
					
				}
				
			}
		};
		
		btnLinkedin.addActionListener(irLinkedin);

			
			
		
		
		JButton btnGithub = new JButton("");
		btnGithub.setIcon(new ImageIcon(Frm_Bienvenido_Conversor.class.getResource("/com/conversor/imagenes/GitHub.png")));
		btnGithub.setBackground(Color.WHITE);
		btnGithub.setBounds(273, 121, 54, 46);
		contentPanelConversor.add(btnGithub);
		
		ActionListener irGitHub = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent eventoHtml) {
				try {
					if(Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
							if(desktop.isSupported(Desktop.Action.BROWSE)) {
								desktop.browse(new URI("https://github.com/albertonz18"));
							}
					}
					
				}catch(Exception errorHtml) {
					errorHtml.printStackTrace();
					
				}
				
			}
		};
		
		btnGithub.addActionListener(irGitHub);

		
	}
}
