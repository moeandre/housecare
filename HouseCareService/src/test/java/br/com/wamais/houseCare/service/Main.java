package br.com.wamais.houseCare.service;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {

		Main main = new Main();
		//main.generateInterface();
		main.generateImpl();
	}

	public void generateInterface() {

		final String repository = Main.buildInterfaces();
		final Map<String, String> entities = Main.buildList();
		for (Entry<String, String> entry : entities.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key);
			System.out.println(value);

			System.out.println(String.format(repository, key, value));
			byte data[] = String.format(repository, key, value).getBytes();
			Path p = Paths.get(String.format("I%sService.java", key));

			try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, java.nio.file.StandardOpenOption.CREATE,
					java.nio.file.StandardOpenOption.APPEND))) {
				out.write(data, 0, data.length);
			} catch (IOException x) {
				System.err.println(x);
			}
		}
	}
	
	public void generateImpl() {

		final String repository = Main.buildService();
		final Map<String, String> entities = Main.buildList();
		for (Entry<String, String> entry : entities.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key);
			System.out.println(value);

			System.out.println(String.format(repository, key, value));
			byte data[] = String.format(repository, key, value).getBytes();
			Path p = Paths.get(String.format("%sServiceImpl.java", key));

			try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, java.nio.file.StandardOpenOption.CREATE,
					java.nio.file.StandardOpenOption.APPEND))) {
				out.write(data, 0, data.length);
			} catch (IOException x) {
				System.err.println(x);
			}
		}
	}

	public static Map<String, String> buildList() {

		Map<String, String> retVal = new HashMap<String, String>();

		retVal.put("Anotacao", "AnotacaoPK");
		retVal.put("AtributoPapel", "AtributoPapelPK");
		retVal.put("AtributoUsuario", "AtributoUsuarioPK");
		retVal.put("Auditoria", "Integer");
		retVal.put("Caixa", "CaixaPK");
		retVal.put("Cliente", "ClientePK");
		retVal.put("Cobranca", "Integer");
		retVal.put("Configuracao", "ConfiguracaoPK");
		retVal.put("Cuidado", "Integer");
		retVal.put("Diagnostico", "Integer");
		retVal.put("DiagnosticoCuidado", "DiagnosticoCuidadoPK");
		retVal.put("Empresa", "Integer");
		retVal.put("Familiar", "FamiliarPK");
		retVal.put("Fatura", "Integer");
		retVal.put("Funcionario", "FuncionarioPK");
		retVal.put("Historico", "HistoricoPK");
		retVal.put("Inventario", "InventarioPK");
		retVal.put("Lancamento", "LancamentoPK");
		retVal.put("Lotacao", "LotacaoPK");
		retVal.put("Medicamento", "Integer");
		retVal.put("Papel", "Integer");
		retVal.put("PapelEmpresa", "PapelEmpresaPK");
		retVal.put("PapelEmpresaUsuario", "PapelEmpresaUsuarioPK");
		retVal.put("Parametro", "Integer");
		retVal.put("PrescricaoEnfermagem", "PrescricaoEnfermagemPK");
		retVal.put("PrescricaoMedicamentosa", "PrescricaoMedicamentosaPK");
		retVal.put("Quarto", "QuartoPK");
		retVal.put("Servico", "ServicoPK");
		retVal.put("Sessao", "Integer");
		retVal.put("SinalVital", "Integer");

		return retVal;

	}

	public static String buildInterfaces(){
		
		StringBuilder sb = new StringBuilder("package br.com.wamais.houseCare.service;").append('\n');
		sb.append('\n');
		sb.append("import br.com.wamais.houseCare.domain.%1$2s;").append('\n');
		sb.append("import br.com.wamais.houseCare.domain.%2$2s;").append('\n');
		sb.append('\n');
		sb.append("public interface I%1$2sService extends ICrudService<%1$2s, %2$2s> {").append('\n');
		sb.append('\n');
		sb.append("}").append('\n');
		
		return sb.toString();

	}
	public static String buildService() {

		StringBuilder sb = new StringBuilder("package br.com.wamais.houseCare.service.impl;").append('\n');
		sb.append('\n');
		sb.append("import java.security.NoSuchAlgorithmException;").append('\n');
		sb.append('\n');
		sb.append("import org.springframework.beans.factory.annotation.Autowired;").append('\n');
		sb.append("import org.springframework.stereotype.Service;").append('\n');
		sb.append("import org.springframework.transaction.annotation.Transactional;").append('\n');
		sb.append('\n');
		sb.append("import br.com.wamais.houseCare.domain.%1$2s;").append('\n');
		sb.append("import br.com.wamais.houseCare.domain.%2$2s;").append('\n');
		sb.append("import br.com.wamais.houseCare.repository.%1$2sRepository;").append('\n');
		sb.append("import br.com.wamais.houseCare.service.I%1$2sService;").append('\n');
		sb.append('\n');
		sb.append("@Service").append('\n');
		sb.append("@Transactional").append('\n');
		sb.append("public class %1$2sServiceImpl extends AbstractService<%1$2s, %2$2s> implements I%1$2sService {").append('\n');
		sb.append('\n');
		sb.append("@Autowired").append('\n');
		sb.append("private %1$2sRepository repository;").append('\n');
		sb.append('\n');
		sb.append("@Autowired").append('\n');
		sb.append("public void superRepository(final %1$2sRepository repository) {").append('\n');
		sb.append('\n');
		sb.append("	super.setRepository(repository);").append('\n');
		sb.append("}").append('\n');
		sb.append('\n');
		sb.append("}").append('\n');

		return sb.toString();
	}

}
