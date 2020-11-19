package visual;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import system.Controller;
import system.GeneticAlgorithm;

public class SettingEvents extends SettingWindow implements ActionListener {
	private Controller controller;
//////////////////////////////////constructor///////////////////////////////////////
	public SettingEvents(Controller controller) {
		setController(controller);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		this.setVisible(true);
	}
///////////////////////////////////Methods///////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(okButton)) {
			String file = null;
			if(radio11.isSelected()) 
				file = radio11.getText();
			if(radio32.isSelected()) 
				file = radio32.getText();
			if(radio34.isSelected()) 
				file = radio34.getText();
			if(radio74.isSelected()) 
				file = radio74.getText();
			int fitness = 0;
			if(radioCost.isSelected())
				fitness = Controller.COST;
			if(radioProduction.isSelected())
				fitness = Controller.PRODUTION;
			if(radioBoth.isSelected())
				fitness = Controller.BOTH;
			int elitism = 0;
			if(radioWorst.isSelected()) 
				elitism = Controller.WORST;
			else if(radioRandom.isSelected())
				elitism = Controller.RANDOM;
			double tsm = (Double)tsmPopField.getValue();
			double onePoint = (Double)onePointPopField.getValue();
			double twoPoint = (Double)twoPointPopField.getValue();
			if((tsm + twoPoint + onePoint)!= 1.0) {
				JOptionPane.showMessageDialog(this, "The distribution of the population in the amounts of population must sum 1", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			int selection = 0;
			if(selectionCombobox.getSelectedIndex() == 0)
				selection = Controller.TOURNAMENT;
			else if(selectionCombobox.getSelectedIndex() == 1)
				selection = Controller.SIMPLE;
			controller.setParameters(file, (Integer)populationField.getValue(), selection, (Double)tsmProbField.getValue(), tsm, (Double)onePointProbField.getValue(), onePoint, (Double)twoPointProbField.getValue(), twoPoint, (Double)mutDistributionField.getValue(), (Double)simpleMutatorField.getValue(), (Double)shiftingMutatorField.getValue(), fitness, elitism, genLimitCheckbox.isSelected(), timeLimitCheckbox.isSelected(), (Integer)genLimitField.getValue(), (Integer)timeLimitField.getValue());
			controller.stepForward();
			this.dispose();
		}
		else if(e.getSource().equals(cancelButton)) {
			this.dispose();
		}
	}
//////////////////////////////////Getters and Setters////////////////////////////////
	public Controller getController() {
		return controller;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
}
