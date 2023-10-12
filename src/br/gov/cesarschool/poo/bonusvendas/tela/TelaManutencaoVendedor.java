package br.gov.cesarschool.poo.bonusvendas.tela;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import br.gov.cesarschool.poo.bonusvendas.negocio.VendedorMediator;

public class TelaManutencaoVendedor {

	protected Shell shell;
	
	private VendedorMediator vendedorMediator = VendedorMediator.getInstancia();
	
	private Text textCPF;
	private Text textNomeCompleto;
	private Text textRenda;
	private Text textLogradouro;
	private Text textNumero;
	private Text textComplemento;
	private Text textCEP;
	private Text textCidade;
	private Text textDataDeNascimento;
	private Text txtBrasil;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaManutencaoVendedor window = new TelaManutencaoVendedor();
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
		display.dispose();
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 35, 151, 14);
		lblNewLabel.setText("CPF");
		
		textCPF = new Text(shell, SWT.BORDER);
		textCPF.setBounds(10, 55, 134, 19);
		addCPFFormatter(textCPF);
		
		textNomeCompleto = new Text(shell, SWT.BORDER);
		textNomeCompleto.setBounds(10, 104, 151, 19);
		addStringValidation(textNomeCompleto);
		    
		
		Label lblSexo = new Label(shell, SWT.NONE);
		lblSexo.setBounds(10, 129, 59, 14);
		lblSexo.setText("Sexo");
		
		Button btnRadioButtonFeminino = new Button(shell, SWT.RADIO);
		btnRadioButtonFeminino.setBounds(10, 149, 90, 18);
		btnRadioButtonFeminino.setText("Feminino");
		
		Button btnRadioButtonMasculino = new Button(shell, SWT.RADIO);
		btnRadioButtonMasculino.setBounds(10, 171, 90, 18);
		btnRadioButtonMasculino.setText("Masculino");
		
		Label lblNomeCompleto = new Label(shell, SWT.NONE);
		lblNomeCompleto.setBounds(10, 84, 134, 14);
		lblNomeCompleto.setText("Nome Completo");
		
		Label lblDataDeNascimento = new Label(shell, SWT.NONE);
		lblDataDeNascimento.setBounds(10, 202, 134, 14);
		lblDataDeNascimento.setText("Data de Nascimento");
		
		textRenda = new Text(shell, SWT.BORDER);
		textRenda.setBounds(177, 55, 64, 19);
		addRendaFormatter(textRenda);
		
		Label lblLogradouro = new Label(shell, SWT.NONE);
		lblLogradouro.setBounds(177, 84, 122, 14);
		lblLogradouro.setText("Logradouro");
		
		Label lblRenda = new Label(shell, SWT.NONE);
		lblRenda.setBounds(182, 35, 59, 14);
		lblRenda.setText("Renda");
		
		
		textLogradouro = new Text(shell, SWT.BORDER);
		textLogradouro.setBounds(177, 104, 193, 19);
		
		Label lblNmero = new Label(shell, SWT.NONE);
		lblNmero.setBounds(182, 129, 59, 14);
		lblNmero.setText("Número");
		
		textNumero = new Text(shell, SWT.BORDER);
		textNumero.setBounds(177, 149, 97, 19);
		addNumeroFormatter(textNumero);
		
		
		Label lblComplemento = new Label(shell, SWT.NONE);
		lblComplemento.setBounds(177, 175, 90, 14);
		lblComplemento.setText("Complemento");
		
		textComplemento = new Text(shell, SWT.BORDER);
		textComplemento.setBounds(177, 195, 97, 19);
		
		Label lblCep = new Label(shell, SWT.NONE);
		lblCep.setBounds(182, 222, 38, 14);
		lblCep.setText("CEP");
		
		textCEP = new Text(shell, SWT.BORDER);
		textCEP.setBounds(177, 242, 97, 19);
		addCEPFormatter(textCEP);
		
		Label lblCidade = new Label(shell, SWT.NONE);
		lblCidade.setBounds(324, 35, 59, 14);
		lblCidade.setText("Cidade");
		
		textCidade = new Text(shell, SWT.BORDER);
		textCidade.setBounds(324, 55, 90, 19);
		
		Label lblEstado = new Label(shell, SWT.NONE);
		lblEstado.setBounds(324, 140, 59, 14);
		lblEstado.setText("Estado");
		
		Combo comboEstado = new Combo(shell, SWT.NONE);
		comboEstado.setItems(new String[] {"Acre", "Amapá", "Amazonas", "Alagoas", "Aracajú", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goias", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Sul", "Rio Grande do Norte", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Tocantins"});
		comboEstado.setBounds(324, 167, 90, 22);
		
		
		textDataDeNascimento = new Text(shell, SWT.BORDER);
		textDataDeNascimento.setBounds(10, 222, 122, 19);
		addDataNascimentoFormatter(textDataDeNascimento);
		
		Label lblPais = new Label(shell, SWT.NONE);
		lblPais.setBounds(324, 195, 59, 14);
		lblPais.setText("Pais");
		
		txtBrasil = new Text(shell, SWT.BORDER);
		txtBrasil.setEnabled(false);
		txtBrasil.setText("Brasil");
		txtBrasil.setBounds(324, 217, 64, 19);

		
		Button enviarButton = new Button(shell, SWT.BORDER);
		enviarButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		enviarButton.setBounds(320, 241, 94, 27);
		enviarButton.setText("Enviar");
		
		   
	}
	
    
	private void addStringValidation(final Text text) {
        text.addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent e) {
                if (!e.text.matches("[a-zA-Z ]*")) {
                    e.doit = false;
                }
            }
        });
    }

	
	private void addCPFFormatter(final Text text) {
	    text.addVerifyListener(new VerifyListener() {
	        @Override
	        public void verifyText(VerifyEvent e) {
	            String currentText = ((Text) e.widget).getText();
	            String newText = currentText.substring(0, e.start) + e.text + currentText.substring(e.end);
	            
	            
	            String digitsOnly = newText.replaceAll("[^0-9]", "");
	            
	            
	            if (digitsOnly.length() >= 11) {
	                digitsOnly = digitsOnly.substring(0, 11);
	                String formattedCPF = String.format("%s.%s.%s-%s", digitsOnly.substring(0, 3), digitsOnly.substring(3, 6), digitsOnly.substring(6, 9), digitsOnly.substring(9, 11));
	                text.setText(formattedCPF);
	                e.doit = false;  
	            } else {
	                text.setText(digitsOnly);  
	            }
	        }
	    });
	}

	
	
	
	
	 private void addCEPFormatter(final Text text) {
	        text.addVerifyListener(new VerifyListener() {
	            @Override
	            public void verifyText(VerifyEvent e) {
	                String newText = text.getText().substring(0, e.start) + e.text + text.getText(e.end, text.getText().length() - 1);
	                if (!newText.matches("\\d{0,5}-\\d{0,3}")) {
	                    e.doit = false;
	                }
	            }
	        });
	    }

	   
	    private void addRendaFormatter(final Text text) {
	        text.addVerifyListener(new VerifyListener() {
	            @Override
	            public void verifyText(VerifyEvent e) {
	                String newText = text.getText().substring(0, e.start) + e.text + text.getText(e.end, text.getText().length() - 1);
	                if (!newText.matches("\\d*\\.?\\d*")) {
	                    e.doit = false;
	                }
	            }
	        });
	    }

	    
	    private void addDataNascimentoFormatter(final Text text) {
	        text.addVerifyListener(new VerifyListener() {
	            @Override
	            public void verifyText(VerifyEvent e) {
	                String currentText = ((Text) e.widget).getText();
	                String newText = currentText.substring(0, e.start) + e.text + currentText.substring(e.end);
	                if (!newText.matches("\\d{0,2}(\\/\\d{0,2}(\\/\\d{0,4})?)?")) {
	                    e.doit = false;
	                }
	            }
	        });
    }
	    
	    
	    private void addNumeroFormatter(final Text text) {
	        text.addVerifyListener(new VerifyListener() {
	            @Override
	            public void verifyText(VerifyEvent e) {
	                String currentText = ((Text) e.widget).getText();
	                String newText = currentText.substring(0, e.start) + e.text + currentText.substring(e.end);
	                if (!newText.matches("\\d{0,2}(\\/\\d{0,2}(\\/\\d{0,4})?)?")) {
	                    e.doit = false;
	                }
	            }
	        });
    }
}