import http from "./http-common";

class FaturaDataService {
  
  getAll(idEmpresa, idCliente) {
    return http.get(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/fatura/listar`);
  }

  get(idEmpresa, idCliente, id) {
    return http.get(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/fatura/detalhar/${id}/`);
  }

  create(idEmpresa, idCliente, data) {
    return http.post(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/fatura/criar`, data);
  }

  update(idEmpresa, idCliente, id, data) {
    return http.put(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/fatura/editar/${id}`, data);
  }

  delete(idEmpresa, idCliente, id) {
    return http.delete(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/fatura/delete/${id}`);
  }

}

export default new FaturaDataService();