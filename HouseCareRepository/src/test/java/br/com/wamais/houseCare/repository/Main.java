package br.com.wamais.houseCare.repository;

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

		final String repository = Main.buildRepository();
		final Map<String, String> entities = Main.buildList();
		for(Entry<String, String> entry : entities.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    System.out.println(key);
		    System.out.println(value);
		    
		    System.out.println(String.format(repository, key,value));
		    byte data[] = String.format(repository, key,value).getBytes();
		    Path p = Paths.get(String.format("%sRepository.java",key));

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

	public static String buildRepository() {

		StringBuilder sb = new StringBuilder("package br.com.wamais.houseCare.repository;").append('\n');
		sb.append('\n');
		sb.append("import org.springframework.data.jpa.repository.JpaRepository;").append('\n');
		sb.append("import org.springframework.stereotype.Repository;").append('\n');
		sb.append('\n');
		sb.append("import br.com.wamais.houseCare.domain.%1$2s;").append('\n');
		sb.append("import br.com.wamais.houseCare.domain.%2$2s;").append('\n');
		sb.append('\n');
		sb.append("@Repository").append('\n');
		sb.append("public interface %1$2sRepository extends JpaRepository<%1$2s, %2$2s> {").append('\n');
		sb.append('\n');
		sb.append("}").append('\n');

		return sb.toString();
	}

}
