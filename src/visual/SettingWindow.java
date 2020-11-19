/*
 * Created by JFormDesigner on Sat Jun 17 12:56:19 BRT 2017
 */

package visual;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Jc
 */
public class SettingWindow extends JFrame {
	public SettingWindow() {
		initComponents();
	}


	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		panel1 = new JPanel();
		radio11 = new JRadioButton();
		radio32 = new JRadioButton();
		radio34 = new JRadioButton();
		radio74 = new JRadioButton();
		panel2 = new JPanel();
		panel11 = new JPanel();
		toleranceCheckBox3 = new JLabel();
		populationField = new JSpinner();
		selectionCombobox = new JComboBox<>();
		panel3 = new JPanel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		tsmProbField = new JSpinner();
		tsmPopField = new JSpinner();
		label6 = new JLabel();
		onePointProbField = new JSpinner();
		onePointPopField = new JSpinner();
		label7 = new JLabel();
		twoPointProbField = new JSpinner();
		twoPointPopField = new JSpinner();
		panel5 = new JPanel();
		panel13 = new JPanel();
		toleranceCheckBox5 = new JLabel();
		mutDistributionField = new JSpinner();
		panel14 = new JPanel();
		toleranceCheckBox6 = new JLabel();
		simpleMutatorField = new JSpinner();
		panel15 = new JPanel();
		toleranceCheckBox7 = new JLabel();
		shiftingMutatorField = new JSpinner();
		panel6 = new JPanel();
		panel4 = new JPanel();
		radioCost = new JRadioButton();
		radioProduction = new JRadioButton();
		radioBoth = new JRadioButton();
		panel8 = new JPanel();
		radioWorst = new JRadioButton();
		radioRandom = new JRadioButton();
		panel7 = new JPanel();
		panel19 = new JPanel();
		genLimitCheckbox = new JCheckBox();
		genLimitField = new JSpinner();
		panel21 = new JPanel();
		timeLimitCheckbox = new JCheckBox();
		timeLimitField = new JSpinner();
		label1 = new JLabel();
		buttonBar = new JPanel();
		okButton = new JButton();
		cancelButton = new JButton();

		//======== this ========
		setTitle("Genetic Scheduling");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{
				contentPanel.setLayout(new GridBagLayout());
				((GridBagLayout)contentPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
				((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {0, 0};
				((GridBagLayout)contentPanel.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0E-4};
				((GridBagLayout)contentPanel.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

				//======== panel1 ========
				{
					panel1.setBorder(new TitledBorder("Files"));
					panel1.setLayout(new GridBagLayout());
					((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0};
					((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0};
					((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
					((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

					//---- radio11 ----
					radio11.setText("1Machine_1Part");
					radio11.setSelected(true);
					panel1.add(radio11, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 0), 0, 0));

					//---- radio32 ----
					radio32.setText("3Machines_2Parts");
					panel1.add(radio32, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 0), 0, 0));

					//---- radio34 ----
					radio34.setText("3Machines_4Parts");
					panel1.add(radio34, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 0), 0, 0));

					//---- radio74 ----
					radio74.setText("7Machines_4Parts");
					panel1.add(radio74, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
				}
				contentPanel.add(panel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//======== panel2 ========
				{
					panel2.setBorder(new TitledBorder(" Configuration"));
					panel2.setLayout(new GridBagLayout());
					((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 0};
					((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0};
					((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
					((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

					//======== panel11 ========
					{
						panel11.setLayout(new GridBagLayout());
						((GridBagLayout)panel11.getLayout()).columnWidths = new int[] {0, 0, 0};
						((GridBagLayout)panel11.getLayout()).rowHeights = new int[] {0, 0};
						((GridBagLayout)panel11.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
						((GridBagLayout)panel11.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

						//---- toleranceCheckBox3 ----
						toleranceCheckBox3.setText("Population size: ");
						panel11.add(toleranceCheckBox3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));

						//---- populationField ----
						populationField.setModel(new SpinnerNumberModel(200, 1, null, 10));
						panel11.add(populationField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
					}
					panel2.add(panel11, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 0), 0, 0));

					//---- selectionCombobox ----
					selectionCombobox.setModel(new DefaultComboBoxModel<>(new String[] {
						"Tournament Selection",
						"Simple Selection"
					}));
					panel2.add(selectionCombobox, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 0), 0, 0));

					//======== panel3 ========
					{
						panel3.setBorder(new TitledBorder("Crossover"));
						panel3.setLayout(new GridBagLayout());
						((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
						((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0};
						((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0E-4};
						((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

						//---- label2 ----
						label2.setText("method");
						panel3.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 5), 0, 0));

						//---- label3 ----
						label3.setText("methodProb.:");
						panel3.add(label3, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 5), 0, 0));

						//---- label4 ----
						label4.setText("amount of pop.:");
						panel3.add(label4, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 0), 0, 0));

						//---- label5 ----
						label5.setText("TSMCrossover:");
						panel3.add(label5, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 5), 0, 0));

						//---- tsmProbField ----
						tsmProbField.setModel(new SpinnerNumberModel(0.8, 0.0, 1.0, 0.05));
						panel3.add(tsmProbField, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 5), 0, 0));

						//---- tsmPopField ----
						tsmPopField.setModel(new SpinnerNumberModel(0.5, 0.0, 1.0, 0.05));
						panel3.add(tsmPopField, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 0), 0, 0));

						//---- label6 ----
						label6.setText("OnePointCrossover:");
						panel3.add(label6, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 5), 0, 0));

						//---- onePointProbField ----
						onePointProbField.setModel(new SpinnerNumberModel(0.8, 0.0, 1.0, 0.05));
						panel3.add(onePointProbField, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 5), 0, 0));

						//---- onePointPopField ----
						onePointPopField.setModel(new SpinnerNumberModel(0.25, 0.0, 1.0, 0.05));
						panel3.add(onePointPopField, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 0), 0, 0));

						//---- label7 ----
						label7.setText("TwoPointCrossover:");
						panel3.add(label7, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 5), 0, 0));

						//---- twoPointProbField ----
						twoPointProbField.setModel(new SpinnerNumberModel(0.8, 0.0, 1.0, 0.05));
						panel3.add(twoPointProbField, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 5), 0, 0));

						//---- twoPointPopField ----
						twoPointPopField.setModel(new SpinnerNumberModel(0.25, 0.0, 1.0, 0.05));
						panel3.add(twoPointPopField, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
					}
					panel2.add(panel3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 0), 0, 0));

					//======== panel5 ========
					{
						panel5.setBorder(new TitledBorder("Mutators"));
						panel5.setLayout(new GridBagLayout());
						((GridBagLayout)panel5.getLayout()).columnWidths = new int[] {0, 0};
						((GridBagLayout)panel5.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
						((GridBagLayout)panel5.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
						((GridBagLayout)panel5.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

						//======== panel13 ========
						{
							panel13.setLayout(new GridBagLayout());
							((GridBagLayout)panel13.getLayout()).columnWidths = new int[] {0, 0, 0};
							((GridBagLayout)panel13.getLayout()).rowHeights = new int[] {0, 0};
							((GridBagLayout)panel13.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
							((GridBagLayout)panel13.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

							//---- toleranceCheckBox5 ----
							toleranceCheckBox5.setText("Sons Distribution: ");
							panel13.add(toleranceCheckBox5, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 5), 0, 0));

							//---- mutDistributionField ----
							mutDistributionField.setModel(new SpinnerNumberModel(0.5, 0.0, 1.0, 0.05));
							panel13.add(mutDistributionField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 0), 0, 0));
						}
						panel5.add(panel13, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 0), 0, 0));

						//======== panel14 ========
						{
							panel14.setLayout(new GridBagLayout());
							((GridBagLayout)panel14.getLayout()).columnWidths = new int[] {0, 0, 0};
							((GridBagLayout)panel14.getLayout()).rowHeights = new int[] {0, 0};
							((GridBagLayout)panel14.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
							((GridBagLayout)panel14.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

							//---- toleranceCheckBox6 ----
							toleranceCheckBox6.setText("Simple Mutation Prob.:");
							panel14.add(toleranceCheckBox6, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 5), 0, 0));

							//---- simpleMutatorField ----
							simpleMutatorField.setModel(new SpinnerNumberModel(0.1, 0.0, 1.0, 0.05));
							panel14.add(simpleMutatorField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 0), 0, 0));
						}
						panel5.add(panel14, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 0), 0, 0));

						//======== panel15 ========
						{
							panel15.setLayout(new GridBagLayout());
							((GridBagLayout)panel15.getLayout()).columnWidths = new int[] {0, 0, 0};
							((GridBagLayout)panel15.getLayout()).rowHeights = new int[] {0, 0};
							((GridBagLayout)panel15.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
							((GridBagLayout)panel15.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

							//---- toleranceCheckBox7 ----
							toleranceCheckBox7.setText("Shifting Mutation Prob.:");
							panel15.add(toleranceCheckBox7, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 5), 0, 0));

							//---- shiftingMutatorField ----
							shiftingMutatorField.setModel(new SpinnerNumberModel(0.1, 0.0, 1.0, 0.05));
							panel15.add(shiftingMutatorField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 0), 0, 0));
						}
						panel5.add(panel15, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
					}
					panel2.add(panel5, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
				}
				contentPanel.add(panel2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//======== panel6 ========
				{
					panel6.setLayout(new GridBagLayout());
					((GridBagLayout)panel6.getLayout()).columnWidths = new int[] {0, 0};
					((GridBagLayout)panel6.getLayout()).rowHeights = new int[] {0, 0, 0};
					((GridBagLayout)panel6.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
					((GridBagLayout)panel6.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

					//======== panel4 ========
					{
						panel4.setBorder(new TitledBorder("Fitness"));
						panel4.setLayout(new GridBagLayout());
						((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {0, 0};
						((GridBagLayout)panel4.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0};
						((GridBagLayout)panel4.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
						((GridBagLayout)panel4.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

						//---- radioCost ----
						radioCost.setText("Cost");
						radioCost.setSelected(true);
						panel4.add(radioCost, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 0), 0, 0));

						//---- radioProduction ----
						radioProduction.setText("Prodution");
						panel4.add(radioProduction, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 0), 0, 0));

						//---- radioBoth ----
						radioBoth.setText("Both");
						panel4.add(radioBoth, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 0), 0, 0));

						//======== panel8 ========
						{
							panel8.setBorder(new TitledBorder("Extermination Method"));
							panel8.setLayout(new GridBagLayout());
							((GridBagLayout)panel8.getLayout()).columnWidths = new int[] {0, 0};
							((GridBagLayout)panel8.getLayout()).rowHeights = new int[] {0, 0, 0};
							((GridBagLayout)panel8.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
							((GridBagLayout)panel8.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

							//---- radioWorst ----
							radioWorst.setText("Worst");
							radioWorst.setSelected(true);
							panel8.add(radioWorst, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.BOTH,
								new Insets(0, 0, 5, 0), 0, 0));

							//---- radioRandom ----
							radioRandom.setText("Random");
							panel8.add(radioRandom, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 0), 0, 0));
						}
						panel4.add(panel8, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
					}
					panel6.add(panel4, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 0), 0, 0));

					//======== panel7 ========
					{
						panel7.setBorder(new TitledBorder("Stop criteria"));
						panel7.setLayout(new GridBagLayout());
						((GridBagLayout)panel7.getLayout()).columnWidths = new int[] {0, 0};
						((GridBagLayout)panel7.getLayout()).rowHeights = new int[] {0, 0, 0};
						((GridBagLayout)panel7.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
						((GridBagLayout)panel7.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

						//======== panel19 ========
						{
							panel19.setLayout(new GridBagLayout());
							((GridBagLayout)panel19.getLayout()).columnWidths = new int[] {0, 0, 0};
							((GridBagLayout)panel19.getLayout()).rowHeights = new int[] {0, 0};
							((GridBagLayout)panel19.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
							((GridBagLayout)panel19.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

							//---- genLimitCheckbox ----
							genLimitCheckbox.setText("Gen. limit:");
							genLimitCheckbox.setSelected(true);
							panel19.add(genLimitCheckbox, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 5), 0, 0));

							//---- genLimitField ----
							genLimitField.setModel(new SpinnerNumberModel(200, 10, null, 100));
							panel19.add(genLimitField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 0), 0, 0));
						}
						panel7.add(panel19, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 0), 0, 0));

						//======== panel21 ========
						{
							panel21.setLayout(new GridBagLayout());
							((GridBagLayout)panel21.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
							((GridBagLayout)panel21.getLayout()).rowHeights = new int[] {0, 0};
							((GridBagLayout)panel21.getLayout()).columnWeights = new double[] {1.0, 1.0, 0.0, 1.0E-4};
							((GridBagLayout)panel21.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

							//---- timeLimitCheckbox ----
							timeLimitCheckbox.setText("Time Limit:");
							panel21.add(timeLimitCheckbox, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 5), 0, 0));

							//---- timeLimitField ----
							timeLimitField.setModel(new SpinnerNumberModel(60, 1, null, 10));
							panel21.add(timeLimitField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 5), 0, 0));

							//---- label1 ----
							label1.setText("seg");
							panel21.add(label1, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.BOTH,
								new Insets(0, 0, 0, 0), 0, 0));
						}
						panel7.add(panel21, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
					}
					panel6.add(panel7, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
				}
				contentPanel.add(panel6, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			//======== buttonBar ========
			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
				((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

				//---- okButton ----
				okButton.setText("OK");
				buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- cancelButton ----
				cancelButton.setText("Cancel");
				buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		setSize(675, 385);
		setLocationRelativeTo(null);

		//---- fileGroup ----
		ButtonGroup fileGroup = new ButtonGroup();
		fileGroup.add(radio11);
		fileGroup.add(radio32);
		fileGroup.add(radio34);
		fileGroup.add(radio74);

		//---- fitnessGroup ----
		ButtonGroup fitnessGroup = new ButtonGroup();
		fitnessGroup.add(radioCost);
		fitnessGroup.add(radioProduction);
		fitnessGroup.add(radioBoth);

		//---- buttonGroup1 ----
		ButtonGroup buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(radioWorst);
		buttonGroup1.add(radioRandom);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JPanel panel1;
	public JRadioButton radio11;
	public JRadioButton radio32;
	public JRadioButton radio34;
	public JRadioButton radio74;
	protected JPanel panel2;
	private JPanel panel11;
	public JLabel toleranceCheckBox3;
	public JSpinner populationField;
	public JComboBox<String> selectionCombobox;
	private JPanel panel3;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	public JSpinner tsmProbField;
	public JSpinner tsmPopField;
	private JLabel label6;
	public JSpinner onePointProbField;
	public JSpinner onePointPopField;
	private JLabel label7;
	public JSpinner twoPointProbField;
	public JSpinner twoPointPopField;
	private JPanel panel5;
	private JPanel panel13;
	public JLabel toleranceCheckBox5;
	public JSpinner mutDistributionField;
	private JPanel panel14;
	public JLabel toleranceCheckBox6;
	public JSpinner simpleMutatorField;
	private JPanel panel15;
	public JLabel toleranceCheckBox7;
	public JSpinner shiftingMutatorField;
	private JPanel panel6;
	private JPanel panel4;
	public JRadioButton radioCost;
	public JRadioButton radioProduction;
	public JRadioButton radioBoth;
	private JPanel panel8;
	public JRadioButton radioWorst;
	public JRadioButton radioRandom;
	private JPanel panel7;
	private JPanel panel19;
	public JCheckBox genLimitCheckbox;
	public JSpinner genLimitField;
	private JPanel panel21;
	public JCheckBox timeLimitCheckbox;
	public JSpinner timeLimitField;
	private JLabel label1;
	private JPanel buttonBar;
	public JButton okButton;
	public JButton cancelButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
