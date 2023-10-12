package br.gov.cesarschool.poo.bonusvendas.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
<<<<<<< Updated upstream
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


import br.gov.cesarschool.poo.bonusvendas.negocio.VendedorMediator;
=======
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
>>>>>>> Stashed changes

public class TelaAcumuloResgate {
	
	protected Shell shell;
<<<<<<< Updated upstream
	
=======
	private Text txtNumeroCaixaDe;
	private Text text_2;
	private Label lblNewLabel;
	private Label lblNewLabel_1;
	private Label lblNewLabel_2;
	private Label lblNewLabel_3;
	private Label lblNewLabel_4;
	private Text text;

>>>>>>> Stashed changes

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaAcumuloResgate window = new TelaAcumuloResgate();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(550, 350);
		shell.setText("SWT Application");
		
<<<<<<< Updated upstream
=======
		txtNumeroCaixaDe = new Text(shell, SWT.BORDER);
		txtNumeroCaixaDe.setToolTipText("");
		txtNumeroCaixaDe.setBounds(155, 73, 91, 18);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		this.lblNewLabel = lblNewLabel;
		lblNewLabel.setBounds(21, 75, 127, 15);
		lblNewLabel.setText("Numero da Caixa de Bonus");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		this.lblNewLabel_2 = lblNewLabel_2;
		lblNewLabel_2.setBounds(285, 74, 44, 15);
		lblNewLabel_2.setText("Saldo");
		
		Button btnRadioButton = new Button(shell, SWT.RADIO);
		btnRadioButton.setBounds(21, 119, 77, 15);
		btnRadioButton.setText("Acumular");
		
		Button btnRadioButton_1 = new Button(shell, SWT.RADIO);
		btnRadioButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnRadioButton_1.setBounds(108, 119, 77, 15);
		btnRadioButton_1.setText("Regastar");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setEditable(false);
		text_2.setBounds(322, 72, 59, 18);
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(264, 73, 1, 146);
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		lblNewLabel_4.setBounds(212, 10, 111, 31);
		lblNewLabel_4.setText("Vendedor");
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setBounds(21, 98, 77, 15);
		lblNewLabel_5.setText("Operação");
		
		Button btnNewButton = new Button(shell, SWT.BORDER);
		btnNewButton.setForeground(SWTResourceManager.getColor(192, 192, 192));
		btnNewButton.setBounds(21, 165, 61, 20);
		btnNewButton.setText("Buscar");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setItems(new String[] {"Serviço", "Produto", "Cash"});
		combo.setBounds(285, 115, 96, 19);
		combo.setText("Tipo de resgate");
		
		Label lblNewLabel_6 = new Label(shell, SWT.NONE);
		lblNewLabel_6.setBounds(285, 154, 49, 15);
		lblNewLabel_6.setText("Valor");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(322, 152, 41, 18);
		
		Button btnNewButton_1 = new Button(shell, SWT.BORDER);
		btnNewButton_1.setBounds(285, 194, 96, 20);
		btnNewButton_1.setText("Acumular/Resgatar");
		
		Button btnNewButton_2 = new Button(shell, SWT.BORDER);
		btnNewButton_2.setBounds(285, 220, 61, 20);
		btnNewButton_2.setText("Voltar");

>>>>>>> Stashed changes
	}
}
