package br.gov.cesarschool.poo.bonusvendas.tela.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import br.gov.cesarschool.poo.bonusvendas.dao.CaixaDeBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.negocio.AcumuloResgateMediator;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.MessageBox;

public class TelaAcumuloResgate {
	
	

	protected Shell shell;
	AcumuloResgateMediator mediator = AcumuloResgateMediator.getInstance();
	CaixaDeBonusDAO numeroCaixaDeBonus = new CaixaDeBonusDAO();
	private Text textNumeroCaixaBonus;
	private Text textSaldoAtual;
	private Text textValor;
	private Button btnAcumularresgatar;
	private Button btnVoltar;
	private Button btnOpProduto;
	private Button btnOpServico;

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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		textNumeroCaixaBonus = new Text(shell, SWT.BORDER);
		textNumeroCaixaBonus.setToolTipText("Número da caixa de Bonus");
		textNumeroCaixaBonus.setBounds(10, 16, 76, 21);
		
		Button btnOpCash = new Button(shell, SWT.RADIO);
		btnOpCash.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnOpCash.setBounds(132, 18, 90, 16);
		btnOpCash.setText("CASH");
		
		Button btnBuscar = new Button(shell, SWT.NONE);
        btnBuscar.setBounds(349, 226, 75, 25);
        btnBuscar.setText("Buscar");
        btnBuscar.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                String numCaixa = textNumeroCaixaBonus.getText();
                long numCaixaLong = Long.parseLong(numCaixa);
                // Assuming mediator has a method `getSaldoByCaixa`
                if (numeroCaixaDeBonus.buscar(numCaixaLong)==null) {
	                MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
	                messageBox.setText("Erro");
	                messageBox.setMessage("Erro: Não foi possível encontrar vendedor.");
	                messageBox.open();
                } else {
                	textNumeroCaixaBonus.setEnabled(false);
                	btnOpServico.setEnabled(false);
                	btnOpCash.setEnabled(false);
                	btnOpProduto.setEnabled(false);
                	textSaldoAtual.setEnabled(true);
                	btnAcumularresgatar.setEnabled(true);
                	btnVoltar.setEnabled(true);
                }
            }
        });

		
		textSaldoAtual = new Text(shell, SWT.BORDER);
		textSaldoAtual.setEnabled(false);
		textSaldoAtual.setBounds(10, 43, 76, 21);
		
		Combo comboTipoDeResgate = new Combo(shell, SWT.NONE);
		comboTipoDeResgate.setEnabled(false);
		comboTipoDeResgate.setBounds(243, 16, 91, 23);
		
		textValor = new Text(shell, SWT.BORDER);
		textValor.setEnabled(false);
		textValor.setBounds(10, 70, 76, 21);
		
	    btnAcumularresgatar = new Button(shell, SWT.NONE);
	    btnAcumularresgatar.setEnabled(false);
	    btnAcumularresgatar.setBounds(229, 226, 114, 25);
	    btnAcumularresgatar.setText("Acumular/Resgatar");
	    
	    btnAcumularresgatar.addSelectionListener(new SelectionAdapter() {
	        @Override
	        public void widgetSelected(SelectionEvent e) {
	            String valor = textValor.getText();
	            if (!isDecimal(valor)) {
	                MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
	                messageBox.setText("Erro");
	                messageBox.setMessage("Erro: Número não decimal");
	                messageBox.open();
	            }
	        }

			private boolean isDecimal(String valor) {
			    try {
			        Double.parseDouble(valor);
			        return true;
			    } catch (NumberFormatException e) {
			        return false;
			    }

			}
	    });

		
		btnVoltar = new Button(shell, SWT.NONE);
		btnVoltar.setEnabled(false);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnVoltar.setBounds(10, 226, 75, 25);
		btnVoltar.setText("Voltar");
		
		btnOpProduto = new Button(shell, SWT.RADIO);
		btnOpProduto.setBounds(132, 40, 90, 16);
		btnOpProduto.setText("PRODUTO");
		
		btnOpServico = new Button(shell, SWT.RADIO);
		btnOpServico.setBounds(132, 62, 90, 16);
		btnOpServico.setText("SERVIÇO");

		
		
	}
}
