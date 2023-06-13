package com.conversor.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.conversor.codigo.ConversoresTemperatura;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Frm_Conversor_Temperatura extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPanelConversor;
	private JTextField txCantidadInicial;
	private JTextField txCantidadFinal;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Conversor_Temperatura frame = new Frm_Conversor_Temperatura();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	public Frm_Conversor_Temperatura() {
		setTitle("Conversor Alura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 249);
		contentPanelConversor = new JPanel();
		contentPanelConversor.setBackground(Color.WHITE);
		contentPanelConversor.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPanelConversor);
		contentPanelConversor.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Conversor de Tempertura");
		labelTitulo.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(0, 11, 247, 40);
		contentPanelConversor.add(labelTitulo);
		
		JLabel labelCantidadInicial = new JLabel("Cantidad Inicial:");
		labelCantidadInicial.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		labelCantidadInicial.setBounds(10, 83, 129, 26);
		contentPanelConversor.add(labelCantidadInicial);
		
		JLabel labelCantidadFinal = new JLabel("Cantidad Final:");
		labelCantidadFinal.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		labelCantidadFinal.setBounds(9, 113, 114, 26);
		contentPanelConversor.add(labelCantidadFinal);
		
		JLabel labelImagen = new JLabel("");
		labelImagen.setBounds(257, 0, 180, 189);
		contentPanelConversor.add(labelImagen);
		labelImagen.setIcon(new ImageIcon(getClass().getResource("/com/conversor/imagenes/conversor-de-temperatura.png")));
		JLabel lblPastorAlbertoNuez = new JLabel("Pastor Alberto Nuñez Reynaga - 2023");
		lblPastorAlbertoNuez.setToolTipText("\r\n");
		lblPastorAlbertoNuez.setFont(new Font("Bahnschrift", Font.PLAIN, 10));
		lblPastorAlbertoNuez.setBounds(253, 180, 167, 26);
		contentPanelConversor.add(lblPastorAlbertoNuez);
		
		JLabel labelPie = new JLabel("");
		labelPie.setOpaque(true);
		labelPie.setBackground(new Color(0, 0, 102));
		labelPie.setBounds(0, 199, 437, 14);
		contentPanelConversor.add(labelPie);
		
		txCantidadInicial = new JTextField();
		txCantidadInicial.setBounds(133, 83, 114, 26);
		contentPanelConversor.add(txCantidadInicial);
		txCantidadInicial.setColumns(10);
		txCantidadInicial.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evento) {
				double num = evento.getKeyChar();
				
				boolean numeros = num >= 46 && num <= 57;
				
				if(!numeros) {
					evento.consume();
				}
			}
		});
		
		txCantidadFinal = new JTextField();
		txCantidadFinal.setEditable(false);
		txCantidadFinal.setColumns(10);
		txCantidadFinal.setBounds(133, 113, 114, 26);
		contentPanelConversor.add(txCantidadFinal);
		
		JComboBox<String> boxInicial = new JComboBox<String>();
		boxInicial.setModel(new DefaultComboBoxModel<String>(new String[] {"Celsius", "Fahrenheit", "Kelvin"}));
		boxInicial.setBounds(15, 49, 114, 26);
		contentPanelConversor.add(boxInicial);
		
		JComboBox<String> boxFinal = new JComboBox<String>();
		boxFinal.setBounds(133, 49, 114, 26);
		contentPanelConversor.add(boxFinal);
		boxFinal.setModel(new DefaultComboBoxModel<String>(new String[] {"Fahrenheit","Celsius","Kelvin"}));
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(10, 148, 114, 26);
		contentPanelConversor.add(btnRegresar);
		

		
		ActionListener regresar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Frm_Bienvenido_Conversor.main(null);
				dispose();	
			}
		};
		
		btnRegresar.addActionListener(regresar);
		
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.setBounds(133, 148, 114, 26);
		contentPanelConversor.add(btnConvertir);
		
		ActionListener convertir = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txCantidadFinal.setText("");
				
				if(txCantidadInicial.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"Ingrese una Cantidad Inicial.");
				}
				
				if(boxInicial.getSelectedItem()=="Celsius" && boxFinal.getSelectedItem()=="Fahrenheit" ) {
					txCantidadFinal.setText(String.valueOf(ConversoresTemperatura.CelsiusFahrenheit
											(Double.valueOf(txCantidadInicial.getText())))+"° "+ boxFinal.getSelectedItem());
				}
				else if(boxInicial.getSelectedItem()=="Celsius" && boxFinal.getSelectedItem()=="Kelvin" ) {
					txCantidadFinal.setText(String.valueOf(ConversoresTemperatura.CelsiusKelvin
											(Double.valueOf(txCantidadInicial.getText())))+"° "+ boxFinal.getSelectedItem());
				}
				else if(boxInicial.getSelectedItem()=="Celsius" && boxFinal.getSelectedItem()=="Celsius" ) {
					txCantidadFinal.setText(String.valueOf(txCantidadInicial.getText())+"° "+ boxFinal.getSelectedItem());
				}
				else if(boxInicial.getSelectedItem()=="Fahrenheit" && boxFinal.getSelectedItem()=="Celsius" ) {
					txCantidadFinal.setText(String.valueOf(ConversoresTemperatura.FahrenheitCelsius
											(Double.valueOf(txCantidadInicial.getText())))+"° "+ boxFinal.getSelectedItem());
				}
				else if(boxInicial.getSelectedItem()=="Fahrenheit" && boxFinal.getSelectedItem()=="Kelvin" ) {
					txCantidadFinal.setText(String.valueOf(ConversoresTemperatura.FahrenheitKelvin
											(Double.valueOf(txCantidadInicial.getText())))+"° "+ boxFinal.getSelectedItem());
				}
				else if(boxInicial.getSelectedItem()=="Fahrenheit" && boxFinal.getSelectedItem()=="Fahrenheit" ) {
					txCantidadFinal.setText(String.valueOf(txCantidadInicial.getText())+"° "+ boxFinal.getSelectedItem());
				}
				else if(boxInicial.getSelectedItem()=="Kelvin" && boxFinal.getSelectedItem()=="Celsius" ) {
					txCantidadFinal.setText(String.valueOf(ConversoresTemperatura.KelvinCelsius
											(Double.valueOf(txCantidadInicial.getText())))+"° "+ boxFinal.getSelectedItem());
				}
				else if(boxInicial.getSelectedItem()=="Kelvin" && boxFinal.getSelectedItem()=="Fahrenheit" ) {
					txCantidadFinal.setText(String.valueOf(ConversoresTemperatura.KelvinFahrenheit
											(Double.valueOf(txCantidadInicial.getText())))+"° "+ boxFinal.getSelectedItem());
				}
				else if(boxInicial.getSelectedItem()=="Kelvin" && boxFinal.getSelectedItem()=="Kelvin") {
					txCantidadFinal.setText(String.valueOf(txCantidadInicial.getText())+"° "+ boxFinal.getSelectedItem());
				} 
				else {
					JOptionPane.showMessageDialog(null,"Se presento un error.");
				}
				
			}
		};
		
		btnConvertir.addActionListener(convertir);
			
	}
	
}
