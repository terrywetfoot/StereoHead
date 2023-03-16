import javax.swing.BorderFactory;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanPot extends JPanel implements ChangeListener {

	private JSlider slider;
	public JLabel label;
	public int value;
	
	///////////////////////////////////////////////////////
	///CONSTRUCTOR
	public PanPot() {
		slider = new JSlider(JSlider.HORIZONTAL, -100, 100, 0);
		slider.setMajorTickSpacing(100);
		slider.setMinorTickSpacing(20);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(this);

		label = new JLabel("0");
		label.setBorder(BorderFactory.createEtchedBorder());
		

		add(slider);
		add(label);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		value = slider.getValue();
		label.setText(Integer.toString(value));
	}

	public int getValue() {
		return slider.getValue();
	}
	
	public void reset() {
		slider.setValue(0);
	}
}
