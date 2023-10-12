package br.gov.cesarschool.poo.bonusvendas.tela;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import br.gov.cesarschool.poo.bonusvendas.negocio.AcumuloResgateMediator;






public class TelaAcumuloResgate {
	
	protected Shell shell;
	
	private AcumuloResgateMediator mediator = AcumuloResgateMediator.getInstancia();


	private Text NumeroCaixa;
	private Text Saldo;
	private Label lblNewLabel;
	private Label lblNewLabel_1;
	private Label lblNewLabel_2;
	private Label lblNewLabel_3;
	private Label lblNewLabel_4;
	private Text valor;



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
		
		NumeroCaixa = new Text(shell, SWT.BORDER);
		NumeroCaixa.setToolTipText("");
		NumeroCaixa.setBounds(155, 73, 91, 18);
		
		Button Acumular = new Button(shell, SWT.RADIO);
		Acumular.setBounds(21, 119, 77, 15);
		Acumular.setText("Acumular");
		
		Button Resgatar = new Button(shell, SWT.RADIO);
		Resgatar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		Resgatar.setBounds(108, 119, 77, 15);
		Resgatar.setText("Regastar");
		
		Saldo = new Text(shell, SWT.BORDER);
		Saldo.setEditable(false);
		Saldo.setBounds(322, 72, 59, 18);
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(264, 73, 1, 146);
		
		
		Combo tipoResgate = new Combo(shell, SWT.NONE);
		tipoResgate.setItems(new String[] {"Serviço", "Produto", "Cash"});
		tipoResgate.setBounds(285, 115, 96, 19);
		tipoResgate.setText("Tipo de resgate");
		
		valor = new Text(shell, SWT.BORDER);
		valor.setBounds(322, 152, 41, 18);
		
		Button acumularOuResgatar = new Button(shell, SWT.BORDER);
		acumularOuResgatar.setBounds(285, 194, 96, 20);
		acumularOuResgatar.setText("Acumular/Resgatar");
		
		Button voltar = new Button(shell, SWT.BORDER);
		voltar.setBounds(285, 220, 61, 20);
		voltar.setText("Voltar");


	}
}
