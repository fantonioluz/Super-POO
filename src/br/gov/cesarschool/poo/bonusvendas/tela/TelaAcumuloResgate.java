package br.gov.cesarschool.poo.bonusvendas.tela;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.gov.cesarschool.poo.bonusvendas.dao.CaixaDeBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;






public class TelaAcumuloResgate {
	
	protected Shell shell;
	
	private CaixaDeBonusDAO mediator = new CaixaDeBonusDAO();


	private Text NumeroCaixa;
	private Text Saldo;
	private Text valor;
	private Button Acumular;
	private Button Resgatar;
	private Combo tipoResgate;
	private Button acumularOuResgatar;
	private Button voltar;
	private Button Buscar;



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
		this.Acumular = Acumular;
		Acumular.setBounds(21, 119, 77, 15);
		Acumular.setText("Acumular");
		
		Button Resgatar = new Button(shell, SWT.RADIO);
		this.Resgatar = Resgatar;
		Resgatar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		Resgatar.setBounds(108, 119, 77, 15);
		Resgatar.setText("Regastar");
		
		Saldo = new Text(shell, SWT.BORDER);
		Saldo.setEnabled(false);
		Saldo.setEditable(false);
		Saldo.setBounds(322, 73, 59, 18);
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(264, 73, 1, 146);
		
		
		Combo tipoResgate = new Combo(shell, SWT.NONE);
		tipoResgate.setEnabled(false);
		this.tipoResgate = tipoResgate;
		tipoResgate.setItems(new String[] {"Serviço", "Produto", "Cash"});
		tipoResgate.setBounds(285, 115, 96, 19);
		tipoResgate.setText("Tipo de resgate");
		
		valor = new Text(shell, SWT.BORDER);
		valor.setEnabled(false);
		valor.setBounds(322, 152, 41, 18);
		
		Button acumularOuResgatar = new Button(shell, SWT.BORDER);
		acumularOuResgatar.setEnabled(false);
		this.acumularOuResgatar = acumularOuResgatar;
		acumularOuResgatar.setBounds(285, 194, 96, 20);
		acumularOuResgatar.setText("Acumular/Resgatar");
		
		Button voltar = new Button(shell, SWT.BORDER);
		voltar.setEnabled(false);
		this.voltar = voltar;
		voltar.setBounds(285, 220, 61, 20);
		voltar.setText("Voltar");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(24, 76, 128, 15);
		lblNewLabel.setText("Numero da Caixa de Bonus");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(24, 100, 49, 15);
		lblNewLabel_1.setText("Operação");
		
		Label lblSaldo = new Label(shell, SWT.NONE);
		lblSaldo.setEnabled(false);
		lblSaldo.setBounds(283, 75, 33, 15);
		lblSaldo.setText("Saldo");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setBounds(283, 154, 33, 15);
		lblNewLabel_2.setText("Valor");
		
		Button Buscar = new Button(shell, SWT.BORDER);
		Buscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				CaixaDeBonus caixaDeBonus = mediator.buscar(Long.parseLong(NumeroCaixa.getText()));
				if(caixaDeBonus == null) {
					JOptionPane.showMessageDialog(null, 
					"Caixa de bonus inexistente!");
				} else {
					Saldo.setText(String.valueOf(caixaDeBonus.getSaldo()));
					Saldo.setEnabled(true);
					lblSaldo.setEnabled(true);
					if(Acumular.getSelection()) {
						valor.setEnabled(true);
						acumularOuResgatar.setEnabled(true);
						voltar.setEnabled(true);
					} else if(Resgatar.getSelection()) {
						tipoResgate.setEnabled(true);
						valor.setEnabled(true);
						acumularOuResgatar.setEnabled(true);
						voltar.setEnabled(true);
					}
				}
				


			}
		});
		this.Buscar = Buscar;
		Buscar.setBounds(21, 194, 61, 20);
		Buscar.setText("Buscar");


	}



	
}
