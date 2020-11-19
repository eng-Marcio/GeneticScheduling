package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.xy.XYIntervalDataItem;
import org.jfree.data.xy.XYIntervalSeries;
import org.jfree.data.xy.XYIntervalSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import stages.ProcessCell;
import system.Controller;
import exportPack.Part;
import exportPack.Workingstep;

public class EvolutionEvents extends EvolutionWindow implements ActionListener {
	private Controller controller;
	private XYSeries evoSerie;
	private XYIntervalSeriesCollection taskDataset;
	
/////////////////////////////////////////constructor///////////////////////////////////////
	public EvolutionEvents(Controller controller) {
		setController(controller);
		backButton.addActionListener(this);
		executeButton.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		configurePane();
		this.setVisible(true);
	}
/////////////////////////////////////////Methods///////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(executeButton)) {
			if(executeButton.isSelected()) {
				executeButton.setText("Stop");
				controller.evolve();
			}
			else {
				executeButton.setText("Execute");
				controller.stopEvolve();
			}
		}
		else if(e.getSource().equals(backButton)) {
			if(executeButton.isSelected())
				JOptionPane.showMessageDialog(this, "First you have to stop the execution of the algorithm.", "Error", JOptionPane.ERROR_MESSAGE);
			else {
				controller.stepBack();
				this.dispose();
			}
		}
	}
	public void configurePane() {
		///////////////evolution graph////////////////////
		evoSerie = new XYSeries("Best Solution");
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(evoSerie);
		JFreeChart chart = ChartFactory.createXYLineChart("Solution Progress", "generation", "Score", dataset, PlotOrientation.VERTICAL, true, true, false);
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setShapesVisible(false);
//        Rectangle rect = new Rectangle(1, 1);
//        renderer.setSeriesShape(1, rect);
		((XYPlot)chart.getPlot()).setRenderer(renderer);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinePaint(Color.gray);
		ChartPanel chartPanel = new ChartPanel(chart);
		progressPane.add(chartPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		//////////////////gantt graph////////////////////////////////
		setTaskDataset(new XYIntervalSeriesCollection());
		taskDataset.setNotify(false);
		JFreeChart timeChart = ChartFactory.createXYBarChart(
				"Time Multi Piece Routing", "time", true, "Machines",
				taskDataset, PlotOrientation.HORIZONTAL,
				true, false, false);
		XYPlot plot2 = (XYPlot) timeChart.getPlot();
		plot2.setRangePannable(true);
		plot2.setRangeAxis(new DateAxis("Time"));
		String[] machines = new String[controller.getGaData().getMachines().size()];
		machines= controller.getGaData().getMachines().toArray(machines);
		SymbolAxis xAxis = new SymbolAxis("Machines", machines);
		xAxis.setGridBandsVisible(false);
		plot2.setDomainAxis(xAxis);
		XYBarRenderer renderer2 = (XYBarRenderer) plot2.getRenderer();
		renderer2.setUseYInterval(true);
		plot2.setRenderer(renderer2);
		plot2.setBackgroundPaint(Color.white);
		plot2.setDomainGridlinePaint(Color.lightGray);
		plot2.setRangeGridlinePaint(Color.lightGray);
		ChartUtilities.applyCurrentTheme(timeChart);
		ChartPanel timePanel = new ChartPanel(timeChart);
		gantPane.add(timePanel, new GridBagConstraints(0, 0, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		this.revalidate();
		this.repaint();
	}
	public void printResult(int generation, double score, ArrayList<ProcessCell>resultSet) {
		evoSerie.add(generation, score);
		if(!evoSerie.isEmpty()) {
			if(score < evoSerie.getMinY())
				return;
		}
		//if((generation >= controller.getGenerationLimit())) {
		if((generation%20 == 0)||(generation >= controller.getGenerationLimit())) {
			taskDataset.removeAllSeries();
			for(int i = 0; i < controller.getGaData().getParts().size(); i++) {
				XYIntervalSeries serie = new XYIntervalSeries(controller.getGaData().getParts().get(i).getName());
				taskDataset.addSeries(serie);
			}
			//clear table
			int rowCount = scheduleTable.getRowCount();
			//Remove rows one by one from the end of the table
			for (int i = rowCount - 1; i >= 0; i--) {
			    ((DefaultTableModel)scheduleTable.getModel()).removeRow(i);
			}
			for (int i = 0; i < resultSet.size(); i++) {
				String ws = resultSet.get(i).getWorkingstep().getName();
				String machine = resultSet.get(i).getMachine();
				String part = findPart(resultSet.get(i).getWorkingstep());
				String id = getId(resultSet.get(i).getWorkingstep());
				String idPrescedente = getId(resultSet.get(i).getWorkingstep().getPrecedentWorkinstep());
				Date referencia = new Date();
				referencia.setHours(0);
				referencia.setMinutes(0);
				referencia.setSeconds(0);
				long reference = referencia.getTime();
				Millisecond start = new Millisecond(new Date(reference + Math.round(resultSet.get(i).getStart()*60000)));
				Millisecond end = new Millisecond(new Date(reference + Math.round(resultSet.get(i).getEnd()*60000)));
				String duration = "" + (resultSet.get(i).getEnd() - resultSet.get(i).getStart());
				Object[] line = new Object[] {part,ws, id, idPrescedente, machine,start.toString(),end.toString(),duration, resultSet.get(i).getTotalCost()};
				DefaultTableModel model = (DefaultTableModel) scheduleTable.getModel();
				model.addRow(line);
				XYIntervalSeries serie = getSerieByName(part);
				int position = controller.getGaData().getMachines().indexOf(machine);
				if(i != resultSet.size() - 1)
					serie.add(new XYIntervalDataItem(position, position - 0.45, position + 0.45, start.getFirstMillisecond(), start.getFirstMillisecond(), end.getFirstMillisecond()),false);
				else
					serie.add(new XYIntervalDataItem(position, position - 0.45, position + 0.45, start.getFirstMillisecond(), start.getFirstMillisecond(), end.getFirstMillisecond()),true);
			}
			taskDataset.setNotify(true);
			taskDataset.setNotify(false);
		}
	}
	public String findPart(Workingstep workingstep) {
		for(int i = 0; i < controller.getGaData().getParts().size(); i++) {
			if(controller.getGaData().getParts().get(i).getWorkingsteps().contains(workingstep))
				return controller.getGaData().getParts().get(i).getName();
		}
		return null;
	}
	public XYIntervalSeries getSerieByName(String name) {
		for(int i =0; i < taskDataset.getSeriesCount(); i++) {
			if(taskDataset.getSeries(i).getKey().equals(name))
				return taskDataset.getSeries(i);
		}
		return null;
	}
	public String getId(Workingstep ws) {
		if(ws == null)
			return "-";
		for(int i = 0; i < controller.getGaData().getParts().size(); i++) {
			if(controller.getGaData().getParts().get(i).getWorkingsteps().contains(ws))
				return i + "-" + controller.getGaData().getParts().get(i).getWorkingsteps().indexOf(ws);
		}
		return null;
	}
////////////////////////////////////////Getters and Setters////////////////////////////////
	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
	public XYSeries getEvoSerie() {
		return evoSerie;
	}
	public void setEvoSerie(XYSeries evoSerie) {
		this.evoSerie = evoSerie;
	}
	public XYIntervalSeriesCollection getTaskDataset() {
		return taskDataset;
	}
	public void setTaskDataset(XYIntervalSeriesCollection taskDataset) {
		this.taskDataset = taskDataset;
	}
}
