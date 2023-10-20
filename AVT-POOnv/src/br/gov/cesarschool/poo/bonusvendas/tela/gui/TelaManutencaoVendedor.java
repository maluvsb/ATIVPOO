package br.gov.cesarschool.poo.bonusvendas.tela.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.ModifyListener;

import br.gov.cesarschool.poo.bonusvendas.negocio.VendedorMediator;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

public class TelaManutencaoVendedor {
	
	protected Shell shell;
	VendedorMediator mediator = VendedorMediator.getInstance();
	private Text CPF;
	private Text NomeCompleto;
	private Text textDataNascimento;
	private Text Renda;
	private Text Logradouro;
	private Text Numero;
	private Text Complemento;
	private Text CEP;
	private Text Cidade;
	private Button btnIncluir;
	private Button btnAlterar;

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
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setToolTipText("CPF");
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		CPF = new Text(shell, SWT.BORDER);
		CPF.setText("CPF");
        CPF.setToolTipText("CPF");
        CPF.setBounds(10, 10, 76, 21);
        ModifyListener[] cpfListenerContainer = new ModifyListener[1];

	    cpfListenerContainer[0] = e -> {
	        String cpf = CPF.getText();
	        cpf = cpf.replaceAll("[^0-9]", "");
	        
	        if (cpf.length() > 11) {
	            cpf = cpf.substring(0, 11);
	        }
	        
	        StringBuilder formattedCpf = new StringBuilder(cpf);

	        if (formattedCpf.length() > 3) {
	            formattedCpf.insert(3, '.');
	        }
	        if (formattedCpf.length() > 7) {
	            formattedCpf.insert(7, '.');
	        }
	        if (formattedCpf.length() > 11) {
	            formattedCpf.insert(11, '-');
	        }

	        CPF.removeModifyListener(cpfListenerContainer[0]);
	        CPF.setText(formattedCpf.toString());
	        CPF.setSelection(formattedCpf.length());
	        CPF.addModifyListener(cpfListenerContainer[0]);
	    };

	    CPF.addModifyListener(cpfListenerContainer[0]);
		
		
		
		NomeCompleto = new Text(shell, SWT.BORDER);
		NomeCompleto.setText("Nome completo");
		NomeCompleto.setToolTipText("Nome completo");
		NomeCompleto.setBounds(10, 37, 76, 21);
		
		textDataNascimento = new Text(shell, SWT.BORDER);
		textDataNascimento.setText("Data de Nascimento");
		textDataNascimento.setToolTipText("Data de nascimento");
		textDataNascimento.setEnabled(true);
		textDataNascimento.setBounds(10, 64, 76, 21);
		
		ModifyListener[] dateListenerContainer = new ModifyListener[1];

		dateListenerContainer[0] = e -> {
		    String date = textDataNascimento.getText();
		    date = date.replaceAll("[^0-9]", "");
		    
		    if (date.length() > 8) {
		        date = date.substring(0, 8);
		    }
		    
		    StringBuilder formattedDate = new StringBuilder(date);

		    if (formattedDate.length() > 2) {
		        formattedDate.insert(2, '/');
		    }
		    if (formattedDate.length() > 5) {
		        formattedDate.insert(5, '/');
		    }

		    textDataNascimento.removeModifyListener(dateListenerContainer[0]);
		    textDataNascimento.setText(formattedDate.toString());
		    textDataNascimento.setSelection(formattedDate.length());
		    textDataNascimento.addModifyListener(dateListenerContainer[0]);
		};

		textDataNascimento.addModifyListener(dateListenerContainer[0]);
		
		Button btnSexoMasculino = new Button(shell, SWT.RADIO);
		btnSexoMasculino.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnSexoMasculino.setBounds(119, 10, 90, 16);
		btnSexoMasculino.setText("Masculino");
		
		Button btnSexoFeminino = new Button(shell, SWT.RADIO);
		btnSexoFeminino.setBounds(119, 32, 90, 16);
		btnSexoFeminino.setText("Feminino");
		
		Renda = new Text(shell, SWT.BORDER);
		Renda.setText("Renda");
		Renda.setToolTipText("Renda");
		Renda.setBounds(10, 91, 76, 21);

		// Adiciona um VerifyListener para validar a entrada da renda
		Renda.addVerifyListener(new VerifyListener() {
		    @Override
		    public void verifyText(VerifyEvent e) {
		        String newText = ((Text) e.widget).getText() + e.text;
		        
		        // Aceita apenas números e ponto, e verifica o formato
		        e.doit = newText.matches("\\d+(\\.\\d{0,2})?");
		    }
		});
		
		Logradouro = new Text(shell, SWT.BORDER);
		Logradouro.setText("Logradouro");
		Logradouro.setToolTipText("Logradouro");
		Logradouro.setBounds(10, 118, 76, 21);
		
		Numero = new Text(shell, SWT.BORDER);
		Numero.setText("Número");
		Numero.setToolTipText("Número");
		Numero.setBounds(10, 145, 76, 21);

		// Adiciona um VerifyListener para validar a entrada do número
		Numero.addVerifyListener(new VerifyListener() {
		    @Override
		    public void verifyText(VerifyEvent e) {
		        String newText = ((Text) e.widget).getText() + e.text;
		        
		        // Aceita apenas números e verifica o comprimento
		        e.doit = newText.matches("\\d{0,7}");
		    }
		});
		
		Complemento = new Text(shell, SWT.BORDER);
		Complemento.setText("Complemento");
		Complemento.setToolTipText("Complemento");
		Complemento.setBounds(10, 172, 76, 21);
		
		CEP = new Text(shell, SWT.BORDER);
		CEP.setText("CEP");
		CEP.setToolTipText("CEP");
		CEP.setBounds(10, 199, 76, 21);

		// Adiciona um VerifyListener para validar a entrada do CEP
		CEP.addVerifyListener(new VerifyListener() {
		    @Override
		    public void verifyText(VerifyEvent e) {
		        String newText = ((Text) e.widget).getText() + e.text;
		        
		        // Aceita apenas números e verifica o comprimento
		        e.doit = newText.matches("\\d{0,8}") && newText.length() <= 8;
		    }
		});
		
		Cidade = new Text(shell, SWT.BORDER);
		Cidade.setText("Cidade");
		Cidade.setToolTipText("Cidade");
		Cidade.setBounds(10, 226, 76, 21);
		
		Combo comboEstado = new Combo(shell, SWT.NONE);
		comboEstado.setToolTipText("Estado");
		comboEstado.setBounds(226, 8, 91, 23);
		
		String[] estados = {
			    "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", 
			    "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", 
			    "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", 
			    "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", 
			    "São Paulo", "Sergipe", "Tocantins"
			};


			comboEstado.setItems(estados);
			
			btnIncluir = new Button(shell, SWT.NONE);
			btnIncluir.setBounds(349, 222, 75, 25);
			btnIncluir.setText("Incluir");

			
			btnAlterar = new Button(shell, SWT.NONE);
			btnAlterar.setBounds(268, 222, 75, 25);
			btnAlterar.setText("Alterar");

	}
}
