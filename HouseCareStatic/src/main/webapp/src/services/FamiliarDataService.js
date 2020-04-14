import http from "./http-common";

class FamiliarDataService {
  
  getAll(idEmpresa) {
    return http.get(`/api/rest/empresa/${idEmpresa}/familiar/listar`);
  }

  getAllByCliente(idEmpresa, idCliente) {
    return http.get(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/familiar/listar`);
  }

  getByCliente(idEmpresa, idCliente, id) {
    return http.get(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/familiar/detalhar/${id}/`);
  }

  get(idEmpresa, id) {
    return http.get(`/api/rest/empresa/${idEmpresa}/familiar/detalhar/${id}/`);
  }

  create(idEmpresa, data) {
    return http.post(`/api/rest/empresa/${idEmpresa}/familiar/criar`, data);
  }

  update(idEmpresa, id, data) {
    return http.put(`/api/rest/empresa/${idEmpresa}/familiar/editar/${id}`, data);
  }

  deleteByCliente(idEmpresa, idCliente, id) {
    return http.delete(`/api/rest/empresa/${idEmpresa}/cliente/${idCliente}/familiar/delete/${id}`);
  }

  delete(idEmpresa, id) {
    return http.delete(`/api/rest/empresa/${idEmpresa}/familiar/delete/${id}`);
  }

}

export default new FamiliarDataService();