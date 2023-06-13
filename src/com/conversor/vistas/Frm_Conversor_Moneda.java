package com.conversor.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.conversor.codigo.ConversoresMonedas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frm_Conversor_Moneda<Icon> extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPanelConversor;
	private JTextField txCantidadInicial;
	private JTextField txCantidadFinal;
	
	double pesoMxPorDolar = 17.35d;
	double pesoMxPorEuro = 18.59d;
	double pesoMxPorYen = 0.12d;
	double pesoMxPorLibra = 21.63d;
	double pesoMxPorWon = 0.013d;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Conversor_Moneda<?> frame = new Frm_Conversor_Moneda<Object>();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}


	public Frm_Conversor_Moneda() {
		setTitle("Conversor Alura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 295);
		contentPanelConversor = new JPanel();
		contentPanelConversor.setBackground(Color.WHITE);
		contentPanelConversor.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPanelConversor);
		contentPanelConversor.setLayout(null);
		
		JLabel labelTitulo = new JLabel("<html>Conversor de Divisas<br> de Pesos Mexicanos.</html>");
		labelTitulo.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(0, 0, 247, 59);
		contentPanelConversor.add(labelTitulo);
		
		JLabel labelMonedaFinal = new JLabel("Moneda Final:");
		labelMonedaFinal.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMonedaFinal.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		labelMonedaFinal.setBounds(10, 100, 119, 26);
		contentPanelConversor.add(labelMonedaFinal);
		
		JLabel labelCantidadInicial = new JLabel("Cantidad Inicial:");
		labelCantidadInicial.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCantidadInicial.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		labelCantidadInicial.setBounds(0, 130, 129, 26);
		contentPanelConversor.add(labelCantidadInicial);
		
		JLabel labelCantidadFinal = new JLabel("Cantidad Final:");
		labelCantidadFinal.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCantidadFinal.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		labelCantidadFinal.setBounds(9, 160, 120, 26);
		contentPanelConversor.add(labelCantidadFinal);
		
		JLabel labelImagen = new JLabel("");
		labelImagen.setBounds(254, 0, 202, 230);
		contentPanelConversor.add(labelImagen);
		
		ImageIcon imagenMonedas = new ImageIcon(Frm_Conversor_Moneda.class.getResource("/com/conversor/imagenes/Monedas.png"));
		new ImageIcon(imagenMonedas.getImage().getScaledInstance(labelImagen.getWidth(),labelImagen.getHeight(),Image.SCALE_DEFAULT));
		
		labelImagen.setIcon(new ImageIcon(Frm_Conversor_Moneda.class.getResource("/com/conversor/imagenes/Monedas.png")));
		
		JLabel labelPie = new JLabel("");
		labelPie.setOpaque(true);
		labelPie.setBackground(new Color(0, 0, 102));
		labelPie.setBounds(0, 242, 462, 15);
		contentPanelConversor.add(labelPie);
		
		JLabel lblPastorAlbertoNuez = new JLabel("Pastor Alberto Nuñez Reynaga - 2023");
		lblPastorAlbertoNuez.setToolTipText("\r\n");
		lblPastorAlbertoNuez.setFont(new Font("Bahnschrift", Font.PLAIN, 10));
		lblPastorAlbertoNuez.setBounds(286, 222, 176, 26);
		contentPanelConversor.add(lblPastorAlbertoNuez);
		
		JLabel labelMonedaInicial = new JLabel("Moneda Inicial:");
		labelMonedaInicial.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMonedaInicial.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		labelMonedaInicial.setBounds(10, 70, 119, 26);
		contentPanelConversor.add(labelMonedaInicial);
		
		txCantidadInicial = new JTextField();
		txCantidadInicial.setBounds(133, 130, 114, 26);
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
		txCantidadFinal.setBounds(133, 160, 114, 26);
		contentPanelConversor.add(txCantidadFinal);
		
		JComboBox<String> boxInicial = new JComboBox<String>();
		boxInicial.setBounds(133, 70, 114, 26);
		contentPanelConversor.add(boxInicial);
		boxInicial.setModel(new DefaultComboBoxModel<String>(new String[] {"","PesoMx", "DolarUS", "Euro", "Yen", "LibraUK", "Won"}));
		
		
		JComboBox<String> boxFinal = new JComboBox<String>();
		boxFinal.setBounds(133, 100, 114, 26);
		contentPanelConversor.add(boxFinal);
		boxFinal.setModel(new DefaultComboBoxModel<String>(new String[] {"", "DolarUS","PesoMx" , "Euro", "Yen", "LibraUK", "Won"}));
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(10, 195, 114, 26);
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
		btnConvertir.setBounds(133, 195, 114, 26);
		contentPanelConversor.add(btnConvertir);
		
		ActionListener convertir = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(txCantidadInicial.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"Ingrese una Cantidad Inicial.");
				}
				
				if(boxInicial.getSelectedItem() == "") {
					JOptionPane.showMessageDialog(null,"Ingrese una Moneda Inicial.");
				}
				
				if(boxFinal.getSelectedItem() == "") {
					JOptionPane.showMessageDialog(null,"Ingrese una Moneda Final.");
				}
				
					Double tempCantidadInicial = Double.valueOf(txCantidadInicial.getText()) ;
					
					if(boxInicial.getSelectedItem() == "DolarUS") {
						tempCantidadInicial = ConversoresMonedas.ConvertirAPeso(Double.valueOf(txCantidadInicial.getText()) , pesoMxPorDolar);
					}
					else if(boxInicial.getSelectedItem() == "Euro"){
						tempCantidadInicial = ConversoresMonedas.ConvertirAPeso(Double.valueOf(txCantidadInicial.getText()) , pesoMxPorEuro);
					}
					else if(boxInicial.getSelectedItem() == "Yen"){
						tempCantidadInicial = ConversoresMonedas.ConvertirAPeso(Double.valueOf(txCantidadInicial.getText()) , pesoMxPorYen);
					}
					else if(boxInicial.getSelectedItem() == "LibraUK"){
						tempCantidadInicial = ConversoresMonedas.ConvertirAPeso(Double.valueOf(txCantidadInicial.getText()) , pesoMxPorLibra);
					}
					else if(boxInicial.getSelectedItem() == "Won"){
						tempCantidadInicial = ConversoresMonedas.ConvertirAPeso(Double.valueOf(txCantidadInicial.getText()) , pesoMxPorWon);
					}
					else if(boxInicial.getSelectedItem() == "PesoMx"){
						tempCantidadInicial = Double.valueOf(txCantidadInicial.getText());
					}
				
				
						String monConv = (String) boxFinal.getSelectedItem();
						switch (monConv) {
						case "DolarUS":
							txCantidadFinal.setText("$"+String.valueOf(ConversoresMonedas.ConvertirOtraMoneda
													(tempCantidadInicial,pesoMxPorDolar)));
							break;
						case "Euro":
							txCantidadFinal.setText("$"+String.valueOf(ConversoresMonedas.ConvertirOtraMoneda
													(tempCantidadInicial,pesoMxPorEuro)));
							break;
						case "Yen":
							txCantidadFinal.setText("$"+String.valueOf(ConversoresMonedas.ConvertirOtraMoneda
													(tempCantidadInicial,pesoMxPorYen)));
							break;
						case "LibraUK":
							txCantidadFinal.setText("$"+String.valueOf(ConversoresMonedas.ConvertirOtraMoneda
													(tempCantidadInicial,pesoMxPorLibra)));
							break;
						case "Won":
							txCantidadFinal.setText("$"+String.valueOf(ConversoresMonedas.ConvertirOtraMoneda
													(tempCantidadInicial,pesoMxPorWon)));
							break;
						case "PesoMx":
							txCantidadFinal.setText("$"+String.valueOf(tempCantidadInicial));
							break;
						default:
							txCantidadFinal.setText("Seleccione Moneda");
							break;
						}
					}
				
		};
		
		btnConvertir.addActionListener(convertir);
	
	}
}
