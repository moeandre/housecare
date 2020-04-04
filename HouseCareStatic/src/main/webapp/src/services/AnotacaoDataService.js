import http from "./http-common";

class AnotacaoDataService {
  
  getAll(idEmpresa, idCliente) {
    return http.get(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/anotacao/listar`);
  }

  get(idEmpresa, idCliente, id) {
    return http.get(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/anotacao/detalhar/${id}/`);
  }

  create(idEmpresa, idCliente, data) {
    return http.post(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/anotacao/criar`, data);
  }

  update(idEmpresa, idCliente, id, data) {
    return http.put(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/anotacao/editar/${id}`, data);
  }

  delete(idEmpresa, idCliente, id) {
    return http.delete(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/anotacao/delete/${id}`);
  }

}

export default new AnotacaoDataService();