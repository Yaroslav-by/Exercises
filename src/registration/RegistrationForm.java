package registration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JButton;

public class RegistrationForm {

	private JFrame frmRegistrationform;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm window = new RegistrationForm();
					window.frmRegistrationform.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistrationForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	private void initialize() {
		frmRegistrationform = new JFrame();
		frmRegistrationform.setResizable(false);
		frmRegistrationform.setTitle("RegistrationForm");
		frmRegistrationform.setForeground(Color.WHITE);
		frmRegistrationform.setBounds(100, 100, 650, 680);
		frmRegistrationform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistrationform.getContentPane().setLayout(null);
		
		JPanel panelForText = new JPanel();
		panelForText.setBounds(0, 0, 636, 71);
		panelForText.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0417\u0430\u043F\u043E\u043B\u043D\u0438\u0442\u0435 \u043F\u043E\u043B\u044F \u0434\u043B\u044F \u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u0438 ");
		lblNewLabel.setBounds(147, 10, 367, 29);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panelForText.add(lblNewLabel);
		frmRegistrationform.getContentPane().add(panelForText);
		
		JLabel lblNewLabel_1 = new JLabel("\u0425\u043E\u0437\u044F\u0438\u043D \u043F\u0438\u0442\u043E\u043C\u0446\u0430");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(250, 49, 140, 13);
		panelForText.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 80, 144, 150);
		frmRegistrationform.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\u0424\u0418\u041E");
		lblNewLabel_2.setBounds(10, 10, 35, 20);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u0412\u043E\u0437\u0440\u0430\u0441\u0442");
		lblNewLabel_3.setBounds(10, 35, 54, 20);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u041F\u043E\u043B");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 60, 45, 20);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u041D\u043E\u043C\u0435\u0440 \u0442\u0435\u043B\u0435\u0444\u043E\u043D\u0430");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(10, 85, 124, 20);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("\u041F\u043E\u0447\u0442\u0430");
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5_1.setBounds(10, 110, 124, 20);
		panel.add(lblNewLabel_5_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(143, 80, 493, 150);
		frmRegistrationform.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 10, 473, 20);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(textField);
		textField.setColumns(45);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 120, 1));
		spinner.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		spinner.setBounds(10, 35, 100, 20);
		panel_1.add(spinner);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u041C\u0443\u0436\u0441\u043A\u043E\u0439");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBounds(10, 60, 103, 20);
		rdbtnNewRadioButton.setFocusable(false);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u0416\u0435\u043D\u0441\u043A\u0438\u0439");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rdbtnNewRadioButton_1.setBounds(115, 60, 103, 20);
		rdbtnNewRadioButton_1.setFocusable(false);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\u0410 \u044F  \u0435\u0449\u0435 \u043D\u0435 \u043E\u043F\u0440\u0435\u0434\u0435\u043B\u0438\u043B\u0441\u044F");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setSelected(true);
		rdbtnNewRadioButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rdbtnNewRadioButton_2.setBounds(220, 60, 191, 21);
		rdbtnNewRadioButton_2.setFocusable(false);
		panel_1.add(rdbtnNewRadioButton_2);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_1.setColumns(45);
		textField_1.setBounds(10, 85, 473, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_2.setColumns(45);
		textField_2.setBounds(10, 110, 473, 20);
		panel_1.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 278, 144, 304);
		frmRegistrationform.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u041A\u043B\u0438\u0447\u043A\u0430");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(10, 10, 73, 20);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("\u0412\u0438\u0434");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(10, 35, 54, 20);
		panel_2.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("\u041F\u043E\u043B");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(10, 60, 45, 20);
		panel_2.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("\u0426\u0432\u0435\u0442");
		lblNewLabel_5_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5_2.setBounds(10, 85, 124, 20);
		panel_2.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("\u0412\u0435\u0441, \u043A\u0433");
		lblNewLabel_5_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5_1_1.setBounds(10, 110, 124, 20);
		panel_2.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("\u041B\u044E\u0431\u0438\u043C\u044B\u0435");
		lblNewLabel_5_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5_1_1_1.setBounds(10, 200, 124, 20);
		panel_2.add(lblNewLabel_5_1_1_1);
		
		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("\u0438\u0433\u0440\u0443\u0448\u043A\u0438");
		lblNewLabel_5_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5_1_1_1_1.setBounds(10, 220, 124, 20);
		panel_2.add(lblNewLabel_5_1_1_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(143, 278, 493, 304);
		frmRegistrationform.getContentPane().add(panel_1_1);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_3.setColumns(45);
		textField_3.setBounds(10, 10, 473, 20);
		panel_1_1.add(textField_3);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("\u041A\u0430\u0431\u0435\u043B\u044C");
		buttonGroup_1.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setSelected(true);
		rdbtnNewRadioButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rdbtnNewRadioButton_3.setFocusable(false);
		rdbtnNewRadioButton_3.setBounds(10, 60, 103, 20);
		panel_1_1.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("\u0421\u0443\u043A\u0430");
		buttonGroup_1.add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rdbtnNewRadioButton_1_1.setFocusable(false);
		rdbtnNewRadioButton_1_1.setBounds(115, 60, 103, 20);
		panel_1_1.add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_2_1 = new JRadioButton(" \u0336\u0410\u0336 \u0336\u043E\u0336\u043D\u0336 \u0336\u0435\u0336\u0449\u0336\u0435\u0336 \u0336\u043D\u0336\u0435\u0336 \u0336\u043E\u0336\u043F\u0336\u0440\u0336\u0435\u0336\u0434\u0336\u0435\u0336\u043B\u0336\u0438\u0336\u043B\u0336\u0441\u0336\u044F\u0336");
		rdbtnNewRadioButton_2_1.setEnabled(false);
		rdbtnNewRadioButton_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rdbtnNewRadioButton_2_1.setFocusable(false);
		rdbtnNewRadioButton_2_1.setBounds(220, 60, 210, 21);
		panel_1_1.add(rdbtnNewRadioButton_2_1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"\u0421\u043E\u0431\u0430\u043A\u0430", "\u041A\u043E\u0442", "\u0425\u043E\u043C\u044F\u043A", "\u041A\u0440\u044B\u0441\u0430", "\u041F\u043E\u043F\u0443\u0433\u0430\u0439", "\u0427\u0435\u0440\u0435\u043F\u0430\u0445\u0430", "\u042F\u0449\u0435\u0440\u0438\u0446\u0430"}));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox.setBounds(10, 35, 130, 20);
		panel_1_1.add(comboBox);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"\u0427\u0435\u0440\u043D\u044B\u0439", "\u0411\u0435\u043B\u044B\u0439", "\u0421\u0435\u0440\u044B\u0439", "\u041A\u0440\u0430\u0441\u043D\u044B\u0439", "\u0420\u044B\u0436\u0438\u0439", "\u0413\u043E\u043B\u0443\u0431\u043E\u0439", "\u0417\u0435\u043B\u0435\u043D\u044B\u0439", "\u041E\u0440\u0430\u043D\u0436\u0435\u0432\u044B\u0439"}));
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_1.setBounds(10, 85, 130, 20);
		panel_1_1.add(comboBox_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u0414\u0440\u0443\u0433\u043E\u0439");

		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		chckbxNewCheckBox.setBounds(153, 85, 75, 21);
		chckbxNewCheckBox.setFocusable(false);
		chckbxNewCheckBox.addActionListener((e) -> {
			
			if (chckbxNewCheckBox.isSelected()) {
				comboBox_1.setEnabled(false);
				textField_4.setEditable(true);
			} else {
				comboBox_1.setEnabled(true);
				textField_4.setText("");
				textField_4.setEditable(false);
			}
			
		});

		panel_1_1.add(chckbxNewCheckBox);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setHorizontalAlignment(SwingConstants.LEFT);
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_4.setColumns(45);
		textField_4.setBounds(242, 86, 241, 20);
		panel_1_1.add(textField_4);
		
		JSlider slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(10);
		slider.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		slider.setBounds(10, 110, 473, 50);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setHorizontalAlignment(SwingConstants.LEFT);
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_5.setColumns(45);
		textField_5.setBounds(417, 170, 36, 20);
		textField_5.setText(Integer.toString(slider.getValue()));
		panel_1_1.add(textField_5);
		
		slider.addChangeListener((e) -> {
			
			textField_5.setText(Integer.toString(slider.getValue()));
			
		});
		panel_1_1.add(slider);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("\u043A\u0433");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_1_1.setBounds(463, 170, 20, 20);
		panel_1_1.add(lblNewLabel_3_1_1);
		
		JList list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"\u041C\u044F\u0447\u0438\u043A", "\u0424\u0440\u0438\u0441\u0431\u0438", "\u041A\u043E\u043B\u044C\u0446\u0430", "\u041A\u043E\u0441\u0442\u043E\u0447\u043A\u0438", "\u041F\u0430\u043B\u043E\u0447\u043A\u0438", "\u0412 \u0444\u043E\u0440\u043C\u0435 \u0436\u0438\u0432\u043E\u0442\u043D\u044B\u0445", "\u041C\u044F\u0433\u043A\u0438\u0435, \u0442\u0435\u043A\u0441\u0442\u0438\u043B\u044C\u043D\u044B\u0435", "\u0418\u043D\u0442\u0435\u0440\u0430\u043A\u0442\u0438\u0432\u043D\u044B\u0435\u0435\u0435\u0435\u0435\u0435/\u0440\u0430\u0437\u0432\u0438\u0432\u0430\u044E\u0449\u0438\u0435"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		list.setBounds(10, 200, 473, 94);
		panel_1_1.add(list);
		
		JPanel panelForText_1 = new JPanel();
		panelForText_1.setBounds(0, 240, 636, 45);
		frmRegistrationform.getContentPane().add(panelForText_1);
		panelForText_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1_1 = new JLabel("\u041F\u0438\u0442\u043E\u043C\u0435\u0446");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panelForText_1.add(lblNewLabel_1_1);
		
		JPanel panelForText_1_1 = new JPanel();
		panelForText_1_1.setBounds(0, 592, 636, 41);
		frmRegistrationform.getContentPane().add(panelForText_1_1);
		panelForText_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("\u0414\u0435\u043B' \u0441\u0434\u0435\u043B\u0430\u043D\u043E!");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setFocusable(false);
		panelForText_1_1.add(btnNewButton);
	}
}
