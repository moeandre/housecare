import http from "./http-common";

class FamiliarDataService {
  
  getAll(idEmpresa, idCliente) {
    return http.get(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/familiar/listar`);
  }

  get(idEmpresa, idCliente, id) {
    return http.get(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/familiar/detalhar/${id}/`);
  }

  create(idEmpresa, idCliente, data) {
    return http.post(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/familiar/criar`, data);
  }

  update(idEmpresa, idCliente, id, data) {
    return http.put(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/familiar/editar/${id}`, data);
  }

  delete(idEmpresa, idCliente, id) {
    return http.delete(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/familiar/delete/${id}`);
  }

}

export default new FamiliarDataService();