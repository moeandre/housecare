import http from "./http-common";

class FuncionarioDataService {
  
  getAll(idEmpresa) {
    return http.get(`/api/rest/empresa/${idEmpresa}/funcionario/listar`);
  }

  get(idEmpresa, id) {
    return http.get(`/api/rest/empresa/${idEmpresa}/funcionario/detalhar/${id}/`);
  }

  create(idEmpresa, data) {
    return http.post(`/api/rest/empresa/${idEmpresa}/funcionario/criar`, data);
  }

  update(idEmpresa, id, data) {
    return http.put(`/api/rest/empresa/${idEmpresa}/funcionario/editar/${id}`, data);
  }

  delete(idEmpresa, id) {
    return http.delete(`/api/rest/empresa/${idEmpresa}/funcionario/delete/${id}`);
  }

}

export default new FuncionarioDataService();