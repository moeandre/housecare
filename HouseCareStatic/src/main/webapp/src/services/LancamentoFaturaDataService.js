import http from "./http-common";

class LancamentoFaturaDataService {
  
  getAll(idEmpresa, idCliente) {
    return http.get(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/fatura/lancamento/listar`);
  }

  get(idEmpresa, idCliente, id) {
    return http.get(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/fatura/lancamento/detalhar/${id}/`);
  }

  create(idEmpresa, idCliente, data) {
    return http.post(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/fatura/lancamento/criar`, data);
  }

  update(idEmpresa, idCliente, id, data) {
    return http.put(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/fatura/lancamento/editar/${id}`, data);
  }

  delete(idEmpresa, idCliente, id) {
    return http.delete(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/fatura/lancamento/delete/${id}`);
  }

  faturarPendentes(idEmpresa, idCliente) {
    return http.put(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/fatura/lancamento/fecharPendentes`,{});
  }

}

export default new LancamentoFaturaDataService();