package br.gov.cesarschool.poo.bonusvendas.tela;

import java.time.LocalDate;
import javax.swing.JOptionPane;

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

import br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo;
import br.gov.cesarschool.poo.bonusvendas.negocio.VendedorMediator;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.StringUtil;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.ValidadorCPF;


public class TelaManutencaoVendedor {

	protected Shell shell;
	
	private VendedorMediator vendedorMediator = VendedorMediator.getInstancia();
	private VendedorDAO vendedorDAO = new VendedorDAO();
	
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
		lblEstado.setBounds(306, 129, 59, 14);
		lblEstado.setText("Estado");
		
		Combo comboEstado = new Combo(shell, SWT.NONE);
		comboEstado.setItems(new String[] {"Acre", "Amapá", "Amazonas", "Alagoas", "Aracajú", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goias", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Sul", "Rio Grande do Norte", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Tocantins"});
		comboEstado.setBounds(306, 149, 134, 27);
		
		
		textDataDeNascimento = new Text(shell, SWT.BORDER);
		textDataDeNascimento.setBounds(10, 222, 122, 19);
		addDataFormatter(textDataDeNascimento);
	
		
		Label lblPais = new Label(shell, SWT.NONE);
		lblPais.setBounds(306, 175, 59, 14);
		lblPais.setText("Pais");
		
		txtBrasil = new Text(shell, SWT.BORDER);
		txtBrasil.setEnabled(false);
		txtBrasil.setText("Brasil");
		txtBrasil.setBounds(306, 195, 64, 19);

		
		Button enviarButton = new Button(shell, SWT.BORDER);
		enviarButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String cpf = textCPF.getText();
				cpf = cpf.replace(".", "");
				cpf = cpf.replace("-", "");

				if(ValidadorCPF.ehCpfValido(cpf) == false) {
					JOptionPane.showMessageDialog(null, "CPF inválido!");
					return;
				}
				if(vendedorDAO.buscar(cpf) != null) {
					JOptionPane.showMessageDialog(null, "CPF já cadastrado!");
					return;
				}
				String nomeCompleto = textNomeCompleto.getText();
				if(StringUtil.ehNuloOuBranco(nomeCompleto)) {
					JOptionPane.showMessageDialog(null, "Nome Completo inválido!");
					return;
				}
				String sexo = "";
				if (btnRadioButtonFeminino.getSelection()) {
					sexo = "Feminino";
				} else if (btnRadioButtonMasculino.getSelection()) {
					sexo = "Masculino";
				}else{
					JOptionPane.showMessageDialog(null, "Sexo inválido!");
					return;
				}
				String dataDeNascimentostr = textDataDeNascimento.getText();
				String[] parts = dataDeNascimentostr.split("/");
				if(parts.length != 3) {
					JOptionPane.showMessageDialog(null, "Data de Nascimento inválida!");
					return;
				}
				int dia = Integer.parseInt(parts[0]);
				int mes = Integer.parseInt(parts[1]);
				int ano = Integer.parseInt(parts[2]);

				if(mes > 12 || mes < 1 || dia > 31 || dia < 1 || ano > 2005 || ano < 1900) {
					JOptionPane.showMessageDialog(null, "Data de Nascimento inválida!");
					return;
				}


				String renda = textRenda.getText();
				if(StringUtil.ehNuloOuBranco(renda)) {
					JOptionPane.showMessageDialog(null, "Renda inválida!");
					return;
				}
				String logradouro = textLogradouro.getText();
				if(StringUtil.ehNuloOuBranco(logradouro)) {
					JOptionPane.showMessageDialog(null, "Logradouro inválido!");
					return;
				}
				String numero = textNumero.getText();
				if(StringUtil.ehNuloOuBranco(numero)) {
					JOptionPane.showMessageDialog(null, "Número inválido!");
					return;
				}
				String complemento = textComplemento.getText();
				if(StringUtil.ehNuloOuBranco(complemento)) {
					JOptionPane.showMessageDialog(null, "Complemento inválido!");
					return;
				}
				String cep = textCEP.getText();
				if(StringUtil.ehNuloOuBranco(cep)) {
					JOptionPane.showMessageDialog(null, "CEP inválido!");
					return;
				}
				String cidade = textCidade.getText();
				if(StringUtil.ehNuloOuBranco(cidade)) {
					JOptionPane.showMessageDialog(null, "Cidade inválida!");
					return;
				}
				String estado = comboEstado.getText();
				if(StringUtil.ehNuloOuBranco(estado)) {
					JOptionPane.showMessageDialog(null, "Estado inválido!");
					return;
				}
				String pais = txtBrasil.getText();
				if(StringUtil.ehNuloOuBranco(pais)) {
					JOptionPane.showMessageDialog(null, "Pais inválido!");
					return;
				}

				
				Endereco endereco = new Endereco(logradouro, Integer.parseInt(numero), complemento, cep, cidade, estado, pais);
				Sexo sexoEnum = null;
				if(sexo.equals("Feminino")) {
					sexoEnum = Sexo.FEMININO;
				} else if(sexo.equals("Masculino")) {
					sexoEnum = Sexo.MASCULINO;
				}
				Vendedor vendedor = new Vendedor(cpf, nomeCompleto, sexoEnum, LocalDate.of(ano, mes, dia), Double.parseDouble(renda), endereco);
				vendedorMediator.incluir(vendedor);
				JOptionPane.showMessageDialog(null, "Vendedor cadastrado com sucesso!");
			}
		});
		enviarButton.setBounds(306, 234, 94, 27);
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


	
	private boolean ignoreModifyEvent = false;

	private void addCPFFormatter(final Text text) {
	    text.addModifyListener(new ModifyListener() {
	        @Override
	        public void modifyText(ModifyEvent e) {
	            if (ignoreModifyEvent) {
	                return;
	            }

	            ignoreModifyEvent = true;

	            String currentText = text.getText().replaceAll("[^0-9]", "");
	            StringBuilder formattedText = new StringBuilder();
	            int length = currentText.length();

	            for (int i = 0; i < length; i++) {
	                formattedText.append(currentText.charAt(i));
	                if (i == 2 || i == 5) {
	                    formattedText.append(".");
	                } else if (i == 8) {
	                    formattedText.append("-");
	                }
	            }

	         
	            if (length > 11) {
	                currentText = currentText.substring(0, 11);
	                length = 11;
	            }
	            
	            
	            if (length == 11) {
	                formattedText.setLength(0); 
	                formattedText.append(currentText.substring(0, 3));
	                formattedText.append(".");
	                formattedText.append(currentText.substring(3, 6));
	                formattedText.append(".");
	                formattedText.append(currentText.substring(6, 9));
	                formattedText.append("-");
	                formattedText.append(currentText.substring(9, 11));
	            }

	            text.setText(formattedText.toString());
	            text.setSelection(formattedText.length());

	            ignoreModifyEvent = false;
	        }
	    });
	}



	
	private boolean ignoreModifyEventCEP = false;

	private void addCEPFormatter(final Text text) {
	    text.addModifyListener(new ModifyListener() {
	        @Override
	        public void modifyText(ModifyEvent e) {
	            if (ignoreModifyEventCEP) {
	                return;
	            }

	            ignoreModifyEventCEP = true;

	            String currentText = text.getText().replaceAll("[^0-9]", "");
	            StringBuilder formattedText = new StringBuilder();
	            int length = currentText.length();

	            if (length > 8) {
	                currentText = currentText.substring(0, 8);
	                length = 8;
	            }
	            if (length < 8) {
	            	// JOptionPane.showMessageDialog(null, "CEP inválido!");
		        	System.out.println("CEP Inválido!");
	            }

	            for (int i = 0; i < length; i++) {
	                if (i == 2) {
	                    formattedText.append(".");
	                } else if (i == 5) {
	                    formattedText.append("-");
	                }
	                formattedText.append(currentText.charAt(i));
	            }

	            text.setText(formattedText.toString());
	            text.setSelection(formattedText.length());

	            ignoreModifyEventCEP = false;
	        }
	    });
	}


	   
	private boolean ignoreModifyEventRenda = false;

	private void addRendaFormatter(final Text text) {
	    text.addModifyListener(new ModifyListener() {
	        @Override
	        public void modifyText(ModifyEvent e) {
	            if (ignoreModifyEventRenda) {
	                return;
	            }

	            ignoreModifyEventRenda = true;

	            String currentText = text.getText().replaceAll("[^0-9]", "");
	            StringBuilder formattedText = new StringBuilder();
	            int length = currentText.length();

	            for (int i = 0; i < length; i++) {
	                if (i == length - 2) {
	                    formattedText.append(".");
	                }
	                formattedText.append(currentText.charAt(i));
	            }

	            text.setText(formattedText.toString());
	            text.setSelection(formattedText.length());

	            ignoreModifyEventRenda = false;
	        }
	    });

	 
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


	    private boolean ignoreModifyEventData = false;

	    private void addDataFormatter(final Text text) {
	        text.addModifyListener(new ModifyListener() {
	            @Override
	            public void modifyText(ModifyEvent e) {
	                if (ignoreModifyEventData) {
	                    return;
	                }

	                ignoreModifyEventData = true;

	                String currentText = text.getText().replaceAll("[^0-9]", "");
	                StringBuilder formattedText = new StringBuilder();
	                int length = currentText.length();

	                if (length > 8) {
	                    currentText = currentText.substring(0, 8);
	                    length = 8;
	                }

	                for (int i = 0; i < length; i++) {
	                    if (i == 2 || i == 4) {
	                        formattedText.append("/");
	                    }
	                    formattedText.append(currentText.charAt(i));
	                }

	
	                text.setText(formattedText.toString());
	                text.setSelection(formattedText.length());
	                
	                //isValidData(formattedText.toString());

	                ignoreModifyEventData = false;
	            }
	        });
	    }

	    
	    //private void isValidData(String data) {
	    //    String[] parts = data.split("/");
	    //    if (parts.length != 3) {
	    //        return;
	    //    }
//
	    //    int day = Integer.parseInt(parts[0]);
	    //    int month = Integer.parseInt(parts[1]);
	    //    int year = Integer.parseInt(parts[2]);
//
	    //    if (year > 2005 || month < 1 || month > 12 || day < 1 || day > 31) {
	    //        return;
	    //    }
	    //}

	    
	    private void addNumeroFormatter(final Text text) {
	        text.addVerifyListener(new VerifyListener() {
	            @Override
	            public void verifyText(VerifyEvent e) {
	                String newText = e.text;
	                String currentText = text.getText();
	                String modifiedText = currentText.substring(0, e.start) + newText + currentText.substring(e.end);

	                if (!modifiedText.matches("^\\d{0,7}$")) {
	                    e.doit = false;
	                }
	            }
	        });
	    }


}