import http from "./http-common";

class ClienteDataService {
  
  getAll(idEmpresa) {
    return http.get(`/api/rest/empresa/${idEmpresa}/cliente/listar`);
  }

  get(idEmpresa, id) {
    return http.get(`/api/rest/empresa/${idEmpresa}/cliente/detalhar/${id}/`);
  }

  create(idEmpresa, data) {
    return http.post(`/api/rest/empresa/${idEmpresa}/cliente/criar`, data);
  }

  update(idEmpresa, id, data) {
    return http.put(`/api/rest/empresa/${idEmpresa}/cliente/editar/${id}`, data);
  }

  

}

export default new ClienteDataService();