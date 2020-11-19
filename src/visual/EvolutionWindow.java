/*
 * Created by JFormDesigner on Sat Jun 17 14:23:41 BRT 2017
 */

package visual;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author Marcio
 */
public class EvolutionWindow extends JFrame {
	public EvolutionWindow() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		dialogPane = new JPanel();
		contentPanel = new JSplitPane();
		progressPane = new JPanel();
		tabbedPane1 = new JTabbedPane();
		gantPane = new JPanel();
		matrixPane = new JPanel();
		scrollPane1 = new JScrollPane();
		scheduleTable = new JTable();
		buttonBar = new JPanel();
		backButton = new JButton();
		executeButton = new JToggleButton();

		//======== this ========
		setTitle("Genetic Scheduling");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{
				contentPanel.setOneTouchExpandable(true);
				contentPanel.setResizeWeight(0.5);

				//======== progressPane ========
				{
					progressPane.setLayout(new GridBagLayout());
					((GridBagLayout)progressPane.getLayout()).columnWidths = new int[] {0, 0};
					((GridBagLayout)progressPane.getLayout()).rowHeights = new int[] {0, 0};
					((GridBagLayout)progressPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
					((GridBagLayout)progressPane.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};
				}
				contentPanel.setLeftComponent(progressPane);

				//======== tabbedPane1 ========
				{

					//======== gantPane ========
					{
						gantPane.setLayout(new GridBagLayout());
						((GridBagLayout)gantPane.getLayout()).columnWidths = new int[] {0, 0};
						((GridBagLayout)gantPane.getLayout()).rowHeights = new int[] {0, 0};
						((GridBagLayout)gantPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
						((GridBagLayout)gantPane.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};
					}
					tabbedPane1.addTab("Gant", gantPane);

					//======== matrixPane ========
					{
						matrixPane.setLayout(new GridBagLayout());
						((GridBagLayout)matrixPane.getLayout()).columnWidths = new int[] {0, 0};
						((GridBagLayout)matrixPane.getLayout()).rowHeights = new int[] {0, 0};
						((GridBagLayout)matrixPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
						((GridBagLayout)matrixPane.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

						//======== scrollPane1 ========
						{

							//---- scheduleTable ----
							scheduleTable.setModel(new DefaultTableModel(
								new Object[][] {
									{null, null, null, null, null, null, "", "", null},
								},
								new String[] {
									"Part", "Workingstep", "Id", "Id-Pre", "Machine", "Start", "End", "Duration", "Cost"
								}
							));
							scrollPane1.setViewportView(scheduleTable);
						}
						matrixPane.add(scrollPane1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
					}
					tabbedPane1.addTab("Matrix", matrixPane);
				}
				contentPanel.setRightComponent(tabbedPane1);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			//======== buttonBar ========
			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
				((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

				//---- backButton ----
				backButton.setText("<    Back");
				buttonBar.add(backButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- executeButton ----
				executeButton.setText("Execute\n");
				buttonBar.add(executeButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		setSize(510, 340);
		setLocationRelativeTo(null);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel dialogPane;
	private JSplitPane contentPanel;
	public JPanel progressPane;
	private JTabbedPane tabbedPane1;
	public JPanel gantPane;
	private JPanel matrixPane;
	private JScrollPane scrollPane1;
	public JTable scheduleTable;
	private JPanel buttonBar;
	public JButton backButton;
	public JToggleButton executeButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
